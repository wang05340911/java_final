package assignment_01.patient;

/**
 * The Inpatient class represents a patient who has been admitted to a 
 * healthcare facility and is assigned a specific room number.
 * 
 * This class extends the Patient class and implements the 
 * AdmittablePatient interface, which requires the implementation 
 * of the admit() method. An Inpatient object contains the patient's 
 * personal information and the room number to which they have 
 * been assigned.
 * 
 * 
 */
public class Inpatient extends Patient implements AdmittablePatient {
    private String roomNumber;

    /**
     * Constructs an Inpatient object with the specified details.
     * 
     * @param id The unique identifier for the patient.
     * @param name The name of the patient.
     * @param email The email address of the patient.
     * @param phoneNumber The phone number of the patient.
     * @param dateOfBirth The date of birth of the patient in a 
     *                    specified format.
     * @param roomNumber The room number assigned to the inpatient.
     */

    public Inpatient(String id, String name,  String email, String phoneNumber, String dateOfBirth, String roomNumber) {
        super(id, name, email, phoneNumber, dateOfBirth);
        this.roomNumber = roomNumber;
    } 

    /**
     * Retrieves the room number assigned to the inpatient.
     * 
     * @return The room number as a String.
     */
    public String getRoomNumber() {
        return roomNumber;
    }
    
     /**
     * Admits the inpatient to the specified room.
     * 
     * This method prints a message indicating that the patient 
     * has been admitted to their assigned room.
     */
	@Override
	public void admit() {
		System.out.print(getName() + " has been admitted to " + getRoomNumber());
		
	}
}
