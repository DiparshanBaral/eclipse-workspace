package users;

import java.nio.InvalidMarkException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import database.DBconnection;

public class Tutor extends User {
    private Connection connect;
    String selectedUserEmail;
    DBconnection db = new DBconnection();
	

    // default constructor
    public Tutor() {
        try {
            connect = db.load();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    

    // parameter
    public Tutor(int id, String name, String email, String phone) {
        super(id, name, email, phone);
    }

    // getting tutors
    public ArrayList<Tutor> gettutor() {
        String select = "SELECT * FROM tutors";
        ArrayList<Tutor> instruct = new ArrayList<Tutor>();
        try {
            PreparedStatement state = connect.prepareStatement(select);
            ResultSet set = state.executeQuery(select);
            while (set.next()) {
                instruct.add(new Tutor(set.getInt("tutor_id"), set.getString("tutor_name"),
                        set.getString("tutor_email"),
                        set.getString("tutor_phone")));
            }
            state.executeQuery();
            state.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return instruct;
    }

    

    public ArrayList<String> gettutorData(String email) {
        String select = "SELECT * FROM tutors WHERE tutor_email = '" + email + "'";
        ArrayList<String> instruct = new ArrayList<String>();
        try {
            PreparedStatement state = connect.prepareStatement(select);
            ResultSet set = state.executeQuery(select);
            while (set.next()) {
                instruct.add(set.getString("tutor_name"));
                instruct.add(set.getString("tutor_phone"));

            }
            state.executeQuery();
            state.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return instruct;
    }



    public void changePassword(String enteredEmail, String oldPassword, String newPassword) {
        try {
            // Verify the old password first
            PreparedStatement stmt = connect
                    .prepareStatement("SELECT tutor_password FROM tutors WHERE tutor_email = ?");
            stmt.setString(1, enteredEmail);
            ResultSet result = stmt.executeQuery();
            if (!result.next() || !result.getString("tutor_password").equals(oldPassword)) {
                JOptionPane.showMessageDialog(null, "Incorrect old password!");
                return;
            }

            // Update the password if the old password is correct
            stmt = connect
                    .prepareStatement("UPDATE tutors SET tutor_password = ? WHERE tutor_email = ?");
            stmt.setString(1, newPassword);
            stmt.setString(2, enteredEmail);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Password changed successfully!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void deletetutor(int id) {
        String query = "DELETE FROM tutors WHERE tutor_id = ?";
        String query1 = "DELETE FROM assigned_modules WHERE tutor_id = ?";
        try {
            PreparedStatement state1 = connect.prepareStatement(query1);
            PreparedStatement state = connect.prepareStatement(query);
            state1.setInt(1, id);
            state1.executeUpdate();
            state.setInt(1, id);
            state.executeUpdate();

            state.close();
            state1.close();
            JOptionPane.showMessageDialog(null, "tutor deleted successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void addtutor(String name, String email, String phone, String password) {
        String query = "INSERT INTO tutors (tutor_name, tutor_email, tutor_phone, tutor_password) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement state = connect.prepareStatement(query);
            state.setString(1, name);
            state.setString(2, email);
            state.setString(3, phone);
            state.setString(4, password);
            state.executeUpdate();
            state.close();
            JOptionPane.showMessageDialog(null, "tutor added successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void generateReport(int studentId, int moduleId, int marks) throws SQLException {
        if (marks < 0 || marks > 100 || studentId == 0 || moduleId == 0) {
            throw new InvalidMarkException();

        }
        String sql = "INSERT INTO results (student_id, module_id, marks) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(1, studentId);
            statement.setInt(2, moduleId);
            statement.setInt(3, marks);
            statement.executeUpdate();
            statement.close();
            connect.close();
            JOptionPane.showMessageDialog(null, "Report generated successfully!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
