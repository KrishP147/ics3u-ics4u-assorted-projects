/* This program uses an OOP, and GUI based approach in combination with 
* recursive methods to run a countdown from a specified number to 0.
* This program is very cool.
* Author: Krish Punjabi
* Date: June 6 2024
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class FUNDOWN extends JFrame implements ActionListener {
	public static final long serialVersionUID = 1L;
	public int startingNumber;
	public JLabel countdownLabel;
	public JButton fastFwdButton;
	public JPanel countdownPanel;
	public JPanel rightPanel;
	public Timer countdownTimer;
	public boolean isFastForward = false;

	public FUNDOWN(int width, int height, String title, Color color, int startingNumber) {
		// Setup JFrame
		getContentPane().setLayout(null);
		setSize(width, height);
		setTitle(title);
		getContentPane().setBackground(color);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		this.startingNumber = startingNumber;
	}

	public void showGUI() { // Very important method which makes your JFrame visible!
		setVisible(true);
	}

	// getters and setters
	public int getStartingNumber() {
		return startingNumber;
	}

	public JLabel getCountdownLabel() {
		return countdownLabel;
	}

	public JButton getFastFwdButton() {
		return fastFwdButton;
	}

	public JPanel getCountdownPanel() {
		return countdownPanel;
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

	public void setCountdownLabel(JLabel countdownLabel) {
		this.countdownLabel = countdownLabel;
	}

	public void setFastFwdButton(JButton fastFwdButton) {
		this.fastFwdButton = fastFwdButton;
	}

	public void setCountdownPanel(JPanel countdownPanel) {
		this.countdownPanel = countdownPanel;
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

	public void startCountdown() { // method to validate the starting number of the countdown before starting the
									// recursive method
		try {
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

	public void showBlastOff() {
		// Clear all existing components
		getContentPane().removeAll();
		revalidate();
		repaint();

		// Add panel for blastoff text and GIF
		JPanel blastOffPanel = addJPanel(new JPanel(), 0, 0, getWidth(), getHeight(), Color.BLACK);
		JLabel blastOffLabel = addJLabel(blastOffPanel, 0, 100, getWidth(), 100, "Blastoff", Color.RED, "Serif",
				Font.BOLD, 60);

		// Add blastoff GIF
		ImageIcon blastOffIcon = new ImageIcon("blastoff.gif");
		JLabel blastOffGifLabel = new JLabel(blastOffIcon);
		blastOffGifLabel.setBounds(0, 200, getWidth(), getHeight() - 200); // Adjust position and size as needed
		blastOffPanel.add(blastOffLabel);
		blastOffPanel.add(blastOffGifLabel);

		// Refresh the frame
		getContentPane().add(blastOffPanel);
		revalidate();
		repaint();
	}

	public void setupCountdownPanel() { // sets central countdown panel
		setCountdownPanel(addJPanel(getCountdownPanel(), 50, 30, 400, 300, Color.YELLOW)); // panel is set
		setCountdownLabel(addJLabel(getCountdownPanel(), 50, 50, 300, 200, "", Color.BLUE, "Serif", Font.BOLD, 120)); // number
																														// label
																														// is
																														// set
	}

	public void setupRightPanel() { // sets rightward panel with fastfwd button and reset button
		setRightPanel(addJPanel(getRightPanel(), 423, 0, 181, 300, Color.BLACK)); // sets panel
		setFastFwdButton(addJButton(getFastFwdButton(), getRightPanel(), 100, 100, 43, 157, ">>", "Arial", Font.BOLD,
				Color.LIGHT_GRAY, Color.BLACK, 40)); // sets fastfwd button
		addFastFwdMouseListener();// adds mouse listener to fastfwd button
	}

	public static void main(String[] args) {
		final int WIDTH = 600;
		final int HEIGHT = 400;

		FUNDOWN c = new FUNDOWN(WIDTH, HEIGHT, "Countdown Timer", Color.BLACK, 15); // an instance of countdown is
		// created

		c.setupCountdownPanel();
		c.setupRightPanel();

		c.showGUI(); // frame is shown
		c.startCountdown();

		// countdown + recursion only starts once user has first entered input, and has
		// submitted their starting number
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
