package Connectionsql;

import java.sql.*;

public class Connectionimpl implements Connectionsql {
    @Override
    public  Connection getConnection()
    {
        String Url = "jdbc:mysql://127.0.0.1:3306/supermarket?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String UserName = "root";
        String Password = "123456";
        Connection conn = null;
        try {
             conn = DriverManager.getConnection(Url,UserName,Password);
            return conn;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }


    @Override
    public void close(ResultSet rs, Statement st, Connection conn)
    {
        try {
            if(rs != null)
            {
                rs.close();
            }
            if(st != null)
            {
                st.close();
            }
            if(conn != null)
            {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
@Override
    public  void close(Statement st, Connection conn)
    {
        try {
            if(st != null)
            {
                st.close();
            }
            if(conn != null)
            {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
