package workshop10;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class q1 {

    private JFrame frame;
    private JTextField first_name;
    private JTextField last_name;
    private JTextField email;
    private JPasswordField password;
    private JPasswordField confirmPassword;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    q1 window = new q1();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public q1() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 850, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 128, 255));
        panel.setBounds(10, 10, 816, 63);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Sign up");
        lblNewLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 34));
        lblNewLabel.setBounds(327, 10, 172, 43);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 83, 803, 500);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("First Name:");
        lblNewLabel_1.setBounds(153, 37, 96, 24);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel_1.add(lblNewLabel_1);

        first_name = new JTextField();
        first_name.setBounds(153, 71, 509, 34);
        first_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(first_name);
        first_name.setColumns(10);

        last_name = new JTextField();
        last_name.setBounds(153, 159, 509, 34);
        last_name.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(last_name);
        last_name.setColumns(10);

        email = new JTextField();
        email.setBounds(153, 253, 509, 34);
        email.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(email);
        email.setColumns(10);

        password = new JPasswordField();
        password.setBounds(153, 338, 509, 39);
        password.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(password);

        JLabel lblNewLabel_2 = new JLabel("Last Name:");
        lblNewLabel_2.setBounds(153, 125, 96, 24);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel_1.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Email:");
        lblNewLabel_3.setBounds(153, 216, 96, 27);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel_1.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Password:");
        lblNewLabel_4.setBounds(153, 297, 96, 31);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel_1.add(lblNewLabel_4);

        JLabel lblConfirmPassword = new JLabel("Confirm Password:");
        lblConfirmPassword.setBounds(153, 385, 150, 31);
        lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel_1.add(lblConfirmPassword);

        confirmPassword = new JPasswordField();
        confirmPassword.setBounds(153, 420, 509, 39);
        confirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel_1.add(confirmPassword);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSignUp.setBounds(153, 470, 120, 30);
        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signUp();
            }
        });
        panel_1.add(btnSignUp);

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnCancel.setBounds(300, 470, 120, 30);
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel_1.add(btnCancel);
    }

    private void signUp() {
        String firstName = first_name.getText();
        String lastName = last_name.getText();
        String userEmail = email.getText();
        char[] userPassword = password.getPassword();
        char[] userConfirmPassword = confirmPassword.getPassword();

        if (!new String(userPassword).equals(new String(userConfirmPassword))) {
            JOptionPane.showMessageDialog(frame, "Passwords do not match. Please try again.");
            return;
        }

     // Save user information to the database
        saveToDatabase(firstName, lastName, userEmail, new String(userPassword));

        // Clear the fields after sign up
        first_name.setText("");
        last_name.setText("");
        email.setText("");
        password.setText("");
        confirmPassword.setText("");

        JOptionPane.showMessageDialog(frame, "Sign up successful!");

    }
    private void saveToDatabase(String firstName, String lastName, String email, String password) {
    	final String DB_URL = "jdbc:mysql://localhost:3307/oodp_10";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            System.out.print("Connecting to database....");

            // Insert user information into the users table
            String query = "INSERT INTO users (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, firstName);
                preparedStatement.setString(2, lastName);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, password);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("User information saved to the database.");
                } else {
                    System.out.println("Failed to save user information to the database.");
                }
            }
        } catch (SQLException exc) {
            System.out.println("Something went wrong while connecting to the database.");
            System.out.println(exc);
        }
    }
}
