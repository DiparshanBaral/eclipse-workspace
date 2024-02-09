package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

public class AddCourse {

	private JFrame frame;
	private JTextField CourseName;
	private JTextField Batch;
	private JTextField FirstModule1;
	private JTextField FirstModule2;
	private JTextField FirstModule3;
	private JTextField SecondModule1;
	private JTextField SecondModule2;
	private JTextField SecondModule3;
	private JTextField ThirdModule1;
	private JTextField ThirdModule2;
	private JTextField ThirdModule3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourse window = new AddCourse();
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
	public AddCourse() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Course Name:");
		lblNewLabel_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(60, 92, 147, 31);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel NoofSeats = new JLabel("No. of Seats:");
		NoofSeats.setFont(new Font("Garamond", Font.PLAIN, 24));
		NoofSeats.setBounds(416, 92, 157, 31);
		frame.getContentPane().add(NoofSeats);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("1st Year");
		lblNewLabel_1_1_2.setFont(new Font("Garamond", Font.BOLD, 30));
		lblNewLabel_1_1_2.setBounds(60, 216, 157, 31);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Module 1");
		lblNewLabel_1_1_3.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1_1_3.setBounds(60, 281, 157, 31);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Module 2");
		lblNewLabel_1_1_4.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1_1_4.setBounds(416, 281, 157, 31);
		frame.getContentPane().add(lblNewLabel_1_1_4);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Module 3");
		lblNewLabel_1_1_5.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1_1_5.setBounds(841, 281, 157, 31);
		frame.getContentPane().add(lblNewLabel_1_1_5);
		
		JLabel lblNewLabel_1_1_6 = new JLabel("2nd Year");
		lblNewLabel_1_1_6.setFont(new Font("Garamond", Font.BOLD, 30));
		lblNewLabel_1_1_6.setBounds(60, 377, 157, 31);
		frame.getContentPane().add(lblNewLabel_1_1_6);
		
		JLabel lblNewLabel_1_1_7 = new JLabel("Module 1");
		lblNewLabel_1_1_7.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1_1_7.setBounds(60, 439, 157, 31);
		frame.getContentPane().add(lblNewLabel_1_1_7);
		
		JLabel lblNewLabel_1_1_8 = new JLabel("Module 2");
		lblNewLabel_1_1_8.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1_1_8.setBounds(416, 439, 157, 31);
		frame.getContentPane().add(lblNewLabel_1_1_8);
		
		JLabel lblNewLabel_1_1_9 = new JLabel("Module 3");
		lblNewLabel_1_1_9.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1_1_9.setBounds(841, 439, 157, 31);
		frame.getContentPane().add(lblNewLabel_1_1_9);
		
		JLabel lblNewLabel_1_1_10 = new JLabel("3rd Year");
		lblNewLabel_1_1_10.setFont(new Font("Garamond", Font.BOLD, 30));
		lblNewLabel_1_1_10.setBounds(60, 544, 157, 31);
		frame.getContentPane().add(lblNewLabel_1_1_10);
		
		JLabel lblNewLabel_1_1_11 = new JLabel("Module 1");
		lblNewLabel_1_1_11.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1_1_11.setBounds(60, 600, 157, 31);
		frame.getContentPane().add(lblNewLabel_1_1_11);
		
		JLabel lblNewLabel_1_1_12 = new JLabel("Module 2");
		lblNewLabel_1_1_12.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1_1_12.setBounds(416, 600, 157, 31);
		frame.getContentPane().add(lblNewLabel_1_1_12);
		
		JLabel lblNewLabel_1_1_13 = new JLabel("Module 3");
		lblNewLabel_1_1_13.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1_1_13.setBounds(841, 600, 157, 31);
		frame.getContentPane().add(lblNewLabel_1_1_13);
		
		CourseName = new JTextField();
		CourseName.setBounds(60, 134, 234, 31);
		frame.getContentPane().add(CourseName);
		CourseName.setColumns(10);
		
		Batch = new JTextField();
		Batch.setColumns(10);
		Batch.setBounds(416, 133, 234, 31);
		frame.getContentPane().add(Batch);
		
		FirstModule1 = new JTextField();
		FirstModule1.setColumns(10);
		FirstModule1.setBounds(60, 322, 234, 31);
		frame.getContentPane().add(FirstModule1);
		
		FirstModule2 = new JTextField();
		FirstModule2.setColumns(10);
		FirstModule2.setBounds(416, 322, 234, 31);
		frame.getContentPane().add(FirstModule2);
		
		FirstModule3 = new JTextField();
		FirstModule3.setColumns(10);
		FirstModule3.setBounds(840, 322, 234, 31);
		frame.getContentPane().add(FirstModule3);
		
		SecondModule1 = new JTextField();
		SecondModule1.setColumns(10);
		SecondModule1.setBounds(60, 480, 234, 31);
		frame.getContentPane().add(SecondModule1);
		
		SecondModule2 = new JTextField();
		SecondModule2.setColumns(10);
		SecondModule2.setBounds(416, 486, 234, 31);
		frame.getContentPane().add(SecondModule2);
		
		SecondModule3 = new JTextField();
		SecondModule3.setColumns(10);
		SecondModule3.setBounds(840, 486, 234, 31);
		frame.getContentPane().add(SecondModule3);
		
		ThirdModule1 = new JTextField();
		ThirdModule1.setColumns(10);
		ThirdModule1.setBounds(60, 643, 234, 31);
		frame.getContentPane().add(ThirdModule1);
		
		ThirdModule2 = new JTextField();
		ThirdModule2.setColumns(10);
		ThirdModule2.setBounds(416, 641, 234, 31);
		frame.getContentPane().add(ThirdModule2);
		
		ThirdModule3 = new JTextField();
		ThirdModule3.setColumns(10);
		ThirdModule3.setBounds(841, 641, 234, 31);
		frame.getContentPane().add(ThirdModule3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(10, 10, 1313, 68);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Course");
		lblNewLabel.setBounds(514, 5, 284, 70);
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 61));
		lblNewLabel.setBackground(new Color(100, 149, 237));
		panel.add(lblNewLabel);
		
		JButton addCoursebtn = new JButton("Add");
		addCoursebtn.setBounds(1081, 10, 189, 43);
		panel.add(addCoursebtn);
		addCoursebtn.setFont(new Font("Garamond", Font.PLAIN, 30));
	}
}
