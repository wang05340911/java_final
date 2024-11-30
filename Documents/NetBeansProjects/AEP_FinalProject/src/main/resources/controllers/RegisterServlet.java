package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.User;
import daos.UserDAO;

/**
 * RegisterServlet handles user registration for both Academic Professionals
 * and Academic Institutions.
 * 
 * 
 */
@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO(); // Initialize DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Forward to registration page
        request.getRequestDispatcher("/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType"); // "professional" or "institution"
        String currentInstitution = request.getParameter("currentInstitution"); // For professionals
        String academicPosition = request.getParameter("academicPosition");     // For professionals
        String institutionName = request.getParameter("institutionName");       // For institutions

        // Validate input
        if (email == null || password == null || userType == null || email.isEmpty() || password.isEmpty()) {
            request.setAttribute("errorMessage", "Email, password, and user type are required.");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        // Create user object based on userType
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password); // Consider hashing the password
        user.setUserType(userType);

        if ("professional".equals(userType)) {
            user.setCurrentInstitution(currentInstitution);
            user.setAcademicPosition(academicPosition);
        } else if ("institution".equals(userType)) {
            user.setInstitutionName(institutionName);
        }

        // Save user in database
        boolean isRegistered = userDAO.registerUser(user);

        if (isRegistered) {
            // Registration successful
            request.setAttribute("successMessage", "Registration successful. Please log in.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            // Registration failed
            request.setAttribute("errorMessage", "Registration failed. Please try again.");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        userDAO.close(); // Close DAO resources
    }
}