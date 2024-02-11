package gui;

import java.awt.EventQueue;
import database.DBconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import backend.Validation;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class signup {

	JFrame frame;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JPasswordField passwordField;
	private JPasswordField confirmPassword;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup window = new signup();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public signup() {
		initialize();
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1360, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(10, 10, 1326, 108);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to signup page");
		lblNewLabel.setBounds(461, 25, 371, 45);
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 39));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(289, 128, 946, 585);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Select User Mode:");
		lblNewLabel_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(105, 10, 211, 30);
		panel_1.add(lblNewLabel_1);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Garamond", Font.PLAIN, 24));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Admin", "Teacher", "Student"}));
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(291, 10, 131, 30);
		panel_1.add(comboBox);
		
		JLabel namelabel = new JLabel("First Name:");
		namelabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		namelabel.setBounds(105, 50, 126, 37);
		panel_1.add(namelabel);
		
		JLabel lastNamelabel = new JLabel("Last Name:");
		lastNamelabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		lastNamelabel.setBounds(453, 50, 126, 37);
		panel_1.add(lastNamelabel);
		
		JLabel emaillabel = new JLabel("Email:");
		emaillabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		emaillabel.setBounds(105, 132, 126, 37);
		panel_1.add(emaillabel);
		
		JLabel passwordlabel = new JLabel("Password:");
		passwordlabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		passwordlabel.setBounds(105, 214, 126, 37);
		panel_1.add(passwordlabel);
		
		JLabel cpasswordlabel = new JLabel("Confirm Password:");
		cpasswordlabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		cpasswordlabel.setBounds(105, 297, 192, 37);
		panel_1.add(cpasswordlabel);
		
		firstName = new JTextField();
		firstName.setFont(new Font("Garamond", Font.PLAIN, 22));
		firstName.setBounds(105, 97, 284, 37);
		panel_1.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setFont(new Font("Garamond", Font.PLAIN, 22));
		lastName.setColumns(10);
		lastName.setBounds(453, 97, 315, 37);
		panel_1.add(lastName);
		
		email = new JTextField();
		email.setFont(new Font("Garamond", Font.PLAIN, 22));
		email.setColumns(10);
		email.setBounds(105, 167, 452, 37);
		panel_1.add(email);
		JLabel lblNewLabel_3 = new JLabel("Select Course:");
        lblNewLabel_3.setFont(new Font("Garamond", Font.PLAIN, 24));
        lblNewLabel_3.setBounds(453, 10, 134, 30);
        panel_1.add(lblNewLabel_3);
        lblNewLabel_3.setVisible(false);
        
        
        
        
        JComboBox<String> selectCourseCombo = new JComboBox<>();
        selectCourseCombo.setFont(new Font("Garamond", Font.PLAIN, 18));
        selectCourseCombo.setBounds(594, 14, 250, 30);
        panel_1.add(selectCourseCombo);
        selectCourseCombo.setVisible(false);
        
        comboBox.addActionListener(e -> {
            // Check if "Student" is selected
            if ("Student".equals(comboBox.getSelectedItem())) {
                // If yes, show the course selection components
                lblNewLabel_3.setVisible(true);
                selectCourseCombo.setVisible(true);
            } else {
                // If not, hide the course selection components
                lblNewLabel_3.setVisible(false);
                selectCourseCombo.setVisible(false);
            }
        });

        // Fetch course names and populate the JComboBox
        try (Connection connection = new DBconnection().load();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT course_name FROM courses");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                selectCourseCombo.addItem(resultSet.getString("course_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		JButton btnNewButton = new JButton("Create my account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedUserMode = comboBox.getSelectedItem().toString();
	            String firstNameValue = firstName.getText();
	            
	            String emailValue = email.getText();
	            String passwordValue = new String(passwordField.getPassword());
	            String confirmPasswordValue = new String(confirmPassword.getPassword());
	            String phoneValue = phone.getText();
	            String selectedCourse = selectCourseCombo.getSelectedItem().toString();
	            
	         // Validate user input
	            if (!Validation.validate(emailValue, passwordValue, phoneValue)) {
	                JOptionPane.showMessageDialog(frame, "Invalid input. Please check your entries.", "Validation Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            // Validate password match
	            if (!passwordValue.equals(confirmPasswordValue)) {
	                JOptionPane.showMessageDialog(frame, "Passwords do not match!", "Password Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }

	            // Database operations
	            try (Connection connection = new DBconnection().load()) {
	                switch (selectedUserMode) {
	                    case "Admin":
	                        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO admin (admin_name, admin_email, admin_password) VALUES (?, ?, ?)")) {
	                            // Set parameters
	                            preparedStatement.setString(1, firstNameValue);
	                            preparedStatement.setString(2, emailValue);
	                            preparedStatement.setString(3, passwordValue);

	                            // Execute query
	                            preparedStatement.executeUpdate();
	                        }
	                        break;

	                    case "Teacher":
	                        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tutors (tutor_name, tutor_email, tutor_password, tutor_phone) VALUES (?, ?, ?, ?)")) {
	                            // Set parameters
	                            preparedStatement.setString(1, firstNameValue);
	                            preparedStatement.setString(2, emailValue);
	                            preparedStatement.setString(3, passwordValue);
	                            preparedStatement.setString(4, phoneValue);

	                            // Execute query
	                            preparedStatement.executeUpdate();
	                        }
	                        break;

	                    case "Student":
	                        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (student_name, course_id, student_email, student_password, student_phone, level) VALUES (?, ?, ?, ?, ?, ?)")) {
	                            // Set parameters
	                            preparedStatement.setString(1, firstNameValue);

	                            // Retrieve course ID based on the selected course name
	                            try (PreparedStatement courseStatement = connection.prepareStatement("SELECT course_id FROM courses WHERE course_name = ?")) {
	                                courseStatement.setString(1, selectedCourse);
	                                ResultSet courseResultSet = courseStatement.executeQuery();
	                                if (courseResultSet.next()) {
	                                    preparedStatement.setInt(2, courseResultSet.getInt("course_id"));
	                                }
	                            }

	                            preparedStatement.setString(3, emailValue);
	                            preparedStatement.setString(4, passwordValue);
	                            preparedStatement.setString(5, phoneValue);

	                            // Set the value for the "level" column
	                            preparedStatement.setInt(6, 1);  // Replace with the appropriate level value

	                            // Execute query
	                            preparedStatement.executeUpdate();
	                        }
	                        break;

	                    default:
	                        JOptionPane.showMessageDialog(frame, "Invalid user mode selected", "Error", JOptionPane.ERROR_MESSAGE);
	                        return;
	                }

	                // Add entry to activity table after successful validation and database operations
	                try (PreparedStatement activityStatement = connection.prepareStatement("INSERT INTO activity (activity_name, activity_date, activity_time) VALUES (?, CURDATE(), CURTIME())")) {
	                    String activityEntry;
	                    switch (selectedUserMode) {
	                        case "Admin":
	                            activityEntry = "Admin: " + firstNameValue + " joined";
	                            break;
	                        case "Teacher":
	                            activityEntry = "Tutor: " + firstNameValue + " joined";
	                            break;
	                        case "Student":
	                            activityEntry = "Student: " + firstNameValue + " joined";
	                            break;
	                        default:
	                            activityEntry = "Unknown user mode joined";
	                            break;
	                    }
	                    activityStatement.setString(1, activityEntry);
	                    activityStatement.executeUpdate();
	                }

	                JOptionPane.showMessageDialog(frame, selectedUserMode + " account created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
	            } catch (SQLException ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(frame, "Error creating " + selectedUserMode + " account", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	            
	            if (Validation.validate(emailValue, passwordValue, phoneValue)) {
	                
	                try {
	                	String enteredEmail = null;
						dashboard window = new dashboard(selectedUserMode, enteredEmail);
                        window.frame.setVisible(true);
                        frame.dispose();  // Close the current frame
	                } catch (Exception ex) {
	                    ex.printStackTrace();
	                }
	            } else {
	                // Display an error message or take appropriate action
	                JOptionPane.showMessageDialog(frame, "Invalid input. Please check your entries.", "Validation Error", JOptionPane.ERROR_MESSAGE);
	            }


			}
			
			
		});
		
		
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(134, 85, 236));
		btnNewButton.setFont(new Font("Garamond", Font.PLAIN, 21));
		btnNewButton.setIcon(null);
		btnNewButton.setBounds(105, 488, 192, 37);
		panel_1.add(btnNewButton);
		
		
		
		JLabel lblAlreadyHaveAn = new JLabel("Already have an account?");
		lblAlreadyHaveAn.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblAlreadyHaveAn.setBounds(105, 538, 252, 37);
		panel_1.add(lblAlreadyHaveAn);
		
		JLabel lblSignIn = new JLabel("Sign In");
        lblSignIn.setFont(new Font("Garamond", Font.PLAIN, 24));
        lblSignIn.setBounds(352, 538, 76, 37);
        lblSignIn.setForeground(Color.BLUE); // Set color to blue for indication of hyperlink
        lblSignIn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor to hand when hovered
        panel_1.add(lblSignIn);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(105, 250, 452, 37);
        panel_1.add(passwordField);
        
        confirmPassword = new JPasswordField();
        confirmPassword.setBounds(105, 344, 452, 37);
        panel_1.add(confirmPassword);
        
        JLabel lblNewLabel_2 = new JLabel("Phone:");
        lblNewLabel_2.setFont(new Font("Garamond", Font.PLAIN, 24));
        lblNewLabel_2.setBounds(105, 391, 192, 37);
        panel_1.add(lblNewLabel_2);
        
        phone = new JTextField();
        phone.setBounds(105, 427, 452, 37);
        panel_1.add(phone);
        phone.setColumns(10);
        
        JPanel cmsPanel = new JPanel();
        cmsPanel.setLayout(null);
        cmsPanel.setBorder(UIManager.getBorder("TextPane.border"));
        cmsPanel.setBackground(new Color(211, 211, 211));
        cmsPanel.setBounds(10, 128, 270, 173);
        frame.getContentPane().add(cmsPanel);
        
        JLabel lblNewLabel_1_1 = new JLabel("Course");
        lblNewLabel_1_1.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblNewLabel_1_1.setBounds(59, 23, 114, 40);
        cmsPanel.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Management");
        lblNewLabel_1_1_1.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblNewLabel_1_1_1.setBounds(30, 62, 217, 40);
        cmsPanel.add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("System");
        lblNewLabel_1_1_1_1.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblNewLabel_1_1_1_1.setBounds(59, 100, 114, 40);
        cmsPanel.add(lblNewLabel_1_1_1_1);
        
        JLabel lblNewLabel_4 = new JLabel("");
        lblNewLabel_4.setIcon(new ImageIcon(signup.class.getResource("/gui/images/CMS.png")));
        lblNewLabel_4.setBounds(10, 313, 270, 270);
        frame.getContentPane().add(lblNewLabel_4);
        
        
        
        
        

        lblSignIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	openLoginWindow();
            }

            private void openLoginWindow() {
            	try {
                    login loginWindow = new login();
                    loginWindow.frame.setVisible(true);
                    frame.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			}

			@Override
            public void mouseEntered(MouseEvent e) {
                // Change text color when the mouse enters the label
                lblSignIn.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change text color back when the mouse exits the label
                lblSignIn.setForeground(Color.BLUE);
            }
        });
        
	}
	
}
