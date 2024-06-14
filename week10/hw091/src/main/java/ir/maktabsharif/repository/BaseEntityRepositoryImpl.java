package ir.maktabsharif.repository;

import ir.maktabsharif.entity.BaseEntity;
import ir.maktabsharif.config.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseEntityRepositoryImpl<T extends BaseEntity<ID>,ID> implements BaseEntityRepository<T,ID> {


    protected final Connection connection = DataSource.getConnection();

    public static final String FIND_ALL_QUERY_TEMPLATE = "select * from %s";
    public static final String COUNT_ALL_QUERY_TEMPLATE = "select count(*) from %s";

    public static final String FIND_BY_ID_QUERY_TEMPLATE = "select * from %s where id = ?";
    public static final String DELETE_BY_ID_QUERY_TEMPLATE = "delete from %s where id = ?";

    public static final String DELETE_ALL_QUERY_TEMPLATE = "delete from %s where id > 0";
    public static final String EXISTS_BY_ID_QUERY_TEMPLATE = "select count(*) from %s where id = ?";


    public abstract T save(T entity);

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public T[] findAll() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    getFindAllQuery()
            );
            ResultSet resultSet = preparedStatement.executeQuery();
//            T[] baseEntities = new BaseEntity[(int) count()];
            T[] baseEntities = getEntityArrayForFindAll();
            int arrayIndex = 0;
            while (resultSet.next()) {
                baseEntities[arrayIndex++] = mapResultSetToEntity(resultSet);
            }

            return baseEntities;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public T findById(ID id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                getFindByIdQuery()
        );
        preparedStatement.setObject(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
//        if (resultSet.next()) {
//            return mapResultSetToBaseEntity(resultSet);
//        }
//        return null;
        return resultSet.next() ? mapResultSetToEntity(resultSet) : null;
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
    public boolean deleteById(ID id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        DELETE_BY_ID_QUERY_TEMPLATE,
                        getTableName()
                )
        );
        preparedStatement.setObject(1, id);
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean existsById(ID id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(
                        EXISTS_BY_ID_QUERY_TEMPLATE,
                        getTableName()
                )
        );
        preparedStatement.setObject(1, id);
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

    protected abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;
    protected abstract T[] getEntityArrayForFindAll() throws SQLException;

}
