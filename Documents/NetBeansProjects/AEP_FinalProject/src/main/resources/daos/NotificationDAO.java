package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.Notification;
import utils.DatabaseConnection;

/**
 * NotificationDAO provides CRUD operations for the Notification entity.
 * 
 * @author han
 */
public class NotificationDAO {
     private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver"; // Updated to latest driver
    private static final String DB_URL = "jdbc:mysql://localhost:3306/aep";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "@15April2002";               //add my credentials to test the mysql connection

    public NotificationDAO() throws ClassNotFoundException {
        Class.forName(DRIVER_NAME);
    }
    // Create a new notification
    public boolean createNotification(Notification notification) {
        String query = "INSERT INTO Notifications (userId, message, status, notificationDate) "
                     + "VALUES (?, ?, ?, NOW())";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, notification.getUserId());
            stmt.setString(2, notification.getMessage());
            stmt.setString(3, notification.getStatus());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve all notifications for a specific user
    public List<Notification> getNotificationsByUserId(int userId) {
        List<Notification> notifications = new ArrayList<>();
        String query = "SELECT * FROM Notifications WHERE userId = ? ORDER BY notificationDate DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Notification notification = extractNotificationFromResultSet(rs);
                    notifications.add(notification);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notifications;
    }

    // Retrieve a specific notification by its ID
    public Notification getNotificationById(int notificationId) {
        String query = "SELECT * FROM Notifications WHERE notificationId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, notificationId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return extractNotificationFromResultSet(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Delete a specific notification by its ID
    public boolean deleteNotification(int notificationId) {
        String query = "DELETE FROM Notifications WHERE notificationId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, notificationId);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Mark a notification as read
    public boolean markAsRead(int notificationId) {
        String query = "UPDATE Notifications SET status = 'read' WHERE notificationId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, notificationId);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Extract a Notification object from ResultSet
    private Notification extractNotificationFromResultSet(ResultSet rs) throws SQLException {
        Notification notification = new Notification();
        notification.setNotificationId(rs.getInt("notificationId"));
        notification.setUserId(rs.getInt("userId"));
        notification.setMessage(rs.getString("message"));
        notification.setStatus(rs.getString("status"));
        notification.setNotificationDate(rs.getTimestamp("notificationDate"));
        return notification;
    }

    // Close resources (optional, handled by DatabaseConnection)
    public void close() {
        // Close any resources if needed
    }
}