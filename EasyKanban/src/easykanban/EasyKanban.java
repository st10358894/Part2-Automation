/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package easykanban;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author RC_Student_lab
 */
public class EasyKanban {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login login = new Login();

        // User registration
        String firstName = JOptionPane.showInputDialog("Enter your first name:");
        String lastName = JOptionPane.showInputDialog("Enter your last name:");


        // First Sign Up
        JOptionPane.showMessageDialog(null, "Register User");
        String username1 = getValidUsername(scanner);
        String password1 = getValidPassword(scanner);
        String registrationMessage = login.registerUser(username1, password1, firstName, lastName);
        JOptionPane.showMessageDialog(null, registrationMessage);

        if (!registrationMessage.equals("Registration successful!")) {
            return;
        }

        // Second Sign In
        JOptionPane.showMessageDialog(null, "Login");
        String username2 = getValidUsername(scanner);
        String password2 = getValidPassword(scanner);

        if (login.loginUser(username2, password2)) {
            JOptionPane.showMessageDialog(null, "Welcome " + firstName + " " + lastName + ", it is great to see you again!");
            showMainMenu(scanner);
        } else {
            JOptionPane.showMessageDialog(null, "Sign-ins do not match!");
        }
    }

    private static String getValidUsername(Scanner scanner) {
        while (true) {
            String username = JOptionPane.showInputDialog("Enter username (with an underscore and max 5 characters):");
            if (username.contains("_") && username.length() <= 5) {
                JOptionPane.showMessageDialog(null, "Username captured successfully!");
                return username;
            } else {
                JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.");
            }
        }
    }

    private static String getValidPassword(Scanner scanner) {
        while (true) {
            String password = JOptionPane.showInputDialog("Enter password (min 8 characters, with a capital letter, number, and special character):");
            if (password.matches(".*[@#$%^&+=].*") && password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*[0-9].*")) {
                JOptionPane.showMessageDialog(null, "Password captured successfully!");
                return password;
            } else {
                JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.");
            }
        }
    }

    private static void showMainMenu(Scanner scanner) {
        List<Task> tasks = new ArrayList<>();
        boolean quit = false;

        while (!quit) {
            String option = JOptionPane.showInputDialog("Welcome to EasyKanban\n1) Add tasks\n2) Show report\n3) Quit");
            switch (option) {
                case "1":
                    int numberOfTasks = Integer.parseInt(JOptionPane.showInputDialog("How many tasks would you like to add?"));
                    for (int i = 0; i < numberOfTasks; i++) {
                        tasks.add(addTask(scanner, i));
                    }
                    break;
                case "2":
                    JOptionPane.showMessageDialog(null, "Coming Soon");
                    break;
                case "3":
                    quit = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please choose 1, 2, or 3.");
            }
        }
    }

    private static Task addTask(Scanner scanner, int taskNumber) {
        String taskName = JOptionPane.showInputDialog("Enter task name:");
        String taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
        while (!Task.checkTaskDescription(taskDescription)) {
            taskDescription = JOptionPane.showInputDialog("Please enter a task description of less than 50 characters:");
        }
        String developerDetails = JOptionPane.showInputDialog("Enter developer details (First and Last Name):");
        int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours:"));
        String[] statusOptions = {"To Do", "Doing", "Done"};
        String taskStatus = (String) JOptionPane.showInputDialog(null, "Select task status:", "Task Status", JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);

        Task task = new Task(taskName, taskDescription, developerDetails, taskDuration, taskNumber, taskStatus);
        JOptionPane.showMessageDialog(null, task.printTaskDetails());
        return task;
    }
}

    
    
