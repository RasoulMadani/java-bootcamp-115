import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection {
    public static void main(String[] args) {
        try {
            // ساخت اتصال به پایگاه داده
            java.sql.Connection connection =
                    DriverManager.getConnection(
                            "jdbc:mysql://sahand.liara.cloud:33333/jdbc",
                            "root",
                            "OtyJennMi0FmHTmxIgbwgwda"
                    );

              // ساخت استیتمنت
            Statement statement = connection.createStatement();
            // چاپ اطلاعات
            ResultSet resultSet = statement.executeQuery("SELECT * from student where firstname='mohammad'");
            while (resultSet.next()){
                System.out.println(resultSet.getString("firstname"));
                System.out.println(resultSet.getString("lastname"));
                System.out.println(resultSet.getString("studentid"));
            }
            
            // حذف اطلاعات
//            statement.executeUpdate("delete from student where firstname='mohammad' and lastname='mohammadi'");
//            System.out.println("deleted"); //dml

            // به روز رسانی اطلاعات
//            statement.executeUpdate("update student set studentid='112' where firstname='mohammad' and lastname='mohammadi'");
//            System.out.println("updated ...");

            // وارد کردن اطلاعات
//            statement.executeUpdate("insert into student (firstname,lastname,studentid) values ('mohammad','mohammadi',12345)");
//            System.out.println("inserted ...");



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
