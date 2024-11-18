package assignment_01.treatment;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import assignment_01.patient.Outpatient; // Import the specific patient class for testing
import assignment_01.treatment.MedicationTreatmentPlan;

public class MedicationTreatmentPlanTest {

    private MedicationTreatmentPlan medicationPlan;
    private Outpatient outpatient;

    @Before
    public void setUp() {
        // Initialize the MedicationTreatmentPlan
        medicationPlan = new MedicationTreatmentPlan();

        // Initialize an Outpatient patient for testing
        outpatient = new Outpatient(
            "OP001",               // ID
            "John Doe",           // Name
            "john@example.com",   // Email
            "555-1234",           // Phone number
            "1990-06-15",         // Date of birth
            "2024-10-10"          // Appointment date
        );
        // Assign a disease type to the outpatient patient
        outpatient.setDiseaseType("Flu");
    }

    /**
     * Test case for creating a treatment plan for a patient requiring medication.
     */
    @Test
    public void testCreateTreatmentPlan() {
        // Call the createTreatmentPlan method
        String treatmentPlanOutput = medicationPlan.createTreatmentPlan(outpatient);

        // Verify the output contains the expected strings
        assertTrue(treatmentPlanOutput.contains("The patient is diagnosed with Flu and requires medication."));
        assertTrue(treatmentPlanOutput.contains("The patient is " + outpatient.getAge() + "."));
    }

    /**
     * Test case for verifying that the treatment plan generation handles different disease types.
     */
    @Test
    public void testCreateTreatmentPlanWithDifferentDiseaseType() {
        // Change the disease type for testing
        outpatient.setDiseaseType("Cold");

        // Call the createTreatmentPlan method
        String treatmentPlanOutput = medicationPlan.createTreatmentPlan(outpatient);

        // Verify the output contains the expected strings
        assertTrue(treatmentPlanOutput.contains("The patient is diagnosed with Cold and requires medication."));
        assertTrue(treatmentPlanOutput.contains("The patient is " + outpatient.getAge() + "."));
    }
}
