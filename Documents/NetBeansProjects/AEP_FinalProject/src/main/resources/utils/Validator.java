package utils;

import java.util.regex.Pattern;

/**
 * Validator provides utility methods for validating user input,
 * such as email format, password strength, and other constraints.
 * 
 * This class ensures that inputs meet specific requirements before processing.
 * 
 * @author han
 */
public class Validator {

    // Regular expression for validating email addresses
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";

    // Regular expression for validating strong passwords
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    // Regular expression for validating alphanumeric inputs
    private static final String ALPHANUMERIC_REGEX = "^[A-Za-z0-9]+$";

    /**
     * Validate email format.
     *
     * @param email The email to validate.
     * @return true if the email format is valid; false otherwise.
     */
    public static boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return Pattern.matches(EMAIL_REGEX, email);
    }

    /**
     * Validate password strength.
     *
     * A strong password must:
     * - Be at least 8 characters long
     * - Contain at least one uppercase letter
     * - Contain at least one lowercase letter
     * - Contain at least one digit
     * - Contain at least one special character (@$!%*?&)
     *
     * @param password The password to validate.
     * @return true if the password meets strength requirements; false otherwise.
     */
    public static boolean validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        return Pattern.matches(PASSWORD_REGEX, password);
    }

    /**
     * Validate if a string is alphanumeric.
     *
     * @param input The input to validate.
     * @return true if the input contains only letters and numbers; false otherwise.
     */
    public static boolean validateAlphanumeric(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        return Pattern.matches(ALPHANUMERIC_REGEX, input);
    }

    /**
     * Validate if a string exceeds a specific length.
     *
     * @param input The input to validate.
     * @param maxLength The maximum allowed length.
     * @return true if the input does not exceed maxLength; false otherwise.
     */
    public static boolean validateMaxLength(String input, int maxLength) {
        if (input == null) {
            return false;
        }
        return input.length() <= maxLength;
    }

    /**
     * Validate if a string meets a minimum length.
     *
     * @param input The input to validate.
     * @param minLength The minimum required length.
     * @return true if the input meets minLength; false otherwise.
     */
    public static boolean validateMinLength(String input, int minLength) {
        if (input == null) {
            return false;
        }
        return input.length() >= minLength;
    }

    /**
     * Validate if an input is not null or empty.
     *
     * @param input The input to validate.
     * @return true if the input is not null or empty; false otherwise.
     */
    public static boolean validateNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }
}