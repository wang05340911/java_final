package assignment_01.prescription;

import assignment_01.patient.Inpatient;
import assignment_01.patient.Outpatient;
import assignment_01.patient.Patient;
import assignment_01.treatment.MedicationTreatmentPlan;
import assignment_01.treatment.SurgeryTreatmentPlan;
import assignment_01.treatment.TreatmentPlan;
import java.util.Calendar;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;

public class OnlinePrescriptionServiceTest {

   @Test
    public void testGeneratePrescriptionForMedication() {
        Patient patient = new Outpatient("1", "John Doe", "john@example.com", "1234567890", "1990-01-01", "2024-10-01");
        patient.setDiseaseType("Infection");

        TreatmentPlan treatmentPlan = new MedicationTreatmentPlan();
        PrescriptionService service = new OnlinePrescriptionService(treatmentPlan);

        String result = service.generatePrescription(patient);

        assertTrue(result.contains("John Doe"));
        assertTrue(result.contains("Infection"));
    }

    @Test
    public void testGeneratePrescriptionForSurgery() {
        Patient patient = new Inpatient("1", "Jane Doe", "jane@example.com", "0987654321", "1990-01-01", "C101");
        patient.setDiseaseType("Broken Leg");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, Calendar.OCTOBER, 25);
        Date surgeryDate = calendar.getTime();
        TreatmentPlan surgeryPlan = new SurgeryTreatmentPlan(surgeryDate);
        
        PrescriptionService service = new OnlinePrescriptionService(surgeryPlan);

        String result = service.generatePrescription(patient);
        assertTrue(result.contains("Jane Doe"));
        assertTrue(result.contains("Broken Leg"));
        assertTrue(result.contains("Surgery Date"));
    }
}