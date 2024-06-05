/* This program uses an OOP, and GUI based approach in combination with 
* recursive methods to run a countdown from a specified number to 0.
* This program is very cool.
* Author: Krish Punjabi
* Date: June 6 2024
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class CountdownGUI extends JFrame implements ActionListener {
	public static final long serialVersionUID = 1L;
	public int startingNumber;
	public JTextField inputField;
	public JLabel countdownLabel;
	public JButton button;
	public JButton[] buttons = new JButton[12];
	public JButton fastFwdButton;
	public JButton resetButton;
	public JPanel countdownPanel;
	public JPanel keypadPanel;
	public JPanel rightPanel;
	public Timer countdownTimer;
	public boolean isFastForward = false;

	public CountdownGUI(int width, int height, String title, Color color) {
		// Setup JFrame
		getContentPane().setLayout(null);
		setSize(width, height);
		setTitle(title);
		getContentPane().setBackground(color);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}

	public void showGUI() { // Very important method which makes your JFrame visible!
		setVisible(true);
	}

	// getters and setters
	public int getStartingNumber() {
		return startingNumber;
	}

	public JTextField getInputField() {
		return inputField;
	}

	public JLabel getCountdownLabel() {
		return countdownLabel;
	}

	public JButton getButton() {
		return button;
	}

	public JButton[] getButtons() {
		return buttons;
	}

	public JButton getFastFwdButton() {
		return fastFwdButton;
	}

	public JButton getResetButton() {
		return resetButton;
	}

	public JPanel getCountdownPanel() {
		return countdownPanel;
	}

	public JPanel getKeypadPanel() {
		return keypadPanel;
	}

	public JPanel getRightPanel() {
		return rightPanel;
	}

	public Timer getCountdownTimer() {
		return countdownTimer;
	}

	public boolean isFastForward() {
		return isFastForward;
	}

	public void setStartingNumber(int startingNumber) {
		this.startingNumber = startingNumber;
	}

	public void setInputField(JTextField inputField) {
		this.inputField = inputField;
	}

	public void setCountdownLabel(JLabel countdownLabel) {
		this.countdownLabel = countdownLabel;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}

	public void setFastFwdButton(JButton fastFwdButton) {
		this.fastFwdButton = fastFwdButton;
	}

	public void setResetButton(JButton resetButton) {
		this.resetButton = resetButton;
	}

	public void setCountdownPanel(JPanel countdownPanel) {
		this.countdownPanel = countdownPanel;
	}

	public void setKeypadPanel(JPanel keypadPanel) {
		this.keypadPanel = keypadPanel;
	}

	public void setRightPanel(JPanel rightPanel) {
		this.rightPanel = rightPanel;
	}

	public void setCountdownTimer(Timer countdownTimer) {
		this.countdownTimer = countdownTimer;
	}

	public void setFastForward(boolean isFastForward) {
		this.isFastForward = isFastForward;
	}

	// adds JPanel to the JFrame
	public JPanel addJPanel(JPanel panel, int xPos, int yPos, int width, int height, Color color) {
		panel = new JPanel();
		panel.setBounds(xPos, yPos, width, height);
		panel.setBackground(color);
		panel.setLayout(null);
		getContentPane().add(panel);

		return panel;
	}

	// adds JLabel to the JPanel
	public JLabel addJLabel(JPanel panel, int xPos, int yPos, int width, int height, String message, Color color,
			String font, int fontStyle, int fontSize) {

		JLabel label = new JLabel(message, SwingConstants.CENTER); // Set horizontal alignment to CENTER);
		label.setFont(new Font(font, fontStyle, fontSize));
		label.setForeground(color);
		label.setBounds(xPos, yPos, width, height);
		panel.add(label); // add it to the panel

		return label;
	}

	// adds JTextField to the JPanel
	public JTextField addJTextField(JTextField tField, JPanel panel, int xPos, int yPos, int width, int height,
			String message, Color color) {
		tField = new JTextField(message);
		tField.setBackground(color);
		tField.setBounds(xPos, yPos, width, height);
		tField.addActionListener(this);
		panel.add(tField);

		return tField;
	}

	// adds JButton to the JPanel
	public JButton addJButton(JButton button, JPanel panel, int width, int height, int xPos, int yPos, String message,
			String font, int style, Color colorb, Color colorf, int fontSize) {
		button = new JButton(message);
		button.setBounds(xPos, yPos, width, height);
		button.setBackground(colorb);
		button.setForeground(colorf);
		button.setFont(new Font(font, style, fontSize));
		button.addActionListener(this);
		panel.add(button);

		return button;
	}

	// method to add mouse listeners to the fast forward button, which works on
	// holding it down
	public void addFastFwdMouseListener() {
		getFastFwdButton().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				setFastForward(true); // simply updating a boolean value to indicate whether or not to perform the
										// fast
										// forward function
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				setFastForward(false);
			}
		});
	}

	public JButton[] addKeypadButtons(JButton[] buttons, JPanel panel, int x1, int x2, int x3, int y1, int y2, int y3,
			int y4, int width, int height, String font, int style, Color colorb, Color colorf, int fontSize) {

		// method to manually set the positions, and other details of the keypad buttons
		// stored in an array for simplicity + organization
		buttons[1] = addJButton(getButton(), panel, width, height, x1, y1, "1", font, style, colorb, colorf, fontSize);
		buttons[2] = addJButton(getButton(), panel, width, height, x2, y1, "2", font, style, colorb, colorf, fontSize);
		buttons[3] = addJButton(getButton(), panel, width, height, x3, y1, "3", font, style, colorb, colorf, fontSize);
		buttons[4] = addJButton(getButton(), panel, width, height, x1, y2, "4", font, style, colorb, colorf, fontSize);
		buttons[5] = addJButton(getButton(), panel, width, height, x2, y2, "5", font, style, colorb, colorf, fontSize);
		buttons[6] = addJButton(getButton(), panel, width, height, x3, y2, "6", font, style, colorb, colorf, fontSize);
		buttons[7] = addJButton(getButton(), panel, width, height, x1, y3, "7", font, style, colorb, colorf, fontSize);
		buttons[8] = addJButton(getButton(), panel, width, height, x2, y3, "8", font, style, colorb, colorf, fontSize);
		buttons[9] = addJButton(getButton(), panel, width, height, x3, y3, "9", font, style, colorb, colorf, fontSize);
		buttons[0] = addJButton(getButton(), panel, width, height, x2, y4, "0", font, style, colorb, colorf, fontSize);
		buttons[10] = addJButton(getButton(), panel, width, height, x3, y4, "Etr", font, style, colorb, colorf,
				fontSize / 2);
		buttons[11] = addJButton(getButton(), panel, width, height, x1, y4, "Del", font, style, colorb, colorf,
				fontSize / 2);
		// the del and etr buttons need to have smaller text to fit each character on
		// the button, therefore the font size is divided by 2

		return buttons;
	}

	@Override
	public void actionPerformed(ActionEvent e) { // the action to be performed upon a click

		checkKeypad(e); // will check which key is being pressed
		if (e.getSource() == getResetButton()) { // on click, the reset button will run the reset method, resetting
													// frame
			// manually - textfields, buttons, etc
			resetFrame();

		} else if (e.getSource() == getInputField()) { // will start the countdown if there is input from the textfield
														// - //
														// keys like enter, if pressed will trigger this
			startCountdown();

		}
	}

	public void checkKeypad(ActionEvent e) { // method to iterate through the keypad button array, determining the
												// action based on which button is pressed
		for (int i = 0; i < getButtons().length; i++) {
			if (e.getSource() == getButtons()[i]) {
				if (getButtons()[i].getText().equals("Etr")) {
					startCountdown(); // if etr (enter) button is pressed, countdown starts
				} else if (getButtons()[i].getText().equals("Del")) { // if del button is pressed, one character is
																		// deleted
					String currentText = getInputField().getText();
					if (currentText.length() > 0) { // only possible if length of present string is greater than 0
						getInputField().setText(currentText.substring(0, currentText.length() - 1)); // a substring is
																										// taken
						// and set
					}
				} else {
					getInputField().setText(getInputField().getText() + getButtons()[i].getText()); // otherwise, if
																									// clicked, the
					// buttons text is set on to the
					// textfield
				}
			}
		}
	}

	public void startCountdown() { // method to validate the starting number of the countdown before starting the
									// recursive method
		try {
			setStartingNumber(Integer.parseInt(getInputField().getText())); // sets starting number, getting textfield
																			// input
			if (getCountdownTimer() != null) { // timer is stopped, reset with new input immediately, so that countdown
												// doesn't run multiple timers at once. very important
				getCountdownTimer().stop();
			}
			countdown(); // recursive method is run
		} catch (NumberFormatException e) {// exception handling for characters that aren't integers
			JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void countdown() { // this is the recursive method in this program!
		// this method performs the countdown, and continues to call itself until the
		// base case is achieved - the countdown reaches 0, and the blastoff frame is
		// created
		int n = getStartingNumber(); // starting number is stored in a variable for easy reusability

		setCountdownLabelText(String.valueOf(n)); // the text on the countdown label is set to match the value of the
													// starting number

		if (n <= 0) { // base case, this frame is shown once the countdown reaches zero
			showBlastOff();
		} else { // now, while the countdown is still going on, this is what will happen
			int delay;
			if (isFastForward()) { // this is true only is the fast forward button is being held.
				delay = (1000 / getStartingNumber()); // if fast forward button is held, then the delay between the
														// updating of
				// each countdown update is equal to the reciprocal of the number - for
				// example, if the count down is from 8000, fast forward will decrease
				// the updating speed to 1000/8000 - 1/8000 of a second
			} else {
				delay = 1000; // otherwise, delay is equal to 1000 milliseconds (one second)
			}
			setCountdownTimer(new Timer(delay, e -> {// countdown causes the delay, which causes the counter to run
														// again
														// - one big recursive sequence
				toggleCountdownColor(); // colour swap
				setStartingNumber(getStartingNumber() - 1); // number is decremented
				countdown(); // recursive call, after number has been updated, method is rerun
			}));

			getCountdownTimer().setRepeats(false); // timer is set to only decrement once - the repetetion function
													// built
													// into the timer is not used, instead, recursion is used
			getCountdownTimer().start(); // restarting the timer
		}
	}

	public void toggleCountdownColor() { // this method simply swaps the colour every time the countdown label is
											// updated
		if (getCountdownPanel().getBackground() == Color.YELLOW) { // if the background colour is yellowm and this
																	// method is
																	// called, will switch background to blue and
																	// foreground
																	// to yellow
			getCountdownPanel().setBackground(Color.BLUE);
			getCountdownLabel().setForeground(Color.YELLOW);
		} else { // else, the opposite is done
			getCountdownPanel().setBackground(Color.YELLOW);
			getCountdownLabel().setForeground(Color.BLUE);
		}
	}

	public void setCountdownLabelText(String text) { // method to set the text in the countdown, dependent on length of
														// number
		getCountdownLabel().setText(text); // text is set
		int textLength = text.length(); // length is saved
		if (textLength <= 2) { // depending on length (number of digits), size of text is chosen. longer number
								// = smaller font, to fit each digit on the screen
			getCountdownLabel().setFont(new Font("Serif", Font.BOLD, 120));
		} else if (textLength <= 4) {
			getCountdownLabel().setFont(new Font("Serif", Font.BOLD, 100));
		} else if (textLength <= 6) {
			getCountdownLabel().setFont(new Font("Serif", Font.BOLD, 80));
		} else {
			getCountdownLabel().setFont(new Font("Serif", Font.BOLD, 60));
		}
	}

	public void showBlastOff() { // method to create the blastoff frame at the end, almost like the main for this
									// separate blast off object

		final int WIDTH = 600;
		final int HEIGHT = 400;

		BlastOff b = new BlastOff(WIDTH, HEIGHT, "Blast Off!", Color.BLACK, new BorderLayout()); // object is created,
																									// inherits from
																									// Countdown, except
																									// it uses border
																									// layout

		b.addPanel(new BorderLayout(), Color.BLACK);
		b.addWindowListener(new WindowAdapter() { // this special listener is added so that when the blast off window is
													// closed, the frame behind it resets

			@Override
			public void windowClosed(WindowEvent e) {
				resetFrame();
			}
		});
		b.addJLabel("Blast Off!", SwingConstants.CENTER, "Serif", Font.BOLD, 60, Color.RED, BorderLayout.NORTH); // adding
																													// text
																													// label
		b.addJLabel(new ImageIcon("rocket.gif"), BorderLayout.CENTER); // adding imae label

		b.showGUI(); // gui is shown, inherited method from countdown

	}

	public void resetFrame() { // simple method to reset the frame by manually resetting components
		getInputField().setText("");
		getCountdownLabel().setText("");
		getCountdownPanel().setBackground(Color.YELLOW);
		getCountdownLabel().setForeground(Color.BLUE);

		if (getCountdownTimer() != null) { // will effectively reset the timer as well
			getCountdownTimer().stop();
		}
	}

	public void setupKeypadPanel() { // method to set up the keypad panel
		// important to exclusively set panels separately as it is important for this
		// program to constantly use specific instances of each component, multiple
		// times
		setKeypadPanel(addJPanel(getKeypadPanel(), 20, 20, 200, 300, Color.RED)); // setting the kaypad panel
		setInputField(addJTextField(inputField, getKeypadPanel(), 20, 10, 160, 30, "", Color.WHITE)); // setting its
																										// textfield
		setButtons(addKeypadButtons(buttons, getKeypadPanel(), 15, 75, 135, 50, 110, 170, 230, 50, 50, "Arial", // setting
																												// the
																												// individual
																												// keypad
																												// buttons
																												// in an
																												// array
				Font.BOLD, Color.DARK_GRAY, Color.GREEN, 20));
	}

	public void setupCountdownPanel() { // sets central countdown panel
		setCountdownPanel(addJPanel(getCountdownPanel(), 281, 20, 400, 300, Color.YELLOW)); // panel is set
		setCountdownLabel(addJLabel(getCountdownPanel(), 50, 50, 300, 200, "", Color.BLUE, "Serif", Font.BOLD, 120)); // number
																														// label
																														// is
																														// set
	}

	public void setupRightPanel() { // sets rightward panel with fastfwd button and reset button
		setRightPanel(addJPanel(getRightPanel(), 693, 20, 181, 300, Color.BLACK)); // sets panel
		setFastFwdButton(addJButton(getFastFwdButton(), getRightPanel(), 100, 100, 43, 157, ">>", "Arial", Font.BOLD,
				Color.LIGHT_GRAY, Color.BLACK, 40)); // sets fastfwd button
		addFastFwdMouseListener();// adds mouse listener to fastfwd button
		setResetButton(addJButton(getResetButton(), getRightPanel(), 100, 50, 43, 96, "Reset", "Arial", Font.BOLD,
				Color.GREEN, Color.BLACK, 20)); // sets reset button
	}

	public static void main(String[] args) {
		final int WIDTH = 900;
		final int HEIGHT = 400;

		CountdownGUI c = new CountdownGUI(WIDTH, HEIGHT, "Countdown Timer", Color.BLACK); // an instance of countdown is
																							// created

		// panels are set up
		c.setupKeypadPanel();
		c.setupCountdownPanel();
		c.setupRightPanel();

		c.showGUI(); // frame is shown

		// countdown + recursion only starts once user has first entered input, and has
		// submitted their starting number
	}

}

class BlastOff extends CountdownGUI { // separate class to handle the creation of the blast off frame - the base case.
	// this frame inherits from countdown, as it shares much in common with it.

	private static final long serialVersionUID = 1L;
	JPanel panel;

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public BlastOff(int width, int height, String title, Color color, BorderLayout layout) {
		super(width, height, title, color);

		getContentPane().setLayout(layout); // using border layout for this frame
		setResizable(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // so that the program doesn't terminate when this frame is
															// closed
	}

	public void addPanel(BorderLayout layout, Color color) { // override, adding a panel with significantly less
																// parameters due to the usage of border layout
		setPanel(new JPanel());
		getPanel().setLayout(layout);
		getPanel().setBackground(color);
		setPanel(getPanel());
		getContentPane().add(getPanel());

	}

	public void addJLabel(String title, int pos, String font, int fontStyle, int fontSize, Color color,
			String location) { // override, adding a label with significantly less
		// parameters due to the usage of border layout
		JLabel blastOffLabel = new JLabel(title, pos);
		blastOffLabel.setFont(new Font(font, fontStyle, fontSize));
		blastOffLabel.setForeground(color);
		getPanel().add(blastOffLabel, location);
	}

	public void addJLabel(ImageIcon imageIcon, String location) { // another override, polymorphism, using a label to
																	// display an image
		JLabel videoLabel = new JLabel(imageIcon);
		getPanel().add(videoLabel, location);
	}

}