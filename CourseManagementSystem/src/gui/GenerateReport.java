package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GenerateReport {

	private JFrame frame;
	private JTextField ResultStudentID;
	private JTextField ReaultModuleName;
	private JTextField ResultPercentage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateReport window = new GenerateReport();
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
	public GenerateReport() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100,1350, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(10, 10, 1316, 71);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Module Result Form");
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 61));
		lblNewLabel.setBounds(400, 10, 537, 51);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Student ID:");
		lblNewLabel_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(370, 135, 311, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		ResultStudentID = new JTextField();
		ResultStudentID.setColumns(10);
		ResultStudentID.setBounds(370, 193, 375, 38);
		frame.getContentPane().add(ResultStudentID);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Module Name:");
		lblNewLabel_2.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(370, 259, 264, 38);
		frame.getContentPane().add(lblNewLabel_2);
		
		ReaultModuleName = new JTextField();
		ReaultModuleName.setBounds(370, 311, 375, 38);
		frame.getContentPane().add(ReaultModuleName);
		ReaultModuleName.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Enter Percentage:");
		lblNewLabel_3.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(370, 379, 311, 38);
		frame.getContentPane().add(lblNewLabel_3);
		
		ResultPercentage = new JTextField();
		ResultPercentage.setBounds(370, 427, 375, 38);
		frame.getContentPane().add(ResultPercentage);
		ResultPercentage.setColumns(10);
		
		JButton UploadResultbtn = new JButton("Upload Result");
		UploadResultbtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		UploadResultbtn.setBounds(370, 508, 209, 38);
		frame.getContentPane().add(UploadResultbtn);
	}
}
