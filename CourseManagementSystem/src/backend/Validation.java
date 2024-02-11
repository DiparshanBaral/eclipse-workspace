package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import database.DBconnection;

public class Validation {

    public static boolean validate(String email, String password, String phone) {
        return validateEmail(email) && validatePassword(password) && validatePhoneNumber(phone);
    }

    public static boolean validateEmail(String email) {
        // Email must contain @
        return email.contains("@");
    }

    public static boolean validatePassword(String password) {
        // Password must have a capital, followed by a string, and followed by some numbers
        String regex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean validatePhoneNumber(String phone) {
        // Phone number must be numerical and of 10 digits
        return phone.matches("\\d{10}");
    }

    public static boolean validateLogin(String enteredEmail, String enteredPassword, String selectedUserRole) {
        // Validate user login based on the database
    	try (Connection connection = new DBconnection().load()) {
            // Dynamically select the table name based on the user role
            String tableName;
            String emailColumnName;
            String passwordColumnName;

            if (selectedUserRole.equals("Admin")) {
                tableName = "admin";
                emailColumnName = "admin_email";
                passwordColumnName = "admin_password";
            } else {
                tableName = selectedUserRole.toLowerCase() + "s";
                emailColumnName = selectedUserRole.toLowerCase() + "_email";
                passwordColumnName = selectedUserRole.toLowerCase() + "_password";
            }

            // Build and execute SQL query
            String query = "SELECT * FROM " + tableName + " WHERE " + emailColumnName + " = ? AND " + passwordColumnName + " = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, enteredEmail);
                preparedStatement.setString(2, enteredPassword);

                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

	
}
