package assignment_01.management;

import assignment_01.patient.Patient;
import assignment_01.prescription.PrescriptionService;
import assignment_01.treatment.TreatmentPlan;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


/**
 * The PatientManagement class is designed for use by physicians to manage 
 * patient treatment and prescription workflows. This class encapsulates the 
 * logic for creating treatment plans and generating prescriptions, which 
 * are essential tasks in patient care.
 * 
 * This class utilizes a treatment plan and a prescription service, 
 * both of which are injected via the constructor. This approach facilitates 
 * flexibility and adherence to the Dependency Inversion Principle, allowing 
 * for easier unit testing and maintenance.
 */
public class PatientManagement {
    
    private final TreatmentPlan treatmentPlan;
    private final PrescriptionService prescriptionService;
    private final ValidatePatientData validator = new ValidatePatientData();
    private final PatientAgeCalculator ageCalculator = new PatientAgeCalculator();

    /**
     * Constructs a new PatientManagement instance with the specified treatment 
     * plan and prescription service.
     * 
     * This constructor initializes the PatientManagement object with the 
     * necessary components to create treatment plans and manage prescriptions 
     * for patients. The treatment plan and prescription service are expected 
     * to handle their respective responsibilities when called upon.
     *
     * @param treatmentPlan the treatment plan to be used for creating patient 
     *                      treatment plans; must not be null
     * @param prescriptionService the prescription service to be used for 
     *                            generating prescriptions; must not be null
     * 
     *     
     */
    public PatientManagement(TreatmentPlan treatmentPlan, PrescriptionService prescriptionService) {
        this.treatmentPlan = treatmentPlan;
        this.prescriptionService = prescriptionService;
    }

    public boolean addPatient(Patient patient) {
        
        if (!validator.validatePatientData(patient)) {
            System.out.println("Invalid patient data.");
            return false;
        }
        
        long age = ageCalculator.calculatePatientAge(patient.getDateOfBirth());
        patient.setAge(age);
        String lifeStage = ageCalculator.determineLifeStage(age);
        return true;
    }
    /**
     * Creates a treatment plan for the specified patient and prints the 
     * details of the created treatment plan to the console.
     * 
     * This method interacts with the treatmentPlan object to generate 
     * a treatment plan based on the patient's information. It calls the 
     * createTreatmentPlan method of the TreatmentPlan class and prints 
     * the resulting treatment details.
     *
     * @param patient the patient for whom the treatment plan is to be created; 
     *                must not be null
     *
     */
    public void createTreatmentPlan(Patient patient) {
        String treatmentDetails = treatmentPlan.createTreatmentPlan(patient);
        System.out.println("Treatment Plan Created: " + treatmentDetails);
    }


    
    /**
     * Generates a prescription for the specified patient and saves it to a 
     * file with the given filename.
     * 
     * This method utilizes the prescriptionService to generate a 
     * prescription based on the patient's details. It then writes the 
     * generated prescription to a specified file. If the file already exists, 
     * it will be overwritten.
     *
     * @param patient the patient for whom the prescription is to be generated; 
     *                must not be null
     * @param filename the name of the file where the prescription will be saved; 
     *                 must not be null or empty
     * 
     * @throws IOException if an error occurs while writing the prescription to 
     *                     the file
     * 
     */
    public void generatePrescription(Patient patient, String filename) throws IOException {
        String prescription = prescriptionService.generatePrescription(patient);
        try (BufferedWriter bwriter = new BufferedWriter(new FileWriter(filename))) {
            bwriter.write(prescription);
        }
        System.out.println("Prescription saved to file: " + filename);
    }

}