<%-- 
    Document   : profile
    Created on : Nov 28, 2024, 12:34:50 p.m.
    Author     : han
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
                padding: 20px;
                background-color: #f4f4f4;
            }
            .profile {
                max-width: 600px;
                margin: 0 auto;
                background: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            h1 {
                text-align: center;
                color: #333;
            }
            .info {
                margin: 10px 0;
            }
            .info span {
                font-weight: bold;
            }
        </style>
    </head>
    <body>
        <div class="profile">
            <h1>User Profile</h1>
            <%
                // 从 session 获取用户信息
                User user = (User) session.getAttribute("user");
                if (user != null) {
            %>
            <div class="info">
                <span>Name:</span> <%= user.getName() %>
            </div>
            <div class="info">
                <span>Email:</span> <%= user.getEmail() %>
            </div>
            <div class="info">
                <span>Role:</span> <%= user.getUserType() %>
            </div>
            <div class="info">
                <span>Institution:</span> <%= user.getInstitutionName() != null ? user.getInstitutionName() : "N/A" %>
            </div>
            <% } else { %>
                <p style="color: red;">No user is logged in. Please <a href="login.jsp">login</a>.</p>
            <% } %>
        </div>
    </body>
</html>