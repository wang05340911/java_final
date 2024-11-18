package assignment_01.treatment;

import assignment_01.patient.Patient;
import assignment_01.prescription.Prescription;


/**
 * The MedicationTreatmentPlan class implements the TreatmentPlan interface and 
 * provides a method for creating a treatment plan specifically for medication. 
 * It generates a prescription based on the patient's age and disease type.
 * 
 */
public class MedicationTreatmentPlan implements TreatmentPlan {
    
      
    /**
     * Creates a treatment plan for a given patient, generating a prescription 
     * based on their age and disease type.
     * 
     * @param patient The patient for whom the treatment plan is being created.
     * @return A String summarizing the diagnosis and medication requirements for the patient.
     */
    @Override
    public String createTreatmentPlan(Patient patient) {
        Prescription prescription = new Prescription(patient.getAge(), patient.getDiseaseType());
        
        return "The patient is diagnosed with " + patient.getDiseaseType() + " and requires medication. " +
               "The patient is " + patient.getAge() + ".";
    }
}