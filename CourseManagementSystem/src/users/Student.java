package users;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import javax.swing.JOptionPane;



public class Student extends User {
	
	
	public Student() {}

    // parameter
    public Student(int id, String name, String email, String phone) {
        super(id, name, email, phone);
    }

    

    public ArrayList<Student> getStudents() {
        String query = "SELECT * FROM students";
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            PreparedStatement state = connect.prepareStatement(query);
            ResultSet set = state.executeQuery(query);
            while (set.next()) {
                students.add(new Student(set.getInt("student_id"), set.getString("student_name"),
                        set.getString("student_email"),
                        set.getString("student_phone")));

            }
            state.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return students;
    }

    public ArrayList<String> getStudentsData(String email) {
        String query = "SELECT * FROM students WHERE email = ?";
        ArrayList<String> students = new ArrayList<String>();
        try {
            PreparedStatement state = connect.prepareStatement(query);
            state.setString(1, String.valueOf(email));
            ResultSet set = state.executeQuery();
            while (set.next()) {
                students.add(set.getString("student_name"));
                students.add(set.getString("student_phone"));
                students.add(set.getString("level"));

            }
            state.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return students;
    }

    public void changePassword(String enteredEmail, String oldPassword, String newPassword) {
        try {
            // Verify the old password first
            PreparedStatement stmt = connect
                    .prepareStatement("SELECT student_password FROM students WHERE student_email = ?");
            stmt.setString(1, enteredEmail);
            ResultSet result = stmt.executeQuery();
            if (!result.next() || !result.getString("student_password").equals(oldPassword)) {
                JOptionPane.showMessageDialog(null, "Incorrect old password!");
                return;
            }

            // Update the password if the old password is correct
            stmt = connect.prepareStatement("UPDATE students SET student_password = ? WHERE student_email = ?");
            stmt.setString(1, newPassword);
            stmt.setString(2, enteredEmail);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Password changed successfully!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Something went wrong!", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }

    


  

}
