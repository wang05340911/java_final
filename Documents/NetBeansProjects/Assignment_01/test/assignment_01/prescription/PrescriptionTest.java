package assignment_01.prescription;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class PrescriptionTest {

    @Test
    public void testMedicationDetailsForChildAcute() {
        Prescription prescription = new Prescription(5, "Acute");
        
        assertEquals(1, prescription.dailyDosageCount);
        assertEquals(7, prescription.duration);
    }
    @Test
    public void testMedicationDetailsForChildInfection() {
        Prescription prescription = new Prescription(5, "Infection");
        
        assertEquals(1, prescription.dailyDosageCount);
        assertEquals(14, prescription.duration);
    }

    @Test
    public void testMedicationDetailsForChildChronic() {
        Prescription prescription = new Prescription(5, "Chronic");
        
        assertEquals(1, prescription.dailyDosageCount);
        assertEquals(180, prescription.duration);
    }
    
    @Test
    public void testMedicationDetailsForYouthAcute() {
        Prescription prescription = new Prescription(15, "Acute");
        
        
        assertEquals(2, prescription.dailyDosageCount);
        assertEquals(7, prescription.duration);
    }
    
    @Test
    public void testMedicationDetailsForYouthInfection() {
        Prescription prescription = new Prescription(15, "Infection");
        
        
        assertEquals(2, prescription.dailyDosageCount);
        assertEquals(14, prescription.duration);
    }
    @Test
    public void testMedicationDetailsForYouthChronic() {
        Prescription prescription = new Prescription(15, "Chronic");
        
        assertEquals(2, prescription.dailyDosageCount);
        assertEquals(180, prescription.duration);
    }

    
    @Test
    public void testMedicationDetailsForAdultInfection() {
        Prescription prescription = new Prescription(15, "Infection");
        
        
        assertEquals(2, prescription.dailyDosageCount);
        assertEquals(14, prescription.duration);
    }
    @Test
    public void testMedicationDetailsForAdultChronic() {
        Prescription prescription = new Prescription(15, "Chronic");
        
        assertEquals(2, prescription.dailyDosageCount);
        assertEquals(180, prescription.duration);
    }
    @Test
    public void testMedicationDetailsForAdult() {
        Prescription prescription = new Prescription(30, "Acute");
        
        assertEquals(3, prescription.dailyDosageCount);
        assertEquals(7, prescription.duration);
    }

    @Test
    public void testSurgeryDetailsForChild() {
        Date surgeryDate = new Date(); // Current date for surgery
        Prescription prescription = new Prescription(5, surgeryDate, "Broken leg");
        
        // Verify risk factor and fasting requirement for a child
        assertEquals("High", prescription.getRiskFactor());
        assertFalse(prescription.isFastingRequired);
        assertNotNull(prescription.followUpDate); // Check that followUpDate is not null
    }

    @Test
    public void testSurgeryDetailsForYouth() {
        Date surgeryDate = new Date(); // Current date for surgery
        Prescription prescription = new Prescription(15, surgeryDate, "Appendicitis");
        
        // Verify risk factor and fasting requirement for a youth
        assertEquals("Medium", prescription.getRiskFactor());
        assertTrue(prescription.isFastingRequired);
        assertNotNull(prescription.followUpDate); // Check that followUpDate is not null
    }

    @Test
    public void testSurgeryDetailsForAdult() {
        Date surgeryDate = new Date(); // Current date for surgery
        Prescription prescription = new Prescription(25, surgeryDate, "Rhinoplasty");
        
        // Verify risk factor and fasting requirement for an adult
        assertEquals("Low", prescription.getRiskFactor());
        assertTrue(prescription.isFastingRequired);
        assertNotNull(prescription.followUpDate); // Check that followUpDate is not null
    }
}
