package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeleteCourse {

	private JFrame frame;
	private JTextField deleteCoursefield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCourse window = new DeleteCourse();
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
	public DeleteCourse() {
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
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(10, 10, 716, 58);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Course");
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 34));
		lblNewLabel.setBounds(258, 10, 214, 38);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Course ID:");
		lblNewLabel_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(195, 126, 173, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		deleteCoursefield = new JTextField();
		deleteCoursefield.setBounds(195, 175, 329, 31);
		frame.getContentPane().add(deleteCoursefield);
		deleteCoursefield.setColumns(10);
		
		JButton deleteCoursebtn = new JButton("Delete");
		deleteCoursebtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		deleteCoursebtn.setBounds(195, 241, 111, 31);
		frame.getContentPane().add(deleteCoursebtn);
	}

}
