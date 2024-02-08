package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.SystemColor;
import javax.swing.JTextField;

public class courses {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					courses window = new courses();
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
	public courses() {
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
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(10, 195, 270, 508);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton dashButton = new JButton("Dashboard");
		dashButton.setBackground(new Color(255, 250, 250));
		dashButton.setIcon(new ImageIcon(getClass().getResource("/gui/images/dashboard.png")));
		dashButton.setFont(new Font("Garamond", Font.PLAIN, 24));
		dashButton.setBounds(45, 35, 187, 47);
		panel.add(dashButton);
		
		JButton coursebtn = new JButton("Course");
		coursebtn.setBackground(new Color(255, 250, 250));
		coursebtn.setIcon(new ImageIcon(getClass().getResource("/gui/images/course.png")));
		coursebtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		coursebtn.setBounds(45, 92, 187, 47);
		panel.add(coursebtn);

		
		JButton tutorsButton = new JButton("Tutors");
		tutorsButton.setBackground(new Color(255, 250, 250));
		tutorsButton.setIcon(new ImageIcon(getClass().getResource("/gui/images/person.png")));
		tutorsButton.setFont(new Font("Garamond", Font.PLAIN, 24));
		tutorsButton.setBounds(45, 149, 187, 47);
		panel.add(tutorsButton);

		
		JButton studentbtn = new JButton("Students");
		studentbtn.setBackground(new Color(255, 250, 250));
		studentbtn.setIcon(new ImageIcon(getClass().getResource("/gui/images/person.png")));
		studentbtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		studentbtn.setBounds(45, 206, 187, 47);
		panel.add(studentbtn);
		
		JButton settingbtn = new JButton("Settings");
		settingbtn.setBackground(new Color(255, 250, 250));
		settingbtn.setIcon(new ImageIcon(getClass().getResource("/gui/images/setting.png")));
		settingbtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		settingbtn.setBounds(45, 263, 187, 47);
		panel.add(settingbtn);
		
		JButton mailbtn = new JButton("Mail");
		mailbtn.setBackground(new Color(255, 250, 250));
		mailbtn.setIcon(new ImageIcon(getClass().getResource("/gui/images/mail.png")));
		mailbtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		mailbtn.setBounds(45, 320, 187, 47);
		panel.add(mailbtn);
		
		JButton logoutbtn = new JButton("Log Out");
		logoutbtn.setBackground(new Color(255, 250, 250));
		logoutbtn.setIcon(new ImageIcon(getClass().getResource("/gui/images/logout.png")));
		logoutbtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		logoutbtn.setBounds(45, 377, 187, 47);
		panel.add(logoutbtn);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(142, 172, 205));
		panel_1.setBounds(283, 10, 1053, 60);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Courses");
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 39));
		lblNewLabel.setBounds(306, 10, 177, 40);
		panel_1.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1033, 80, 303, 314);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Notification");
		lblNewLabel_6.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_6.setBounds(0, 10, 121, 33);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(getClass().getResource("/gui/images/notification.png")));
		lblNewLabel_7.setBounds(118, 18, 25, 25);
		panel_3.add(lblNewLabel_7);
		
		JScrollPane notiscrollPane = new JScrollPane();
		notiscrollPane.setBounds(0, 53, 303, 261);
		panel_3.add(notiscrollPane);
		
		JTable table_1 = new JTable();
		notiscrollPane.setViewportView(table_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(1033, 404, 303, 299);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("To-Do:");
		lblNewLabel_8.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_8.setBounds(10, 10, 71, 35);
		panel_4.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton.setIcon(new ImageIcon(getClass().getResource("/gui/images/calendar.png")));
		btnNewButton.setBounds(85, 14, 32, 28);
		panel_4.add(btnNewButton);
		
		JScrollPane todoscrollpane = new JScrollPane();
		todoscrollpane.setBounds(0, 55, 303, 244);
		panel_4.add(todoscrollpane);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(UIManager.getBorder("TextPane.border"));
		panel_5.setBackground(new Color(211, 211, 211));
		panel_5.setBounds(10, 10, 270, 173);
		frame.getContentPane().add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Course");
		lblNewLabel_1.setFont(new Font("Algerian", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(59, 23, 114, 40);
		panel_5.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Management");
		lblNewLabel_1_1.setFont(new Font("Algerian", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(30, 62, 217, 40);
		panel_5.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("System");
		lblNewLabel_1_1_1.setFont(new Font("Algerian", Font.PLAIN, 30));
		lblNewLabel_1_1_1.setBounds(59, 100, 114, 40);
		panel_5.add(lblNewLabel_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(282, 80, 741, 66);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Garamond", Font.PLAIN, 24));
		textField.setBounds(31, 10, 252, 37);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(SystemColor.controlLtHighlight);
		lblNewLabel_2.setBounds(0, 10, 30, 30);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(getClass().getResource("/gui/images/search.png")));
		
		JButton addCoursebtn = new JButton("Add Course");
		addCoursebtn.setBackground(SystemColor.textHighlightText);
		addCoursebtn.setFont(new Font("Garamond", Font.PLAIN, 21));
		addCoursebtn.setBounds(293, 10, 138, 37);
		panel_2.add(addCoursebtn);
		
		JButton editCoursebtn = new JButton("Edit Course");
		editCoursebtn.setBackground(SystemColor.textHighlightText);
		editCoursebtn.setFont(new Font("Garamond", Font.PLAIN, 21));
		editCoursebtn.setBounds(441, 10, 138, 37);
		panel_2.add(editCoursebtn);
		
		JButton btnNewButton_3 = new JButton("Delete Course");
		btnNewButton_3.setBackground(SystemColor.textHighlightText);
		btnNewButton_3.setFont(new Font("Garamond", Font.PLAIN, 21));
		btnNewButton_3.setBounds(589, 10, 152, 37);
		panel_2.add(btnNewButton_3);
	}
}
