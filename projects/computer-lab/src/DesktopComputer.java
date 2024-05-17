/* This is a sub class for computer objects - this is a class meant to simulate a Desktop computer.
 * This class provides some unique functions to its parent class - along with a modified display
 * Date: May 17 2024
 * Authors: Krish Punjabi and Isimbi Karama
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;

public class DesktopComputer extends Computer {
	
	//no new fields
	
	//default constructor
	public DesktopComputer () {
		super();
	}
	
	//class constructor, invoked with the new operator; instantiate & initializes an object of class DesktopComputer, with parameters
	public DesktopComputer (String ipAddress, int modelNumber, String operatingSystem, String brand, int manufacturingDate, String memorySize, String compatibleIDE) {		
		super(ipAddress, modelNumber, operatingSystem, brand, manufacturingDate, memorySize, compatibleIDE);
	}

	@Override //overriding the make frame method to add slight modifications to three arguments - frame, panel and keyboard
	public void makeFrame(JFrame frame, JPanel panel, JPanel keyboard) {
		super.makeFrame(frame, panel, keyboard); //original frame is made
	    
		frame.getContentPane().setBackground(Color.GREEN);
        keyboard.setBounds(167, 355, 542, 214);//keyboard position is moved
		
        JPanel monitorFrame = new JPanel(); //new panel meant to demonstrate difference between chromebook and desktop = the bottom stand/frame of the monitor
        monitorFrame.setBackground(new Color(128, 128, 128));
        monitorFrame.setBounds(398, 319, 66, 56);
        frame.getContentPane().add(monitorFrame);
        
        JPanel mousePanel = new JPanel(); //panel meant to demonstrate the mouse of the desktop
        mousePanel.setBackground(new Color(128, 128, 128));
        mousePanel.setBounds(736, 425, 66, 81);
        frame.getContentPane().add(mousePanel);
        mousePanel.setLayout(null);
        
        //panels for the left and right clickers of the mouse, only for display
        JPanel leftClickPanel = new JPanel();
        leftClickPanel.setBackground(new Color(0, 0, 128));
        leftClickPanel.setBounds(0, 0, 35, 33);
        mousePanel.add(leftClickPanel);
        
        JPanel rightClickPanel = new JPanel();
        rightClickPanel.setBackground(new Color(64, 128, 128));
        rightClickPanel.setBounds(31, 0, 35, 33);
        mousePanel.add(rightClickPanel);
	    
        //panel for actual computer for desktop; the box
        JPanel computerPanel = new JPanel();
        computerPanel.setBackground(new Color(0, 0, 0));
        computerPanel.setBounds(23, 113, 119, 317);
        frame.getContentPane().add(computerPanel);
        computerPanel.setLayout(null);
        
        //since this is the class that will be used in the computer lab, need a button to navigate back to the homepage - essentially just dispose the frame. 
        //this button provides that functionality - powering off the frame
        JButton powerButton = new JButton("Power");
        powerButton.setBackground(new Color(255, 0, 0));
        powerButton.setBounds(35, 22, 74, 23);
        powerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); //disposes frame, as homepage lies underneath
            }
        });
        computerPanel.add(powerButton);
        
        //method to "mess around", unique possibility with desktops using cables
        //will simply terminate the frame - similar to the power button, but will display message discouraging this behaviour
        JButton messAroundButton = new JButton("Mess With Cables");
        messAroundButton.setBounds(730, 100, 150, 39);
        frame.getContentPane().add(messAroundButton);
        messAroundButton.setBackground(Color.ORANGE);
        messAroundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	messAroundWithCables(); //method to show this frame
            	frame.dispose();
            }
        });
	    
        frame.setVisible(true); // Make the frame visible after all components are added
	}
	
	public void messAroundWithCables() { //special frame to show the "game over" message
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel.setBackground(Color.BLACK);
		panel.setBounds(251, 190, 470, 243);
		panel.setLocation(35, 30);
        panel.setLayout(null);
        
		JLabel gameOver = new JLabel("Game Over.");
		gameOver.setForeground(Color.GREEN);
		gameOver.setBounds(10, 81, 764, 259);
		gameOver.setFont(new Font("Goudy Stout", Font.BOLD, 64));
        gameOver.setHorizontalAlignment(SwingConstants.CENTER);
        gameOver.setVerticalAlignment(SwingConstants.CENTER);
        
        JLabel warningMessage = new JLabel("Never play with cables in the lab.");
        warningMessage.setForeground(Color.RED);
        warningMessage.setBounds(74, 319, 615, 134);
        warningMessage.setFont(new Font("Arial", Font.PLAIN, 36));
        warningMessage.setHorizontalAlignment(SwingConstants.CENTER);
        warningMessage.setVerticalAlignment(SwingConstants.CENTER);
        
        panel.add(gameOver);
        panel.add(warningMessage);
		frame.getContentPane().add(panel);
		frame.setSize(800, 600); // Set frame size
		frame.setVisible(true);
	}

	public static void main(String[] args) { //this will dissapear when chromebook and desktop pc are finalized - same except will add png with frame around JPanel - corresponding with type of computer
		//for use if running independently
		
		JFrame frame = new JFrame();
	    JPanel panel = new JPanel();
	    JPanel keyboard = new JPanel();
	    
		DesktopComputer desktop = new DesktopComputer("192.158.1.38", 2153, "macOS", "LENOVO", 2007, "64GB", "Eclipse"); //DesktopComputer is made with its specifications
        desktop.makeFrame(frame, panel, keyboard); // frame is made
    }
}