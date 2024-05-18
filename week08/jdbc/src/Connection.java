import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    public static void main(String[] args) {
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            java.sql.Connection connection =
                    DriverManager.getConnection(
                            "jdbc:mysql://root:OtyJennMi0FmHTmxIgbwgwda@sahand.liara.cloud:33333/jdbc",
                            "root",
                            "OtyJennMi0FmHTmxIgbwgwda"
                    );
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from student");
            while (resultSet.next()){
                System.out.println(resultSet.getString("firstname") );
                System.out.println(resultSet.getString("lastname"));
                System.out.println(resultSet.getString("studentid"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
