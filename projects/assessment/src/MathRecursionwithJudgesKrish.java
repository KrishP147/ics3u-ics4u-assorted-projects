
/* This program uses an OOP, and GUI based approach in combination with 
* recursive methods to run factorial, fibonacci, prime number,
* exponential, multiplication and countdown functions.
* Author: Krish Punjabi
* Date: June 13 2024
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

public class MathRecursionwithJudgesKrish extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel panel; // this is the panel to store the buttons, textfields and labels regarding the
							// operations.
	private JScrollPane scrollPane; // this is the scroll pane that the judge panel is added to
	private JPanel judgePanel; // this is the judge panel; the lower panel containing all the judges (buttons)
								// and some labels
	private String[] operationType; // string array to store the operation type for each button
	private JButton[] buttons; // this is an array that will store all the jbuttons that are in this program
	private JTextField[] tFields; // array for all tfields
	private JButton activeButton; // the active button, the one that is currently being interacted with
	private JTextField[] activeTextField; // corresponding active textfields, array since some buttons can have 2
											// corresponding textfields
	private JRadioButton yesButton; // JRadio buttons to reset frame
	private JRadioButton noButton; // JRadio button to terminate program
	private long numberOne; // long to store the input of the operations
	private long numberTwo; // long to store the second input number, for exponent and multiplication
							// operations

	public MathRecursionwithJudgesKrish(int width, int height, String title, Color color, int numOfButtons,
			int numOfTextFields) {
		// JFrame constructor
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

	public long getNumberOne() {
		return numberOne;
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

	public void setNumberOne(long numberOne) {
		this.numberOne = numberOne;
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

	public void setOperationType(int index, String operationType) { // additional setter method, to set specific
																	// elements in the operation type array. will
																	// require the index and the individiual String to
																	// store as an element.
		this.operationType[index] = operationType;
	}

	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}

	public void setButtons(int index, JButton button) { // additional setter method, to set specific
														// elements in the buttons array. will
														// require the index and the individiual JButton to
														// store as an element.
		this.buttons[index] = button;
	}

	public void settFields(JTextField[] tFields) {
		this.tFields = tFields;
	}

	public void settFields(int index, JTextField tField) { // additional setter method, to set specific
															// elements in the textfield array. will
															// require the index and the individiual JTextField to
															// store as an element.
		this.tFields[index] = tField;
	}

	public void setActiveButton(JButton activeButton) {
		this.activeButton = activeButton;
	}

	public void setActiveTextField(JTextField[] activeTextField) {
		this.activeTextField = activeTextField;
	}

	public void setActiveTextField(int index, JTextField activeTextField) {// additional setter method, to set specific
																			// elements in the active textfield array.
																			// will
																			// require the index and the individiual
																			// JTextField to
																			// store as an element.
		this.activeTextField[index] = activeTextField;
	}

	public void setYesButton(JRadioButton yesButton) {
		this.yesButton = yesButton;
	}

	public void setNoButton(JRadioButton noButton) {
		this.noButton = noButton;
	}

	public void showGUI() { // Important method to make the GUI visible!
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
	// Polymorphic method, used to create a scrollable panel by setting the size
	// using new Dimension
	public void addJPanel(int width, int height, Color color) {
		setJudgePanel(new JPanel());
		getJudgePanel().setPreferredSize(new Dimension(width, height));
		getJudgePanel().setBackground(color);
		getJudgePanel().setLayout(null);
		getScrollPane().setViewportView(getJudgePanel()); // Add judgePanel to scrollPane
	}

	// Adds ScrollPane to the main JPanel
	public void addScrollPane(int xPos, int yPos, int width, int height, Color color) {
		setScrollPane(new JScrollPane());
		getScrollPane().setBounds(xPos, yPos, width, height);
		getScrollPane().setBackground(color);
		getScrollPane().setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // yes horizontal
																								// scrolling
		getScrollPane().setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // no vertical scrolling
		getPanel().add(getScrollPane());
	}

	// Adds JLabel to the JPanel
	public void addJLabel(boolean judge, int xPos, int yPos, int width, int height, String message, Color color) {
		JLabel label = new JLabel(message);
		label.setForeground(color);
		label.setBounds(xPos, yPos, width, height);

		if (judge) // if the label is intended to be on the judge panel, this variable will be true
			getJudgePanel().add(label);
		else
			getPanel().add(label); // otherwise, will just add to main (upper) panel
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
	// Polymorphic and intended for judge buttons, adding imageicons, and an integer
	// for the gap between image and text
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
	public void addJRadioButton(int xPos, int yPos, int width, int height, String text, Color color) {
		JRadioButton rButton = new JRadioButton(text);
		rButton.setBounds(xPos, yPos, width, height);
		rButton.setBackground(color);
		rButton.addActionListener(this);
		getPanel().add(rButton);

		// Assigning yes or no button depending on text
		if (text.equals("YES")) {
			setYesButton(rButton);
		} else if (text.equals("NO")) {
			setNoButton(rButton);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { // action performed method

		// Handling operations for the first 4 buttons and text fields - these buttons
		// all have one corresponding textfield
		// gettFields().length returns 8, and getButtons().length returns 16
		// gettFields().length - 4 returns 4, and getButtons().length - 12 returns 4
		for (int i = 0, j = 0; i < gettFields().length - 4 && j < getButtons().length - 12; i++, j++) {
			if (e.getSource() == (getButtons()[j])) { // if the source is one of the three four buttons from the array
				setActiveButton(getButtons()[j]); // this button is set as the active button
				setActiveTextField(new JTextField[2]); // active TField array is set
				setActiveTextField(0, gettFields()[i]); // for this method, only one active textfield needs to be set.
														// the corresponding tfield (same i) is set
				setActiveTextField(1, gettFields()[i]); // need to enter a non-null value here, simply duplicating value
														// at index 0
				performOperation(getOperationType()[j]); // the corresponding operation is performed
				break;
			}
		}

		// Handle operations for the last two buttons with two text fields
		// gettFields().length - 4 returns 4, and getButtons().length - 12 returns 4
		// gettFields().length returns 8, and getButtons().length - 10 returns 6
		for (int i = gettFields().length - 4, j = getButtons().length - 12; i < gettFields().length
				&& j < getButtons().length - 10; i += 2, j++) { // using two integers here because the numbers for
																// textfields and buttons dont line up - textfield at
																// index 4 and 5 correspond with button at 4, textfield
																// at index 6 and 7 correspond with button at 5
			if (e.getSource() == (getButtons()[j])) { // if the source is one of the two possible buttons from the array
				setActiveButton(getButtons()[j]); // this button is set as the active button
				setActiveTextField(new JTextField[2]); // active TField array is set
				setActiveTextField(0, gettFields()[i]); // the first active textfield is set
				setActiveTextField(1, gettFields()[i + 1]); // the second active textfield is set, one ahead of the
															// first
				performOperation(getOperationType()[j]); // the corresponding operation is performed
				break;
			}
		}

		// Handle operations for the two buttons with no text fields, the random and
		// info buttons
		// getButtons().length - 10 returns 6, and getButtons().length - 8 returns 8
		for (int i = getButtons().length - 10; i < getButtons().length - 8; i++) {
			if (e.getSource() == (getButtons()[i])) { // if the source is one of the two buttons from the array
				resetGUI(); // gui is reset, and active textfields are set to null(inside method)
				setActiveButton(getButtons()[i]); // this button is set as the active button
				performOperation(getOperationType()[i]); // the corresponding operation is performed
				break;
			}
		}
		// Handle operations for the eight judge buttons with no text fields
		// getButtons().length - 8 returns 8, and getButtons().length returns 16
		for (int i = getButtons().length - 8; i < getButtons().length; i++) {
			if (e.getSource() == (getButtons()[i])) { // if the source is one of the eight buttons from the array
				setActiveButton(getButtons()[i]); // this button is set as the active button
				playReaction(getOperationType()[i]); // perform corresponding operation
			}
		}

		if (e.getSource() == getYesButton()) {
			getYesButton().setSelected(true);
			resetGUI(); // if yes is pressed, everything is reset
		} else if (e.getSource() == getNoButton()) {
			goodBye(); // if no is pressed, program terminates
		}
	}

	public void resetGUI() { // method to reset gui - if continue is pressed, etc.

		setActiveTextField(null); // textfields are set to null - no active textfield
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

	public void playReaction(String operationType) { // method to play specific sounds, or "reactions" for judge buttons
		File file = null;
		String message = "";
		AudioInputStream audioStream;
		Clip clip; // file and clip initialization

		try {
			getActiveTextField()[0].getText(); // gets active textfield's text
		} catch (NullPointerException ex) {
			getActiveButton().setText("NOTHING TO JUDGE"); // error message
			return;
		}

		switch (operationType) { // setting appropriate message and sound file depending on operation type
		case "JUDGE LION":
			message = "PURRFECTION!";
			file = new File("Meow.wav");
			break;
		case "JUDGE TIGER":
			message = "ROARSOME!";
			file = new File("TigerRoar.wav");
			break;
		case "JUDGE HORSE":
			message = "HOOF-TASTIC!";
			file = new File("HorseWhinnyExcited.wav");
			break;
		case "JUDGE BEAR":
			message = "UN-BEAR-LIVEABLE!";
			file = new File("BearGrowl.wav");
			break;
		case "JUDGE COW":
			message = "A-MOO-ZING!";
			file = new File("CowMoo.wav");
			break;
		case "JUDGE ELEPHANT":
			message = "ELE-FANTASTIC!";
			file = new File("ElephantTrumpet.wav");
			break;
		case "JUDGE DOLPHIN":
			message = "FIN-TASTIC!";
			file = new File("DolphinClicks.wav");
			break;
		case "JUDGE OTTER":
			message = "OTTER THIS WORLD!";
			file = new File("OtterSqueal.wav");
			break;
		default:
			message = "Invalid Judge";
			file = new File(".wav");
			break;
		}

		getActiveButton().setText(message); // the clicked button has its text set

		try { // will attempt to play file
			audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start(); // Start audio playback
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) { // in case file is not
																								// found, etc.
			JOptionPane.showMessageDialog(null, "Error playing clip: " + e.getMessage());
		}
	}

	public void performOperation(String operationType) { // method to perform the recursion operations
		String result = "";
		long n;
		long n2;
		try { // will validate input - must be of type Long
			n = Long.parseLong(getActiveTextField()[0].getText()); // gets active text fields text
			n2 = Long.parseLong(getActiveTextField()[1].getText()); // gets active text fields text
			// needs to not be null, or will not work - that is why in actionperformed for
			// buttons with one active textfield, the second index also needs to be set to
			// something that is not null

			if (n < 0 || (n2 < 0 && operationType != "EXPONENT")) { // negative numbers not allowed, unless they are the
																	// exponent
				getActiveButton().setText("Negative numbers not allowed."); // error message
				return;
			}

		} catch (NumberFormatException ex) {
			getActiveButton().setText("Please enter a valid \"long\" value."); // error message
			setActiveTextField(null); // active textfield deactivated when input is invalid
			return;
		} catch (NullPointerException ex) { // if active textfields are null, n and n2 are irrelevant, this means the
											// buttons have no textfields
			n = 0;
			n2 = 0;
		}

		setNumberOne(n); // starting number is updated
		setNumberTwo(n2); // second number is updated

		try { // switch case to run methods for operations based on operation type
			switch (operationType) {
			case "FACTORIAL":
				result = "" + findFactorial(getNumberOne()); // runs method to find the factorial
				break;
			case "PRIME NUMBER?":
				result = isPrime(getNumberOne(), (int) Math.sqrt(getNumberOne()));// method to check if a number is
																					// prime.
				// the square root is taken because
				// mathematically, from the
				// smallest possible factor to the
				// largest, if you find no factors before
				// getting to the square root, there is
				// no need to look further (smaller factor *
				// larger
				// factor, the hypothetical larger factor
				// would need to
				// multiply by a smaller already checked
				// factor
				break;
			case "FIBONACCI":
				result = findFibonacci(getNumberOne(), 0, 1); // runs fibonacci method. first parameter is number of
																// terms,
																// next two are starting numbers, always 0 1
				break;
			case "COUNTDOWN":
				result = findCountdown(getNumberOne()); // runs countdown method
				break;
			case "EXPONENT":
				result = findExponent(getNumberOne(), getNumberTwo()); // runs exponentiation method, needs two
																		// numbers
				// (base and exponent)
				break;
			case "MULTIPLY":
				result = "" + findMultiplication(getNumberOne(), getNumberTwo()); // runs multiplication method needs
																					// two
				// numbers (multiplying two numbers)
				break;
			case "RANDOM":
				for (int j = 0; j < gettFields().length; j++) { // picks random numbers from 1 to 100 for each textfield
					gettFields()[j].setText("" + ((int) (Math.random() * 100) + 1));
				}
				result = "RANDOM"; // result text to be displlayed on random button, stays the same
				break;
			case "INFO":
				programDescription(); // opens program description pane
				result = "INFO"; // result text reset
				break;
			default:
				result = "Invalid operation";
				break;
			}

		} catch (StackOverflowError | Exception e) { // if there is a stack overflow or any other kind of exception with
														// recursion, will print this message
			result = "Out of memory space";
		}

		if (result.equals("-1") || result.equals("1 / -1")) // in the case that long overflow occurs - going to negative
															// numbers than the largest long value, will return -1
			result = "Result too large/small";

		if (getActiveButton().getFontMetrics(getActiveButton().getFont()).stringWidth(result) > getActiveButton()
				.getWidth()) {
			getActiveButton().setText("View Console"); // if, for any button, the text on the button doesn't fit
			System.out.println(result); // print to console (fibonacci or countdown)
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
		return n1 + findMultiplication(n1, n2 - 1);
		// Multiplication is simply repeated addition - breaking it down into this form
		// through recursion
	}

	public String findExponent(long base, long n) {
		String exponent = "";

		if (n == 0) {
			return "1"; // Base case: any number raised to the power of 0 is 1
		} else if (n == 1) {
			return Long.toString(base); // Base case: any number raised to the power of 1 is itself
		} else if (n < 0) {
			return "1 / " + findExponent(base, -n); // Handle negative exponent
		}

		exponent = "" + base * (Long.valueOf(findExponent(base, n - 1)));
		// Exponentation is simply repeated multiplication - breaking it down into this
		// form through recursion
		if (Long.valueOf(exponent) < 0) // when the factorial is actually greater than the max long value, will return a
			// random negative number
			return "-1"; // signal to send out error message in perform operation method

		return exponent;
	}

	public String findCountdown(long number) {

		if (number <= 0) {
			return "0!"; // Base case: if number is zero or negative, return an empty string
		} else {
			return number + " " + findCountdown(number - 1);
			// will simply keep printing the next number, decrementing by 1
		}
	}

	public long findFactorial(long l) {
		long factorial = 1;

		if (l == 0)
			return 1; // base case or termination condition

		factorial = l * findFactorial(l - 1); // recursive call, multiplying by next number (going down)

		if (factorial < 0) // when the factorial is actually greater than the max long value, will return a
							// random negative number
			return -1; // -1 is the signal that an error has occured

		return factorial; // return statement
	}

	public String isPrime(long l, int divisor) {
		if (l <= 1)
			return "NOT A PRIME NUMBER"; // 1 and numbers less than 1 are not prime
		if (divisor == 1)
			return "IS A PRIME NUMBER"; // base case, when divisor reaches 1, it's prime
		if (l % divisor == 0)
			return "IS A COMPOSITE NUMBER"; // if the number is divisible by the divisor, it's not prime (composite)
		return isPrime(l, divisor - 1); // recursively check the next divisor
	}

	public String findFibonacci(long n, long a, long b) {
		String fibonacci = "";

		if (n == 0)
			return ""; // Base case, when n is equal to 0, return empty string
		long c = a + b; // Calculate the next Fibonacci number
		if (c <= 0) // if result is too large (larger than max long), will return a random negative
					// number, handling that case
			return fibonacci + "Values too large to continue...";

		fibonacci = a + " " + findFibonacci(n - 1, b, c); // recursive call

		return fibonacci; // return the sequence
	}

	public void programDescription() { // program description method
		JOptionPane.showMessageDialog(null,
				"This project uses recursion to perform various operations.\nClick on a button to perform an operation.\nClick on a judge for a fun surprise!",
				"Math with Recursion and Judges", JOptionPane.INFORMATION_MESSAGE);
	}

	public void goodBye() { // this method displays a goodbye message to the user
		JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
		System.exit(0);// closes the program
	}

	public void addPanels() {
		// Method to add all JPanels
		addJPanel(0, 0, 884, 811, Color.LIGHT_GRAY);
		addScrollPane(0, 480, 884, 333, Color.GREEN);
		addJPanel(2200, 333, Color.GREEN);
	}

	public void addLabels() {
		// Method to add all JLabels
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

		// Judge Panel JLabels
		addJLabel(true, 265, 0, 397, 30, "CLICK ON THE JUDGE PANEL TO CHECK THEIR IMPRESSIONS!", Color.BLUE);
		addJLabel(true, 825, 0, 397, 30, "CLICK ON THE JUDGE PANEL TO CHECK THEIR IMPRESSIONS!", Color.BLUE);
		addJLabel(true, 1385, 0, 397, 30, "CLICK ON THE JUDGE PANEL TO CHECK THEIR IMPRESSIONS!", Color.BLUE);
	}

	public void addTextFields() {
		// Method to add all JTextFields
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
		// Method to add all JButtons

		// Adding Operation Buttons
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

		// Adding Judge Buttons
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
		final int NUM_OF_BUTTONS = 16; // number of buttons in the GUI, corresponds to array length
		final int NUM_OF_TEXTFIELDS = 8; // number of textfields in GUI, corresponds to array length

		MathRecursionwithJudgesKrish m = new MathRecursionwithJudgesKrish(LENGTH, WIDTH, TITLE, COLOR, NUM_OF_BUTTONS,
				NUM_OF_TEXTFIELDS);

		// Start with a program decription
		m.programDescription();

		// Adds various panels, labels, textfields and buttons
		m.addPanels();
		m.addLabels();
		m.addTextFields();
		m.addButtons();

		// GUI is made visible
		m.showGUI();
	}
}
