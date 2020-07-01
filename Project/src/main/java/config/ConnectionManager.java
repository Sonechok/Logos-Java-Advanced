package config;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final Logger log = Logger.getLogger(ConnectionManager.class);

    private static final String URL = "jdbc:mysql://localhost:3306/i_shop?serverTimezone=UTC";

    private static String USER_NAME = "newuser";

    private static String PASSWORD = "12345qwert";

    private static Connection connection;

    private ConnectionManager() {
    }

    public static Connection createConnection() {
        log.info("Creating connection to data base");
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            } catch (SQLException e) {
                log.error("Error while creating connection to data base with user"+ USER_NAME +
                        " and url " + URL, e);
            }
        }
        log.debug("Connection was created successfully");
        return connection;
    }

    public static void closeConnection() {
        log.debug("Close connection");
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                log.error("Error while closing connection to data base with user"+ USER_NAME +
                        " and url " + URL, e);
            }
        }
    }
}
