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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.Icon;

public class dashboard {

	private JFrame frame;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField courseSearch;
	private JTextField studentSearch;

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
		CardLayout cardLayout = new CardLayout();
		frame = new JFrame();
		frame.setBounds(100, 100, 1360, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBackground(new Color(211, 211, 211));
		sidePanel.setBounds(10, 195, 270, 508);
		frame.getContentPane().add(sidePanel);
		sidePanel.setLayout(null);
		
		JButton dashButton = new JButton("Dashboard");
		dashButton.setBackground(new Color(255, 250, 250));
		dashButton.setIcon(new ImageIcon(getClass().getResource("/gui/images/dashboard.png")));
		dashButton.setFont(new Font("Garamond", Font.PLAIN, 24));
		dashButton.setBounds(45, 35, 187, 47);
		sidePanel.add(dashButton);
		
		JButton coursebtn = new JButton("Course");
		coursebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(container, "course");
			}
		});
		coursebtn.setBackground(new Color(255, 250, 250));
		coursebtn.setIcon(new ImageIcon(getClass().getResource("/gui/images/course.png")));
		coursebtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		coursebtn.setBounds(45, 92, 187, 47);
		sidePanel.add(coursebtn);

		
		JButton tutorsButton = new JButton("Tutors");
		tutorsButton.setBackground(new Color(255, 250, 250));
		tutorsButton.setIcon(new ImageIcon(getClass().getResource("/gui/images/person.png")));
		tutorsButton.setFont(new Font("Garamond", Font.PLAIN, 24));
		tutorsButton.setBounds(45, 149, 187, 47);
		sidePanel.add(tutorsButton);

		
		JButton studentbtn = new JButton("Students");
		studentbtn.setBackground(new Color(255, 250, 250));
		studentbtn.setIcon(new ImageIcon(getClass().getResource("/gui/images/person.png")));
		studentbtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		studentbtn.setBounds(45, 206, 187, 47);
		sidePanel.add(studentbtn);
		
		JButton settingbtn = new JButton("Settings");
		settingbtn.setBackground(new Color(255, 250, 250));
		settingbtn.setIcon(new ImageIcon(getClass().getResource("/gui/images/setting.png")));
		settingbtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		settingbtn.setBounds(45, 263, 187, 47);
		sidePanel.add(settingbtn);
		
		JButton mailbtn = new JButton("Mail");
		mailbtn.setBackground(new Color(255, 250, 250));
		mailbtn.setIcon(new ImageIcon(getClass().getResource("/gui/images/mail.png")));
		mailbtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		mailbtn.setBounds(45, 320, 187, 47);
		sidePanel.add(mailbtn);
		
		JButton logoutbtn = new JButton("Log Out");
		logoutbtn.setBackground(new Color(255, 250, 250));
		logoutbtn.setIcon(new ImageIcon(getClass().getResource("/gui/images/logout.png")));
		logoutbtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		logoutbtn.setBounds(45, 377, 187, 47);
		sidePanel.add(logoutbtn);

		
		
		JPanel cmsPanel = new JPanel();
		cmsPanel.setBackground(new Color(211, 211, 211));
		cmsPanel.setBorder(UIManager.getBorder("TextPane.border"));
		cmsPanel.setBounds(10, 10, 270, 173);
		frame.getContentPane().add(cmsPanel);
		cmsPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Course");
		lblNewLabel_1.setFont(new Font("Algerian", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(59, 23, 114, 40);
		cmsPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Management");
		lblNewLabel_1_1.setFont(new Font("Algerian", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(30, 62, 217, 40);
		cmsPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("System");
		lblNewLabel_1_1_1.setFont(new Font("Algerian", Font.PLAIN, 30));
		lblNewLabel_1_1_1.setBounds(59, 100, 114, 40);
		cmsPanel.add(lblNewLabel_1_1_1);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(282, 10, 1054, 693);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(new CardLayout(0, 0));
		
		JPanel dashPanel = new JPanel();
		mainPanel.add(dashPanel, "name_81620814996000");
		dashPanel.setLayout(null);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(142, 172, 205));
		headerPanel.setBounds(0, 0, 1053, 60);
		dashPanel.add(headerPanel);
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setFont(new Font("Garamond", Font.PLAIN, 39));
		lblDashboard.setBounds(306, 10, 177, 40);
		headerPanel.add(lblDashboard);
		
		JPanel notiPanel = new JPanel();
		notiPanel.setLayout(null);
		notiPanel.setBounds(750, 63, 303, 630);
		dashPanel.add(notiPanel);
		
		JLabel lblNewLabel_6 = new JLabel("Notification");
		lblNewLabel_6.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_6.setBounds(0, 10, 121, 33);
		notiPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(getClass().getResource("/gui/images/notification.png")));
		lblNewLabel_7.setBounds(118, 18, 25, 25);
		notiPanel.add(lblNewLabel_7);
		
		JScrollPane notiscrollPane = new JScrollPane();
		notiscrollPane.setBounds(0, 53, 303, 577);
		notiPanel.add(notiscrollPane);
		
		JPanel totalCourses = new JPanel();
		totalCourses.setBorder(UIManager.getBorder("CheckBox.border"));
		totalCourses.setBounds(10, 75, 230, 167);
		dashPanel.add(totalCourses);
		totalCourses.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total Courses:");
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 10, 147, 33);
		totalCourses.add(lblNewLabel);
		
		JLabel totalCoursesCount = new JLabel("4");
		totalCoursesCount.setFont(new Font("Garamond", Font.PLAIN, 61));
		totalCoursesCount.setBounds(10, 53, 129, 104);
		totalCourses.add(totalCoursesCount);
		
		JPanel totalTutor = new JPanel();
		totalTutor.setBorder(UIManager.getBorder("CheckBox.border"));
		totalTutor.setBounds(255, 75, 230, 167);
		dashPanel.add(totalTutor);
		totalTutor.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Total Tutors:");
		lblNewLabel_2.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(10, 10, 140, 33);
		totalTutor.add(lblNewLabel_2);
		
		JLabel totalTutorsCount = new JLabel("44");
		totalTutorsCount.setFont(new Font("Garamond", Font.PLAIN, 61));
		totalTutorsCount.setBounds(20, 53, 129, 104);
		totalTutor.add(totalTutorsCount);
		
		JPanel panel = new JPanel();
		panel.setBorder(UIManager.getBorder("CheckBox.border"));
		panel.setBounds(500, 74, 230, 168);
		dashPanel.add(panel);
		panel.setLayout(null);
		
		JLabel totalStudentsCount = new JLabel("44");
		totalStudentsCount.setFont(new Font("Garamond", Font.PLAIN, 61));
		totalStudentsCount.setBounds(10, 54, 129, 104);
		panel.add(totalStudentsCount);
		
		JLabel lblNewLabel_3 = new JLabel("Total Students:");
		lblNewLabel_3.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(10, 10, 154, 34);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Activities History");
		lblNewLabel_4.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_4.setBounds(10, 276, 182, 37);
		dashPanel.add(lblNewLabel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 323, 733, 360);
		dashPanel.add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Activities"
			}
		));
		
		// Set the preferred width for the "ID" column
		table_2.getColumnModel().getColumn(0).setPreferredWidth(10);

				// Set the preferred width for the "Activity" column
		table_2.getColumnModel().getColumn(1).setPreferredWidth(610);	
		table_2.setFont(new Font("Garamond", Font.PLAIN, 20)); // Adjust the size (e.g., 20)
		table_2.getTableHeader().setFont(new Font("Garamond", Font.BOLD, 20));  
		
		
		
		JPanel coursePanel = new JPanel();
		mainPanel.add(coursePanel, "name_81646405971000");
		coursePanel.setLayout(null);
		
		JPanel headerPanel_1 = new JPanel();
		headerPanel_1.setLayout(null);
		headerPanel_1.setBackground(new Color(142, 172, 205));
		headerPanel_1.setBounds(0, 0, 1053, 60);
		coursePanel.add(headerPanel_1);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setFont(new Font("Garamond", Font.PLAIN, 39));
		lblCourse.setBounds(306, 10, 177, 40);
		headerPanel_1.add(lblCourse);
		
		JPanel courseSearchPanel = new JPanel();
		courseSearchPanel.setLayout(null);
		courseSearchPanel.setBounds(-1, 63, 821, 66);
		coursePanel.add(courseSearchPanel);
		
		courseSearch = new JTextField();
		courseSearch.setFont(new Font("Garamond", Font.PLAIN, 24));
		courseSearch.setColumns(10);
		courseSearch.setBounds(66, 10, 275, 37);
		courseSearchPanel.add(courseSearch);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBackground(SystemColor.controlLtHighlight);
		lblNewLabel_2_1.setBounds(26, 10, 30, 30);
		courseSearchPanel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setIcon(new ImageIcon(getClass().getResource("/gui/images/search.png")));
		
		JButton addCoursebtn = new JButton("Add Course");
		addCoursebtn.setFont(new Font("Garamond", Font.PLAIN, 21));
		addCoursebtn.setBackground(SystemColor.textHighlightText);
		addCoursebtn.setBounds(363, 10, 138, 37);
		courseSearchPanel.add(addCoursebtn);
		
		JButton editCoursebtn = new JButton("Edit Course");
		editCoursebtn.setFont(new Font("Garamond", Font.PLAIN, 21));
		editCoursebtn.setBackground(SystemColor.textHighlightText);
		editCoursebtn.setBounds(511, 10, 138, 37);
		courseSearchPanel.add(editCoursebtn);
		
		JButton btnNewButton_3 = new JButton("Delete Course");
		btnNewButton_3.setFont(new Font("Garamond", Font.PLAIN, 21));
		btnNewButton_3.setBackground(SystemColor.textHighlightText);
		btnNewButton_3.setBounds(659, 10, 152, 37);
		courseSearchPanel.add(btnNewButton_3);
		
		JPanel studentPanel = new JPanel();
		mainPanel.add(studentPanel, "name_81682433354600");
		studentPanel.setLayout(null);
		
		JPanel headerPanel_2 = new JPanel();
		headerPanel_2.setLayout(null);
		headerPanel_2.setBackground(new Color(142, 172, 205));
		headerPanel_2.setBounds(0, 0, 1053, 60);
		studentPanel.add(headerPanel_2);
		
		JLabel lblStudent = new JLabel("Students");
		lblStudent.setFont(new Font("Garamond", Font.PLAIN, 39));
		lblStudent.setBounds(306, 10, 177, 40);
		headerPanel_2.add(lblStudent);
		
		JPanel studentsearchPanel = new JPanel();
		studentsearchPanel.setLayout(null);
		studentsearchPanel.setBounds(0, 70, 806, 66);
		studentPanel.add(studentsearchPanel);
		
		JLabel iconLabel = new JLabel((Icon) null);
		iconLabel.setBounds(35, 10, 30, 30);
		studentsearchPanel.add(iconLabel);
		iconLabel.setIcon(new ImageIcon(getClass().getResource("/gui/images/search.png")));
		
		studentSearch = new JTextField();
		studentSearch.setFont(new Font("Garamond", Font.PLAIN, 24));
		studentSearch.setColumns(10);
		studentSearch.setBounds(86, 10, 243, 37);
		studentsearchPanel.add(studentSearch);
		
		JButton addCoursebtn_1 = new JButton("Edit Student");
		addCoursebtn_1.setFont(new Font("Garamond", Font.PLAIN, 21));
		addCoursebtn_1.setBackground(SystemColor.textHighlightText);
		addCoursebtn_1.setBounds(339, 10, 138, 37);
		studentsearchPanel.add(addCoursebtn_1);
		
		JButton editCoursebtn_1 = new JButton("Delete Student");
		editCoursebtn_1.setFont(new Font("Garamond", Font.PLAIN, 19));
		editCoursebtn_1.setBackground(SystemColor.textHighlightText);
		editCoursebtn_1.setBounds(487, 10, 147, 37);
		studentsearchPanel.add(editCoursebtn_1);
		
		JButton btnNewButton_3_1 = new JButton("View Progress");
		btnNewButton_3_1.setFont(new Font("Garamond", Font.PLAIN, 21));
		btnNewButton_3_1.setBackground(SystemColor.textHighlightText);
		btnNewButton_3_1.setBounds(644, 10, 152, 37);
		studentsearchPanel.add(btnNewButton_3_1);
		
		JPanel setingsPanel = new JPanel();
		mainPanel.add(setingsPanel, "name_81696700830100");
		setingsPanel.setLayout(null);
		
		JPanel headerPanel_4 = new JPanel();
		headerPanel_4.setLayout(null);
		headerPanel_4.setBackground(new Color(142, 172, 205));
		headerPanel_4.setBounds(0, 0, 1053, 60);
		setingsPanel.add(headerPanel_4);
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setFont(new Font("Garamond", Font.PLAIN, 39));
		lblSettings.setBounds(306, 10, 177, 40);
		headerPanel_4.add(lblSettings);
		
		JPanel tutorPanel = new JPanel();
		mainPanel.add(tutorPanel, "name_81912417026100");
		tutorPanel.setLayout(null);
		
		JPanel headerPanel_3 = new JPanel();
		headerPanel_3.setLayout(null);
		headerPanel_3.setBackground(new Color(142, 172, 205));
		headerPanel_3.setBounds(0, 0, 1053, 60);
		tutorPanel.add(headerPanel_3);
		
		JLabel lblTutor = new JLabel("Tutor");
		lblTutor.setFont(new Font("Garamond", Font.PLAIN, 39));
		lblTutor.setBounds(306, 10, 177, 40);
		headerPanel_3.add(lblTutor);
		
		JPanel tutorSearchPanel = new JPanel();
		tutorSearchPanel.setLayout(null);
		tutorSearchPanel.setBounds(0, 63, 808, 66);
		tutorPanel.add(tutorSearchPanel);
		
		JLabel iconLabel_1 = new JLabel((Icon) null);
		iconLabel_1.setBounds(33, 10, 30, 30);
		tutorSearchPanel.add(iconLabel_1);
		iconLabel_1.setIcon(new ImageIcon(getClass().getResource("/gui/images/search.png")));
		
		JTextField tutorSearch = new JTextField();
		tutorSearch.setFont(new Font("Garamond", Font.PLAIN, 24));
		tutorSearch.setColumns(10);
		tutorSearch.setBounds(73, 10, 267, 37);
		tutorSearchPanel.add(tutorSearch);
		
		JButton addCoursebtn_2 = new JButton("Add Tutor");
		addCoursebtn_2.setFont(new Font("Garamond", Font.PLAIN, 21));
		addCoursebtn_2.setBackground(SystemColor.textHighlightText);
		addCoursebtn_2.setBounds(350, 10, 138, 37);
		tutorSearchPanel.add(addCoursebtn_2);
		
		JButton editCoursebtn_2 = new JButton("Edit Tutor");
		editCoursebtn_2.setFont(new Font("Garamond", Font.PLAIN, 21));
		editCoursebtn_2.setBackground(SystemColor.textHighlightText);
		editCoursebtn_2.setBounds(498, 10, 138, 37);
		tutorSearchPanel.add(editCoursebtn_2);
		
		JButton btnNewButton_3_2 = new JButton("Delete Tutor");
		btnNewButton_3_2.setFont(new Font("Garamond", Font.PLAIN, 21));
		btnNewButton_3_2.setBackground(SystemColor.textHighlightText);
		btnNewButton_3_2.setBounds(646, 10, 152, 37);
		tutorSearchPanel.add(btnNewButton_3_2);
	}
}
