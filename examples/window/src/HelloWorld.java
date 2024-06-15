import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class HelloWorld {

	private JFrame frame;
	private JTextField textField;
	public static String word;
	public static char first;
	public static char last;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorld window = new HelloWorld();
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
	public HelloWorld() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("NEW FRAME FOR STRINGS");
		frame.getContentPane().setBackground(new Color(255, 255, 128));
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter your string:");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 78, 149, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(0, 128, 0));
		lblNewLabel_1.setBackground(new Color(255, 128, 64));
		lblNewLabel_1.setBounds(347, 79, 86, 14);
		lblNewLabel_1.setText(" ");
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setForeground(new Color(255, 128, 64));
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField.setEnabled(true);
		textField.setBounds(192, 76, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Click here to swap the first and last characters of your word");
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnNewButton.setForeground(new Color(0, 100, 0));
		btnNewButton.setBackground(new Color(255, 99, 71));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				word = textField.getText();
				first = (word.charAt(0));
				last = word.charAt(word.length()-1);
				lblNewLabel_1.setText(last + word.substring (1, (word.length()-1)) + first);
								
			}
		});
		
		btnNewButton.setBounds(80, 131, 383, 46);
		frame.getContentPane().add(btnNewButton);
		
		
		
	}
}
