package gui;

import java.awt.EventQueue;




import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import backend.activities;
import courses.Courses;
import courses.Modules;
import database.DBconnection;
import users.Admin;


import users.Student;
import users.Tutor;


import javax.swing.JScrollPane;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.Icon;

public class dashboard {

	JFrame frame;

	private JTable table_2;
	private JTextField courseSearch;
	private JTextField studentSearch;
	private JPanel mainPanel;
	private Desktop desktop;
	private CardLayout cardLayout = new CardLayout(0, 0);
	private JTextField oldPassword;
	private JTextField newPassword;
	private JTable table;
	private JTable table_1;
	private JTable table_3;
	private JTable table_4;
	private static String enteredEmail;
	private static String selectedRole;

	
	


	/**
	 * Launch the application.
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard window = new dashboard(selectedRole, enteredEmail);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 * @return 
	 */
	public dashboard(String selectedRole, String enteredEmail) {
		
		dashboard.selectedRole= selectedRole;
		dashboard.enteredEmail = enteredEmail;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		cardLayout = new CardLayout();
		frame = new JFrame();
		frame.setBounds(100, 100, 1360, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel sidePanel = new JPanel();
		sidePanel.setBackground(new Color(211, 211, 211));
		sidePanel.setBounds(10, 195, 270, 508);
		frame.getContentPane().add(sidePanel);
		sidePanel.setLayout(null);
		
		
		JButton mailbtn = new JButton("Mail");
		mailbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktop = Desktop.getDesktop();

				try {
					desktop.browse(new URI("https://gmail.com/"));
				} catch (IOException | URISyntaxException e1) {

					e1.printStackTrace();
				}
			}
		});
		mailbtn.setBackground(new Color(255, 250, 250));
		mailbtn.setIcon(new ImageIcon(getClass().getResource("/gui/images/mail.png")));
		mailbtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		mailbtn.setBounds(45, 320, 187, 47);
		sidePanel.add(mailbtn);
		
		JButton logoutbtn = new JButton("Log Out");
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        login loginWindow = new login();
		        loginWindow.frame.setVisible(true);
		        frame.dispose();
			}
		});
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
		
		mainPanel = new JPanel();
		mainPanel.setBounds(282, 10, 1054, 693);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(cardLayout);
		
		JPanel dashPanel = new JPanel();
		mainPanel.add(dashPanel, "name_81620814996000");
		dashPanel.setLayout(null);
		
		JButton dashButton = new JButton("Dashboard");
		dashButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "name_81620814996000");
	            frame.revalidate();
				frame.repaint();
			}
		});
        dashButton.setBackground(new Color(255, 250, 250));
        dashButton.setIcon(new ImageIcon(getClass().getResource("/gui/images/dashboard.png")));
        dashButton.setFont(new Font("Garamond", Font.PLAIN, 24));
        dashButton.setBounds(45, 35, 187, 47);
        sidePanel.add(dashButton);
		
		JPanel headerPanel = new JPanel();
		headerPanel.setLayout(null);
		headerPanel.setBackground(new Color(142, 172, 205));
		headerPanel.setBounds(0, 0, 1053, 60);
		dashPanel.add(headerPanel);
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setFont(new Font("Garamond", Font.PLAIN, 39));
		lblDashboard.setBounds(306, 10, 177, 40);
		headerPanel.add(lblDashboard);
		
		JPanel totalCourses = new JPanel();
		totalCourses.setBorder(UIManager.getBorder("CheckBox.border"));
		totalCourses.setBounds(10, 75, 230, 167);
		dashPanel.add(totalCourses);
		totalCourses.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Total Courses:");
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel.setBounds(10, 10, 147, 33);
		totalCourses.add(lblNewLabel);
		
		Courses c = new Courses();
		JLabel totalCoursesCount = new JLabel("" + c.getCourse().size());
		totalCoursesCount.setFont(new Font("Garamond", Font.PLAIN, 61));
		totalCoursesCount.setBounds(10, 53, 125, 104);
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
		
		Tutor t = new Tutor();
		JLabel totalTutorsCount = new JLabel("" + t.gettutor().size());
		totalTutorsCount.setFont(new Font("Garamond", Font.PLAIN, 61));
		totalTutorsCount.setBounds(20, 53, 129, 104);
		totalTutor.add(totalTutorsCount);
		
		JPanel totalStudents = new JPanel();
		totalStudents.setBorder(UIManager.getBorder("CheckBox.border"));
		totalStudents.setBounds(500, 74, 230, 168);
		dashPanel.add(totalStudents);
		totalStudents.setLayout(null);
		
		
		Student s = new Student();
		JLabel totalStudentsCount = new JLabel("" + s.getStudents().size());
		totalStudentsCount.setFont(new Font("Garamond", Font.PLAIN, 61));
		totalStudentsCount.setBounds(10, 54, 129, 104);
		totalStudents.add(totalStudentsCount);
		
		JLabel lblNewLabel_3 = new JLabel("Total Students:");
		lblNewLabel_3.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(10, 10, 154, 34);
		totalStudents.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Activities History");
		lblNewLabel_4.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_4.setBounds(10, 276, 182, 37);
		dashPanel.add(lblNewLabel_4);
		
		JScrollPane activityTable = new JScrollPane();
		activityTable.setBounds(10, 323, 733, 360);
		dashPanel.add(activityTable);
		
		table_2 = new JTable();
		activityTable.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Activities"
			}
		));
		
		
		table_2.getColumnModel().getColumn(0).setPreferredWidth(10);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(610);	
		table_2.setFont(new Font("Garamond", Font.PLAIN, 20));
		table_2.getTableHeader().setFont(new Font("Garamond", Font.BOLD, 20));
		table_2.setRowHeight(27);
		
		DBconnection dbConnection = new DBconnection();
		Connection connection = dbConnection.load();
		
		
		activities activityManager = new activities(connection);
		activityManager.displayActivities(table_2); 
		
		
		
		JPanel coursePanel = new JPanel();
		mainPanel.add(coursePanel, "name_81646405971000");
		coursePanel.setLayout(null);
		
		JButton coursebtn = new JButton("Course");
		coursebtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	cardLayout.show(mainPanel, "name_81646405971000");
		    	
	            frame.revalidate();
		    }
		});
		coursebtn.setBackground(new Color(255, 250, 250));
		coursebtn.setIcon(new ImageIcon(getClass().getResource("/gui/images/course.png")));
		coursebtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		coursebtn.setBounds(45, 92, 187, 47);
		sidePanel.add(coursebtn);
		
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
		addCoursebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse addCourse = new AddCourse();
		        addCourse.frame.setVisible(true);
			}
		});
		addCoursebtn.setFont(new Font("Garamond", Font.PLAIN, 21));
		addCoursebtn.setBackground(SystemColor.textHighlightText);
		addCoursebtn.setBounds(363, 10, 138, 37);
		courseSearchPanel.add(addCoursebtn);
		
		if(selectedRole=="Admin") {
			addCoursebtn.setVisible(true);
		}else {
			addCoursebtn.setVisible(false);
		}
		
		JButton editCoursebtn = new JButton("Edit Course");
		editCoursebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditCourse editCourse = new EditCourse();
				editCourse.frame.setVisible(true);
			}
		});
		editCoursebtn.setFont(new Font("Garamond", Font.PLAIN, 21));
		editCoursebtn.setBackground(SystemColor.textHighlightText);
		editCoursebtn.setBounds(511, 10, 138, 37);
		courseSearchPanel.add(editCoursebtn);
		
		if(selectedRole=="Admin") {
			editCoursebtn.setVisible(true);
		}else {
			editCoursebtn.setVisible(false);
		}
		
		JButton btnNewButton_3 = new JButton("Delete Course");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCourse deleteCourse = new DeleteCourse();
				deleteCourse.frame.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Garamond", Font.PLAIN, 21));
		btnNewButton_3.setBackground(SystemColor.textHighlightText);
		btnNewButton_3.setBounds(659, 10, 152, 37);
		courseSearchPanel.add(btnNewButton_3);
		
		if(selectedRole=="Admin") {
			btnNewButton_3.setVisible(true);
		}else {
			btnNewButton_3.setVisible(false);
		}
		
		JScrollPane coursesTable = new JScrollPane();
		coursesTable.setBounds(10, 180, 811, 183);
		coursePanel.add(coursesTable);

		table = new JTable();
		coursesTable.setViewportView(table);

		DefaultTableModel model = new DefaultTableModel(
		        new Object[][] {},
		        new String[] {
		                "ID", "Course Name"
		        }
		);

		table.setModel(model);

		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(610);
		table.setFont(new Font("Garamond", Font.PLAIN, 20));
		table.getTableHeader().setFont(new Font("Garamond", Font.BOLD, 20));
		table.setRowHeight(30);
		
		for (int j = 0; j < c.getCourse().size(); j++) {
		    model.addRow(new Object[]{c.getCourse().get(j).course_id, c.getCourse().get(j).course_name});
		}
		
		
		
		JLabel lblNewLabel_6 = new JLabel("Courses:");
		lblNewLabel_6.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_6.setBounds(9, 139, 101, 31);
		coursePanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Modules:");
		lblNewLabel_7.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_7.setBounds(10, 391, 100, 31);
		coursePanel.add(lblNewLabel_7);
		
		JScrollPane modulesTable = new JScrollPane();
		modulesTable.setBounds(10, 432, 811, 251);
		coursePanel.add(modulesTable);

		table_1 = new JTable();
		modulesTable.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
		        new Object[][] {
		        },
		        new String[] {
		                "ID", "Module Name", "Course", "Type"
		        }
		));

		// Set the preferred column widths
		table_1.getColumnModel().getColumn(0).setPreferredWidth(10);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(300);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(100);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(100);

		// Set the font for the table and table header
		table_1.setFont(new Font("Garamond", Font.PLAIN, 20));
		table_1.getTableHeader().setFont(new Font("Garamond", Font.BOLD, 20));

		// Set the row height
		table_1.setRowHeight(30); // Adjust the value (e.g., 30) to your preferred row height

		Modules m = new Modules();
		DefaultTableModel model1 = (DefaultTableModel) table_1.getModel();
		for (int j = 0; j < m.getModules().size(); j++) {
		    model1.addRow(new Object[]{m.getModules().get(j).module_id, m.getModules().get(j).module_name,
		            m.getModules().get(j).course_id, m.getModules().get(j).module_type});
		}
		
		
		
		
		JPanel studentPanel = new JPanel();
		mainPanel.add(studentPanel, "name_81682433354600");
		studentPanel.setLayout(null);
		
		JButton studentbtn = new JButton("Students");
		studentbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "name_81682433354600");
	            frame.revalidate();
			}
		});
		studentbtn.setBackground(new Color(255, 250, 250));
		studentbtn.setIcon(new ImageIcon(getClass().getResource("/gui/images/person.png")));
		studentbtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		studentbtn.setBounds(45, 206, 187, 47);
		sidePanel.add(studentbtn);
		
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
		addCoursebtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditStudent editstudent = new EditStudent();
				editstudent.frame.setVisible(true);
			}
		});
		addCoursebtn_1.setFont(new Font("Garamond", Font.PLAIN, 21));
		addCoursebtn_1.setBackground(SystemColor.textHighlightText);
		addCoursebtn_1.setBounds(339, 10, 138, 37);
		studentsearchPanel.add(addCoursebtn_1);
		if(selectedRole=="Admin") {
			addCoursebtn_1.setVisible(true);
		}else {
			addCoursebtn_1.setVisible(false);
		}		
		JButton editCoursebtn_1 = new JButton("Delete Student");
		editCoursebtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStudent deletestudent = new DeleteStudent();
				deletestudent.frame.setVisible(true);
			}
		});
		editCoursebtn_1.setFont(new Font("Garamond", Font.PLAIN, 19));
		editCoursebtn_1.setBackground(SystemColor.textHighlightText);
		editCoursebtn_1.setBounds(487, 10, 147, 37);
		studentsearchPanel.add(editCoursebtn_1);
		if(selectedRole=="Admin") {
			editCoursebtn_1.setVisible(true);
		}else {
			editCoursebtn_1.setVisible(false);
		}
		
		JButton btnNewButton_3_1 = new JButton("View Progress");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewProgress viewprogress = new ViewProgress();
				viewprogress.frame.setVisible(true);
			}
		});
		btnNewButton_3_1.setFont(new Font("Garamond", Font.PLAIN, 21));
		btnNewButton_3_1.setBackground(SystemColor.textHighlightText);
		btnNewButton_3_1.setBounds(644, 10, 152, 37);
		studentsearchPanel.add(btnNewButton_3_1);
		if(selectedRole=="Admin") {
			btnNewButton_3_1.setVisible(true);
		}else if(selectedRole == "Tutor") {
			btnNewButton_3_1.setVisible(false);
		}else if(selectedRole == "Student") {
			btnNewButton_3_1.setVisible(true);
		}
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 157, 806, 511);
		studentPanel.add(scrollPane_4);

		table_3 = new JTable();
		scrollPane_4.setViewportView(table_3);
		table_3.setModel(new DefaultTableModel(
		        new Object[][] {
		        },
		        new String[] {
		                "ID", "Name", "Email", "Phone"
		        }
		));

		
		table_3.getColumnModel().getColumn(0).setPreferredWidth(10);
		table_3.getColumnModel().getColumn(1).setPreferredWidth(200);
		table_3.getColumnModel().getColumn(2).setPreferredWidth(200);
		table_3.getColumnModel().getColumn(3).setPreferredWidth(150);

		
		table_3.setFont(new Font("Garamond", Font.PLAIN, 20));
		table_3.getTableHeader().setFont(new Font("Garamond", Font.BOLD, 20));

		
		table_3.setRowHeight(30); 

		
		DefaultTableModel studentTable = (DefaultTableModel) table_3.getModel();
		for (int j = 0; j < s.getStudents().size(); j++) {
		    studentTable.addRow(new Object[]{s.getStudents().get(j).id, s.getStudents().get(j).name,
		            s.getStudents().get(j).email, s.getStudents().get(j).phone});
		}


		
		JPanel setingsPanel = new JPanel();
		mainPanel.add(setingsPanel, "name_81696700830100");
		setingsPanel.setLayout(null);
		
		JButton settingbtn = new JButton("Settings");
		settingbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "name_81696700830100");
	            frame.revalidate();
			}
		});
		settingbtn.setBackground(new Color(255, 250, 250));
		settingbtn.setIcon(new ImageIcon(getClass().getResource("/gui/images/setting.png")));
		settingbtn.setFont(new Font("Garamond", Font.PLAIN, 24));
		settingbtn.setBounds(45, 263, 187, 47);
		sidePanel.add(settingbtn);
		
		JPanel headerPanel_4 = new JPanel();
		headerPanel_4.setLayout(null);
		headerPanel_4.setBackground(new Color(142, 172, 205));
		headerPanel_4.setBounds(0, 0, 1053, 60);
		setingsPanel.add(headerPanel_4);
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setFont(new Font("Garamond", Font.PLAIN, 39));
		lblSettings.setBounds(306, 10, 177, 40);
		headerPanel_4.add(lblSettings);
		
		JLabel lblNewLabel_12 = new JLabel("Security & Login");
		lblNewLabel_12.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_12.setBounds(10, 70, 169, 34);
		setingsPanel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Old Password:");
		lblNewLabel_13.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_13.setBounds(10, 152, 143, 27);
		setingsPanel.add(lblNewLabel_13);

		oldPassword = new JPasswordField();
		oldPassword.setBounds(171, 152, 234, 27);
		setingsPanel.add(oldPassword);

		JLabel lblNewLabel_14 = new JLabel("New Password:");
		lblNewLabel_14.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_14.setBounds(480, 152, 154, 27);
		setingsPanel.add(lblNewLabel_14);

		newPassword = new JPasswordField();
		newPassword.setBounds(644, 152, 234, 27);
		setingsPanel.add(newPassword);

		JButton changePasswordbtn = new JButton("Change Password");
		changePasswordbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPass = new String(((JPasswordField) newPassword).getPassword());
				String oldPass = new String(((JPasswordField) oldPassword).getPassword());
				Admin a = new Admin();
				if(selectedRole=="Student") {
					s.changePassword(enteredEmail, oldPass, newPass);
				 } else if(selectedRole=="Tutor"){
					 t.changePassword(enteredEmail, oldPass, newPass);
				 }else if(selectedRole=="Admin") {
					 a.changePassword(enteredEmail, oldPass, newPass);
				 }
			}
		});
		changePasswordbtn.setFont(new Font("Garamond", Font.PLAIN, 21));
		changePasswordbtn.setBounds(10, 215, 197, 27);
		setingsPanel.add(changePasswordbtn);


		
		JButton btnNewButton = new JButton("Create Student Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GenerateReport generatereport = new GenerateReport();
				generatereport.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Garamond", Font.PLAIN, 22));
		btnNewButton.setBounds(10, 297, 241, 34);
		setingsPanel.add(btnNewButton);
		if(selectedRole=="Tutor") {
			btnNewButton.setVisible(true);
		}else {
			btnNewButton.setVisible(false);
		}
		
		JPanel tutorPanel = new JPanel();
		mainPanel.add(tutorPanel, "name_81912417026100");
		tutorPanel.setLayout(null);
		
		JButton tutorsButton = new JButton("Tutors");
		tutorsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(mainPanel, "name_81912417026100");
	            frame.revalidate();
			}
		});
		tutorsButton.setBackground(new Color(255, 250, 250));
		tutorsButton.setIcon(new ImageIcon(getClass().getResource("/gui/images/person.png")));
		tutorsButton.setFont(new Font("Garamond", Font.PLAIN, 24));
		tutorsButton.setBounds(45, 149, 187, 47);
		sidePanel.add(tutorsButton);
		
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
		addCoursebtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTutor addtutor = new AddTutor();
				addtutor.frame.setVisible(true);
			}
		});
		addCoursebtn_2.setFont(new Font("Garamond", Font.PLAIN, 21));
		addCoursebtn_2.setBackground(SystemColor.textHighlightText);
		addCoursebtn_2.setBounds(350, 10, 138, 37);
		tutorSearchPanel.add(addCoursebtn_2);
		if(selectedRole=="Admin") {
			addCoursebtn_2.setVisible(true);
		}else {
			addCoursebtn_2.setVisible(false);
		}
		
		JButton editCoursebtn_2 = new JButton("Edit Tutor");
		editCoursebtn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditTutor edittutor = new EditTutor();
				edittutor.frame.setVisible(true);
			}
		});
		editCoursebtn_2.setFont(new Font("Garamond", Font.PLAIN, 21));
		editCoursebtn_2.setBackground(SystemColor.textHighlightText);
		editCoursebtn_2.setBounds(498, 10, 138, 37);
		tutorSearchPanel.add(editCoursebtn_2);
		if(selectedRole=="Admin") {
			editCoursebtn_2.setVisible(true);
		}else {
			editCoursebtn_2.setVisible(false);
		}
		
		JButton btnNewButton_3_2 = new JButton("Delete Tutor");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteTutor deletetutor = new DeleteTutor();
				deletetutor.frame.setVisible(true);
			}
		});
		btnNewButton_3_2.setFont(new Font("Garamond", Font.PLAIN, 21));
		btnNewButton_3_2.setBackground(SystemColor.textHighlightText);
		btnNewButton_3_2.setBounds(646, 10, 152, 37);
		tutorSearchPanel.add(btnNewButton_3_2);
		if(selectedRole=="Admin") {
			btnNewButton_3_2.setVisible(true);
		}else {
			btnNewButton_3_2.setVisible(false);
		}
		
		JScrollPane tutorsTable = new JScrollPane();
		tutorsTable.setBounds(10, 152, 798, 541);
		tutorPanel.add(tutorsTable);

		table_4 = new JTable();
		tutorsTable.setViewportView(table_4);
		table_4.setModel(new DefaultTableModel(
		        new Object[][] {
		        },
		        new String[] {
		                "ID", "Name", "Email", "Phone"
		        }
		));

		// Set the preferred column widths
		table_4.getColumnModel().getColumn(0).setPreferredWidth(10);
		table_4.getColumnModel().getColumn(1).setPreferredWidth(200);
		table_4.getColumnModel().getColumn(2).setPreferredWidth(200);
		table_4.getColumnModel().getColumn(3).setPreferredWidth(150);

		// Set the font for the table and table header
		table_4.setFont(new Font("Garamond", Font.PLAIN, 20));
		table_4.getTableHeader().setFont(new Font("Garamond", Font.BOLD, 20));

		// Set the row height
		table_4.setRowHeight(30); // Adjust the value (e.g., 30) to your preferred row height

		// Populate the table with data
		DefaultTableModel tutorTable = (DefaultTableModel) table_4.getModel();
		for (int j = 0; j < t.gettutor().size(); j++) {
		    tutorTable.addRow(new Object[]{t.gettutor().get(j).id, t.gettutor().get(j).name,
		            t.gettutor().get(j).email, t.gettutor().get(j).phone});
		}
		
		

	}
	
	
}
