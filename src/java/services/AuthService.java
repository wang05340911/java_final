package services;

import daos.UserDAO;
import models.User;

/**
 * AuthService handles authentication and authorization logic,
 * interacting with UserDAO to validate user credentials and manage sessions.
 * 
 * This service abstracts the authentication logic from the servlet layer.
 * 
 * @author han
 */
public class AuthService {

    private UserDAO userDAO;

    // Constructor
    public AuthService() {
        this.userDAO = new UserDAO();
    }

    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // Authenticate user by email and password
    public User authenticate(String email, String password) {
        // Retrieve user from DAO
        User user = userDAO.authenticate(email, password);

        if (user != null && validatePassword(password, user.getPassword())) {
            return user; // Return authenticated user
        }
        return null; // Authentication failed
    }

    // Validate the password (add hashing if needed)
    private boolean validatePassword(String rawPassword, String storedHashedPassword) {
        // For simplicity, compare raw passwords directly (NOT RECOMMENDED for production).
        // Replace with proper hashing and comparison logic (e.g., BCrypt).
        return rawPassword.equals(storedHashedPassword);
    }

    // Check if the user has the required role (authorization logic)
    public boolean hasRole(User user, String requiredRole) {
        return user != null && requiredRole.equals(user.getUserType());
    }

    // Additional methods (optional)
    // Example: Password hashing
    public String hashPassword(String rawPassword) {
        // Replace with a real password hashing algorithm (e.g., BCrypt).
        return rawPassword; // Placeholder
    }

    public boolean changePassword(int userId, String newPassword) {
        String hashedPassword = hashPassword(newPassword);
        User user = userDAO.getUserById(userId);
        if (user != null) {
            user.setPassword(hashedPassword);
            return userDAO.updateUser(user);
        }
        return false;
    }

    // Cleanup resources
    public void close() {
        userDAO.close();
    }
}