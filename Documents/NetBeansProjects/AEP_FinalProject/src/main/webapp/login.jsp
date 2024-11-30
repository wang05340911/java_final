<%-- 
    Document   : login
    Created on : Nov 28, 2024, 12:35:01 p.m.
    Author     : han
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }
            .login-container {
                max-width: 400px;
                margin: 100px auto;
                background: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            h1 {
                text-align: center;
                color: #333;
            }
            form {
                display: flex;
                flex-direction: column;
                gap: 15px;
            }
            label {
                font-weight: bold;
            }
            input {
                padding: 10px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
            button {
                background-color: #007BFF;
                color: white;
                padding: 10px;
                border: none;
                border-radius: 4px;
                font-size: 16px;
                cursor: pointer;
            }
            button:hover {
                background-color: #0056b3;
            }
            .error-message {
                color: red;
                text-align: center;
                margin-bottom: 10px;
            }
            .register-link {
                text-align: center;
                margin-top: 10px;
            }
            .register-link a {
                text-decoration: none;
                color: #007BFF;
            }
            .register-link a:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <div class="login-container">
            <h1>Login</h1>
            <%-- Display error message if provided in request --%>
            <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
            <% if (errorMessage != null) { %>
                <div class="error-message"><%= errorMessage %></div>
            <% } %>
            <form action="/mavenproject1/login" method="post">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" placeholder="Enter your email" required>
                
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" required>
                
                <button type="submit">Login</button>
            </form>
            <div class="register-link">
                <p>Don't have an account? <a href="register.jsp">Register here</a>.</p>
            </div>
        </div>
    </body>
</html>