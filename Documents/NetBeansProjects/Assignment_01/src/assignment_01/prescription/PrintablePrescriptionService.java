package assignment_01.prescription;

import assignment_01.patient.Patient;
import assignment_01.treatment.MedicationTreatmentPlan;
import assignment_01.treatment.SurgeryTreatmentPlan;
import assignment_01.treatment.TreatmentPlan;
import java.util.Date;
/**
 * The PrintablePrescriptionService class implements the PrescriptionService interface
 * to provide functionality for generating printable prescriptions for patients. 
 * It formats the prescription details in plain text.
 *  
 */
public class PrintablePrescriptionService implements PrescriptionService {

    private TreatmentPlan treatmentPlan;
    
    /**
     * Constructs a PrintablePrescriptionService with the specified treatment plan.
     * 
     * @param treatmentPlan The treatment plan to be used for generating prescriptions.
     */
    
    public PrintablePrescriptionService(TreatmentPlan treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    /**
     * Generates a prescription for the specified patient based on their treatment plan.
     * 
     * The generated prescription includes the patient's name, date of birth, 
     * diagnosis, and treatment details formatted in plain text. It handles both 
     * medication and surgery treatment plans.
     * 
     * @param patient The patient for whom the prescription is generated.
     * @return A String representation of the prescription in plain text format.
     */

    @Override
    public String generatePrescription(Patient patient) {
        StringBuilder prescription = new StringBuilder();

        prescription.append("Treatment Details \n");
        prescription.append("========================\n");
        prescription.append("Patient Name: ").append(patient.getName()).append("\n");
        prescription.append("Date of Birth: ").append(patient.getDateOfBirth()).append("\n");

        
        String diagnosis = treatmentPlan.createTreatmentPlan(patient);              // Generated diagnosis using the treatment plan
        prescription.append("Diagnosis: ").append(diagnosis).append("\n");
        
         Prescription prescriptionDetails;
        if (treatmentPlan instanceof MedicationTreatmentPlan) {
            prescriptionDetails = new Prescription(patient.getAge(), diagnosis); // For Medication
            prescription.append("Treatment Plan:\n");
            prescription.append(prescriptionDetails.displayPrescriptionDetails()).append("\n");
        } else if (treatmentPlan instanceof SurgeryTreatmentPlan) {
            
            Date surgeryDate = ((SurgeryTreatmentPlan) treatmentPlan).getSurgeryDate(); 
            prescriptionDetails = new Prescription(patient.getAge(), surgeryDate, diagnosis); // For Surgery
            prescription.append("Treatment Plan:\n");
            prescription.append(prescriptionDetails.displaySurgeryDetails()).append("<\n");
        }
        
         
                return prescription.toString();
    }
}