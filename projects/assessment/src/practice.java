
/* This program uses an OOP, and GUI based approach in combination with 
* recursive methods to run factorial, fibonacci and prime number functions.
* Author: Krish Punjabi
* Date: June 10 2024
*/
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class MathRecursionwithJudges extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JPanel judgePanel;
	private String[] operationType;
	private JButton[] buttons;
	private JTextField[] tFields;
	private JButton activeButton;
	private JTextField[] activeTextField;
	private JRadioButton yesButton;
	private JRadioButton noButton;
	private long startingNumber;
	private long numberTwo;

	public MathRecursionwithJudges(int width, int height, String title, Color color, int numOfButtons,
			int numOfTextFields) {
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
		this.tFields = new JTextField[numOfTextFields];
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

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JPanel getJudgePanel() {
		return judgePanel;
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

	public void setNumber(long startingNumber) {
		this.startingNumber = startingNumber;
	}

	public void setNumberTwo(long numberTwo) {
		this.numberTwo = numberTwo;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public void setJudgePanel(JPanel judgePanel) {
		this.judgePanel = judgePanel;
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
		getContentPane().add(getPanel());
	}

	// Adds JPanel to the JFrame
	public void addJPanel(int width, int height, Color color) {
		setJudgePanel(new JPanel());
		getJudgePanel().setPreferredSize(new Dimension(width, height));
		getJudgePanel().setBackground(color);
		getJudgePanel().setLayout(null);
		getScrollPane().setViewportView(getJudgePanel()); // Add judgePanel to scrollPane
	}

	// Adds JPanel to the JFrame
	public void addScrollPane(int xPos, int yPos, int width, int height, Color color) {
		setScrollPane(new JScrollPane());
		getScrollPane().setBounds(xPos, yPos, width, height);
		getScrollPane().setBackground(color);
		getScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		getPanel().add(getScrollPane());
	}

	// Adds JLabel to the JPanel
	public void addJLabel(boolean judge, int xPos, int yPos, int width, int height, String message, Color color) {
		JLabel label = new JLabel(message);
		label.setForeground(color);
		label.setBounds(xPos, yPos, width, height);

		if (judge)
			getJudgePanel().add(label);
		else
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
	public void addJButton(int index, int xPos, int yPos, int width, int height, String message, Color colorb,
			Color colorf) {
		JButton button = new JButton(message);
		button.setBounds(xPos, yPos, width, height);
		button.setBackground(colorb);
		button.setForeground(colorf);
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
		button.setIconTextGap(gap);
		getJudgePanel().add(button);
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
		for (int i = 0, j = 0; i < gettFields().length - 4 && j < getButtons().length - 12; i++, j++) {
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
		for (int i = gettFields().length - 4, j = getButtons().length - 12; i < gettFields().length
				&& j < getButtons().length - 10; i += 2, j++) {
			if (e.getSource() == (getButtons()[j])) { // if the source is one of the three buttons from the array
				setActiveButton(getButtons()[j]); // this button is set as the active button
				tFields[0] = gettFields()[i];
				tFields[1] = gettFields()[i + 1];
				setActiveTextField(tFields); // similarly, the corresponding text field is taken
				performOperation(getOperationType()[j]); // the corresponding operation is performed
				break;
			}
		}

		for (int i = getButtons().length - 10; i < getButtons().length - 8; i++) {
			if (e.getSource() == (getButtons()[i])) { // if the source is one of the three buttons from the array
				resetGUI();
				setActiveButton(getButtons()[i]); // this button is set as the active button
				performOperation(getOperationType()[i]); // the corresponding operation is performed
				break;
			}
		}
		// Handle operations for the last three buttons with two text fields
		for (int i = getButtons().length - 8; i < getButtons().length; i++) {
			if (e.getSource() == (getButtons()[i])) { // if the source is one of the three buttons from the array
				setActiveButton(getButtons()[i]); // this button is set as the active button
				playReaction(getOperationType()[i]);
			}
		}

		if (e.getSource() == getYesButton()) {
			getYesButton().setSelected(true);
			resetGUI(); // if yes is pressed, everything is reset
		} else if (e.getSource() == getNoButton()) {
			goodBye(); // if no is pressed, program terminates
		}
	}

	public void resetGUI() {

		setActiveTextField(null); // similarly, the corresponding text field is taken
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
		File file = null;
		String message = "";
		AudioInputStream audioStream;
		Clip clip;

		try {
			getActiveTextField()[0].getText(); // gets active textfield's text
		} catch (NullPointerException ex) {
			getActiveButton().setText("NOTHING TO JUDGE"); // error message
			return;
		}

		switch (operationType) {
		case "JUDGE LION":
			message = "PURRFECTION";
			file = new File("Meow.wav");
			break;
		case "JUDGE TIGER":
			message = "ROARSOME";
			file = new File("TigerRoar.wav");
			break;
		case "JUDGE HORSE":
			message = "HOOF-TASTIC";
			file = new File("HorseWhinnyExcited.wav");
			break;
		case "JUDGE BEAR":
			message = "UN-BEAR-LIVEABLE";
			file = new File("BearGrowl.wav");
			break;
		case "JUDGE COW":
			message = "A-MOO-ZING";
			file = new File("CowMoo.wav");
			break;
		case "JUDGE ELEPHANT":
			message = "ELE-FANTASTIC";
			file = new File("ElephantTrumpet.wav");
			break;
		case "JUDGE DOLPHIN":
			message = "FIN-TASTIC";
			file = new File("DolphinClicks.wav");
			break;
		case "JUDGE OTTER":
			message = "OTTER THIS WORLD";
			file = new File("OtterSqueal.wav");
			break;
		}

		getActiveButton().setText(message);

		try {
			audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start(); // Start audio playback
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			JOptionPane.showMessageDialog(null, "Error playing clip: " + e.getMessage());
		}
	}

	public void performOperation(String operationType) {
		String result = "";
		long n;
		long n2;
		try {
			n = Long.parseLong(getActiveTextField()[0].getText()); // gets active text fields text
			n2 = Long.parseLong(getActiveTextField()[1].getText()); // gets active text fields text

			if (n < 0 || (n2 < 0 && operationType != "EXPONENT")) {
				getActiveButton().setText("Negative numbers not allowed."); // error message
				return;
			}

		} catch (NumberFormatException ex) {
			getActiveButton().setText("Please enter a valid \"long\" value."); // error message
			return;
		} catch (NullPointerException ex) {
			n = 0;
			n2 = 0;
		}

		setNumber(n); // starting number is updated
		setNumberTwo(n2);

		try {
			switch (operationType) {
			case "FACTORIAL":
				result = "" + findFactorial(getNumber()); // runs method to find the factorial
				break;
			case "PRIME NUMBER?":
				result = isPrime(getNumber(), (int) Math.sqrt(getNumber())); // method to check if a number is prime
				break;
			case "FIBONACCI":
				result = findFibonacci(getNumber(), 0, 1); // runs Fibonacci method. first parameter is number of terms,
				break;
			case "COUNTDOWN":
				result = findCountdown(getNumber()); // runs countdown method
				break;
			case "EXPONENT":
				result = findExponent(getNumber(), getNumberTwo()); // runs exponentiation method
				break;
			case "MULTIPLY":
				result = "" + findMultiplication(getNumber(), getNumberTwo()); // runs multiplication method
				break;
			case "RANDOM":
				for (int j = 0; j < gettFields().length; j++) {
					gettFields()[j].setText("" + ((int) (Math.random() * 100) + 1));
				}
				result = "RANDOM";
				break;
			case "INFO":
				programDescription();
				result = "INFO";
				break;
			default:
				result = "Invalid operation";
				break;
			}

		} catch (StackOverflowError | Exception e) {
			result = "Out of memory space";
		}

		if (result.equals("-1") || result.equals("1 / -1")) // in the case that the factorial is larger than the
															// largest long value, will return -2
			result = "Result too large/small";

		if (getActiveButton().getFontMetrics(getActiveButton().getFont()).stringWidth(result) > getActiveButton()
				.getWidth()) {
			getActiveButton().setText("View Console"); // if, for any button, the text on the button doesn't fit, will
			System.out.println(result); // print to console (mainly Fibonacci)
		} else {
			getActiveButton().setText(result); // otherwise, button text shows result
		}
	}

	public long findMultiplication(long n1, long n2) {
		if (n1 == 0 || n2 == 0) {
			return 0; // Base case: anything multiplied by 0 is 0
		}
		if (n2 == 1) {
			return n1; // Base case: n1 multiplied by 1 is n1
		}
		if (n1 == 1) {
			return n2; // Base case: n2 multiplied by 1 is n2
		}
		return n1 + findMultiplication(n1, n2 - 1); // Recursive case: n1 + (n1 * (n2 - 1))
	}

	public String findExponent(long base, long n) {
		String exponent = "1";

		if (n == 0) {
			return "1"; // Base case: any number raised to the power of 0 is 1
		} else if (n == 1) {
			return Long.toString(base); // Base case: any number raised to the power of 1 is itself
		} else if (n < 0) {
			return "1 / " + findExponent(base, -n); // Handle negative exponent
		}

		exponent = "" + base * (Long.valueOf(findExponent(base, n - 1))); // Recursive case: base * (base ^ (exponent -
																			// 1))

		if (Long.valueOf(exponent) < 0) // when the factorial is actually greater than the max long value, will return a
			// random negative number
			return "-1";

		return exponent;
	}

	public String findCountdown(long number) {

		if (number <= 0) {
			return ""; // Base case: if number is zero or negative, return an empty string
		} else {
			return number + " " + findCountdown(number - 1); // Recursive case: "count" + number + " " +
																// countdown(number - 1)
		}
	}

	public long findFactorial(long l) {
		long factorial = 1;

		if (l == 0)
			return 1; // base case or termination condition

		factorial = l * findFactorial(l - 1); // recursive call, multiplying by next number (going down)

		if (factorial < 0) // when the factorial is actually greater than the max long value, will return a
							// random negative number
			return -1;

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

	public void programDescription() {
		JOptionPane.showMessageDialog(null,
				"This project uses recursion to perform various operations.\nClick on a button to perform an operation.\nClick on a judge for a fun surprise!",
				"Math with Recursion and Judges", JOptionPane.INFORMATION_MESSAGE);
	}

	public void goodBye() { // this method displays a goodbye message to the user
		JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
		System.exit(0);// closes the program
	}

	public void addPanels() {
		// Adding JPanel
		addJPanel(0, 0, 884, 811, Color.LIGHT_GRAY);
		addScrollPane(0, 480, 884, 333, Color.GREEN);
		addJPanel(2200, 333, Color.GREEN);
	}

	public void addLabels() {
		// Adding JLabels
		addJLabel(false, 301, 11, 329, 40, "WELCOME TO THE RECURSION ASSESSMENT!", Color.BLUE);
		addJLabel(false, 10, 50, 345, 30, "Enter a number and click the button to find the factorial:", Color.BLUE);
		addJLabel(false, 10, 121, 428, 30, "Enter a number and click the button to determine if it is a prime number:",
				Color.BLUE);
		addJLabel(false, 10, 192, 397, 30, "Enter a number and click the button for the Fibonacci sequence:",
				Color.BLUE);
		addJLabel(false, 10, 263, 397, 30, "Enter a number and click the button for a countdown:", Color.BLUE);
		addJLabel(false, 10, 334, 507, 30,
				"Enter a number as the base,  and as the exponent, then click the button for their result:",
				Color.BLUE);
		addJLabel(false, 10, 405, 507, 30, "Enter 2 numbers and click the button for their product:", Color.BLUE);

		addJLabel(false, 742, 187, 77, 30, "CONTINUE?", Color.BLUE);
		addJLabel(false, 695, 30, 215, 40, "GENERATE RANDOM INPUT?", Color.BLUE);
		addJLabel(false, 695, 332, 215, 40, "PROGRAM DESCRIPTION?", Color.BLUE);

		addJLabel(true, 265, 0, 397, 30, "CLICK ON THE JUDGE PANEL TO CHECK THEIR IMPRESSIONS!", Color.BLUE);
		addJLabel(true, 825, 0, 397, 30, "CLICK ON THE JUDGE PANEL TO CHECK THEIR IMPRESSIONS!", Color.BLUE);
		addJLabel(true, 1385, 0, 397, 30, "CLICK ON THE JUDGE PANEL TO CHECK THEIR IMPRESSIONS!", Color.BLUE);
	}

	public void addTextFields() {
		// Adding JTextFields
		addJTextField(0, 20, 75, 128, 30, "", Color.MAGENTA);
		addJTextField(1, 20, 147, 128, 30, "", Color.MAGENTA);
		addJTextField(2, 20, 219, 128, 30, "", Color.MAGENTA);
		addJTextField(3, 20, 291, 128, 30, "", Color.MAGENTA);
		addJTextField(4, 20, 364, 62, 30, "", Color.MAGENTA);
		addJTextField(5, 86, 364, 62, 30, "", Color.MAGENTA);
		addJTextField(6, 20, 435, 62, 30, "", Color.MAGENTA);
		addJTextField(7, 86, 435, 62, 30, "", Color.MAGENTA);
	}

	public void addButtons() {
		// Adding JButtons
		addJButton(0, 180, 75, 461, 30, "FACTORIAL", Color.RED, Color.BLACK);
		addJButton(1, 180, 147, 461, 30, "PRIME NUMBER?", Color.ORANGE, Color.BLACK);
		addJButton(2, 180, 219, 461, 30, "FIBONACCI", Color.YELLOW, Color.BLACK);
		addJButton(3, 180, 291, 461, 30, "COUNTDOWN", Color.GREEN, Color.BLACK);
		addJButton(4, 180, 364, 461, 30, "EXPONENT", Color.CYAN, Color.BLACK);
		addJButton(5, 180, 435, 461, 30, "MULTIPLY", Color.BLUE, Color.WHITE);
		addJButton(6, 722, 67, 97, 23, "RANDOM", Color.PINK, Color.BLACK);
		addJButton(7, 722, 370, 97, 23, "INFO", Color.MAGENTA, Color.BLACK);

		// Adding JRadioButtons
		addJRadioButton(697, 217, 70, 30, "YES", Color.GREEN);
		addJRadioButton(777, 217, 70, 30, "NO", Color.GREEN);

		addJButton(8, 57, 38, 202, 267, "JUDGE TIGER", Color.BLUE, Color.PINK, "tiger.jpg", 6);
		addJButton(9, 337, 38, 202, 267, "JUDGE LION", Color.BLUE, Color.PINK, "lion.jpg", 4);
		addJButton(10, 617, 38, 202, 267, "JUDGE HORSE", Color.BLUE, Color.PINK, "horse.jpg", 9);
		addJButton(11, 897, 38, 202, 267, "JUDGE BEAR", Color.BLUE, Color.PINK, "bear.jpg", 9);
		addJButton(12, 1177, 38, 202, 267, "JUDGE COW", Color.BLUE, Color.PINK, "cow.jpg", 6);
		addJButton(13, 1457, 38, 202, 267, "JUDGE ELEPHANT", Color.BLUE, Color.PINK, "elephant.jpg", 10);
		addJButton(14, 1737, 38, 202, 267, "JUDGE DOLPHIN", Color.BLUE, Color.PINK, "dolphin.jpg", 18);
		addJButton(15, 2017, 38, 202, 267, "JUDGE OTTER", Color.BLUE, Color.PINK, "otter.jpg", 26);
	}

	public static void main(String[] args) {
		final int WIDTH = 850;
		final int LENGTH = 900;
		final String TITLE = "RECURSION MathRecursionwithJudges";
		final Color COLOR = Color.LIGHT_GRAY;
		final int NUM_OF_BUTTONS = 16;
		final int NUM_OF_TEXTFIELDS = 8;

		MathRecursionwithJudges m = new MathRecursionwithJudges(LENGTH, WIDTH, TITLE, COLOR, NUM_OF_BUTTONS,
				NUM_OF_TEXTFIELDS);

		m.programDescription();
		m.addPanels();
		m.addLabels();
		m.addTextFields();
		m.addButtons();
		m.showGUI();
	}
}
