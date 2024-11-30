package controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Notification;
import daos.NotificationDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * NotificationServlet handles notifications for academic professionals and institutions.
 * 
 * @author han
 */
@WebServlet(name = "NotificationServlet", urlPatterns = {"/notifications"})
public class NotificationServlet extends HttpServlet {

    private NotificationDAO notificationDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            notificationDAO = new NotificationDAO(); // Initialize DAO
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotificationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                listNotifications(request, response);
            } else {
                switch (action) {
                    case "view":
                        viewNotification(request, response);
                        break;
                    case "delete":
                        deleteNotification(request, response);
                        break;
                    default:
                        listNotifications(request, response);
                        break;
                }
            }
        } catch (Exception e) {
            throw new ServletException("Error handling GET request", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("create".equals(action)) {
                createNotification(request, response);
            } else {
                response.sendRedirect("notifications");
            }
        } catch (Exception e) {
            throw new ServletException("Error handling POST request", e);
        }
    }

    private void listNotifications(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId"); // Assuming session has userId
        List<Notification> notifications = notificationDAO.getNotificationsByUserId(userId);
        request.setAttribute("notifications", notifications);
        request.getRequestDispatcher("/notifications.jsp").forward(request, response);
    }

    private void viewNotification(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int notificationId = Integer.parseInt(request.getParameter("id"));
        Notification notification = notificationDAO.getNotificationById(notificationId);
        request.setAttribute("notification", notification);
        request.getRequestDispatcher("/notificationDetails.jsp").forward(request, response);
    }

    private void createNotification(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String userId = request.getParameter("userId");
        String message = request.getParameter("message");

        Notification notification = new Notification();
        notification.setUserId(Integer.parseInt(userId));
        notification.setMessage(message);
        notification.setStatus("unread");

        notificationDAO.createNotification(notification);
        response.sendRedirect("notifications");
    }

    private void deleteNotification(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int notificationId = Integer.parseInt(request.getParameter("id"));
        notificationDAO.deleteNotification(notificationId);
        response.sendRedirect("notifications");
    }

    @Override
    public void destroy() {
        notificationDAO.close(); // Close DAO resources
    }
}