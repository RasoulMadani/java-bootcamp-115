package ir.maktabsharif.repository.card;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.entity.Card;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.repository.BaseEntityRepositoryImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardRepositoryImpl extends BaseEntityRepositoryImpl implements CardRepository {
    @Override
    public boolean checkExistCardName(String cardName) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    STR."select * from \{getTableName()} where name= ?"
            );
            preparedStatement.setString(1, cardName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getLong(1) > 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BaseEntity[] getCards(Long userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    STR."select * from \{getTableName()} where user_id = ?"
            );
            preparedStatement.setLong(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            BaseEntity[] baseEntities = new BaseEntity[(int) count(userId)];
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
    public BaseEntity[] findCardByName(String name ,Long userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    STR."select * from \{getTableName()} where user_id = ? and name=?"
            );
            preparedStatement.setLong(1,userId);
            preparedStatement.setString(2,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            BaseEntity[] baseEntities = new BaseEntity[(int) countForFindByName(userId,name)];
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
    public BaseEntity[] findCardByBankName(String bankName, Long userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    """
                            select
                            		    cards.id as id,
                                     	cards.name as name,
                                     	cards.card_number as card_number,
                                     	cards.bank_id as bank_id,
                                     	cards.user_id as user_id
                            from cards
                            join banks on cards.bank_id = banks.id
                            WHERE banks.name = ? and cards.user_id = ?
                    """
            );
            preparedStatement.setString(1,bankName);
            preparedStatement.setLong(2,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            BaseEntity[] baseEntities = new BaseEntity[(int) countForFindCardByBankName(userId,bankName)];
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
    public Card findCardByUserId(Long userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    """
                                 SELECT
                                        cards.id as id,
                                     	cards.name as name,
                                     	cards.card_number as card_number,
                                     	cards.bank_id as bank_id,
                                     	cards.user_id as user_id
                                 from accounts
                                 join cards
                                 on accounts.id = cards.account_id
                                 join users
                                 on accounts.user_id = users.id
                                 WHERE users.id = ?
                         """
            );
            preparedStatement.setLong(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Card card = null;
            if (resultSet.next()) {
              card =  new Card(resultSet.getLong("id"), resultSet.getString("name"),resultSet.getString("card_number"),resultSet.getLong("bank_id"),resultSet.getLong("user_id"));
            }

            return card;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public long count(Long userId) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    STR."select count(*) from \{getTableName()} where user_id = ?"
            );
            preparedStatement.setLong(1,userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public long countForFindByName(Long userId,String name) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    STR."select count(*) from \{getTableName()} where user_id = ? and name=?"
            );
            preparedStatement.setLong(1,userId);
            preparedStatement.setString(2,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public long countForFindCardByBankName(Long userId,String name) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    """
                             select
                                 count(*)
                             from cards
                             join banks on cards.bank_id = banks.id
                             WHERE banks.name = ? and cards.user_id = ?
                     """
            );
            preparedStatement.setString(1,name);
            preparedStatement.setLong(2,userId);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public BaseEntity save(BaseEntity entity) {
        Card card = (Card) entity;
        String insertQuery = STR."insert into \{getTableName()}(name,card_number,user_id,bank_id,account_id) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, card.getName());
            preparedStatement.setString(2, card.getCard_number());
            preparedStatement.setLong(3, card.getUser_id());
            preparedStatement.setLong(4, card.getBank_id());
            preparedStatement.setLong(5, card.getAccount().getId());
            if (preparedStatement.executeUpdate() > 0) {
                return card;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected String getTableName() {
        return Card.TABLE_NAME;
    }

    @Override
    protected BaseEntity mapResultSetToBaseEntity(ResultSet resultSet) throws SQLException {
        return new Card(resultSet.getLong("id"), resultSet.getString("name"),resultSet.getString("card_number"),resultSet.getLong("bank_id"),resultSet.getLong("user_id"));
    }
}
