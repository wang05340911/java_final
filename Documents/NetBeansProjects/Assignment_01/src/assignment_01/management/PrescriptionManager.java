/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_01.management;

import assignment_01.patient.Patient;
import assignment_01.prescription.OnlinePrescriptionService;
import assignment_01.prescription.PrescriptionService;
import assignment_01.treatment.MedicationTreatmentPlan;
import assignment_01.treatment.TreatmentPlan;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The PrescriptionManager class is responsible for managing prescription 
 * operations related to patients. It utilizes the PrescriptionService to 
 * generate and save prescription information in a specified file format.
 * 
 * This class provides functionality to create a prescription file for 
 * a patient and handles potential I/O errors during file operations.
 * 
 * @author Amritpal Kaur
 */
public class PrescriptionManager {
    
     private final PrescriptionService prescriptionService;

     /**
     * Constructs a PrescriptionManager with the specified PrescriptionService.
     * This constructor enables the PrescriptionManager to utilize the 
     * provided PrescriptionService for generating prescriptions.
     *
     * @param prescriptionService the PrescriptionService instance used 
     *    
      */
    public PrescriptionManager(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    
    /**
     * Creates a prescription file for the specified patient.
     * 
     * This method generates a prescription for the given patient using the 
     * associated PrescriptionService and writes the prescription details to 
     * the specified file.
     *
     * @param patient The patient for whom the prescription is created; 
     *                must not be null
     * @param filename The name of the file to write the prescription to; 
     *                 must not be null or empty
     * @return the filename of the created prescription file
     * 
     * @throws IOException If an I/O error occurs while writing the file.
     */
   
    
    public String generatePrescription(Patient patient, String filename) throws IOException {
         String prescription = prescriptionService.generatePrescription(patient);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(prescription);
        }
        return filename;
    }
    
}
