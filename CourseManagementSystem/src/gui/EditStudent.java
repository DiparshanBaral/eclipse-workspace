package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import courses.CRUDCourse;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditStudent{

	JFrame frame;
	private JTextField editStudentID;
	private JTextField editStudentName;
	private JTextField editStudentPhone;
	private JTextField editStudentEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditStudent window = new EditStudent();
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
	public EditStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1350, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(10, 10, 1316, 67);
		frame.getContentPane().add(panel);
		
		JLabel lblEditStudent = new JLabel("Edit Student");
		lblEditStudent.setFont(new Font("Garamond", Font.PLAIN, 61));
		lblEditStudent.setBounds(535, 10, 320, 47);
		panel.add(lblEditStudent);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID:");
		lblNewLabel_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(379, 123, 215, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		editStudentID = new JTextField();
		editStudentID.setColumns(10);
		editStudentID.setBounds(379, 190, 364, 40);
		frame.getContentPane().add(editStudentID);
		
		JLabel lblNewLabel_1_1 = new JLabel("Student Name:");
		lblNewLabel_1_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(379, 261, 215, 40);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		editStudentName = new JTextField();
		editStudentName.setColumns(10);
		editStudentName.setBounds(379, 311, 364, 40);
		frame.getContentPane().add(editStudentName);
		
		JLabel lblNewLabel_2 = new JLabel("Student Phone:");
		lblNewLabel_2.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(375, 381, 191, 37);
		frame.getContentPane().add(lblNewLabel_2);
		
		editStudentPhone = new JTextField();
		editStudentPhone.setColumns(10);
		editStudentPhone.setBounds(379, 440, 364, 40);
		frame.getContentPane().add(editStudentPhone);
		
		JLabel lblNewLabel_3 = new JLabel("Student Email:");
		lblNewLabel_3.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(379, 508, 208, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		editStudentEmail = new JTextField();
		editStudentEmail.setColumns(10);
		editStudentEmail.setBounds(379, 549, 364, 40);
		frame.getContentPane().add(editStudentEmail);
		
		JButton btnUpdateStudent = new JButton("Update Student");
		btnUpdateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CRUDCourse c = new CRUDCourse();
		        int si = Integer.parseInt(editStudentID.getText());
		        String sn = editStudentName.getText();
		        String sp = editStudentPhone.getText();
		        String se = editStudentEmail.getText();
		        c.updateStudent(si, sn, sp, se);
		        frame.dispose();
			}
		});
		btnUpdateStudent.setFont(new Font("Garamond", Font.PLAIN, 24));
		btnUpdateStudent.setBounds(379, 621, 215, 36);
		frame.getContentPane().add(btnUpdateStudent);
	}

}
