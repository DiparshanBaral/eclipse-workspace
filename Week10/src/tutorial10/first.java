package tutorial10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class first {

	private JFrame frame;
	private JTextField Age;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					first window = new first();
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
	public first() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel Header = new JPanel();
		Header.setBackground(new Color(128, 128, 255));
		Header.setForeground(new Color(128, 128, 255));
		Header.setBounds(10, 10, 566, 59);
		frame.getContentPane().add(Header);
		Header.setLayout(null);
		
		JLabel Main_Label = new JLabel("Vote Management System");
		Main_Label.setBounds(61, 5, 395, 45);
		Main_Label.setFont(new Font("Segoe Print", Font.BOLD, 25));
		Main_Label.setBackground(new Color(27, 39, 101));
		Header.add(Main_Label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(122, 228, 202));
		panel.setBounds(10, 70, 566, 347);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Age = new JTextField();
		Age.setFont(new Font("Segoe Print", Font.PLAIN, 16));
		Age.setBounds(58, 125, 138, 41);
		panel.add(Age);
		Age.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter your age:");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		lblNewLabel.setBounds(58, 90, 207, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your name:");
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(58, 10, 188, 25);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		textField.setBounds(57, 45, 139, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel eligibilityDisplay = new JLabel("");
		eligibilityDisplay.setFont(new Font("Segoe Print", Font.PLAIN, 14));
		eligibilityDisplay.setBounds(58, 221, 266, 28);
		panel.add(eligibilityDisplay);
		
		JButton btnNewButton = new JButton("Check Eligibility");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int age = Integer.parseInt(Age.getText());
                if(age>=18) {
                	eligibilityDisplay.setText("You are eligible to vote!");
                }
                else{
                	eligibilityDisplay.setText("You are not eligible to vote!");
                }
			}
		});
		btnNewButton.setFont(new Font("Segoe Print", Font.PLAIN, 10));
		btnNewButton.setBounds(58, 176, 128, 21);
		panel.add(btnNewButton);
		
	}
}
