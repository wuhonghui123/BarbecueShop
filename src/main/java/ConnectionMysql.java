import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMysql {
    static String Url = "jdbc:mysql://127.0.0.1:3306/supermarket?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    static String UserName = "root";
    static String Password = "123456";
    public static Connection getConnection()
    {
        try {
            return DriverManager.getConnection(Url,UserName,Password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}

