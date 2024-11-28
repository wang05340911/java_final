package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseConnection manages database connections for the application.
 * 
 * This class provides a centralized way to connect to the database,
 * ensuring proper resource management.
 * 
 * @author han
 */
public class DatabaseConnection {

    // Database connection properties
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Aa880911";

    // JDBC Driver
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // Singleton Connection
    private static Connection connection = null;

    // Private constructor to prevent instantiation
    private DatabaseConnection() {
    }

    // Get a connection instance
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Load JDBC Driver
                Class.forName(DRIVER);

                // Establish connection
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                System.out.println("Database connection established.");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to establish database connection.", e);
            }
        }
        return connection;
    }

    // Close the connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}