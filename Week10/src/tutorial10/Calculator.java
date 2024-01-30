package tutorial10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculator extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField num1;
    private JTextField num2;
    private JTextField resultTextField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calculator frame = new Calculator();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Calculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(6, 6, 638, 460);
        contentPane.add(panel);
        panel.setLayout(null);
        
        num1 = new JTextField();
        num1.setBounds(92, 156, 187, 51);
        panel.add(num1);
        num1.setColumns(10);
        
        JLabel number1Label = new JLabel("Enter number 1");
        number1Label.setBounds(94, 128, 96, 16);        
        panel.add(number1Label);
JLabel number2Label = new JLabel("Enter number 2");
        number2Label.setBounds(368, 128, 96, 16);
        panel.add(number2Label);
        
        num2 = new JTextField();
        num2.setColumns(10);
        num2.setBounds(388, 156, 187, 51);    
        panel.add(num2);
        
        JLabel result = new JLabel("Result:");
        result.setBounds(344, 406, 96, 16);
        panel.add(result);
        
        resultTextField = new JTextField();
        resultTextField.setColumns(10);
        resultTextField.setBounds(429, 389, 187, 51);
        panel.add(resultTextField);
        
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(315, 174, 61, 16);
        panel.add(lblNewLabel);
        
        JButton addition = new JButton("+");
        addition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        addition.setBounds(120, 263, 117, 29);
        panel.add(addition);
        addition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblNewLabel.setText("+");
            }
        });
        
        JButton subtraction = new JButton("-");
        subtraction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblNewLabel.setText("-");
            }
        });
        subtraction.setBounds(259, 263, 117, 29);
        panel.add(subtraction);
        
        JButton multiply = new JButton("X");
        multiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblNewLabel.setText("*");
            }
        });
        multiply.setBounds(397, 263, 117, 29);
        panel.add(multiply);
        
        JButton euqualButton = new JButton("=");
        euqualButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(lblNewLabel.getText()=="*") {
                    int result =  Integer.parseInt(num1.getText()) * Integer.parseInt(num2.getText());
                    resultTextField.setText(Integer.toString(result));
                }
                if(lblNewLabel.getText()=="+") {
                    int result =  Integer.parseInt(num1.getText()) + Integer.parseInt(num2.getText());
                    resultTextField.setText(Integer.toString(result));
                }
                if(lblNewLabel.getText()=="-") {
                    int result =  Integer.parseInt(num1.getText()) - Integer.parseInt(num2.getText());
                    resultTextField.setText(Integer.toString(result));
                }
            }
        });
        euqualButton.setBounds(241, 334, 158, 29);
        panel.add(euqualButton);
        
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lblNewLabel.setText("");
                num1.setText("");
                num2.setText("");
                resultTextField.setText("");
            }
        });
        resetButton.setBounds(22, 34, 117, 29);
        panel.add(resetButton);
    }
}
