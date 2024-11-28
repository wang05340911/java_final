package models;

/**
 * Course represents a course entity in the system.
 * This class contains fields and methods for managing course data.
 * 
 * @author han
 */
public class Course {

    private int id; // Unique ID for the course
    private String title; // Course title
    private String code; // Course code (e.g., "CST8288")
    private String term; // Term (e.g., "Fall 2024")
    private String schedule; // Schedule (e.g., "Morning" or "Evening")
    private String deliveryMethod; // Delivery method (e.g., "In-Person", "Online")
    private String preferredQualifications; // Required qualifications for teaching this course
    private String compensation; // Compensation for teaching the course
    private int institutionId; // ID of the institution offering this course

    // Default Constructor
    public Course() {
    }

    // Parameterized Constructor
    public Course(String title, String code, String term, String schedule,
                  String deliveryMethod, String preferredQualifications, String compensation, int institutionId) {
        this.title = title;
        this.code = code;
        this.term = term;
        this.schedule = schedule;
        this.deliveryMethod = deliveryMethod;
        this.preferredQualifications = preferredQualifications;
        this.compensation = compensation;
        this.institutionId = institutionId;
    }

    // Parameterized Constructor with ID
    public Course(int id, String title, String code, String term, String schedule,
                  String deliveryMethod, String preferredQualifications, String compensation, int institutionId) {
        this.id = id;
        this.title = title;
        this.code = code;
        this.term = term;
        this.schedule = schedule;
        this.deliveryMethod = deliveryMethod;
        this.preferredQualifications = preferredQualifications;
        this.compensation = compensation;
        this.institutionId = institutionId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    public String getPreferredQualifications() {
        return preferredQualifications;
    }

    public void setPreferredQualifications(String preferredQualifications) {
        this.preferredQualifications = preferredQualifications;
    }

    public String getCompensation() {
        return compensation;
    }

    public void setCompensation(String compensation) {
        this.compensation = compensation;
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    // Override toString for debugging
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", term='" + term + '\'' +
                ", schedule='" + schedule + '\'' +
                ", deliveryMethod='" + deliveryMethod + '\'' +
                ", preferredQualifications='" + preferredQualifications + '\'' +
                ", compensation='" + compensation + '\'' +
                ", institutionId=" + institutionId +
                '}';
    }
}