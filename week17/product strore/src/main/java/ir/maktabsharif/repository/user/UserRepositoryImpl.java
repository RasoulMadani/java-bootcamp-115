package ir.maktabsharif.repository.user;


import ir.maktabsharif.entity.User;
import ir.maktabsharif.repository.BaseEntityRepositoryImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRepositoryImpl extends BaseEntityRepositoryImpl<User,Long> implements UserRepository {

    public User findByUsernameAndPassword(String username, String password) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    STR."select * from \{getTableName()} where username= ? and password = ?"
            );
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? (User) mapResultSetToEntity(resultSet) : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public boolean checkExistUsername(String username) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(
                    STR."select * from \{getTableName()} where username= ?"
            );
            preparedStatement.setString(1, username);
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
    public User save(User entity) {
        String insertQuery = """
                insert into users(username,password) values (?,?)
                """;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, entity.getUsername());
            preparedStatement.setString(2, entity.getPassword());
            if (preparedStatement.executeUpdate() > 0) {
                    return  entity;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected String getTableName() {
        return User.TABLE_NAME;
    }

    @Override
    protected User mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getLong("id"), resultSet.getString("username"), resultSet.getString("password"));
    }

    @Override
    protected User[] getEntityArrayForFindAll() {
        try {
            return new User[(int)count()];
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
