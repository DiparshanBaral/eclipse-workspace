package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditCourse {

	private JFrame frame;
	private JTextField courseID;
	private JTextField courseName;
	private JTextField TotalSeats;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditCourse window = new EditCourse();
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
	public EditCourse() {
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
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(10, 0, 1326, 69);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Course");
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 61));
		lblNewLabel.setBounds(524, 10, 312, 49);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Course ID:");
		lblNewLabel_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(400, 155, 202, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Course Name:");
		lblNewLabel_1_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(400, 267, 202, 36);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Total Seats Available:");
		lblNewLabel_1_2.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1_2.setBounds(400, 390, 202, 36);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		courseID = new JTextField();
		courseID.setBounds(400, 201, 314, 42);
		frame.getContentPane().add(courseID);
		courseID.setColumns(10);
		
		courseName = new JTextField();
		courseName.setColumns(10);
		courseName.setBounds(400, 325, 314, 42);
		frame.getContentPane().add(courseName);
		
		TotalSeats = new JTextField();
		TotalSeats.setColumns(10);
		TotalSeats.setBounds(400, 450, 314, 42);
		frame.getContentPane().add(TotalSeats);
		
		JButton updateCoursebtn = new JButton("Update Course");
		updateCoursebtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		updateCoursebtn.setBounds(469, 537, 173, 36);
		frame.getContentPane().add(updateCoursebtn);
	}
}