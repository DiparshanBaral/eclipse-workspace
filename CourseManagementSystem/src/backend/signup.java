package backend;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Image;
import javax.swing.JPasswordField;
import backend.login;

public class signup {

	JFrame frame;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup window = new signup();
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
	public signup() {
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
		panel.setBackground(new Color(176, 196, 222));
		panel.setBounds(34, 27, 1302, 108);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to signup page");
		lblNewLabel.setBounds(461, 25, 371, 45);
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 39));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(291, 145, 946, 556);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel namelabel = new JLabel("First Name:");
		namelabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		namelabel.setBounds(105, 50, 126, 37);
		panel_1.add(namelabel);
		
		JLabel lastNamelabel = new JLabel("Last Name:");
		lastNamelabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		lastNamelabel.setBounds(453, 50, 126, 37);
		panel_1.add(lastNamelabel);
		
		JLabel emaillabel = new JLabel("Email:");
		emaillabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		emaillabel.setBounds(105, 144, 126, 37);
		panel_1.add(emaillabel);
		
		JLabel passwordlabel = new JLabel("Password:");
		passwordlabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		passwordlabel.setBounds(105, 226, 126, 37);
		panel_1.add(passwordlabel);
		
		JLabel cpasswordlabel = new JLabel("Confirm Password:");
		cpasswordlabel.setFont(new Font("Garamond", Font.PLAIN, 24));
		cpasswordlabel.setBounds(105, 315, 192, 37);
		panel_1.add(cpasswordlabel);
		
		firstName = new JTextField();
		firstName.setFont(new Font("Garamond", Font.PLAIN, 22));
		firstName.setBounds(105, 97, 284, 37);
		panel_1.add(firstName);
		firstName.setColumns(10);
		
		lastName = new JTextField();
		lastName.setFont(new Font("Garamond", Font.PLAIN, 22));
		lastName.setColumns(10);
		lastName.setBounds(453, 97, 315, 37);
		panel_1.add(lastName);
		
		email = new JTextField();
		email.setFont(new Font("Garamond", Font.PLAIN, 22));
		email.setColumns(10);
		email.setBounds(105, 179, 452, 37);
		panel_1.add(email);
		
		JButton btnNewButton = new JButton("Create my account");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(134, 85, 236));
		btnNewButton.setFont(new Font("Garamond", Font.PLAIN, 21));
		btnNewButton.setIcon(null);
		btnNewButton.setBounds(105, 434, 192, 37);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Select User Mode:");
		lblNewLabel_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(105, 10, 211, 30);
		panel_1.add(lblNewLabel_1);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setFont(new Font("Garamond", Font.PLAIN, 24));
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Admin", "Teacher", "Student"}));
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(291, 10, 131, 30);
		panel_1.add(comboBox);
		
		JLabel lblAlreadyHaveAn = new JLabel("Already have an account?");
		lblAlreadyHaveAn.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblAlreadyHaveAn.setBounds(105, 496, 252, 37);
		panel_1.add(lblAlreadyHaveAn);
		
		JLabel lblSignIn = new JLabel("Sign In");
        lblSignIn.setFont(new Font("Garamond", Font.PLAIN, 24));
        lblSignIn.setBounds(353, 496, 76, 37);
        lblSignIn.setForeground(Color.BLUE); // Set color to blue for indication of hyperlink
        lblSignIn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Set cursor to hand when hovered
        panel_1.add(lblSignIn);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(105, 273, 452, 37);
        panel_1.add(passwordField);
        
        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(105, 362, 452, 37);
        panel_1.add(passwordField_1);

        lblSignIn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	openLoginWindow();
            }

            private void openLoginWindow() {
            	try {
                    login loginWindow = new login();
                    loginWindow.frame.setVisible(true);
                    frame.dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
			}

			@Override
            public void mouseEntered(MouseEvent e) {
                // Change text color when the mouse enters the label
                lblSignIn.setForeground(Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Change text color back when the mouse exits the label
                lblSignIn.setForeground(Color.BLUE);
            }
        });
	}
}
