package controllers;

import daos.UserDAO;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * LoginServlet handles user authentication and session management.
 * 
 * It validates user credentials and redirects them based on their user type.
 * 
 * @author han
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() throws ServletException {
        userDAO = new UserDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // Authenticate user
            User user = userDAO.authenticate(email, password);

            if (user != null) {
                // Authentication successful
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                // Redirect based on user type
                if ("professional".equals(user.getUserType())) {
                    response.sendRedirect("dashboardProfessional");
                } else if ("institution".equals(user.getUserType())) {
                    response.sendRedirect("dashboardInstitution");
                } else {
                    response.sendRedirect("home");
                }
            } else {
                // Authentication failed
                request.setAttribute("errorMessage", "Invalid email or password");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "An error occurred during login. Please try again.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        userDAO.close();
    }
}