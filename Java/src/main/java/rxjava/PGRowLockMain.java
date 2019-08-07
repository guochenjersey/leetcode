package rxjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PGRowLockMain {
    public static void main(String... args) throws SQLException {
        Connection connection = connection();

    }

    private static Connection connection() throws SQLException {
        String url = "jdbc:postgresql://localhost:8001/maxxdb";
        Properties props = new Properties();
        props.setProperty("user","maxxsys");
        props.setProperty("password","Flex123!");
        return DriverManager.getConnection(url, props);
    }
}


