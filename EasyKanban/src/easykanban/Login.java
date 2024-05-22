/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package easykanban;
/**
 *
 * @author RC_Student_lab
 */
public class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        return password.matches(".*[@#$%^&+=].*") &&
                password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*");
    }

    public String registerUser(String username, String password, String firstName, String lastName) {
        if (checkUserName(username) && checkPasswordComplexity(password)) {
            this.username = username;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
            return "Registration successful!";
        } else {
            return "Registration failed. Please check username or password format.";
        }
    }

    public boolean loginUser(String username, String password) {
        return this.username != null && this.password != null &&
                this.username.equals(username) && this.password.equals(password);
    }
}
  

