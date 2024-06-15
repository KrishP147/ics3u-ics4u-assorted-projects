import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements KeyListener {

	JLabel label;
	JLabel label2;
	ImageIcon icon;
	ImageIcon icon2;

	MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000, 1000);
		this.setLayout(null);
		this.addKeyListener(this);

		icon = new ImageIcon("cow.jpg");
		icon2 = new ImageIcon("lion.jpg");

		label = new JLabel();
		label.setBounds(0, 0, 202, 267);
		label.setIcon(icon);
		label2 = new JLabel();
		label2.setBounds(300, 0, 202, 267);
		label2.setIcon(icon2);
		// label.setBackground(Color.red);
		// label.setOpaque(true);
		this.getContentPane().setBackground(Color.black);
		this.add(label);
		this.add(label2);
		this.setVisible(true);
		this.setResizable(false);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// keyTyped = Invoked when a key is typed. Uses KeyChar, char output

		switch (e.getKeyChar()) {
		case 'a':
			label2.setLocation(label2.getX() - 10, label2.getY());
			break;
		case 'w':
			label2.setLocation(label2.getX(), label2.getY() - 10);
			break;
		case 's':
			label2.setLocation(label2.getX(), label2.getY() + 10);
			break;
		case 'd':
			label2.setLocation(label2.getX() + 10, label2.getY());
			break;
		}
		switch (label2.getX()) {
		case -1:
			label2.setLocation(0, label2.getY());
			break;
		case 1001:
			label2.setLocation(1000, label2.getY());
			break;
		}
		switch (label2.getY()) {
		case -1:
			label2.setLocation(label2.getX(), 0);
			break;
		case 1001:
			label2.setLocation(label2.getX(), 1000);
			break;
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// keyPressed = Invoked when a physical key is pressed down. Uses KeyCode, int
		// output
		switch (e.getKeyCode()) {
		case 37:
			label.setLocation(label.getX() - 10, label.getY());
			break;
		case 38:
			label.setLocation(label.getX(), label.getY() - 10);
			break;
		case 39:
			label.setLocation(label.getX() + 10, label.getY());
			break;
		case 40:
			label.setLocation(label.getX(), label.getY() + 10);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// keyReleased = called whenever a button is released
		System.out.println("You released key char: " + e.getKeyChar());
		System.out.println("You released key code: " + e.getKeyCode());
	}
}