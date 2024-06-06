package ir.maktabsharif.repository;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.util.config.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseEntityRepositoryImpl implements BaseEntityRespository {


    protected final Connection connection = DataSource.getConnection();

    public static final String FIND_ALL_QUERY_TEMPLATE = "select * from %s";
    public static final String COUNT_ALL_QUERY_TEMPLATE = "select count(*) from %s";

    public static final String FIND_BY_ID_QUERY_TEMPLATE = "select * from %s where id = ?";
    public static final String DELETE_BY_ID_QUERY_TEMPLATE = "delete from %s where id = ?";

    public static final String DELETE_ALL_QUERY_TEMPLATE = "delete from %s where id > 0";
    public static final String EXISTS_BY_ID_QUERY_TEMPLATE = "select count(*) from %s where id = ?";


    @Override
    public abstract BaseEntity save(BaseEntity entity);

    @Override
    public BaseEntity update(BaseEntity entity) {
        return null;
    }

    @Override
    public BaseEntity[] findAll() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    getFindAllQuery()
            );
            ResultSet resultSet = preparedStatement.executeQuery();
            BaseEntity[] baseEntities = new BaseEntity[(int) count()];
            System.out.println(count() + " " + getFindAllQuery());
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
    public BaseEntity findById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                getFindByIdQuery()
        );
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
//        if (resultSet.next()) {
//            return mapResultSetToBaseEntity(resultSet);
//        }
//        return null;
        return resultSet.next() ? mapResultSetToBaseEntity(resultSet) : null;
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

    @Override
    public void deleteAll() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        DELETE_ALL_QUERY_TEMPLATE,
                        getTableName()
                )
        );
        preparedStatement.executeUpdate();
    }

    @Override
    public boolean deleteById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        DELETE_BY_ID_QUERY_TEMPLATE,
                        getTableName()
                )
        );
        preparedStatement.setLong(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean existsById(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        EXISTS_BY_ID_QUERY_TEMPLATE,
                        getTableName()
                )
        );
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        return resultSet.getLong(1) > 0;
    }

    protected String getFindAllQuery() {
        return String.format(
                FIND_ALL_QUERY_TEMPLATE,
                getTableName()
        );
    }

    protected String getFindByIdQuery() {
        return String.format(
                FIND_BY_ID_QUERY_TEMPLATE,
                getTableName()
        );
    }

    protected abstract String getTableName();

    protected abstract BaseEntity mapResultSetToBaseEntity(ResultSet resultSet) throws SQLException;


}
