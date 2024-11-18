package assignment_01.Physician;

import assignment_01.management.PatientManagement;
import assignment_01.management.ValidatePatientData;
import assignment_01.patient.Inpatient;
import assignment_01.patient.Outpatient;
import assignment_01.prescription.OnlinePrescriptionService;
import assignment_01.prescription.PrintablePrescriptionService;
import assignment_01.treatment.MedicationTreatmentPlan;
import assignment_01.treatment.SurgeryTreatmentPlan;
import assignment_01.treatment.TreatmentPlan;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

  /**
 * The Physician class serves as the entry point for the patient management system. 
 * It creates patient instances, validates their data, and generates treatment plans 
 * and prescriptions for both inpatient and outpatient scenarios.
 */
  

public class Physician {
	 /**
     * The main method is the entry point of the application. It creates instances of 
     * inpatient and outpatient patients, validates their data, generates treatment plans, 
     * and creates prescriptions in various formats.
     *
     * @param args command-line arguments (not used in this application)
     * @throws IOException if there is an error while writing prescription files
     */
    public static void main(String[] args) throws IOException {
    	
    	
      
        Inpatient inpatient = new Inpatient("11","John Cena","cena@outlook.com","5432174567", "1997-10-17", "C212");
        inpatient.setDiseaseType("Broken Leg");
        Outpatient outpatient = new Outpatient("12","Maria Schulich","Schulich@outlook.com","3436784567", "1980-10-27","2024-10-11");
         outpatient.setDiseaseType("Chronic");
             
        ValidatePatientData validate = new ValidatePatientData();
        if(!validate.validatePatientData(inpatient) || !validate.validatePatientData(outpatient)){
            System.out.println("Patient data validation failed.");
        }else{
            System.out.println("Patient validation successfull");
        }
        
       
                
        TreatmentPlan medicationTreatmentPlan = new MedicationTreatmentPlan();      //Instantiate mediacation treatmeant plan
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.OCTOBER, 25); 
        Date surgeryDate = calendar.getTime();
        TreatmentPlan surgeryTreatmentPlan = new SurgeryTreatmentPlan(surgeryDate); //Instantiate surgeryTreatment plan

        
        PatientManagement outpatientManagementHtml = new PatientManagement(medicationTreatmentPlan, new OnlinePrescriptionService(medicationTreatmentPlan)); //Prescription is being created based on the treatment plan
        PatientManagement outpatientManagementTxt = new PatientManagement(medicationTreatmentPlan, new PrintablePrescriptionService(medicationTreatmentPlan));

        PatientManagement inpatientSurgery = new PatientManagement(surgeryTreatmentPlan, new OnlinePrescriptionService(surgeryTreatmentPlan));
        
        inpatientSurgery.createTreatmentPlan(inpatient);
        inpatientSurgery.generatePrescription(inpatient, "John_surgery.html");
        
        PatientManagement inpatientSurgeryTxt = new PatientManagement(surgeryTreatmentPlan, new PrintablePrescriptionService(surgeryTreatmentPlan));
        inpatientSurgeryTxt.createTreatmentPlan(inpatient);
        inpatientSurgeryTxt.generatePrescription(inpatient, "John_surgery.txt");

        
        // Create treatment plans for each patient
        outpatientManagementHtml.createTreatmentPlan(outpatient);
        outpatientManagementTxt.createTreatmentPlan(outpatient);

        
        outpatientManagementHtml.generatePrescription(outpatient, "Maria_Schulich_prescription.html");
        outpatientManagementTxt.generatePrescription(outpatient, "Maria_Schulich_prescription.txt");

           }
}