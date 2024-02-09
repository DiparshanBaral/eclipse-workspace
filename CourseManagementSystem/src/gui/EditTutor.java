package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditTutor {

	private JFrame frame;
	private JTextField editTutorID;
	private JTextField editTutorName;
	private JTextField editTutorPhone;
	private JTextField editTutoremail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditTutor window = new EditTutor();
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
	public EditTutor() {
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
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(10, 10, 1316, 67);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Tutor");
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 61));
		lblNewLabel.setBounds(535, 10, 320, 47);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tutor ID:");
		lblNewLabel_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(455, 146, 215, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		editTutorID = new JTextField();
		editTutorID.setBounds(455, 196, 364, 40);
		frame.getContentPane().add(editTutorID);
		editTutorID.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tutor Name:");
		lblNewLabel_1_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(455, 273, 215, 40);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		editTutorName = new JTextField();
		editTutorName.setColumns(10);
		editTutorName.setBounds(455, 323, 364, 40);
		frame.getContentPane().add(editTutorName);
		
		JLabel lblNewLabel_2 = new JLabel("Tutors Phone:");
		lblNewLabel_2.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(455, 406, 191, 37);
		frame.getContentPane().add(lblNewLabel_2);
		
		editTutorPhone = new JTextField();
		editTutorPhone.setColumns(10);
		editTutorPhone.setBounds(455, 453, 364, 40);
		frame.getContentPane().add(editTutorPhone);
		
		JLabel lblNewLabel_3 = new JLabel("Tutors Email:");
		lblNewLabel_3.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(455, 533, 208, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		editTutoremail = new JTextField();
		editTutoremail.setColumns(10);
		editTutoremail.setBounds(455, 586, 364, 40);
		frame.getContentPane().add(editTutoremail);
		
		JButton btnUpdateTutor = new JButton("Update Tutor");
		btnUpdateTutor.setFont(new Font("Garamond", Font.PLAIN, 24));
		btnUpdateTutor.setBounds(455, 667, 173, 36);
		frame.getContentPane().add(btnUpdateTutor);
	}

}
