package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import courses.Result;
import exception.NullException;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class ViewProgress{

	JFrame frame;
	private JTextField progressReportID;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProgress window = new ViewProgress();
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
	public ViewProgress() {
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
		panel.setBounds(10, 10, 1316, 78);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Progress Report");
		lblNewLabel.setBackground(new Color(100, 149, 237));
		lblNewLabel.setFont(new Font("Garamond", Font.PLAIN, 61));
		lblNewLabel.setBounds(463, 10, 414, 68);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Student ID:");
		lblNewLabel_1.setFont(new Font("Garamond", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(393, 118, 311, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		progressReportID = new JTextField();
		progressReportID.setBounds(393, 166, 375, 38);
		frame.getContentPane().add(progressReportID);
		progressReportID.setColumns(10);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    int id = Integer.parseInt(progressReportID.getText());
                    displayResultsInTable(id);
                } catch (NullException | NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Fill the empty box!!", "Error!", JOptionPane.WARNING_MESSAGE);
                }
			}
		});
		btnNewButton.setFont(new Font("Garamond", Font.PLAIN, 24));
		btnNewButton.setBounds(393, 231, 136, 31);
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(247, 345, 679, 347);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Garamond", Font.PLAIN, 24));
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Module", "Marks"
			}
		));
		table.setRowHeight(30);
	}
	private void displayResultsInTable(int student_id) {
        Result result = new Result();
        ArrayList<Result> resultList = result.displayResult(student_id);

        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0); // Clear existing rows

        for (Result res : resultList) {
            tableModel.addRow(new Object[] { res.moduleName, res.marks });
        }
    }
}
