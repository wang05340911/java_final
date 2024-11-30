package models;

/**
 * User represents a base class for all users in the system.
 * This class contains common fields and methods for all types of users.
 * 
 * @author han
 */
public class User {

    private int id; // Unique ID for the user
    private String name; // User's name
    private String email; // User's email
    private String password; // User's hashed password
    private String userType; // User type: "professional" or "institution"
    private String currentInstitution; // Current institution for professionals (optional)
    private String academicPosition; // Academic position for professionals (optional)
    private String institutionName; // Name of the institution for institutions (optional)

    // Default Constructor
    public User() {
    }

    // Parameterized Constructor
    public User(int id, String name, String email, String password, String userType, 
                String currentInstitution, String academicPosition, String institutionName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.currentInstitution = currentInstitution;
        this.academicPosition = academicPosition;
        this.institutionName = institutionName;
    }

    // Overloaded Constructor for partial initialization
    public User(String name, String email, String password, String userType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCurrentInstitution() {
        return currentInstitution;
    }

    public void setCurrentInstitution(String currentInstitution) {
        this.currentInstitution = currentInstitution;
    }

    public String getAcademicPosition() {
        return academicPosition;
    }

    public void setAcademicPosition(String academicPosition) {
        this.academicPosition = academicPosition;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    // Override toString for debugging
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", userType='" + userType + '\'' +
                ", currentInstitution='" + currentInstitution + '\'' +
                ", academicPosition='" + academicPosition + '\'' +
                ", institutionName='" + institutionName + '\'' +
                '}';
    }
}