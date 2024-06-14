/* This program creates a JFrame object to calculate
* the sum and product of two numbers, inputted by the user through two JTextFields.
* This program uses JButtons and JRadioButtons in combination with Action Listeners
* to perform actions in accordance with user input.
* Author: Krish Punjabi
* Date May 31 2024
*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddandMultiply extends JFrame implements ActionListener {
	public AddandMultiply() {
	} // all variables & methods are inherited from JFrame

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton addButton;
	private JButton multiplyButton;
	private JRadioButton yesButton;
	private JRadioButton noButton;
	private JTextField tField1;
	private JTextField tField2;

	public AddandMultiply(int width, int height, String title, Color color) { // class constructor
		getContentPane().setLayout(null); // absolute positioning; no layout manager
		setSize(width, height); // set the JFrame size
		setTitle(title); // set the JFrame title
		getContentPane().setBackground(color); // background color
		setLocationRelativeTo(null); // centers the JFrame on the screen
		setDefaultCloseOperation(EXIT_ON_CLOSE); // exit the program when closing the JFrame
	}

	public void showGUI() { // Very important method which makes your JFrame visible!
		setVisible(true);
	}

	// adds JPanel to the JFrame
	public void addJPanel(int xPos, int yPos, int width, int height, Color color) {
		panel = new JPanel();
		panel.setBounds(xPos, yPos, width, height);
		panel.setBackground(color);
		panel.setLayout(null);
		getContentPane().add(panel);
	}

	// adds JLabel to the JPanel
	public void addJLabel(int xPos, int yPos, int width, int height, String message, Color color) {
		JLabel label = new JLabel(message);
		label.setForeground(color);
		label.setBounds(xPos, yPos, width, height);
		panel.add(label);
	}

	// adds JTextField to the JPanel
	public void addJTextField(int xPos, int yPos, int width, int height, String message, Color color) {
		JTextField tField = new JTextField(message);
		tField.setBackground(color);
		tField.setBounds(xPos, yPos, width, height);
		panel.add(tField);

		if (message.equals("Number1")) // assigning specific textfields based on message - number1 textfield is
										// assigned as textfield1
			tField1 = tField;
		else
			tField2 = tField;
	}

	// adds JButton to the JPanel
	public void addJButton(int xPos, int yPos, int width, int height, String message) {
		JButton button = new JButton(message);
		button.setBounds(xPos, yPos, width, height);
		button.addActionListener(this);
		panel.add(button);

		if (message.equals("Add")) // assigning buttons to variables
			addButton = button;
		else
			multiplyButton = button;
	}

	// adds JRadioButton to the JPanel
	public void addJRadioButton(int xPos, int yPos, int width, int height, String message, Color color) {
		JRadioButton rButton = new JRadioButton(message);
		rButton.setBounds(xPos, yPos, width, height);
		rButton.addActionListener(this);
		rButton.setBackground(color); // Set background color
		panel.add(rButton);

		if (message.equals("YES")) // assigning the two radio buttons
			yesButton = rButton;
		else
			noButton = rButton;
	}

	@Override
	public void actionPerformed(ActionEvent e) { // the action to be performed upon a click

		if (e.getSource() == addButton) {
			performOperation('+', addButton); // performs the adding operation

		} else if (e.getSource() == multiplyButton) {
			performOperation('*', multiplyButton); // performs the multiplying operation

		} else if (e.getSource() == yesButton) { // manually resets and repaints frame - textfields, buttons, etc

			tField1.setText(""); // textfields reset
			tField2.setText("");

			addButton.setText("Add"); // add button reset, re-enabled
			addButton.setEnabled(true);

			multiplyButton.setText("Multiply"); // multiply button reset, re-enabled
			multiplyButton.setEnabled(true);

			yesButton.setSelected(false); // deselecting the yes button for reuse
			repaint();

		} else if (e.getSource() == noButton) { // closes program
			System.exit(0);
		}
	}

	// performs addition or multiplication based on user input
	public void performOperation(char operator, JButton button) {
		double result = 0;
		double n1 = 0;
		double n2 = 0;
		try { // gets input
			n1 = Double.parseDouble(tField1.getText());
			n2 = Double.parseDouble(tField2.getText());
		} catch (NumberFormatException ex) { // if input doesn't work, catches exception and sends error message on
												// button text
			button.setText("Please enter valid numbers.");
			return; // tries the input again - alternative to while loop
		}

		if (operator == '+') {
			result = n1 + n2; // addition operation
		} else {
			result = n1 * n2; // multiplication operation
		}

		button.setText("Result: " + formatNum(result)); // updates button text with result (depending on which button is
														// chosen)
		button.setEnabled(false); // disabled after 1 use to introduce continue functionality to reset
	}

	// formats the result to one decimal place
	public String formatNum(double num) {
		DecimalFormat df = new DecimalFormat("0.0");
		return df.format(num);
	}

	public static void main(String[] args) {
		AddandMultiply g = new AddandMultiply(800, 400, "ADDITION and MULTIPLICATION PRACTICE", Color.GRAY);
		g.addJPanel(30, 30, 700, 300, Color.YELLOW);
		g.addJLabel(300, 10, 200, 30, "Let's do some MATH!", Color.BLUE);
		g.addJLabel(10, 70, 200, 30, "Number1", Color.BLUE);
		g.addJTextField(10, 90, 200, 30, "Number1", Color.MAGENTA); // tField1, for n1
		g.addJLabel(10, 170, 200, 30, "Number2", Color.BLUE);
		g.addJTextField(10, 190, 200, 30, "Number2", Color.MAGENTA); // tField2, for n2
		g.addJButton(250, 120, 200, 30, "Add"); // addButton, for addition operation
		g.addJButton(250, 160, 200, 30, "Multiply"); // multiplyButton, for multiplication operation
		g.addJLabel(530, 115, 200, 30, "CONTINUE?", Color.BLUE);
		g.addJRadioButton(500, 140, 70, 30, "YES", Color.GREEN); // yesButton, to reset frame
		g.addJRadioButton(580, 140, 70, 30, "NO", Color.GREEN); // noButton, to terminate program
		g.showGUI(); // displays GUI to user, important
	}
}
