<%-- 
    Document   : notifications
    Created on : Nov 28, 2024, 12:35:13 p.m.
    Author     : han
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Notification"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notifications</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }
            .container {
                max-width: 800px;
                margin: 50px auto;
                background: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            h1 {
                text-align: center;
                color: #333;
            }
            .notification {
                border-bottom: 1px solid #ddd;
                padding: 10px 0;
            }
            .notification:last-child {
                border-bottom: none;
            }
            .notification-title {
                font-weight: bold;
                color: #007BFF;
            }
            .notification-date {
                font-size: 0.9em;
                color: gray;
            }
            .no-notifications {
                text-align: center;
                color: red;
                margin: 20px 0;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Notifications</h1>
            <%
                // 获取通知列表
                List<Notification> notifications = (List<Notification>) request.getAttribute("notifications");
                if (notifications != null && !notifications.isEmpty()) {
            %>
            <% for (Notification notification : notifications) { %>
            <div class="notification">
                <div class="notification-title"><%= notification.getTitle() %></div>
                <div class="notification-date"><%= notification.getDate() %></div>
                <p><%= notification.getMessage() %></p>
            </div>
            <% } %>
            <% } else { %>
                <p class="no-notifications">No notifications available.</p>
            <% } %>
        </div>
    </body>
</html>