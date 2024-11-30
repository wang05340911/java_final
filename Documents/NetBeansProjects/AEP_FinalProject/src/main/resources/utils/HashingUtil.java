package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * HashingUtil provides utility methods for hashing and validating passwords.
 * 
 * This class uses SHA-256 for hashing and includes support for salts
 * to improve security against precomputed hash attacks.
 * 
 * @author han
 */
public class HashingUtil {

    private static final String HASH_ALGORITHM = "SHA-256";
    private static final int SALT_LENGTH = 16;

    // Generate a random salt
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    // Hash a raw password with a given salt
    public static String hashPassword(String rawPassword, String salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
            String saltedPassword = salt + rawPassword;
            byte[] hash = digest.digest(saltedPassword.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Hashing algorithm not found: " + HASH_ALGORITHM, e);
        }
    }

    // Validate a password by hashing the input and comparing it to the stored hash
    public static boolean validatePassword(String rawPassword, String salt, String storedHash) {
        String hashedPassword = hashPassword(rawPassword, salt);
        return hashedPassword.equals(storedHash);
    }
}