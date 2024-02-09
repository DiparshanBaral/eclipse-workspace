package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;

public class AddTutor {

	private JFrame frame;
	private JTextField tutorsName;
	private JTextField tutorsID;
	private JTextField tutorsPhone;
	private JTextField tutorsEmail;

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
		
		JButton addTutorbtn = new JButton("Add");
		addTutorbtn.setFont(new Font("Garamond", Font.PLAIN, 30));
		addTutorbtn.setBounds(1081, 10, 189, 43);
		panel.add(addTutorbtn);
		
		JLabel lblNewLabel = new JLabel("Tutors Name:");
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel.setBounds(432, 147, 234, 37);
		frame.getContentPane().add(lblNewLabel);
		
		tutorsName = new JTextField();
		tutorsName.setBounds(432, 194, 266, 31);
		frame.getContentPane().add(tutorsName);
		tutorsName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Tutors ID:");
		lblNewLabel_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(432, 264, 234, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		tutorsID = new JTextField();
		tutorsID.setBounds(432, 315, 266, 31);
		frame.getContentPane().add(tutorsID);
		tutorsID.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tutors Phone:");
		lblNewLabel_2.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(432, 388, 191, 37);
		frame.getContentPane().add(lblNewLabel_2);
		
		tutorsPhone = new JTextField();
		tutorsPhone.setBounds(432, 435, 266, 31);
		frame.getContentPane().add(tutorsPhone);
		tutorsPhone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tutors Email:");
		lblNewLabel_3.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(432, 498, 208, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		tutorsEmail = new JTextField();
		tutorsEmail.setBounds(432, 550, 266, 31);
		frame.getContentPane().add(tutorsEmail);
		tutorsEmail.setColumns(10);
	}

}
