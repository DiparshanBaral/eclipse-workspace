package courses;

import java.beans.Statement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import database.DBconnection;
import exception.NullException;

public class CRUDCourse {
    private Connection connect = null;
    private DBconnection db = new DBconnection();

    public CRUDCourse() {
        try {
            connect = db.load();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void createCourse(String courseName) {
        String query = "INSERT INTO courses(course_name) VALUES(?)";
        if(courseName.isEmpty()) {
        	throw new NullException();
        }
        try {
            PreparedStatement state = connect.prepareStatement(query);
            state.setString(1, courseName);
            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Course created successfully!", "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't create the course!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void createModules(int courseId, JTextField[] moduleTextFields) {
        String moduleQuery = "INSERT INTO modules(module_name, module_type, course_id) VALUES(?, 'core', ?)";

        try {
            for (JTextField moduleTextField : moduleTextFields) {
                String moduleName = moduleTextField.getText();

               
                

                try (PreparedStatement moduleStatement = connect.prepareStatement(moduleQuery)) {
                    moduleStatement.setString(1, moduleName);
                    moduleStatement.setInt(2, courseId);
                    moduleStatement.executeUpdate();
                }
            }

            JOptionPane.showMessageDialog(null, "Modules created successfully!", "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();  // Print stack trace for debugging
            JOptionPane.showMessageDialog(null, "Couldn't create the modules!", "Error!",
                    JOptionPane.ERROR_MESSAGE);
        }
    }




    public void deleteCourse(int courseId) {
        String module = "DELETE FROM modules WHERE course_id = ?";
        String query = "DELETE FROM courses WHERE course_id = ?";
        if (courseId == 0) {
            throw new NullException();
        }
        try {
            PreparedStatement state = connect.prepareStatement(query);
            PreparedStatement state2 = connect.prepareStatement(module);
            state2.setInt(1, courseId);
            state.setInt(1, courseId);
            state2.executeUpdate();
            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Course deleted successfully!", "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't delete the course!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteStudent(int studentId) {
        String query = "DELETE FROM students WHERE student_id = ?";
        if (studentId == 0) {
            throw new NullException();
        }
        try {
            // Delete the student
            try (PreparedStatement state = connect.prepareStatement(query)) {
                state.setInt(1, studentId);
                state.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Student deleted successfully!", "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't delete the student!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void deleteTutor(int tutorId) {
        String query = "DELETE FROM tutors WHERE tutor_id = ?";
        if (tutorId == 0) {
            throw new NullException();
        }
        try {
            // Delete the tutor
            try (PreparedStatement state = connect.prepareStatement(query)) {
                state.setInt(1, tutorId);
                state.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Tutor deleted successfully!", "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't delete the tutor!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }



    public void updateCourse(int courseId, String courseName) {
        if (courseName.equals("") || courseId == 0) {
            throw new NullException();
        }
        String query = "UPDATE courses SET course_name = ? WHERE course_id = ?";
        try {
            PreparedStatement state = connect.prepareStatement(query);
            state.setString(1, courseName);
            state.setInt(2, courseId);
            state.executeUpdate();
            JOptionPane.showMessageDialog(null, "Course updated successfully!", "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't update the course!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateTutor(int tutorId, String tutorName, String tutorPhone, String tutorEmail) {
        if (tutorName.equals("") || tutorPhone.equals("") || tutorEmail.equals("") || tutorId == 0) {
            throw new NullException();
        }
        
        String query = "UPDATE tutors SET tutor_name = ?, tutor_phone = ?, tutor_email = ? WHERE tutor_id = ?";
        
        try {
            // Update the tutor information
            try (PreparedStatement state = connect.prepareStatement(query)) {
                state.setString(1, tutorName);
                state.setString(2, tutorPhone);
                state.setString(3, tutorEmail);
                state.setInt(4, tutorId);
                state.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Tutor information updated successfully!", "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't update tutor information!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateStudent(int studentId, String studentName, String studentPhone, String studentEmail) {
        if (studentName.equals("") || studentPhone.equals("") || studentEmail.equals("") || studentId == 0) {
            throw new NullException();
        }

        String query = "UPDATE students SET student_name = ?, student_phone = ?, student_email = ? WHERE student_id = ?";

        try {
            // Update the student information
            try (PreparedStatement state = connect.prepareStatement(query)) {
                state.setString(1, studentName);
                state.setString(2, studentPhone);
                state.setString(3, studentEmail);
                state.setInt(4, studentId);
                state.executeUpdate();
            }

            JOptionPane.showMessageDialog(null, "Student information updated successfully!", "Success!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Couldn't update student information!", "Error!", JOptionPane.ERROR_MESSAGE);
        }
    }


}
