package com.VR;
import java.sql.*;
public class JdbcUtils {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "carry24";
        return DriverManager.getConnection(url,user,password);
    }
    public static PreparedStatement getPreparedStatement(Connection connection,String sql) throws SQLException {
        return connection.prepareStatement(sql);
    }

    public static void close( Statement st, Connection conn,ResultSet rs) {
        if (rs != null) {
            try {
                st.close();
                conn.close();
                rs.close();

            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
