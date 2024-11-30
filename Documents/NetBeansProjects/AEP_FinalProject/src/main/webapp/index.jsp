<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }
            .welcome-container {
                max-width: 400px;
                margin: 100px auto;
                background: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                text-align: center;
            }
            h1 {
                color: #333;
            }
            a {
                display: block;
                margin: 15px 0;
                padding: 10px;
                background-color: #007BFF;
                color: white;
                text-decoration: none;
                border-radius: 4px;
                font-size: 16px;
            }
            a:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <div class="welcome-container">
            <h1>Welcome to the System</h1>
            <a href="register.jsp">Register</a>
            <a href="login.jsp">Login</a>
        </div>
    </body>
</html>
