package ir.maktabsharif.repository.account;

import ir.maktabsharif.entity.Account;
import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.Card;
import ir.maktabsharif.entity.Transaction;
import ir.maktabsharif.repository.BaseEntityRepositoryImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepositoryImpl extends BaseEntityRepositoryImpl implements AccountRepository {


    @Override
    public Account findAccountByUserId(Long userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    """
                                   SELECT
                                           accounts.id as id,
                                           accounts.user_id as user_id,
                                           accounts.bank_id as bank_id,
                                           accounts.balance as balance,
                                           accounts.shaba_number as shaba_number,
                                           accounts.account_number as account_number
                                      from accounts
                                      join users
                                      on accounts.user_id = users.id
                                      WHERE users.id = ?;
                            """
            );
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Account account = null;
            if (resultSet.next()) {
                account = new Account(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        resultSet.getLong("bank_id"),
                        resultSet.getDouble("balance"),
                        resultSet.getString("shaba_number"),
                        resultSet.getString("account_number")
                );
            }

            return account;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByCardNumber(String destinationCard) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    """
                                   SELECT
                                        accounts.id as id,
                                        accounts.user_id as user_id,
                                        accounts.bank_id as bank_id,
                                        accounts.balance as balance,
                                        accounts.shaba_number as shaba_number,
                                        accounts.account_number as account_number
                                   from accounts
                                   join cards
                                   on accounts.id = cards.account_id
                                   WHERE cards.card_number = ?
                            """
            );
            preparedStatement.setString(1, destinationCard);
            ResultSet resultSet = preparedStatement.executeQuery();
            Account account = null;
            if (resultSet.next()) {
                account = new Account(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        resultSet.getLong("bank_id"),
                        resultSet.getDouble("balance"),
                        resultSet.getString("shaba_number"),
                        resultSet.getString("account_number")
                );
            }

            return account;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean transferMoneyFromAccount(Account accountOrigin, Account accountDestination, double amount, double feed) {
        PreparedStatement preparedStatement = null;
        String updateQuery1 = STR."update \{getTableName()} set balance = ? where id= ?";
        String updateQuery2 = STR."update \{getTableName()} set balance = ? where id= ?";
        try {
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(
                    updateQuery1
            );
            preparedStatement.setDouble(1, accountOrigin.getBalance() - (amount + feed));
            preparedStatement.setLong(2, accountOrigin.getId());
            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement(
                    updateQuery2
            );
            preparedStatement.setDouble(1, accountDestination.getBalance() + amount);
            preparedStatement.setLong(2, accountDestination.getId());
            preparedStatement.executeUpdate();


            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountByShabaNumber(String destinationShabaNumber) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    """
                                   SELECT
                                        *
                                   from accounts
                                   WHERE  shaba_number = ?
                            """
            );
            preparedStatement.setString(1, destinationShabaNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            Account account = null;
            if (resultSet.next()) {
                account = new Account(
                        resultSet.getLong("id"),
                        resultSet.getLong("user_id"),
                        resultSet.getLong("bank_id"),
                        resultSet.getDouble("balance"),
                        resultSet.getString("shaba_number"),
                        resultSet.getString("account_number")
                );
            }

            return account;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean withdrawFromAccount(Account account, double amount) {
        PreparedStatement preparedStatement = null;
        String updateQuery1 = STR."update \{getTableName()} set balance = ? where id= ?";
        try {
            preparedStatement = connection.prepareStatement(
                    updateQuery1
            );
            preparedStatement.setDouble(1, account.getBalance() - (amount));
            preparedStatement.setLong(2, account.getId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean depositToCard(Account account, double amount) {
        PreparedStatement preparedStatement = null;
        String updateQuery1 = STR."update \{getTableName()} set balance = ? where id= ?";
        try {
            preparedStatement = connection.prepareStatement(
                    updateQuery1
            );
            preparedStatement.setDouble(1, account.getBalance() + (amount));
            preparedStatement.setLong(2, account.getId());

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean payaBatch(Account accountOrigin, Account[] accounts, double amountDestination, double amountOrigin) {

        String updateQuery1 = STR."update \{getTableName()} set balance = ? where id= ?";

        try {
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery1);

            for (Account account : accounts) {
                preparedStatement.setDouble(1, account.getBalance() + (amountDestination));
                preparedStatement.setLong(2, account.getId());
                preparedStatement.addBatch();
            }
            preparedStatement.setDouble(1, accountOrigin.getBalance() - (amountOrigin));
            preparedStatement.setLong(2, accountOrigin.getId());
            preparedStatement.addBatch();

            preparedStatement.executeBatch();

            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BaseEntity save(BaseEntity entity) {
        return null;
    }

    @Override
    protected String getTableName() {
        return Account.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToBaseEntity(ResultSet resultSet) throws SQLException {
        return null;
    }
}
