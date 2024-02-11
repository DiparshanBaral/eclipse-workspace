package backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DBconnection;

public class firstName {

    public static String getFirstNameFromDatabase(String enteredEmail, String selectedUserRole) {
        String firstNameQuery = "";
        String tableName = "";

        switch (selectedUserRole) {
            case "Admin":
                tableName = "admin";
                break;
            case "Tutor":
                tableName = "tutors";
                break;
            case "Student":
                tableName = "students";
                break;
            // Add more cases if needed

            default:
                // Handle unknown user role
                return null;
        }

        // Query to fetch first name based on email and user role
        firstNameQuery = "SELECT " + selectedUserRole.toLowerCase() + "_name FROM " + tableName + " WHERE " + selectedUserRole.toLowerCase() + "_email = ?";

        try (Connection connection = new DBconnection().load();
             PreparedStatement firstNameStatement = connection.prepareStatement(firstNameQuery)) {
            firstNameStatement.setString(1, enteredEmail);

            try (ResultSet resultSet = firstNameStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Return the first name retrieved from the database
                    return resultSet.getString(1);
                } else {
                    // Handle the case where no matching record is found
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or log an error message
            return null;
        }
    }

    // Add any additional methods or functionality as needed
}
