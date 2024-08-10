package ir.maktabsharif.repository.product;

import ir.maktabsharif.entity.Product;
import ir.maktabsharif.enums.ProductType;
import ir.maktabsharif.repository.BaseEntityRepositoryImpl;
import ir.maktabsharif.repository.user.UserRepository;
import ir.maktabsharif.service.product.exception.ProductSqlException;
import lombok.AllArgsConstructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepositoryImpl extends BaseEntityRepositoryImpl<Product, Integer> implements ProductRepository {


    @Override
    public Product save(Product entity) {
        String insertQuery =
                STR."insert into \{ getTableName() } (name,product_type,price) values (?,?::product_type,?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, String.valueOf(entity.getType()).toLowerCase());
            preparedStatement.setDouble(3, entity.getPrice());

            if (preparedStatement.executeUpdate() > 0) {
                return entity;
            }
            return null;
        } catch (SQLException e) {
            throw new ProductSqlException("query is incorrect !");
        }
    }

    @Override
    protected String getTableName() {
        return Product.TABLE_NAME;
    }

    @Override
    protected Product mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new Product(resultSet.getInt("id"),resultSet.getString("name"), ProductType.valueOf(resultSet.getString("product_type").toUpperCase()),resultSet.getDouble("price"));
    }

    @Override
    protected Product[] getEntityArrayForFindAll() throws SQLException {
        return new Product[(int) count()];
    }
    @Override
    public long count() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        COUNT_ALL_QUERY_TEMPLATE,
                        getTableName()
                )
        );
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getLong(1);
    }
}
