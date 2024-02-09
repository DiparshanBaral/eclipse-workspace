package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeleteStudent {

	private JFrame frame;
	private JTextField deletestudentfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStudent window = new DeleteStudent();
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
	public DeleteStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(10, 10, 716, 58);
		frame.getContentPane().add(panel);
		
		JLabel lblDeleteStudent = new JLabel("Delete Student");
		lblDeleteStudent.setFont(new Font("Garamond", Font.PLAIN, 34));
		lblDeleteStudent.setBounds(258, 10, 214, 38);
		panel.add(lblDeleteStudent);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Student ID:");
		lblNewLabel_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(181, 126, 173, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		deletestudentfield = new JTextField();
		deletestudentfield.setColumns(10);
		deletestudentfield.setBounds(179, 186, 329, 31);
		frame.getContentPane().add(deletestudentfield);
		
		JButton deleteStudentbtn = new JButton("Delete");
		deleteStudentbtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		deleteStudentbtn.setBounds(181, 257, 111, 31);
		frame.getContentPane().add(deleteStudentbtn);
	}
}
