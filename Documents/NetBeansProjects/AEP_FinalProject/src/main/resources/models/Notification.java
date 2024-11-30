package models;

import java.sql.Timestamp;

/**
 * Notification represents a notification entity in the system.
 * 
 * This class contains fields and methods to encapsulate notification details.
 * 
 * @author han
 */
public class Notification {

    private int notificationId; // Unique ID for the notification
    private int userId; // ID of the user to whom the notification is addressed
    private String message; // Notification message
    private String status; // Status of the notification: "unread" or "read"
    private Timestamp notificationDate; // Date and time of the notification

    // Constructors
    public Notification() {
    }

    public Notification(int userId, String message, String status) {
        this.userId = userId;
        this.message = message;
        this.status = status;
    }

    public Notification(int notificationId, int userId, String message, String status, Timestamp notificationDate) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
        this.status = status;
        this.notificationDate = notificationDate;
    }

    // Getters and Setters
    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Timestamp notificationDate) {
        this.notificationDate = notificationDate;
    }

    // Override toString for debugging
    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", userId=" + userId +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", notificationDate=" + notificationDate +
                '}';
    }
}