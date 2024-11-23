/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import dao.UserDAO;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import models.User;

import static org.junit.Assert.*;

public class UserDAOTest {
    private Connection connection;
    private UserDAO userDAO;

    @Before
    public void setUp() throws Exception {
        // Initialize the database connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AEP", "root", "Aa880911");
        userDAO = new UserDAO(connection); // Pass the connection to your DAO
    }

    @Test
    public void testFindUserByEmail() throws Exception {
        // Example test
        String testEmail = "test@example.com";
        User user = userDAO.findUserByEmail(testEmail);

        // Verify the result
        assertNotNull("User should not be null", user);
        assertEquals("Email should match", testEmail, user.getEmail());
    }

    @Test
    public void testInsertUser() throws Exception {
        // Test inserting a new user
        User newUser = new User(1, "John", "Doe", "john@example.com", "password123");
        userDAO.createUser(newUser);

        // Verify the user exists in the database
        User retrievedUser = userDAO.findUserByEmail("john@example.com");
        assertNotNull("User should be found after insertion", retrievedUser);
        assertEquals("Name should match", "John", retrievedUser.getName());
    }

    
}