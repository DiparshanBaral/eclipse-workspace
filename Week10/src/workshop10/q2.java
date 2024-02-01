package workshop10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class q2 {

    private JFrame frame;
    private JTextField mail;
    private JPasswordField pass;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    q2 window = new q2();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public q2() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 850, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(128, 128, 255));
        panel.setBounds(10, 10, 816, 65);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Log in");
        lblNewLabel.setFont(new Font("Nirmala UI", Font.PLAIN, 34));
        lblNewLabel.setBounds(314, 10, 185, 45);
        panel.add(lblNewLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(10, 85, 816, 364);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("Email:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(164, 44, 142, 31);
        panel_1.add(lblNewLabel_1);

        mail = new JTextField();
        mail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        mail.setBounds(162, 85, 480, 38);
        panel_1.add(mail);
        mail.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Password:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(164, 157, 142, 31);
        panel_1.add(lblNewLabel_2);

        pass = new JPasswordField();
        pass.setBounds(162, 199, 480, 38);
        panel_1.add(pass);

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnLogin.setBounds(162, 270, 120, 30);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        panel_1.add(btnLogin);
    }

    private void login() {
        String userEmail = mail.getText();
        char[] userPassword = pass.getPassword();

        if (validateLogin(userEmail, new String(userPassword))) {
            JOptionPane.showMessageDialog(frame, "Login successful!");
        } else {
            JOptionPane.showMessageDialog(frame, "Invalid credentials. Please try again.");
        }

        mail.setText("");
        pass.setText("");
    }

    private boolean validateLogin(String userEmail, String password) {
        final String DB_URL = "jdbc:mysql://localhost:3307/oodp_10";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            System.out.print("Connecting to database....");

            String query = "SELECT * FROM users WHERE email = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, userEmail);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet.next();
            }
        } catch (SQLException exc) {
            System.out.println("Something went wrong while connecting to the database.");
            System.out.println(exc);
            return false;
        }
    }
}
