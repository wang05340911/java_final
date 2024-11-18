/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_01.management;

import assignment_01.patient.Patient;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The ValidatePatientData class is responsible for validating the 
 * attributes of a Patient object to ensure that the data meets 
 * specified criteria.
 * 
 * This class provides methods to validate a patient's name, email, 
 * and phone number using specific rules, such as format checks and 
 * character restrictions. The validation helps ensure data integrity 
 * before proceeding with operations involving patient information.
 * 
 */
public class ValidatePatientData {
    
    /**
     * Validates the provided Patient object's data.
     * 
     * This method checks the patient's name, email, and phone 
     * number for validity. It trims whitespace from the name and 
     * email, ensuring they are properly formatted before returning 
     * a final validation result.
     *
     * @param patient The Patient object to validate; must not be null.
     * @return true if the patient's data is valid; false otherwise
     */
    
    public boolean validatePatientData(Patient patient) {
		if (!isValidName(patient.getName())) {
			return false;
		}
		patient.setName(patient.getName().trim());

		if (!isValidAlphaNumeric(patient.getName())) {
			return false;
		}
		if (patient.getEmail() == null || patient.getEmail().trim().length() == 0) {
			return false;
		}
		patient.setEmail(patient.getEmail().trim());
		if (!isValidEmail(patient.getEmail())) {
			return false;
		}
		
		if(!isValidPhone(patient.getPhoneNumber())) {
			return false;
		}

		return true;
	}

           /**
            * Checks if the given name is valid.
            * 
            * A valid name is non-null and not empty after trimming 
            * whitespace.
            *
            * @param value The name to validate.
            * @return true if the name is valid; false otherwise.
            */
	private boolean isValidName(String value) {
		return value != null && value.trim().length() > 0;
	}


        /**
         * Checks if the given string is alphanumeric.
        * 
        * This method uses a regular expression to ensure that the 
        * string contains only letters, numbers, spaces, hyphens, and 
        * apostrophes.
        *
        * @param value The string to validate.
        * @return true if the string is alphanumeric; false otherwise.
        */ 
         
	private boolean isValidAlphaNumeric(String value) {
		Pattern pattern = Pattern.compile("[^A-Za-z0-9\\s'-]");
		Matcher matcher = pattern.matcher(value);
		return !matcher.find();
	}


        
        
            /** Checks if the given string is alphanumeric.
            * 
            * This method uses a regular expression to ensure that the 
            * string contains only letters, numbers, spaces, hyphens, and 
            * apostrophes.
            *
            * @param value The string to validate.
            * @return true if the string is alphanumeric; false otherwise.
            */
	private boolean isValidEmail(String value) {
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(value);
		return matcher.find();
	}

        
         /**
            * Validates the phone number format.
            * 
            * This method uses a regular expression to check if the phone 
            * number matches the North American format.
            *
            * @param value The phone number to validate.
            * @return true if the phone number format is valid; false otherwise.
            */
	private boolean isValidPhone(String value) {
        Pattern pattern = Pattern.compile("^(\\+1\\s?)?(\\(?\\d{3}\\)?[\\s.-]?)\\d{3}[\\s.-]?\\d{4}$");
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }
}
