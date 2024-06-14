package ir.maktabsharif.repository.cart_item;

import ir.maktabsharif.entity.*;
import ir.maktabsharif.enums.DiscountType;
import ir.maktabsharif.enums.ProductType;
import ir.maktabsharif.repository.BaseEntityRepositoryImpl;
import ir.maktabsharif.exceptions.SqlError;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CartItemRepositoryImpl extends BaseEntityRepositoryImpl<CartItem, Long> implements CartItemRepository {
    @Override
    public CartItem save(CartItem cartItem) {
        String insertQuery =
                STR."insert into \{getTableName()} (cart_id,product_id,discount_id,count) values (?,?,?,?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setLong(1, cartItem.getCart().getId());
            preparedStatement.setLong(2, cartItem.getProduct().getId());
            preparedStatement.setLong(3, cartItem.getDiscount().getId());
            preparedStatement.setInt(4, cartItem.getCount());

            if (preparedStatement.executeUpdate() > 0) {
                return cartItem;
            }
            return null;
        } catch (SQLException e) {
            throw new SqlError("query is incorrect !");
        }
    }

    @Override
    public CartItem findSpecialProductInCart(Cart cart, Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    STR."select * from \{getTableName()} where cart_id= ? and product_id= ?"
            );
            preparedStatement.setLong(1, cart.getId());
            preparedStatement.setLong(2, product.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? mapResultSetToEntity(resultSet) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean increaseProductCountInCart(CartItem cartItem) {
        PreparedStatement preparedStatement = null;
        String updateQuery1 = STR."update \{getTableName()} set count = ? where id= ?";
        try {

            preparedStatement = connection.prepareStatement(
                    updateQuery1
            );
            preparedStatement.setDouble(1, cartItem.getCount() + 1);
            preparedStatement.setLong(2, cartItem.getId());
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }

            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CartItem[] getCartItems(Cart cart) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    """
                               SELECT
                                    cart_items.product_id as product_id,
                                    cart_items.count as count,
                                    products.name as product_name,
                                    products.product_type as product_type,
                                    products.price as price,
                                    cart_items.cart_id as cart_id,
                                    cart_items.discount_id as discount_id,
                                    discounts.name as discount_name,
                                    discounts.code as discount_code,
                                    discounts.amount as discount_amount,
                                    discounts.discount_type as discount_type
                               from cart_items
                               join products ON cart_items.product_id = products.id
                               join discounts ON cart_items.discount_id= discounts.id
                               WHERE cart_items.cart_id = ?
                            """
            );
            preparedStatement.setLong(1, cart.getId());

            ResultSet resultSet = preparedStatement.executeQuery();
            CartItem[] cartItems = new CartItem[(int) countGetCartItems(cart.getId())];
            int arrayIndex = 0;
            while (resultSet.next()) {
                cartItems[arrayIndex++] = mapResultSetToCartItem(resultSet);
            }

            return cartItems;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean decreaseProductCountInCart(CartItem cartItem) {
        PreparedStatement preparedStatement = null;
        String updateQuery1 = STR."update \{getTableName()} set count = ? where id= ?";
        try {

            preparedStatement = connection.prepareStatement(
                    updateQuery1
            );
            preparedStatement.setDouble(1, cartItem.getCount() - 1);
            preparedStatement.setLong(2, cartItem.getId());
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }

            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private CartItem mapResultSetToCartItem(ResultSet resultSet) throws SQLException {
        Product product = new Product(
                resultSet.getInt("product_id"),
                resultSet.getString("product_name"),
                ProductType.valueOf(resultSet.getString("product_type").toUpperCase()),
                resultSet.getDouble("price")
        );
        Cart cart = new Cart(resultSet.getLong("cart_id"));
        Discount discount = new Discount(
                resultSet.getLong("discount_id"),
                resultSet.getString("discount_name"),
                resultSet.getString("discount_code"),
                resultSet.getDouble("discount_amount"),
                DiscountType.valueOf(resultSet.getString("discount_type").toUpperCase())
        );
        return new CartItem(
                resultSet.getLong("cart_id"),
                product,
                resultSet.getInt("count"),
                cart,
                discount
        );
    }

    private long countGetCartItems(Long id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    """
                               SELECT count(*) from cart_items
                                  join products ON cart_items.product_id = products.id
                                  join discounts ON cart_items.discount_id = discounts.id
                                  WHERE cart_items.cart_id = ?
                            """
            );
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected String getTableName() {
        return CartItem.TABLE_NAME;
    }

    @Override
    protected CartItem mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Product product = new Product(resultSet.getInt("product_id"));
        Cart cart = new Cart(resultSet.getLong("cart_id"));
        Discount discount = new Discount(resultSet.getLong("discount_id"));
        return new CartItem(resultSet.getLong("id"), product, resultSet.getInt("count"), cart, discount);
    }

    @Override
    protected CartItem[] getEntityArrayForFindAll() throws SQLException {
        return new CartItem[0];
    }
}
