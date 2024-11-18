package assignment_01.patient;


/**
 * The Outpatient class represents a patient who receives medical care 
 * without being admitted to a healthcare facility.
 * 
 * This class extends the Patient class and includes an additional 
 * property for the appointment date. An Outpatient object contains 
 * the patient's personal information along with their scheduled 
 * appointment date.
 * 
 */
public class Outpatient extends Patient {
	
    private String appointmentDate;
    String diseaseType;

     /**
     * Constructs an Outpatient object with the specified details.
     * 
     * @param id The unique identifier for the patient.
     * @param name The name of the patient.
     * @param email The email address of the patient.
     * @param phoneNumber The phone number of the patient.
     * @param dateOfBirth The date of birth of the patient in a 
     *                    specified format.
     * @param appointmentDate The date of the outpatient's appointment.
     */
    public Outpatient(String id, String name, String email, String phoneNumber, String dateOfBirth, String appointmentDate) {
        super(id, name, email, phoneNumber, dateOfBirth);
        this.appointmentDate = appointmentDate;
    }


    public String getDiseasType(){
        return this.diseaseType;
    }
    
    public void setDiseaseType(){
        
    }
    /**
     * Retrieves the appointment date for the outpatient.
     * 
     * @return The appointment date as a String.
     */
    public String getAppointmentDate() {
        return appointmentDate;
    }

	
}

