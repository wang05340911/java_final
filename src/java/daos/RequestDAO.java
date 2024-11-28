package daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import models.RequestToTeach;
import utils.DatabaseConnection;

/**
 * RequestDAO provides CRUD operations for the RequestToTeach entity.
 * 
 * @author han
 */
public class RequestDAO {

    // Create a new teaching request
    public boolean createRequest(RequestToTeach request) {
        String query = "INSERT INTO Requests (courseId, professionalId, requestDate, status) "
                     + "VALUES (?, ?, NOW(), ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, request.getCourseId());
            stmt.setInt(2, request.getProfessionalId());
            stmt.setString(3, request.getStatus());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieve all requests for a specific academic institution
    public List<RequestToTeach> getRequestsByInstitutionId(int institutionId) {
        List<RequestToTeach> requests = new ArrayList<>();
        String query = "SELECT r.*, c.title, c.code "
                     + "FROM Requests r "
                     + "JOIN Courses c ON r.courseId = c.courseId "
                     + "WHERE c.institutionId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, institutionId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    RequestToTeach request = extractRequestFromResultSet(rs);
                    requests.add(request);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    // Retrieve all requests for a specific academic professional
    public List<RequestToTeach> getRequestsByProfessionalId(int professionalId) {
        List<RequestToTeach> requests = new ArrayList<>();
        String query = "SELECT r.*, c.title, c.code "
                     + "FROM Requests r "
                     + "JOIN Courses c ON r.courseId = c.courseId "
                     + "WHERE r.professionalId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, professionalId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    RequestToTeach request = extractRequestFromResultSet(rs);
                    requests.add(request);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return requests;
    }

    // Update the status of a request (e.g., "pending", "accepted", "rejected")
    public boolean updateRequestStatus(int requestId, String status) {
        String query = "UPDATE Requests SET status = ? WHERE requestId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, status);
            stmt.setInt(2, requestId);

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a request by its ID
    public boolean deleteRequest(int requestId) {
        String query = "DELETE FROM Requests WHERE requestId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, requestId);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Extract a RequestToTeach object from ResultSet
    private RequestToTeach extractRequestFromResultSet(ResultSet rs) throws SQLException {
        RequestToTeach request = new RequestToTeach();
        request.setRequestId(rs.getInt("requestId"));
        request.setCourseId(rs.getInt("courseId"));
        request.setProfessionalId(rs.getInt("professionalId"));
        request.setRequestDate(rs.getTimestamp("requestDate"));
        request.setStatus(rs.getString("status"));
        if (rs.getMetaData().getColumnCount() > 5) {
            request.setCourseTitle(rs.getString("title"));
            request.setCourseCode(rs.getString("code"));
        }
        return request;
    }

    // Close resources (optional, handled by DatabaseConnection)
    public void close() {
        // Close any resources if needed
    }
}