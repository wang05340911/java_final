package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import daos.UserDAO;

/**
 * ProfileServlet handles user profile view and update operations.
 * 
 * @author han
 */
@WebServlet(name = "ProfileServlet", urlPatterns = {"/profile"})
public class ProfileServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        userDAO = new UserDAO(); // Initialize DAO
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login");
            return;
        }

        // Retrieve user from session
        User user = (User) session.getAttribute("user");
        request.setAttribute("user", user);

        // Forward to profile view page
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login");
            return;
        }

        // Retrieve user from session
        User user = (User) session.getAttribute("user");

        // Update profile details
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String currentInstitution = request.getParameter("currentInstitution");
        String academicPosition = request.getParameter("academicPosition");

        user.setName(name);
        user.setEmail(email);
        user.setCurrentInstitution(currentInstitution);
        user.setAcademicPosition(academicPosition);

        // Update user in database
        boolean isUpdated = userDAO.updateUser(user);

        if (isUpdated) {
            session.setAttribute("user", user); // Update session user
            request.setAttribute("successMessage", "Profile updated successfully.");
        } else {
            request.setAttribute("errorMessage", "Error updating profile. Please try again.");
        }

        // Forward to profile page
        request.setAttribute("user", user);
        request.getRequestDispatcher("/profile.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        userDAO.close(); // Close DAO resources
    }
}