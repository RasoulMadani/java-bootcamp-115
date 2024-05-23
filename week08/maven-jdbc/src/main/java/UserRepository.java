import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {
    Connection connection = DatabaseConnection.connection();

    public UserRepository() throws SQLException, ClassNotFoundException {
    }

    public void addUserToDatabase(User user) throws SQLException, ClassNotFoundException {
        String query = "insert into users (firstname,lastname,username,password) values ( ? , ? , ? , ? )";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getFirstname());
        statement.setString(2, user.getLastname());
        statement.setString(3, user.getUsername());
        statement.setString(4, user.getPassword());
        statement.executeUpdate(query);
        System.out.println("inserted ...");
    }
    public void deleteUser(int id) throws SQLException, ClassNotFoundException {
        String query = "delete from users where id=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate(query);
        System.out.println("deleted ...");
    }
}
