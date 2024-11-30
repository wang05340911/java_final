package daos;

import java.sql.*;
import models.User;
import utils.DatabaseConnection;

/**
 * UserDAO provides CRUD operations for the User entity.
 * 
 */
public class UserDAO {
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver"; // Updated to latest driver
    private static final String DB_URL = "jdbc:mysql://localhost:3306/aep";
    private static final String DB_USER = "root";                           //add my credentials to test the mysql connection
    private static final String DB_PASSWORD = "@15April2002";

    // Register a new user
    public boolean registerUser(User user) {
        String query = "INSERT INTO Users (name, email, password, userType, currentInstitution, academicPosition, institutionName) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD );
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword()); // Consider hashing the password
            stmt.setString(4, user.getUserType());
            stmt.setString(5, user.getCurrentInstitution());
            stmt.setString(6, user.getAcademicPosition());
            stmt.setString(7, user.getInstitutionName());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Authenticate a user by email and password
    public User authenticate(String email, String password) {
        String query = "SELECT * FROM Users WHERE email = ? AND password = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            stmt.setString(2, password); // Consider hashing the password for security
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if authentication fails
    }

    // Retrieve a user by their ID
    public User getUserById(int userId) {
        String query = "SELECT * FROM Users WHERE userId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractUserFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update user information
    public boolean updateUser(User user) {
        String query = "UPDATE Users SET name = ?, email = ?, currentInstitution = ?, academicPosition = ?, institutionName = ? "
                     + "WHERE userId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getCurrentInstitution());
            stmt.setString(4, user.getAcademicPosition());
            stmt.setString(5, user.getInstitutionName());
            stmt.setInt(6, user.getId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a user by their ID
    public boolean deleteUser(int userId) {
        String query = "DELETE FROM Users WHERE userId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Extract a User object from ResultSet
    private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("userId"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setUserType(rs.getString("userType"));
        user.setCurrentInstitution(rs.getString("currentInstitution"));
        user.setAcademicPosition(rs.getString("academicPosition"));
        user.setInstitutionName(rs.getString("institutionName"));
        return user;
    }

    // Close resources (optional, handled by DatabaseConnection)
    public void close() {
        // Close resources if needed
    }
}