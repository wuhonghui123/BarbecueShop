import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CloseResource {
    public static void close(ResultSet rs, Statement st, Connection conn)
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

    public static void close(Statement st, Connection conn)
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
