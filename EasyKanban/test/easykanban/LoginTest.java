/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package easykanban;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author RC_Student_lab
 */
public class LoginTest {
    
    public LoginTest() {
    }

    @Test
    public void testCheckUserName() {
        // Valid username
        String validUsername = "user_";
        assertTrue(new Login().checkUserName(validUsername));

        // Invalid usernames
        String noUnderscore = "username";
        assertFalse(new Login().checkUserName(noUnderscore));

        String tooLong = "username_longer_than_5_characters";
        assertFalse(new Login().checkUserName(tooLong));
    }
}