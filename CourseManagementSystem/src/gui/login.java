package gui;

import java.awt.EventQueue;


import backend.firstName;
import backend.Validation;
import database.DBconnection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class login {

	public JFrame frame;
	private JTextField email;
	private JPasswordField passwordField;
	public JComboBox<Object> comboBox;

	
    
    public String getUserEmail() {
        
        String emailInput = this.email.getText();
        return emailInput;
    }
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @return 
	 */
	public login() {
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
		panel.setBounds(11, 27, 1325, 108);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Welcome to login page");
		lblNewLabel.setBounds(461, 25, 371, 45);
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 39));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(291, 145, 602, 556);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel emaillabel = new JLabel("Email:");
		emaillabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		emaillabel.setBounds(105, 85, 126, 37);
		panel_1.add(emaillabel);
		
		JLabel passwordlabel = new JLabel("Password:");
		passwordlabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		passwordlabel.setBounds(105, 190, 126, 37);
		panel_1.add(passwordlabel);
		
		email = new JTextField();
		email.setFont(new Font("Garamond", Font.PLAIN, 22));
		email.setColumns(10);
		email.setBounds(105, 132, 452, 37);
		panel_1.add(email);
		
		
		JLabel lblNewLabel_1 = new JLabel("Select User Mode:");
		lblNewLabel_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(105, 28, 211, 30);
		panel_1.add(lblNewLabel_1);
		
		String[] options = {"Admin", "Tutor", "Student"};
		comboBox = new JComboBox<Object>(options);
		comboBox.setFont(new Font("Garamond", Font.PLAIN, 24));
//		comboBox.addActionListener(new ActionListener() {
//		    @Override
//		    public void actionPerformed(ActionEvent e) {
//		        // Update selectedUserRole when the selection changes
//		        selectedIndex = comboBox.getSelectedIndex();
//		        
//		        System.out.println("Selected User Role: " + selectedIndex);
//		    }
//		});
//		comboBox.setSelectedIndex(0);
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(290, 28, 131, 30);
		panel_1.add(comboBox);
		
		
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Retrieve values from text fields
			    String enteredEmail = getUserEmail();
			    String enteredPassword = new String(passwordField.getPassword());
			    String selectedUserRole = (String) comboBox.getSelectedItem();

			    // Validate login using a method (e.g., validateLogin) in your Validation class
			    if (Validation.validateLogin(enteredEmail, enteredPassword, selectedUserRole)) {
			        // Fetch first name from the database based on the entered email
			        String firstNameValue = firstName.getFirstNameFromDatabase(enteredEmail, selectedUserRole);

			        // Check if first name is retrieved successfully
			        if (firstNameValue != null) {
			            // Now you can use firstNameValue in the activity table entry
			            String activityEntry;
			            switch (selectedUserRole) {
			                case "Admin":
			                    activityEntry = "Admin: " + firstNameValue + " logged in";
			                    break;
			                case "Tutor":
			                    activityEntry = "Tutor: " + firstNameValue + " logged in";
			                    break;
			                case "Student":
			                    activityEntry = "Student: " + firstNameValue + " logged in";
			                    break;
			                default:
			                    activityEntry = "Unknown user role joined";
			                    break;
			            }

			            // Insert entry into activity table
			            try (Connection connection = new DBconnection().load();
			                 PreparedStatement activityStatement = connection.prepareStatement("INSERT INTO activity (activity_name, activity_date, activity_time) VALUES (?, CURDATE(), CURTIME())")) {
			                activityStatement.setString(1, activityEntry);
			                activityStatement.executeUpdate();
			            } catch (SQLException ex) {
			                ex.printStackTrace();
			                // Handle the exception or log an error message
			            }

			            // Open the dashboard frame
			            EventQueue.invokeLater(new Runnable() {
			                public void run() {
			                    try {
			                        dashboard window = new dashboard(selectedUserRole, enteredEmail);
			                        window.frame.setVisible(true);
			                        frame.dispose(); // Close the login frame
			                    } catch (Exception e) {
			                        e.printStackTrace();
			                    }
			                }
			            });
			        } else {
			            // Handle the case where first name retrieval failed
			            JOptionPane.showMessageDialog(frame, "Error retrieving first name from the database",
			                    "Error", JOptionPane.ERROR_MESSAGE);
			        }
			    } else {
			        // Display an error message or take appropriate action
			        JOptionPane.showMessageDialog(frame, "Invalid email, password, or user role.",
			                "Login Error", JOptionPane.ERROR_MESSAGE);
			    }

			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(134, 85, 236));
		btnNewButton.setFont(new Font("Garamond", Font.PLAIN, 21));
		btnNewButton.setIcon(null);
		btnNewButton.setBounds(105, 307, 192, 37);
		panel_1.add(btnNewButton);
		
		
		
		JLabel lblAlreadyHaveAn = new JLabel("Don't have an account?");
		lblAlreadyHaveAn.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblAlreadyHaveAn.setBounds(105, 391, 233, 37);
		panel_1.add(lblAlreadyHaveAn);
		
		JLabel lblSignIn = new JLabel("Sign Up");
        lblSignIn.setFont(new Font("Garamond", Font.PLAIN, 24));
        lblSignIn.setBounds(334, 391, 76, 37);
        lblSignIn.setForeground(Color.BLUE); // Set color to blue for indication of hyperlink
        lblSignIn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor to hand when hovered
        panel_1.add(lblSignIn);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        passwordField.setBounds(105, 237, 452, 37);
        panel_1.add(passwordField);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon(login.class.getResource("/gui/images/CMS.png")));
        lblNewLabel_2.setBounds(11, 338, 270, 270);
        frame.getContentPane().add(lblNewLabel_2);
        
        JPanel cmsPanel = new JPanel();
        cmsPanel.setBounds(11, 155, 270, 173);
        frame.getContentPane().add(cmsPanel);
        cmsPanel.setLayout(null);
        cmsPanel.setBorder(UIManager.getBorder("TextPane.border"));
        cmsPanel.setBackground(new Color(211, 211, 211));
        
        JLabel lblNewLabel_1_1 = new JLabel("Course");
        lblNewLabel_1_1.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblNewLabel_1_1.setBounds(59, 23, 114, 40);
        cmsPanel.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("Management");
        lblNewLabel_1_1_1.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblNewLabel_1_1_1.setBounds(29, 63, 217, 40);
        cmsPanel.add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("System");
        lblNewLabel_1_1_1_1.setFont(new Font("Algerian", Font.PLAIN, 30));
        lblNewLabel_1_1_1_1.setBounds(59, 100, 114, 40);
        cmsPanel.add(lblNewLabel_1_1_1_1);
        
        

        lblSignIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	opensignupWindow();
            }

            private void opensignupWindow() {
            	try {
                    signup loginWindow = new signup();
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
