package assignment_01.treatment;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import assignment_01.patient.Outpatient; // Import the specific patient class for testing
import assignment_01.treatment.SurgeryTreatmentPlan;
import java.util.Date;

public class SurgeryTreatmentPlanTest {

    private SurgeryTreatmentPlan surgeryPlan;
    private Outpatient outpatient;

    @Before
    public void setUp() {
        // Initialize the SurgeryTreatmentPlan with a specific surgery date
        surgeryPlan = new SurgeryTreatmentPlan(new Date());

        // Initialize an Outpatient patient for testing
        outpatient = new Outpatient(
            "OP002",               // ID
            "Jane Smith",          // Name
            "jane@example.com",    // Email
            "555-5678",            // Phone number
            "1985-02-20",          // Date of birth
            "2024-10-15"           // Appointment date
        );
        // Assign a disease type to the outpatient patient
        outpatient.setDiseaseType("Appendicitis");
    }

    /**
     * Test case for creating a treatment plan for a patient requiring surgery.
     */
    @Test
    public void testCreateTreatmentPlan() {
        // Call the createTreatmentPlan method
        String treatmentPlanOutput = surgeryPlan.createTreatmentPlan(outpatient);

        // Verify the output contains the expected strings
        assertTrue(treatmentPlanOutput.contains("The patient requires surgery for Appendicitis."));
        assertTrue(treatmentPlanOutput.contains("The patient is " + outpatient.getAge() + " years old."));
    }

    /**
     * Test case for verifying that the treatment plan generation handles different disease types.
     */
    @Test
    public void testCreateTreatmentPlanWithDifferentDiseaseType() {
        // Change the disease type for testing
        outpatient.setDiseaseType("Cholecystectomy");

        // Call the createTreatmentPlan method
        String treatmentPlanOutput = surgeryPlan.createTreatmentPlan(outpatient);

        // Verify the output contains the expected strings
        assertTrue(treatmentPlanOutput.contains("The patient requires surgery for Cholecystectomy."));
        assertTrue(treatmentPlanOutput.contains("The patient is " + outpatient.getAge() + " years old."));
    }

    /**
     * Test case for retrieving the scheduled surgery date.
     */
    @Test
    public void testGetSurgeryDate() {
        // Retrieve the scheduled surgery date
        Date surgeryDate = surgeryPlan.getSurgeryDate();

        // Verify that the surgery date is not null
        assertNotNull(surgeryDate);
    }
}
