package ir.maktabsharif.repository.transaction;

import ir.maktabsharif.entity.Account;
import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.Transaction;
import ir.maktabsharif.enums.TransactionStatus;
import ir.maktabsharif.enums.TransactionType;
import ir.maktabsharif.repository.BaseEntityRepositoryImpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionRepositoryImpl extends BaseEntityRepositoryImpl implements TransactionRepository {
    @Override
    public BaseEntity save(BaseEntity entity) {
        return null;
    }

    @Override
    protected String getTableName() {
        return Transaction.TABLE_NAME;
    }


    @Override
    public Transaction cardToCard(Account originAccount, Account destinationAccount, double amount) {

        return null;
    }

    public boolean insertTransactionToDB(Transaction transaction) {
        PreparedStatement preparedStatement = null;
        String insertQuery = STR."insert into \{getTableName()}(destination_account_id,origin_account_id,amount,fee,status,type,message,date) values (?,?,?,?,?,?,?,CURRENT_TIMESTAMP)";
        try {
            preparedStatement = connection.prepareStatement(
                    insertQuery
            );
            preparedStatement.setLong(1, transaction.getDestinationAccount().getId());
            preparedStatement.setLong(2, transaction.getOriginAccount().getId());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setDouble(4, transaction.getFee());
            preparedStatement.setString(5, String.valueOf(transaction.getStatus()));
            preparedStatement.setString(6, String.valueOf(transaction.getType()));
            preparedStatement.setString(7, transaction.getMessage());

            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }

            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BaseEntity[] displayTransactionsByTransferType(String type, Long userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    STR."select * from \{getTableName()} where destination_account_id = ? OR origin_account_id = ? and type = ? "
            );
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, userId);
            preparedStatement.setString(3, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            BaseEntity[] baseEntities = new BaseEntity[(int) countDisplayTransactionsByTransferType(type, userId)];
            int arrayIndex = 0;
            while (resultSet.next()) {
                baseEntities[arrayIndex++] = mapResultSetToBaseEntity(resultSet);
            }

            return baseEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BaseEntity[] displayTransactionsBasedOnSpecificDay(String date1, String date2, Long userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    STR."select * from \{getTableName()} where destination_account_id = ? OR origin_account_id = ? and date between ? and ? "
            );
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, userId);
            preparedStatement.setString(3, date1);
            preparedStatement.setString(4, date2);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            BaseEntity[] baseEntities = new BaseEntity[(int) countDisplayTransactionsBasedOnSpecificDay(date1, date2, userId)];
            int arrayIndex = 0;
            while (resultSet.next()) {
                baseEntities[arrayIndex++] = mapResultSetToBaseEntity(resultSet);
            }

            return baseEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BaseEntity[] displayTransactionsBasedOnAmount(double amount, Long userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    STR."select * from \{getTableName()} where (destination_account_id = ? OR origin_account_id = ?) and (amount > ?) "
            );
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, userId);
            preparedStatement.setDouble(3, amount);
            ResultSet resultSet = preparedStatement.executeQuery();
            BaseEntity[] baseEntities = new BaseEntity[(int) countDisplayTransactionsBasedOnAmount(amount, userId)];
            int arrayIndex = 0;
            while (resultSet.next()) {
                baseEntities[arrayIndex++] = mapResultSetToBaseEntity(resultSet);
            }

            return baseEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BaseEntity[] getAllTransactions(Long userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    STR."select * from \{getTableName()} where destination_account_id = ? OR origin_account_id = ?"
            );
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            BaseEntity[] baseEntities = new BaseEntity[(int) countGetAllTransactions(userId)];
            int arrayIndex = 0;
            while (resultSet.next()) {
                baseEntities[arrayIndex++] = mapResultSetToBaseEntity(resultSet);
            }

            return baseEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean insertBatchTransactionToDB(Transaction[] transactions) {
        String insertQuery = STR."insert into \{getTableName()}(destination_account_id,origin_account_id,amount,fee,status,type,message,date) values (?,?,?,?,?,?,?,CURRENT_TIMESTAMP)";

        try {
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            for (Transaction transaction : transactions) {
                preparedStatement.setLong(1, transaction.getDestinationAccount().getId());
                preparedStatement.setLong(2, transaction.getOriginAccount().getId());
                preparedStatement.setDouble(3, transaction.getAmount());
                preparedStatement.setDouble(4, transaction.getFee());
                preparedStatement.setString(5, String.valueOf(transaction.getStatus()));
                preparedStatement.setString(6, String.valueOf(transaction.getType()));
                preparedStatement.setString(7, transaction.getMessage());
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();

            connection.commit();
            connection.setAutoCommit(true);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private long countGetAllTransactions(Long userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    STR."select count(*) from \{getTableName()} where destination_account_id = ? OR origin_account_id = ?"
            );
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public long countDisplayTransactionsByTransferType(String type, Long userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    STR."select count(*) from \{getTableName()} where destination_account_id = ? OR origin_account_id = ? and type = ? "
            );
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, userId);
            preparedStatement.setString(3, type);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public long countDisplayTransactionsBasedOnAmount(double amount, Long userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    STR."select count(*) from \{getTableName()} where (destination_account_id = ? OR origin_account_id = ?) and (amount > ?) "
            );
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, userId);
            preparedStatement.setDouble(3, amount);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public long countDisplayTransactionsBasedOnSpecificDay(String date1, String date2, Long userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    STR."select * from \{getTableName()} where destination_account_id = ? OR origin_account_id = ? and date between ? and ? "
            );
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, userId);
            preparedStatement.setString(3, date1);
            preparedStatement.setString(4, date2);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected BaseEntity mapResultSetToBaseEntity(ResultSet resultSet) throws SQLException {
        Account accountOrigin = new Account(resultSet.getLong("origin_account_id"));
        Account accountDestination = new Account(resultSet.getLong("destination_account_id"));
        return new Transaction(
                accountOrigin, accountDestination,
                resultSet.getDouble("amount"),
                resultSet.getDouble("fee"),
                TransactionStatus.valueOf(resultSet.getString("status")),
                TransactionType.valueOf(resultSet.getString("type")),
                resultSet.getString("message"),
                resultSet.getTimestamp("date")
        );
    }
}
