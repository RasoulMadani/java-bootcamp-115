import java.sql.SQLException;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public UserService() throws SQLException, ClassNotFoundException {
    }

    public void addUserToDB(String firstname, String lastname, String username, String password) throws SQLException, ClassNotFoundException {
        User user = new User(firstname, lastname, username, password);
        userRepository.addUserToDatabase(user);

    }

    public void deleteUser(int id) throws SQLException, ClassNotFoundException {
        userRepository.deleteUser(id);
    }


}
