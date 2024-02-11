package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

import backend.Validation;
import users.Tutor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class AddTutor {

	JFrame frame;
	private JTextField tutorsName;
	private JTextField tutorsPhone;
	private JTextField tutorsEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTutor window = new AddTutor();
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
	public AddTutor() {
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
		panel.setLayout(null);
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(10, 10, 1313, 68);
		frame.getContentPane().add(panel);
		
		JLabel lblAddTutor = new JLabel("Add Tutor");
		lblAddTutor.setFont(new Font("Garamond", Font.PLAIN, 61));
		lblAddTutor.setBackground(new Color(100, 149, 237));
		lblAddTutor.setBounds(514, 5, 284, 70);
		panel.add(lblAddTutor);
		
		JLabel lblNewLabel = new JLabel("Tutors Name:");
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel.setBounds(432, 147, 234, 37);
		frame.getContentPane().add(lblNewLabel);
		
		tutorsName = new JTextField();
		tutorsName.setBounds(432, 194, 266, 31);
		frame.getContentPane().add(tutorsName);
		tutorsName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tutors Phone:");
		lblNewLabel_2.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(432, 235, 191, 37);
		frame.getContentPane().add(lblNewLabel_2);
		
		tutorsPhone = new JTextField();
		tutorsPhone.setBounds(432, 282, 266, 31);
		frame.getContentPane().add(tutorsPhone);
		tutorsPhone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tutors Email:");
		lblNewLabel_3.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(432, 326, 208, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		tutorsEmail = new JTextField();
		tutorsEmail.setBounds(432, 367, 266, 31);
		frame.getContentPane().add(tutorsEmail);
		tutorsEmail.setColumns(10);
		
		JButton addTutorbtn = new JButton("Add");
		addTutorbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = new String(passwordField.getPassword());
				Tutor i = new Tutor();
				if(Validation.validateEmail(tutorsEmail.getText())&&Validation.validatePassword(pass)&& Validation.validatePhoneNumber(tutorsPhone.getText())) {
					i.addtutor(tutorsName.getText(), tutorsEmail.getText(), tutorsPhone.getText(), pass);
				}
				frame.dispose();
			}
		});
		addTutorbtn.setBounds(432, 560, 189, 43);
		frame.getContentPane().add(addTutorbtn);
		addTutorbtn.setFont(new Font("Garamond", Font.PLAIN, 30));
		
		JLabel lblNewLabel_2_1 = new JLabel("Tutors Password:");
		lblNewLabel_2_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_2_1.setBounds(432, 408, 191, 37);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(432, 471, 266, 31);
		frame.getContentPane().add(passwordField);
	}
}
