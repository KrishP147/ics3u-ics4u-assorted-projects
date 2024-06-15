import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MyPanel extends JPanel implements ActionListener {

	final int PANEL_WIDTH = 960;
	final int PANEL_HEIGHT = 540;
	Image enemy;
	// Image backgroundImage;
	Timer timer;
	int xVelocity = 3;
	int yVelocity = 2;
	int x = 0;
	int y = 0;
	Color colour = Color.GREEN;
	int rHeight = 150;
	int rWidth = 200;

	MyPanel() {
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.black);
		enemy = new ImageIcon("enemy.png").getImage();
		// backgroundImage = new ImageIcon("space.png").getImage();
		timer = new Timer(10, this);
		timer.start();
	}

	@Override
	public void paint(Graphics g) {

		super.paint(g); // paint background

		Graphics2D g2D = (Graphics2D) g;

		g2D.setPaint(colour);
		g2D.fillRect(x, y, rWidth, rHeight);
		// g2D.drawImage(backgroundImage, 0, 0, null);
		g2D.drawImage(enemy, x + (rWidth - 150) / 2, y + (rHeight - 90) / 2, null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (x >= PANEL_WIDTH - rWidth || x < 0) {
			xVelocity = xVelocity * -1;
			changeColour();
		}
		x += xVelocity;

		if (y >= PANEL_HEIGHT - rHeight || y < 0) {
			yVelocity = yVelocity * -1;
			changeColour();
		}
		y += yVelocity;
		repaint();
	}

	public void changeColour() {
		if (colour == Color.GREEN) {
			colour = Color.RED;
		} else if (colour == Color.RED) {
			colour = Color.BLUE;
		} else if (colour == Color.BLUE) {
			colour = Color.YELLOW;
		} else if (colour == Color.YELLOW) {
			colour = Color.GREEN;
		}
	}
}
//------------------------------------------------