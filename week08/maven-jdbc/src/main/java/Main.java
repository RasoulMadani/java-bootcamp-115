import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            java.sql.Connection connection =
                    DriverManager.getConnection(
                            "jdbc:postgresql://sahand.liara.cloud:33385/postgres",
                            "root",
                            "rZn4MeI7tuET5E5PVWcAluFO"
                    );
            // ساخت استیتمنت
            Statement statement = connection.createStatement();
            // چاپ اطلاعات
            ResultSet resultSet = statement.executeQuery("SELECT * from artist");
            System.out.println(resultSet);
            while (resultSet.next()){
                System.out.println(resultSet.getString("name") );
                System.out.println(resultSet.getString("age") );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
