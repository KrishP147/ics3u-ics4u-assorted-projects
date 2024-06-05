
/* This program uses an OOP, and GUI based approach in combination with 
* recursive methods to run factorial, fibonacci and prime number functions.
* Author: Krish Punjabi
* Date: June 10 2024
*/
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MathwithRecursion extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private String[] operationType;
	private JButton[] buttons;
	private JTextField[] tFields;
	private JButton activeButton;
	private JTextField activeTextField;
	private JRadioButton yesButton;
	private JRadioButton noButton;
	private long startingNumber;

	public MathwithRecursion(int width, int height, String title, Color color, int numOfButtons) {
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
		this.tFields = new JTextField[numOfButtons];
		this.operationType = new String[numOfButtons];
	}

	// getters and setters

	public long getNumber() {
		return startingNumber;
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

	public JTextField getActiveTextField() {
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

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setOperationType(String[] operationType) {
		this.operationType = operationType;
	}

	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}

	public void settFields(JTextField[] tFields) {
		this.tFields = tFields;
	}

	public void setActiveButton(JButton activeButton) {
		this.activeButton = activeButton;
	}

	public void setActiveTextField(JTextField activeTextField) {
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
		tFields[index] = tField;
	}

	// Adds JButton to the JPanel
	public void addJButton(int index, int xPos, int yPos, int width, int height, String message) {
		JButton button = new JButton(message);
		button.setBounds(xPos, yPos, width, height);
		button.addActionListener(this);
		getPanel().add(button);
		buttons[index] = button;
		operationType[index] = message;
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
		for (int i = 0; i < getButtons().length; i++) {
			if (e.getSource() == (getButtons()[i])) { // if the source is one of the three buttons from the array
				setActiveButton(getButtons()[i]); // this button is set as the active button
				setActiveTextField(gettFields()[i]); // similarily, the corresponding textfield is taken
				performOperation(getOperationType()[i]); // the corresponding operation is performed
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
		for (int i = 0; i < getButtons().length; i++) {
			getButtons()[i].setText(getOperationType()[i]); // button text is simply reset
			gettFields()[i].setText(""); // tfield text is simply reset
		}

		getYesButton().setSelected(false); // yes button is unclicked
		repaint();
	}

	// performs operation based on user input
	public void performOperation(String operationType) {
		String result = "";
		int n;
		try {
			n = Integer.parseInt(getActiveTextField().getText()); // gets active textfields text
		} catch (NumberFormatException ex) {
			getActiveButton().setText("Please enter a valid integer."); // error message
			return;
		}

		setNumber(n); // starting number is updated
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
		MathwithRecursion m = new MathwithRecursion(900, 400, "RECURSION PRACTICE", Color.GRAY, 3);

		// Adding JPanel
		m.addJPanel(0, 0, 884, 361, Color.LIGHT_GRAY);

		// Adding JLabels
		m.addJLabel(389, 25, 100, 30, "--- NUMBERS ---", Color.BLUE);
		m.addJLabel(10, 78, 345, 30, "Enter a number and click the button to find the factorial:", Color.BLUE);
		m.addJLabel(10, 168, 428, 30, "Enter a number and click the button to determine if it is a prime number:",
				Color.BLUE);
		m.addJLabel(742, 167, 77, 30, "CONTINUE?", Color.BLUE);
		m.addJLabel(10, 258, 397, 30, "Enter a number and click the button for the Fibonacci sequence:", Color.BLUE);

		// Adding JTextFields
		m.addJTextField(0, 20, 107, 128, 30, "", Color.MAGENTA);
		m.addJTextField(1, 20, 197, 128, 30, "", Color.MAGENTA);
		m.addJTextField(2, 20, 287, 128, 30, "", Color.MAGENTA);

		// Adding JButtons
		m.addJButton(0, 180, 107, 461, 30, "FACTORIAL");
		m.addJButton(1, 180, 197, 461, 30, "PRIME NUMBER?");
		m.addJButton(2, 180, 287, 461, 30, "FIBONACCI");

		// Adding JRadioButtons
		m.addJRadioButton(697, 197, 70, 30, "YES", Color.GREEN);
		m.addJRadioButton(777, 197, 70, 30, "NO", Color.GREEN);

		// Display GUI
		m.showGUI();
	}
}
