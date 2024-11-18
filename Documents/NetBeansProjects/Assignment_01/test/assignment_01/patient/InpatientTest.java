/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package assignment_01.patient;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gurkirat
 */
public class InpatientTest {
    
    public InpatientTest() {
    }

    /**
     * Test of getRoomNumber method, of class Inpatient.
     */
    @Test
    public void testGetRoomNumber() {
        Inpatient inpatient = new Inpatient("1","Mary Jones", "mary@example.com","4537261283", "Dec-01-2000","T001");
        
        assertEquals("T001" , inpatient.getRoomNumber());
    }

    /**
     * Test of admit method, of class Inpatient.
     */
    @Test
    public void testAdmit() {
        Inpatient inpatient = new Inpatient("1","Mary Jones", "mary@example.com","4537261283", "Dec-01-2000","T001");
        
  
    // Capture the output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out; // Save original System.out
    System.setOut(new PrintStream(outputStream)); // Redirect System.out

    // Call the admit method
    inpatient.admit();

    // Reset System.out
    System.setOut(originalOut);

    // Check the output
    assertEquals("Mary Jones has been admitted to T001", outputStream.toString()); 
    }
    
}
