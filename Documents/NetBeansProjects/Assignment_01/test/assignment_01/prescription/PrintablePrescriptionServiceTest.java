package assignment_01.prescription;

import static org.junit.Assert.*;
import org.junit.Test;
import assignment_01.treatment.MedicationTreatmentPlan;
import assignment_01.treatment.TreatmentPlan;
import assignment_01.patient.Outpatient;
import assignment_01.patient.Patient;

public class PrintablePrescriptionServiceTest {
@Test
    public void testGeneratePrintablePrescription() {
        Patient patient = new Outpatient("1", "Tyler Foley", "Foley@example.com", "6134085266", "1980-01-01", "2024-10-11");
        patient.setDiseaseType("Infection");

        TreatmentPlan treatmentPlan = new MedicationTreatmentPlan();
        PrescriptionService service = new PrintablePrescriptionService(treatmentPlan);

        String result = service.generatePrescription(patient);

        assertTrue(result.contains("Tyler Foley"));
        assertTrue(result.contains("Infection"));
        assertTrue(result.contains("0 days"));
    }
}