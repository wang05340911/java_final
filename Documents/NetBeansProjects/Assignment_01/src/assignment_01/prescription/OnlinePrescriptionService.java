package assignment_01.prescription;

import assignment_01.patient.Patient;
import assignment_01.treatment.MedicationTreatmentPlan;
import assignment_01.treatment.SurgeryTreatmentPlan;
import assignment_01.treatment.TreatmentPlan;
import java.util.Date;

/**
 * The OnlinePrescriptionService class implements the PrescriptionService interface
 * to provide functionality for generating prescriptions for patients. It generates
 * a prescription based on the patient's information and the treatment plan.
 * 
 * This class supports different types of treatment plans, including medication 
 * and surgery, and formats the prescription details in HTML.
 * 
 */
public class OnlinePrescriptionService implements PrescriptionService {

    private TreatmentPlan treatmentPlan;

    /**
     * Constructs an OnlinePrescriptionService with the specified treatment plan.
     * 
     * @param treatmentPlan The treatment plan to be used for generating prescriptions.
     */
    public OnlinePrescriptionService(TreatmentPlan treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    /**
     * Generates a prescription for the specified patient based on their treatment plan.
     * 
     * The generated prescription includes the patient's name, date of birth, 
     * diagnosis, and treatment details formatted in HTML. It handles both medication 
     * and surgery treatment plans.
     * 
     * @param patient The patient for whom the prescription is generated.
     * @return A String representation of the prescription in HTML format.
     */
    @Override
    public String generatePrescription(Patient patient) {
        StringBuilder prescription = new StringBuilder();

        prescription.append("<html>\n");
        prescription.append("<head><title>Treatment Details</title></head>\n");
        prescription.append("<body>\n");
        prescription.append("<p><strong>Patient Name:</strong> ").append(patient.getName()).append("</p>\n");
        prescription.append("<p><strong>Date of Birth:</strong> ").append(patient.getDateOfBirth()).append("</p>\n");

       
        String diagnosis = treatmentPlan.createTreatmentPlan(patient);           // Generated diagnosis using the treatment plan
        prescription.append("<p><strong>Diagnosis:</strong> ").append(diagnosis).append("</p>\n");

        
        Prescription prescriptionDetails;                               // Created a Prescription instance to get details

        if (treatmentPlan instanceof MedicationTreatmentPlan) {
            prescriptionDetails = new Prescription(patient.getAge(), diagnosis); // For Medication
            prescription.append("<p>Treatment Plan:</p>\n");
            prescription.append("<p>").append(prescriptionDetails.displayPrescriptionDetails()).append("</p>\n");
        } else if (treatmentPlan instanceof SurgeryTreatmentPlan) {
            
            Date surgeryDate = ((SurgeryTreatmentPlan) treatmentPlan).getSurgeryDate(); 
            prescriptionDetails = new Prescription(patient.getAge(), surgeryDate, diagnosis); // For Surgery
            prescription.append("<p>Treatment Plan:</p>\n");
            prescription.append("<p>").append(prescriptionDetails.displaySurgeryDetails()).append("</p>\n");
        }

        prescription.append("</body>\n");
        prescription.append("</html>");

        return prescription.toString();
}
}