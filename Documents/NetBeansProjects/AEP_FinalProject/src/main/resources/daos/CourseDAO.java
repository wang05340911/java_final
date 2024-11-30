package daos;

import models.Course;
import utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * CourseDAO handles database operations for courses.
 * This class interacts with the Courses table in the database.
 * 
 */
public class CourseDAO {

     private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver"; // Updated to latest driver
    private static final String DB_URL = "jdbc:mysql://localhost:3306/aep";
    private static final String DB_USER = "root";                           //add my credentials to test the mysql connection
    private static final String DB_PASSWORD = "@15April2002";
    
    public CourseDAO() throws ClassNotFoundException {
        Class.forName(DRIVER_NAME);
    }
    /**
     * Create a new course in the database.
     * 
     * @param course The course object to insert.
     * @return true if the course was created successfully; false otherwise.
     */
    public boolean createCourse(Course course) {
        String query = "INSERT INTO Courses (title, code, term, schedule, deliveryMethod, preferredQualifications, compensation, institutionId) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, course.getTitle());
            stmt.setString(2, course.getCode());
            stmt.setString(3, course.getTerm());
            stmt.setString(4, course.getSchedule());
            stmt.setString(5, course.getDeliveryMethod());
            stmt.setString(6, course.getPreferredQualifications());
            stmt.setString(7, course.getCompensation());
            stmt.setInt(8, course.getInstitutionId());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Retrieve all courses from the database.
     * 
     * @return A list of all courses.
     */
    public List<Course> getAllCourses() {
        String query = "SELECT * FROM Courses";
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                courses.add(mapResultSetToCourse(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

    /**
     * Retrieve a course by its ID.
     * 
     * @param courseId The ID of the course.
     * @return The course with the specified ID, or null if not found.
     */
    public Course getCourseById(int courseId) {
        String query = "SELECT * FROM Courses WHERE courseId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, courseId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToCourse(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Update an existing course in the database.
     * 
     * @param course The course object with updated values.
     * @return true if the course was updated successfully; false otherwise.
     */
    public boolean updateCourse(Course course) {
        String query = "UPDATE Courses SET title = ?, code = ?, term = ?, schedule = ?, deliveryMethod = ?, "
                     + "preferredQualifications = ?, compensation = ?, institutionId = ? WHERE courseId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, course.getTitle());
            stmt.setString(2, course.getCode());
            stmt.setString(3, course.getTerm());
            stmt.setString(4, course.getSchedule());
            stmt.setString(5, course.getDeliveryMethod());
            stmt.setString(6, course.getPreferredQualifications());
            stmt.setString(7, course.getCompensation());
            stmt.setInt(8, course.getInstitutionId());
            stmt.setInt(9, course.getId());

            int rowsUpdated = stmt.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Delete a course by its ID.
     * 
     * @param courseId The ID of the course to delete.
     * @return true if the course was deleted successfully; false otherwise.
     */
    public boolean deleteCourse(int courseId) {
        String query = "DELETE FROM Courses WHERE courseId = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, courseId);

            int rowsDeleted = stmt.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Map a ResultSet row to a Course object.
     * 
     * @param rs The ResultSet row.
     * @return A Course object.
     * @throws SQLException If there is an error accessing the ResultSet.
     */
    private Course mapResultSetToCourse(ResultSet rs) throws SQLException {
        return new Course(
                rs.getInt("courseId"),
                rs.getString("title"),
                rs.getString("code"),
                rs.getString("term"),
                rs.getString("schedule"),
                rs.getString("deliveryMethod"),
                rs.getString("preferredQualifications"),
                rs.getString("compensation"),
                rs.getInt("institutionId")
        );
    }

    /**
     * Close any resources if necessary (currently no resources to close).
     */
    public void close() {
        // Add logic if you need to close any persistent resources.
    }
}