package gui;

import java.awt.EventQueue;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class dashboard {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard window = new dashboard();
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
	public dashboard() {
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
		panel_1.setBackground(new Color(142, 172, 205));
		panel_1.setBounds(283, 10, 1053, 60);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dashboard");
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 39));
		lblNewLabel.setBounds(306, 10, 177, 40);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(290, 80, 733, 623);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 10, 230, 167);
		panel_6.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Total Courses");
		lblNewLabel_2.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(10, 10, 136, 38);
		panel_6.add(lblNewLabel_2);
		
		JLabel totalCourses = new JLabel("4");
		totalCourses.setFont(new Font("Garamond", Font.PLAIN, 61));
		totalCourses.setBounds(20, 58, 99, 99);
		panel_6.add(totalCourses);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_7.setBounds(250, 10, 230, 167);
		panel_2.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Total Tutors");
		lblNewLabel_3.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(10, 10, 139, 36);
		panel_7.add(lblNewLabel_3);
		
		JLabel totalTutors = new JLabel("55");
		totalTutors.setFont(new Font("Garamond", Font.PLAIN, 61));
		totalTutors.setBounds(10, 56, 139, 101);
		panel_7.add(totalTutors);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(UIManager.getBorder("CheckBox.border"));
		panel_8.setBounds(493, 10, 230, 167);
		panel_2.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Total Students");
		lblNewLabel_4.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_4.setBounds(10, 10, 150, 40);
		panel_8.add(lblNewLabel_4);
		
		JLabel totalStudents = new JLabel("234");
		totalStudents.setFont(new Font("Garamond", Font.PLAIN, 61));
		totalStudents.setBounds(10, 60, 174, 97);
		panel_8.add(totalStudents);
		
		JLabel lblNewLabel_5 = new JLabel("Activities History");
		lblNewLabel_5.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_5.setBounds(10, 199, 178, 37);
		panel_2.add(lblNewLabel_5);
		
		JScrollPane activityScrollPane = new JScrollPane();
		activityScrollPane.setFont(new Font("Garamond", Font.PLAIN, 21));
		activityScrollPane.setBounds(10, 235, 713, 388);
		panel_2.add(activityScrollPane);

		table = new JTable();
		activityScrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
		    new Object[][] {},
		    new String[] { "ID", "Activity" }
		));
		table.setFont(new Font("Garamond", Font.PLAIN, 20));

		// Set the preferred width for the "ID" column
		table.getColumnModel().getColumn(0).setPreferredWidth(10);

		// Set the preferred width for the "Activity" column
		table.getColumnModel().getColumn(1).setPreferredWidth(610);
		
		table.setFont(new Font("Garamond", Font.PLAIN, 20)); // Adjust the size (e.g., 20)
		table.getTableHeader().setFont(new Font("Garamond", Font.BOLD, 20)); 
		
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
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(1033, 404, 303, 299);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(211, 211, 211));
		panel_5.setBorder(UIManager.getBorder("TextPane.border"));
		panel_5.setBounds(10, 10, 270, 173);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
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
	}
}
