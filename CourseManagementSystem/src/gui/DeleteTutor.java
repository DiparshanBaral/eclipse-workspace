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

public class DeleteTutor {

	JFrame frame;
	private JTextField deletetutorfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteTutor window = new DeleteTutor();
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
	public DeleteTutor() {
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
		
		JLabel lblDeleteTutor = new JLabel("Delete Tutor");
		lblDeleteTutor.setFont(new Font("Garamond", Font.PLAIN, 34));
		lblDeleteTutor.setBounds(258, 10, 214, 38);
		panel.add(lblDeleteTutor);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Tutor ID:");
		lblNewLabel_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(188, 124, 173, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		deletetutorfield = new JTextField();
		deletetutorfield.setColumns(10);
		deletetutorfield.setBounds(188, 173, 329, 31);
		frame.getContentPane().add(deletetutorfield);
		
		JButton deleteTutorbtn = new JButton("Delete");
		deleteTutorbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CRUDCourse c = new CRUDCourse();
		        
		        int ci = Integer.parseInt(deletetutorfield.getText());
		        c.deleteTutor(ci);
		        frame.dispose();
			}
		});
		deleteTutorbtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		deleteTutorbtn.setBounds(188, 243, 111, 31);
		frame.getContentPane().add(deleteTutorbtn);
	}
}
