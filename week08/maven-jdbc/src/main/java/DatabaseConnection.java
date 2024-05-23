import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String url = "jdbc:postgresql://sahand.liara.cloud:33385/postgres";
    private static final String username = "root";
    private static final String password = "rZn4MeI7tuET5E5PVWcAluFO";

    public static Connection connection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        java.sql.Connection connection =
                DriverManager.getConnection(
                        url,
                        username,
                        password
                );
        return connection;
    }
}
