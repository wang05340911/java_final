package services;

import daos.UserDAO;
import models.User;

/**
 * ProfileService handles business logic related to user profiles,
 * interacting with UserDAO to manage user data.
 * 
 * This service abstracts profile-related logic from the servlet layer.
 * 
 * @author han
 */
public class ProfileService {

    private UserDAO userDAO;

    // Constructor
    public ProfileService() {
        this.userDAO = new UserDAO();
    }

    public ProfileService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // Retrieve user profile by user ID
    public User getProfileById(int userId) {
        return userDAO.getUserById(userId);
    }

    // Update user profile
    public boolean updateProfile(User user) {
        if (validateProfile(user)) {
            return userDAO.updateUser(user);
        }
        return false;
    }

    // Validate profile data
    private boolean validateProfile(User user) {
        if (user == null) {
            return false;
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            return false;
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            return false;
        }
        return true;
    }

    // Change user password
    public boolean changePassword(int userId, String newPassword) {
        User user = userDAO.getUserById(userId);
        if (user != null && validatePassword(newPassword)) {
            user.setPassword(hashPassword(newPassword));
            return userDAO.updateUser(user);
        }
        return false;
    }

    // Validate password (basic rules)
    private boolean validatePassword(String password) {
        return password != null && password.length() >= 8; // Add more rules as needed
    }

    // Hash password (placeholder method, replace with real hashing logic)
    private String hashPassword(String rawPassword) {
        // Use a secure hashing algorithm like BCrypt or Argon2
        return rawPassword; // Placeholder
    }

    // Cleanup resources
    public void close() {
        userDAO.close();
    }
}