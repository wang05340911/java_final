/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author han
 */

import models.Course;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    private Connection connection;

    public CourseDao(Connection connection) {
        this.connection = connection;
    }

    public List<Course> findAll() throws SQLException {
        List<Course> courses = new ArrayList<>();
        String query = "SELECT * FROM courses";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                courses.add(new Course(rs.getInt("id"), rs.getString("name"), rs.getString("description")));
            }
        }
        return courses;
    }

    public void insert(Course course) throws SQLException {
        String query = "INSERT INTO courses (name, description) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getDescription());
            stmt.executeUpdate();
        }
    }
}