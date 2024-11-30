package models;

import java.util.List;

/**
 * AcademicInstitution represents an academic institution entity,
 * extending the base User class.
 * 
 * This class contains fields and methods specific to institutions,
 * including address and offered courses.
 * 
 * @author han
 */
public class AcademicInstitution extends User {

    private String address; // Institution address
    private List<String> coursesOffered; // List of courses offered by the institution
    private String institutionName; // Name of the institution

    // Default Constructor
    public AcademicInstitution() {
        super();
        this.setUserType("institution"); // Default user type for this class
    }

    // Parameterized Constructor
    public AcademicInstitution(String name, String email, String password, String institutionName,
                                String address, List<String> coursesOffered) {
        super(name, email, password, "institution");
        this.address = address;
        this.coursesOffered = coursesOffered;
        this.institutionName = institutionName;
    }

    // Getters and Setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getCoursesOffered() {
        return coursesOffered;
    }

    public void setCoursesOffered(List<String> coursesOffered) {
        this.coursesOffered = coursesOffered;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    // Get the number of courses offered
    public int getNumberOfCourses() {
        return (coursesOffered != null) ? coursesOffered.size() : 0;
    }

    // Override toString for debugging
    @Override
    public String toString() {
        return "AcademicInstitution{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", institutionName='" + institutionName + '\'' +
                ", address='" + address + '\'' +
                ", coursesOffered=" + coursesOffered +
                '}';
    }
}