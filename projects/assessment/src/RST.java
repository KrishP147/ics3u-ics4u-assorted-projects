
//to do - sounds, methods for three new recursions (basic) + action listeners, methods for judges), 
/* This program uses an OOP, and GUI based approach in combination with 
* recursive methods to run factorial, fibonacci and prime number functions.
* Author: Krish Punjabi
* Date: June 10 2024
*/
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class RST extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private String[] operationType;
	private JButton[] buttons;
	private JTextField[] tFields;
	private JButton activeButton;
	private JTextField[] activeTextField;
	private JRadioButton yesButton;
	private JRadioButton noButton;
	private long startingNumber;
	private long numberTwo;

	public RST(int width, int height, String title, Color color, int numOfButtons) {
		// JFrame settings
		getContentPane().setLayout(null);
		setSize(width, height);
		setTitle(title);
		getContentPane().setBackground(color);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// initializing button, textfield and string arrays with info for the three
		// functions
		this.buttons = new JButton[numOfButtons];
		this.tFields = new JTextField[numOfButtons - 1];
		this.operationType = new String[numOfButtons];

	}

	// getters and setters

	public long getNumber() {
		return startingNumber;
	}

	public long getNumberTwo() {
		return numberTwo;
	}

	public JPanel getPanel() {
		return panel;
	}

	public String[] getOperationType() {
		return operationType;
	}

	public JButton[] getButtons() {
		return buttons;
	}

	public JTextField[] gettFields() {
		return tFields;
	}

	public JButton getActiveButton() {
		return activeButton;
	}

	public JTextField[] getActiveTextField() {
		return activeTextField;
	}

	public JRadioButton getYesButton() {
		return yesButton;
	}

	public JRadioButton getNoButton() {
		return noButton;
	}

	public void setNumber(int startingNumber) {
		this.startingNumber = startingNumber;
	}

	public void setNumberTwo(int numberTwo) {
		this.numberTwo = numberTwo;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setOperationType(String[] operationType) {
		this.operationType = operationType;
	}

	public void setOperationType(int index, String operationType) {
		this.operationType[index] = operationType;
	}

	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}

	public void setButtons(int index, JButton button) {
		this.buttons[index] = button;
	}

	public void settFields(JTextField[] tFields) {
		this.tFields = tFields;
	}

	public void settFields(int index, JTextField tField) {
		this.tFields[index] = tField;
	}

	public void setActiveButton(JButton activeButton) {
		this.activeButton = activeButton;
	}

	public void setActiveTextField(JTextField[] activeTextField) {
		this.activeTextField = activeTextField;
	}

	public void setYesButton(JRadioButton yesButton) {
		this.yesButton = yesButton;
	}

	public void setNoButton(JRadioButton noButton) {
		this.noButton = noButton;
	}

	public void showGUI() {
		setVisible(true);
	}

	// Adds JPanel to the JFrame
	public void addJPanel(int xPos, int yPos, int width, int height, Color color) {
		setPanel(new JPanel());
		getPanel().setBounds(xPos, yPos, width, height);
		getPanel().setBackground(color);
		getPanel().setLayout(null);
		getContentPane().add(panel);
	}

	// Adds JLabel to the JPanel
	public void addJLabel(int xPos, int yPos, int width, int height, String message, Color color) {
		JLabel label = new JLabel(message);
		label.setForeground(color);
		label.setBounds(xPos, yPos, width, height);
		getPanel().add(label);
	}

	// Adds JTextField to the JPanel
	public void addJTextField(int index, int xPos, int yPos, int width, int height, String message, Color color) {
		JTextField tField = new JTextField(message);
		tField.setBackground(color);
		tField.setBounds(xPos, yPos, width, height);
		getPanel().add(tField);
		settFields(index, tField);
	}

	// Adds JButton to the JPanel
	public void addJButton(int index, int xPos, int yPos, int width, int height, String message) {
		JButton button = new JButton(message);
		button.setBounds(xPos, yPos, width, height);
		button.addActionListener(this);
		getPanel().add(button);
		setButtons(index, button);
		setOperationType(index, message);
	}

	// Adds JButton to the JPanel
	public void addJButton(int index, int xPos, int yPos, int width, int height, String message, Color colorb,
			Color colorf, String icon, int gap) {
		JButton button = new JButton(message);
		button.setBounds(xPos, yPos, width, height);
		button.setBackground(colorb);
		button.setForeground(colorf);
		button.setIcon(new ImageIcon(icon));
		button.setVerticalTextPosition(SwingConstants.BOTTOM);
		button.setHorizontalTextPosition(SwingConstants.CENTER);
		button.addActionListener(this);
		getPanel().add(button);
		setButtons(index, button);
		setOperationType(index, message);
	}

	// Adds JRadioButton to the JPanel
	public void addJRadioButton(int xPos, int yPos, int width, int height, String message, Color color) {
		JRadioButton rButton = new JRadioButton(message);
		rButton.setBounds(xPos, yPos, width, height);
		rButton.setBackground(color);
		rButton.addActionListener(this);
		getPanel().add(rButton);

		// Assigning yes or no button depending on message
		if (message.equals("YES")) {
			setYesButton(rButton);
		} else if (message.equals("NO")) {
			setNoButton(rButton);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JTextField[] tFields = new JTextField[2];

		// Handle operations for the first three buttons
		for (int i = 0, j = 0; i < gettFields().length - 4 && j < getButtons().length - 5; i++, j++) {
			if (e.getSource() == (getButtons()[j])) { // if the source is one of the three buttons from the array
				setActiveButton(getButtons()[j]); // this button is set as the active button
				tFields[0] = gettFields()[i];
				tFields[1] = gettFields()[i];
				setActiveTextField(tFields); // similarly, the corresponding text field is taken
				performOperation(getOperationType()[j]); // the corresponding operation is performed
				break;
			}
		}

		// Handle operations for the last three buttons with two text fields
		for (int i = gettFields().length - 4, j = getButtons().length - 5; i < gettFields().length
				&& j < getButtons().length - 3; i += 2, j++) {
			if (e.getSource() == (getButtons()[j])) { // if the source is one of the three buttons from the array
				setActiveButton(getButtons()[j]); // this button is set as the active button
				tFields[0] = gettFields()[i];
				tFields[1] = gettFields()[i + 1];
				setActiveTextField(tFields); // similarly, the corresponding text field is taken
				performOperation(getOperationType()[j]); // the corresponding operation is performed
				break;
			}
		}

		// Handle operations for the last three buttons with two text fields
		for (int i = getButtons().length - 3; i < getButtons().length; i++) {
			if (e.getSource() == (getButtons()[i])) { // if the source is one of the three buttons from the array
				setActiveButton(getButtons()[i]); // this button is set as the active button
				playReaction(getOperationType()[i]); // the corresponding operation is performed
				break;
			}
		}

		if (e.getSource() == getYesButton()) {
			getYesButton().setSelected(true);
			resetButtons(); // if yes is pressed, everything is reset
		} else if (e.getSource() == getNoButton()) {
			System.exit(0); // if no is pressed, program terminates

		}
	}

	public void resetButtons() {
		// Reset all buttons
		for (int i = 0; i < getButtons().length; i++) {
			getButtons()[i].setText(getOperationType()[i]); // button text is simply reset
		}

		// Reset all text fields
		for (int j = 0; j < gettFields().length; j++) {
			gettFields()[j].setText(""); // tfield text is simply reset
		}

		getYesButton().setSelected(false); // yes button is unclicked
		repaint();
	}

	public void playReaction(String operationType) {
		try {
			getActiveTextField()[0].getText(); // gets active textfields text
		} catch (NullPointerException ex) {
			getActiveButton().setText("NOTHING TO JUDGE"); // error message
			return;
		}

		getActiveButton().setText("FANTASTIC");

	}

	// performs operation based on user input
	public void performOperation(String operationType) {
		String result = "";
		int n;
		int n2;
		try {
			n = Integer.parseInt(getActiveTextField()[0].getText()); // gets active textfields text
			n2 = Integer.parseInt(getActiveTextField()[1].getText()); // gets active textfields text
		} catch (NumberFormatException ex) {
			getActiveButton().setText("Please enter a valid integer."); // error message
			return;
		}

		setNumber(n); // starting number is updated
		setNumberTwo(n2);
		try {
			if (operationType.equals("FACTORIAL")) {
				result = "" + findFactorial(getNumber()); // runs method to find the factorial
				if (result.equals("-2")) // in the case that the factorial is larger than the largest long value, will
											// return -2
					result = "Result too large";
			} else if (operationType.equals("PRIME NUMBER?")) { // method to check if a number is prime. the square root
																// is taken because mathematically, from the smallest
																// possible factor to the largest, if you find no
																// factors before getting to the square root, there is
																// no need to look further (smaller factor * larger
																// factor, the hypothetical larger factor would need to
																// multiply by a smaller already checked factor
				result = isPrime(getNumber(), (int) Math.sqrt(getNumber()));
			} else if (operationType.equals("FIBONACCI")) {
				result = findFibonacci(getNumber(), 0, 1); // runs fibonacci method. first parameter is number of terms,
				// next two are starting numbers, always 0 1
			} else if (operationType.equals("COUNTDOWN")) {
				result = findCountdown(getNumber());
			} else if (operationType.equals("EXPONENT")) {
				result = findExponent(getNumber(), getNumberTwo());
			} else if (operationType.equals("MULTIPLY")) {
				result = findMultiplication(getNumber(), getNumberTwo());
			}
		} catch (StackOverflowError e) { // will only really be the case for fibonacci, as length of fibonacci can cause
											// stack overflow
			result = "Out of memory space";
		}

		if (getActiveButton().getFontMetrics(getActiveButton().getFont()).stringWidth(result) > getActiveButton()
				.getWidth()) {
			getActiveButton().setText("View Console"); // if, for any button, the text on the button doesn't fit, will
														// print to console (mainly fibonacci)
			System.out.println(result);
		} else {
			getActiveButton().setText(result); // otherwise, button text shows result
		}
	}

	private String findMultiplication(long n1, long n2) {
		// TODO Auto-generated method stub
		return ("" + (n1 * n2));
	}

	private String findExponent(long number, long number2) {
		// TODO Auto-generated method stub
		return ("" + Math.pow(number, number2));
	}

	private String findCountdown(long number) {
		// TODO Auto-generated method stub
		return ("count" + number);
	}

	public long findFactorial(long l) {
		long factorial = 1;

		if (l < 0)
			return -1; // undef for neg numbers
		if (l == 0)
			return 1; // base case or termination condition

		factorial = l * findFactorial(l - 1); // recursive call, multiplying by next number (going down)

		if (factorial < 0) // when the factorial is actually greater than the max long value, will return a
							// random negative number
			return -2;

		return factorial; // return statement
	}

	public String isPrime(long l, int divisor) {
		if (l <= 1)
			return "NOT A PRIME NUMBER"; // 1 and numbers less than 1 are not prime
		if (divisor == 1)
			return "IS A PRIME NUMBER"; // base case, when divisor reaches 1, it's prime
		if (l % divisor == 0)
			return "NOT A PRIME NUMBER"; // if the number is divisible by the divisor, it's not prime
		return isPrime(l, divisor - 1); // recursively check the next divisor
	}

	public String findFibonacci(long n, long a, long b) {
		String fibonacci = "";

		if (n <= 0)
			return ""; // Base case, when n is less than or equal to 0, return empty string
		long c = a + b; // Calculate the next Fibonacci number
		if (c <= 0) // if result is too large (larger than max long), will return a random negative
					// number, andling that case
			return fibonacci + "Values too large to continue...";

		fibonacci = a + " " + findFibonacci(n - 1, b, c); // recursive call

		return fibonacci; // return the sequence
	}

	public static void main(String[] args) {
		RST m = new RST(900, 900, "RECURSION PRACTICE", Color.LIGHT_GRAY, 9);

		// Adding JPanel
		m.addJPanel(0, 0, 884, 861, Color.LIGHT_GRAY);

		// Adding JLabels
		m.addJLabel(301, 11, 329, 40, "WELCOME TO THE RECURSION ASSESSMENT!", Color.BLUE);
		m.addJLabel(10, 50, 345, 30, "Enter a number and click the button to find the factorial:", Color.BLUE);
		m.addJLabel(10, 121, 428, 30, "Enter a number and click the button to determine if it is a prime number:",
				Color.BLUE);
		m.addJLabel(10, 192, 397, 30, "Enter a number and click the button for the Fibonacci sequence:", Color.BLUE);
		m.addJLabel(10, 263, 397, 30, "Enter a number and click the button for a countdown:", Color.BLUE);
		m.addJLabel(10, 334, 507, 30,
				"Enter a number as the base,  and as the exponent, then click the button for their result:",
				Color.BLUE);
		m.addJLabel(10, 405, 507, 30, "Enter 2 numbers and click the button for their product:", Color.BLUE);

		m.addJLabel(742, 167, 77, 30, "CONTINUE?", Color.BLUE);
		m.addJLabel(275, 496, 397, 30, "CLICK ON THE JUDGE PANEL TO CHECK THEIR IMPRESSIONS!", Color.BLUE);

		// Adding JTextFields
		m.addJTextField(0, 20, 75, 128, 30, "", Color.MAGENTA);
		m.addJTextField(1, 20, 147, 128, 30, "", Color.MAGENTA);
		m.addJTextField(2, 20, 219, 128, 30, "", Color.MAGENTA);
		m.addJTextField(3, 20, 291, 128, 30, "", Color.MAGENTA);
		m.addJTextField(4, 20, 364, 62, 30, "", Color.MAGENTA);
		m.addJTextField(5, 86, 364, 62, 30, "", Color.MAGENTA);
		m.addJTextField(6, 20, 435, 62, 30, "", Color.MAGENTA);
		m.addJTextField(7, 86, 435, 62, 30, "", Color.MAGENTA);

		// Adding JButtons
		m.addJButton(0, 180, 75, 461, 30, "FACTORIAL");
		m.addJButton(1, 180, 147, 461, 30, "PRIME NUMBER?");
		m.addJButton(2, 180, 219, 461, 30, "FIBONACCI");
		m.addJButton(3, 180, 291, 461, 30, "COUNTDOWN");
		m.addJButton(4, 180, 364, 461, 30, "EXPONENT");
		m.addJButton(5, 180, 435, 461, 30, "MULTIPLY");

		// Adding JRadioButtons
		m.addJRadioButton(697, 197, 70, 30, "YES", Color.GREEN);
		m.addJRadioButton(777, 197, 70, 30, "NO", Color.GREEN);

		// Adding Judges
		m.addJButton(6, 57, 548, 202, 267, "JUDGE TIGER", Color.BLUE, Color.MAGENTA, "tiger.jpg", 6);
		m.addJButton(7, 337, 548, 202, 267, "JUDGE LION", Color.BLUE, Color.MAGENTA, "lion.jpg", 5);
		m.addJButton(8, 617, 548, 202, 267, "JUDGE HORSE", Color.BLUE, Color.MAGENTA, "horse.jpg", 10);

		// Display GUI
		m.showGUI();
	}
}
