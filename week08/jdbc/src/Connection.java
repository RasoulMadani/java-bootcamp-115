import java.sql.*;

public class Connection {
//    static  final ...
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
//            Statement statement = connection.createStatement();
             String query= "SELECT * from student where firstname= ? ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,"mohammad");
//            statement.setInt(); bach دسته ای
            // چاپ اطلاعات
            ResultSet resultSet = statement.executeQuery();
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
//            statement.executeUpdate("insert into student (firstname,lastname,studentid) values ('mohammad1','mohammadi1',123451)");
//            System.out.println("inserted ...");



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
