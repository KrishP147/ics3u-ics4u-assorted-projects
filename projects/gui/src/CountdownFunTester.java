import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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

public class CountdownFunTester extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField inputField;
	private JLabel countdownLabel;
	private JPanel countdownPanel;
	private Timer countdownTimer;
	private boolean isFastForward = false;

	public CountdownFunTester() {
		// Setup JFrame
		getContentPane().setLayout(null);
		setSize(900, 400);
		setTitle("Countdown Timer");
		getContentPane().setBackground(Color.BLACK);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Keypad panel
		JPanel keypadPanel = new JPanel();
		keypadPanel.setBounds(20, 20, 200, 300);
		keypadPanel.setBackground(Color.RED);
		keypadPanel.setLayout(null);
		getContentPane().add(keypadPanel);

		// TextField at the top
		inputField = new JTextField();
		inputField.setBounds(20, 10, 160, 30);
		keypadPanel.add(inputField);

		// Manually adding buttons to the keypad
		addButton(keypadPanel, "1", 15, 50, true);
		addButton(keypadPanel, "2", 75, 50, true);
		addButton(keypadPanel, "3", 135, 50, true);
		addButton(keypadPanel, "4", 15, 110, true);
		addButton(keypadPanel, "5", 75, 110, true);
		addButton(keypadPanel, "6", 135, 110, true);
		addButton(keypadPanel, "7", 15, 170, true);
		addButton(keypadPanel, "8", 75, 170, true);
		addButton(keypadPanel, "9", 135, 170, true);
		addButton(keypadPanel, "0", 75, 230, true);
		addButton(keypadPanel, "Etr", 135, 230, false);
		addButton(keypadPanel, "Del", 15, 230, false);

		// Panel for countdown display
		countdownPanel = new JPanel();
		countdownPanel.setBounds(281, 20, 400, 300);
		countdownPanel.setBackground(Color.YELLOW);
		countdownPanel.setLayout(null);
		getContentPane().add(countdownPanel);

		countdownLabel = new JLabel("", SwingConstants.CENTER);
		countdownLabel.setFont(new Font("Serif", Font.BOLD, 120));
		countdownLabel.setForeground(Color.BLUE);
		countdownLabel.setBounds(50, 50, 300, 200); // Manually positioning countdownLabel
		countdownPanel.add(countdownLabel);

		JPanel newpanel = new JPanel();
		newpanel.setLayout(null);
		newpanel.setBackground(Color.BLACK);
		newpanel.setBounds(693, 20, 181, 300);
		getContentPane().add(newpanel);

		// Fast forward button
		JButton fastForwardButton = new JButton(">>");

		fastForwardButton.setBounds(43, 157, 100, 100);
		fastForwardButton.setFont(new Font("Arial", Font.BOLD, 40));
		fastForwardButton.setBackground(Color.LIGHT_GRAY);
		fastForwardButton.setForeground(Color.BLACK);
		newpanel.add(fastForwardButton);

		// Reset button
		JButton resetButton = new JButton("Reset");
		resetButton.setBounds(43, 96, 100, 50);
		resetButton.setFont(new Font("Arial", Font.BOLD, 20));
		resetButton.setBackground(Color.GREEN);
		resetButton.setForeground(Color.BLACK);
		resetButton.addActionListener(e -> resetFrame());
		newpanel.add(resetButton);

		// Action listeners
		inputField.addActionListener(e -> startCountdown());

		setVisible(true);
	}

	private void addButton(JPanel panel, String text, int x, int y, boolean num) {
		JButton button = new JButton(text);
		styleButton(button, x, y, 50, 50, num);
		button.addActionListener(e -> {
			if (text.equals("Etr")) { // Changed from "Enter"
				startCountdown();
			} else if (text.equals("Del")) { // Changed from "Backspace"
				String currentText = inputField.getText();
				if (currentText.length() > 0) {
					inputField.setText(currentText.substring(0, currentText.length() - 1));
				}
			} else {
				inputField.setText(inputField.getText() + text);
			}
		});
		panel.add(button);
	}

	private void styleButton(JButton button, int x, int y, int width, int height, boolean num) {

		int size;

		button.setBounds(x, y, width, height);
		button.setBackground(Color.DARK_GRAY);
		button.setForeground(Color.GREEN);

		if (num)
			size = 20;
		else
			size = 10;

		button.setFont(new Font("Arial", Font.BOLD, size));
		button.setFocusable(false);
	}

	private void startCountdown() {
		try {
			int count = Integer.parseInt(inputField.getText());
			if (countdownTimer != null) {
				countdownTimer.stop();
			}
			countdown(count);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Please enter a valid number", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void countdown(int number) {
		if (number < 0)
			return;

		setCountdownLabelText(String.valueOf(number));

		if (number == 0) {
			showBlastOff();
		} else {
			int delay;
			if (isFastForward) {
				delay = (int) Math.max(1, (1000 / Math.max(1, number / 5.0)));
			} else {
				delay = 1000;
			}
			countdownTimer = new Timer(delay, e -> {
				toggleCountdownColor();
				countdown(number - 1);
			});
			countdownTimer.setRepeats(false);
			countdownTimer.start();
		}
	}

	private void toggleCountdownColor() {
		if (countdownPanel.getBackground() == Color.YELLOW) {
			countdownPanel.setBackground(Color.BLUE);
			countdownLabel.setForeground(Color.YELLOW);
		} else {
			countdownPanel.setBackground(Color.YELLOW);
			countdownLabel.setForeground(Color.BLUE);
		}
	}

	private void setCountdownLabelText(String text) {
		countdownLabel.setText(text);
		int textLength = text.length();
		if (textLength <= 2) {
			countdownLabel.setFont(new Font("Serif", Font.BOLD, 120));
		} else if (textLength <= 4) {
			countdownLabel.setFont(new Font("Serif", Font.BOLD, 100));
		} else if (textLength <= 6) {
			countdownLabel.setFont(new Font("Serif", Font.BOLD, 80));
		} else {
			countdownLabel.setFont(new Font("Serif", Font.BOLD, 60));
		}
	}

	private void showBlastOff() {
		JFrame blastOffFrame = new JFrame("Blast Off!");
		blastOffFrame.setSize(600, 400);
		blastOffFrame.setLocationRelativeTo(null);
		blastOffFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		blastOffFrame.getContentPane().setBackground(Color.BLACK);

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.BLACK);
		blastOffFrame.getContentPane().add(panel);

		JLabel blastOffLabel = new JLabel("Blast Off!", SwingConstants.CENTER);
		blastOffLabel.setFont(new Font("Serif", Font.BOLD, 60));
		blastOffLabel.setForeground(Color.RED);
		panel.add(blastOffLabel, BorderLayout.NORTH);

		// Simulating a video with an icon (since embedding a video is complex)
		JLabel videoLabel = new JLabel(new ImageIcon("rocket.gif")); // Ensure rocket.gif is in your project directory
		panel.add(videoLabel, BorderLayout.CENTER);

		blastOffFrame.setVisible(true);

		blastOffFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				resetFrame();
			}
		});
	}

	private void resetFrame() {
		inputField.setText("");
		countdownLabel.setText("");
		countdownPanel.setBackground(Color.YELLOW);
		countdownLabel.setForeground(Color.BLUE);
		if (countdownTimer != null) {
			countdownTimer.stop();
		}
	}

	public static void main(String[] args) {
		new CountdownFunTester();
	}
}
