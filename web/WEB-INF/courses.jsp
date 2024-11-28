<%-- 
    Document   : courses
    Created on : Nov 28, 2024, 12:35:01 p.m.
    Author     : han
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Course"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Courses</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 20px;
            }
            .container {
                max-width: 800px;
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
            table {
                width: 100%;
                border-collapse: collapse;
                margin: 20px 0;
            }
            table th, table td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }
            table th {
                background-color: #f4f4f4;
                font-weight: bold;
            }
            .actions a {
                margin-right: 10px;
                text-decoration: none;
                color: blue;
            }
            .actions a:hover {
                text-decoration: underline;
            }
            .no-data {
                text-align: center;
                color: red;
                margin: 20px 0;
            }
            .add-course {
                display: block;
                margin: 20px 0;
                text-align: right;
            }
            .add-course a {
                text-decoration: none;
                color: white;
                background-color: green;
                padding: 8px 12px;
                border-radius: 4px;
            }
            .add-course a:hover {
                background-color: darkgreen;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Courses</h1>
            <div class="add-course">
                <a href="courses?action=create">Add New Course</a>
            </div>
            <%
                // 从 request 获取课程列表
                List<Course> courses = (List<Course>) request.getAttribute("courses");
                if (courses != null && !courses.isEmpty()) {
            %>
            <table>
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Code</th>
                        <th>Term</th>
                        <th>Schedule</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Course course : courses) { %>
                    <tr>
                        <td><%= course.getTitle() %></td>
                        <td><%= course.getCode() %></td>
                        <td><%= course.getTerm() %></td>
                        <td><%= course.getSchedule() %></td>
                        <td class="actions">
                            <a href="courses?action=edit&id=<%= course.getId() %>">Edit</a>
                            <a href="courses?action=delete&id=<%= course.getId() %>" onclick="return confirm('Are you sure you want to delete this course?')">Delete</a>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
            <% } else { %>
                <p class="no-data">No courses available.</p>
            <% } %>
        </div>
    </body>
</html>