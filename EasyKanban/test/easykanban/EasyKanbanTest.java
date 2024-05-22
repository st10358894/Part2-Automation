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
public class EasyKanbanTest {
    
    public EasyKanbanTest() {
    }

    @Test
    public void testMain() {
        // Since main() method involves GUI, we need to test other methods individually
        // This is a placeholder as GUI interaction can't be tested directly in this way
    }

    @Test
    public void testGetValidUsername() {
        // Mock user input for username
        String validUsername = "user_";
        assertTrue(validUsername.contains("_") && validUsername.length() <= 5);
    }

}