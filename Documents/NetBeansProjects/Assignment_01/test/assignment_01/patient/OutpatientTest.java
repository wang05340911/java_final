/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package assignment_01.patient;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 *
 * @author Amritpal Kaur
 */
public class OutpatientTest {
    
   private Outpatient outpatient;

    @Before
    public void setUp() {
        // Set up an Outpatient instance before each test
        outpatient = new Outpatient("132", "John Cena", "john@example.com", 
                                     "1234567890", "01/01/1990", "10/10/2024");
    }

    @Test
    public void testConstructor() {
        // Test the constructor and ensure the appointmentDate is set correctly
        assertEquals("132", outpatient.getId());
        assertEquals("John Cena", outpatient.getName());
        assertEquals("john@example.com", outpatient.getEmail());
        assertEquals("1234567890", outpatient.getPhoneNumber());
        assertEquals("01/01/1990", outpatient.getDateOfBirth());
        assertEquals("10/10/2024", outpatient.getAppointmentDate());
    }

    @Test
    public void testGetAppointmentDate() {
        // Test the getAppointmentDate method
        assertEquals("10/10/2024", outpatient.getAppointmentDate());
    }
}