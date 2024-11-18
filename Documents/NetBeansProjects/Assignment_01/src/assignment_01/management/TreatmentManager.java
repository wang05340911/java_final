/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_01.management;

import assignment_01.patient.Patient;
import assignment_01.treatment.SurgeryTreatmentPlan;
import assignment_01.treatment.TreatmentPlan;

/**
 The TreatmentManager class is responsible for managing the creation of 
 * treatment plans for patients. It utilizes the PatientAgeCalculator to 
 * determine a patient's age and life stage and then delegates the creation 
 * of the treatment plan to a specified TreatmentPlan implementation.
 * 
 * This class serves as a mediator between patient data and the treatment 
 * planning process, ensuring that the patient's age and life stage are 
 * correctly accounted for in the treatment plan.
 */
public class TreatmentManager {
    
  
    
    private PatientAgeCalculator ageCalculator = new PatientAgeCalculator();
    private final TreatmentPlan treatmentPlan;

    /**
     * Constructs a TreatmentManager with the specified TreatmentPlan.
     * 
     * This constructor initializes the TreatmentManager with a specific 
     * treatment plan implementation that will be used to create treatment 
     * plans for patients.
     * @param treatmentPlan The treatment plan implementation to use; 
     *                   
     */
    public TreatmentManager(TreatmentPlan treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    /**
    * Creates a treatment plan for the specified patient.
     * 
     * This method calculates the patient's age and determines their life 
     * stage based on their date of birth. It then uses the provided treatment 
     * plan to create a treatment plan specific to the patient.
     *
     * @param patient The patient for whom the treatment plan is being created; 
     *                must not be null
     */
    public void createTreatmentPlan(Patient patient) {
        // Calculate patient's age and life stage
        patient.setAge(ageCalculator.calculatePatientAge(patient.getDateOfBirth()));
        patient.setLifeStage(ageCalculator.determineLifeStage(patient.getAge()));

        // Use the injected treatment plan to create the treatment
        treatmentPlan.createTreatmentPlan(patient);
    }
}