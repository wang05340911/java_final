/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author han
 */

import models.Request;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDao {
    private Connection connection;

    public RequestDao(Connection connection) {
        this.connection = connection;
    }

    public List<Request> findByUserId(int userId) throws SQLException {
        List<Request> requests = new ArrayList<>();
        String query = "SELECT * FROM requests WHERE user_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                requests.add(new Request(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("course_id"), rs.getString("status")));
            }
        }
        return requests;
    }

    public void insert(Request request) throws SQLException {
        String query = "INSERT INTO requests (user_id, course_id, status) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, request.getUserId());
            stmt.setInt(2, request.getCourseId());
            stmt.setString(3, request.getStatus());
            stmt.executeUpdate();
        }
    }
}