package util;
import java.sql.*;
public class JDBCUtils {
    public static String goodsurl = "jdbc:mysql://59.110.212.15:3600/final_project?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT";
    public static String goodsroot = "javaweb";
    public static String goodsps = "javaweb";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(goodsurl, goodsroot, goodsps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(Connection connection, PreparedStatement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        close(connection);
    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet set) {
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        close(connection);
    }
}
