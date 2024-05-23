import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        UserService userService = new UserService();
        userService.addUserToDB("allah","allah","allah","allah");
        userService.deleteUser(1);

    }

}
