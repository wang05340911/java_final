package models;

import java.sql.Timestamp;

/**
 * RequestToTeach represents a teaching request submitted by an academic professional
 * to an academic institution for a specific course.
 * 
 * This class contains fields and methods to manage teaching requests.
 * 
 * @author han
 */
public class RequestToTeach {

    private int requestId; // Unique ID for the request
    private int courseId; // Foreign key referencing the course
    private int professionalId; // Foreign key referencing the academic professional
    private Timestamp requestDate; // Date and time of the request
    private String status; // Status of the request (e.g., "pending", "accepted", "rejected")
    private String courseTitle; // Optional, for easier display
    private String courseCode; // Optional, for easier display

    // Constructors
    public RequestToTeach() {
    }

    public RequestToTeach(int courseId, int professionalId, String status) {
        this.courseId = courseId;
        this.professionalId = professionalId;
        this.status = status;
    }

    public RequestToTeach(int requestId, int courseId, int professionalId, Timestamp requestDate, String status) {
        this.requestId = requestId;
        this.courseId = courseId;
        this.professionalId = professionalId;
        this.requestDate = requestDate;
        this.status = status;
    }

    // Getters and Setters
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(int professionalId) {
        this.professionalId = professionalId;
    }

    public Timestamp getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Timestamp requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    // Override toString for debugging
    @Override
    public String toString() {
        return "RequestToTeach{" +
                "requestId=" + requestId +
                ", courseId=" + courseId +
                ", professionalId=" + professionalId +
                ", requestDate=" + requestDate +
                ", status='" + status + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }
}