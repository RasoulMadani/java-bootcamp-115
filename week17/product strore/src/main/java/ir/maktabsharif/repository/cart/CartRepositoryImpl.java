package ir.maktabsharif.repository.cart;

import ir.maktabsharif.entity.Cart;
import ir.maktabsharif.entity.User;
import ir.maktabsharif.enums.CartStatus;
import ir.maktabsharif.repository.BaseEntityRepositoryImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartRepositoryImpl extends BaseEntityRepositoryImpl<Cart, Long> implements CartRepository {
    @Override
    public Cart save(Cart cart) {
        String insertQuery =
                STR."insert into \{getTableName()} (user_id,total_price,total_count,cart_status,date) values (?,?,?,?::cart_status,?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertQuery,PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, cart.getUser().getId());
            preparedStatement.setDouble(2, cart.getTotalPrice());
            preparedStatement.setDouble(3, cart.getTotalCount());
            preparedStatement.setString(4, String.valueOf(cart.getCartStatus()));
            preparedStatement.setDouble(5, cart.getEpochMilliseconds());
            System.out.println(preparedStatement);
            if (preparedStatement.executeUpdate() > 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    long insertId = generatedKeys.getInt(1);
                    cart.setId(insertId);
                    return cart;
                }
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected String getTableName() {
        return Cart.TABLE_NAME;
    }

    @Override
    protected Cart mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Cart(
                resultSet.getLong("id"),
                resultSet.getDouble("total_price"),
                new User(resultSet.getLong("user_id")),
                resultSet.getInt("total_count"),
                CartStatus.valueOf(resultSet.getString("cart_status")),
                resultSet.getLong("date")
        );
    }

    @Override
    protected Cart[] getEntityArrayForFindAll() throws SQLException {
        return new Cart[0];
    }

    @Override
    public Cart findByIdAndUnPaid(Long userId) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    STR."select * from \{getTableName()} where user_id= ? and cart_status= ?::cart_status"
            );
            preparedStatement.setLong(1, userId);
            preparedStatement.setString(2, "UNPAID");
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? mapResultSetToEntity(resultSet) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
