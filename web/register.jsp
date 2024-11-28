<%-- 
    Document   : register
    Created on : Nov 23, 2024, 7:37:27 p.m.
    Author     : han
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
    <form method="post" action="UserServlet?action=register">
        <label>Name:</label>
        <input type="text" name="name"><br>
        <label>Email:</label>
        <input type="email" name="email"><br>
        <label>Password:</label>
        <input type="password" name="password"><br>
        <button type="submit">Register</button>
    </form>
</body>
</html>