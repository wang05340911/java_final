package services;

import daos.NotificationDAO;
import models.Notification;

import java.util.List;

/**
 * NotificationService handles business logic related to notifications,
 * interacting with NotificationDAO to manage notification data.
 * 
 * This service abstracts notification-related logic from the servlet layer.
 * 
 * @author han
 */
public class NotificationService {

    private NotificationDAO notificationDAO;

    // Constructor
    public NotificationService() {
        this.notificationDAO = new NotificationDAO();
    }

    public NotificationService(NotificationDAO notificationDAO) {
        this.notificationDAO = notificationDAO;
    }

    // Create a new notification
    public boolean createNotification(Notification notification) {
        if (validateNotification(notification)) {
            return notificationDAO.createNotification(notification);
        }
        return false;
    }

    // Retrieve notifications for a specific user
    public List<Notification> getNotificationsByUserId(int userId) {
        return notificationDAO.getNotificationsByUserId(userId);
    }

    // Retrieve a specific notification by ID
    public Notification getNotificationById(int notificationId) {
        return notificationDAO.getNotificationById(notificationId);
    }

    // Mark a notification as read
    public boolean markAsRead(int notificationId) {
        return notificationDAO.markAsRead(notificationId);
    }

    // Delete a notification
    public boolean deleteNotification(int notificationId) {
        return notificationDAO.deleteNotification(notificationId);
    }

    // Validate notification data
    private boolean validateNotification(Notification notification) {
        if (notification == null) {
            return false;
        }
        if (notification.getUserId() <= 0) {
            return false;
        }
        if (notification.getMessage() == null || notification.getMessage().isEmpty()) {
            return false;
        }
        return true;
    }

    // Cleanup resources
    public void close() {
        notificationDAO.close();
    }
}