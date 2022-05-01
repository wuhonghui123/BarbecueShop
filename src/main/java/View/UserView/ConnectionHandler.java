package View.UserView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandler {
    public static ThreadLocal<Connection> threadLocal=new ThreadLocal<>();

    public static Connection getConn()throws SQLException{
        Connection conn=threadLocal.get();

        if(conn==null){

            try {
                String user = "root";
                String dbPassword = "123456";
                String url = "jdbc:mysql://120.25.164.209:3306/teashop?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

                /*String user = "root";
                String dbPassword = "123456";
                String url = "jdbc:mysql://120.25.164.209:3306/barbecueshopsystem?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
*/


                conn = DriverManager.getConnection(url, user, dbPassword);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            threadLocal.set(conn);
        }
        return conn;
    }
    public static void closeConnection() throws SQLException {
        Connection conn=threadLocal.get();
        if(conn!=null){
            conn.close();
            threadLocal.remove();

        }
    }
}
