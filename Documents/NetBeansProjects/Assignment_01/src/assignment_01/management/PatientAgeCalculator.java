/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_01.management;

import assignment_01.Physician.Constants;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * The PatientAgeCalculator class provides functionality to calculate a patient's 
 * age based on their date of birth and determine their life stage based on 
 * their calculated age. This class is useful in medical contexts where 
 * age-related considerations are important for patient care and treatment planning.
 */

public class PatientAgeCalculator {
    
    /**
     * Calculates the age of a patient based on the provided date of birth.
     * 
     * <p>This method takes a date of birth in the format "yyyy-MM-dd", 
     * parses it into a LocalDate object, and calculates the patient's age 
     * by determining the difference in years between the date of birth 
     * and the current date.</p>
     *
     * @param dob the date of birth of the patient in "yyyy-MM-dd" format; 
     *            must not be null or empty
     * 
     * @return the age of the patient in years, calculated as a long value
     * 
     */
	public long calculatePatientAge(String dob) {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(dob, formatter);

        LocalDate currentDate = LocalDate.now();
        return Period.between(dateOfBirth, currentDate).getYears();
    }

        
     /**
     * Determines the life stage of a patient based on their age.
     * 
     * This method categorizes the patient into one of three life stages: 
     * CHILD, YOUTH, or ADULT, based on the given age. The categorization is 
     * based on the following criteria:
     *     Age 0 to 6: CHILD
     *     Age 7 to 18: YOUTH
     *     Age 19 and above: ADULT
     *
     * @param age the age of the patient in years; must be non-negative
     * 
     * @return a String representing the life stage of the patient, which 
     *         can be CHILD, YOUTH, or ADULT
     * 
     */   
    public String determineLifeStage(long age) {
        return (age <= 6) ? Constants.CHILD :
               (age <= 18) ? Constants.YOUTH : 
               Constants.ADULT;
    }
}


