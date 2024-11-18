package assignment_01.treatment;

import assignment_01.patient.Patient;
import assignment_01.prescription.Prescription;
import java.util.Date;

/**
 * The SurgeryTreatmentPlan class implements the TreatmentPlan interface and is 
 * responsible for generating a treatment plan specifically for surgical procedures. 
 * It encapsulates the business logic related to the creation of a surgery treatment 
 * plan based on patient information.
 * 
 * */


public class SurgeryTreatmentPlan implements TreatmentPlan {
    
    /** 
     * The date when the surgery is scheduled.
     */
    private Date surgeryDate;

    /**
     * Constructs a SurgeryTreatmentPlan with the specified surgery date.
     * 
     * @param surgeryDate The date on which the surgery is scheduled.
     */
    public SurgeryTreatmentPlan(Date surgeryDate) {
        this.surgeryDate = surgeryDate;
    }

    
    /**
     * Creates a treatment plan for the given patient, detailing the need for surgery.
     * 
     * @param patient The patient for whom the treatment plan is being created.
     * @return A String summarizing the patient's diagnosis and surgical requirements.
     */
    @Override
    public String createTreatmentPlan(Patient patient) {
        return "The patient requires surgery for " + patient.getDiseaseType() + ". " +
               "The patient is " + patient.getAge() + " years old.";
    }

    /**
     * Retrieves the scheduled surgery date.
     * 
     * @return The date of the scheduled surgery.
     */
    public Date getSurgeryDate() {
        return surgeryDate;
    }
}