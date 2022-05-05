package Connectionsql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface Connectionsql {
    Connection getConnection();

    void close(ResultSet rs, Statement st, Connection conn);

    void close(Statement st, Connection conn);
}
