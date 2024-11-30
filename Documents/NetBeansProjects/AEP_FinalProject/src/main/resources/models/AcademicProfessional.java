package models;

/**
 * AcademicProfessional represents an academic professional entity,
 * extending the base User class.
 * 
 * @author han
 */
public class AcademicProfessional extends User {

    private String currentInstitution;
    private String academicPosition;
    private String areaOfExpertise;

    // Constructors
    public AcademicProfessional() {
        super();
        this.setUserType("professional"); // Default user type for this class
    }

    public AcademicProfessional(String name, String email, String password, String currentInstitution, String academicPosition, String areaOfExpertise) {
        super(name, email, password, "professional");
        this.currentInstitution = currentInstitution;
        this.academicPosition = academicPosition;
        this.areaOfExpertise = areaOfExpertise;
    }

    // Getters and Setters
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

    public String getAreaOfExpertise() {
        return areaOfExpertise;
    }

    public void setAreaOfExpertise(String areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }

    // Override toString for better debugging
    @Override
    public String toString() {
        return "AcademicProfessional{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", currentInstitution='" + currentInstitution + '\'' +
                ", academicPosition='" + academicPosition + '\'' +
                ", areaOfExpertise='" + areaOfExpertise + '\'' +
                '}';
    }
}