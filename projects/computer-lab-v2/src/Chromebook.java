/* This is a sub class for computer objects - this is a class meant to simulate a chromebook computer.
 * This class provides some unique functions to its parent class - along with a modified display
 * Date: May 17 2024
 * Authors: Krish Punjabi and Isimbi Karama
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Chromebook extends Computer {
	
	//New field, demonstrating status of computer, accessibility feature
	boolean touchScreen;
	
	//default constructor
	public Chromebook () {
		super();
		this.touchScreen = false;
	}
	
	//class constructor, invoked with the new operator; instantiate & initializes an object of class Chromebook, with parameters
	public Chromebook (String ipAddress, int modelNumber, String operatingSystem, String brand, int manufacturingDate, String memorySize, String compatibleIDE, boolean touchScreen) {		
		super(ipAddress, modelNumber, operatingSystem, brand, manufacturingDate, memorySize, compatibleIDE);
		this.touchScreen = touchScreen;
	}
	
	//getter and setter for boolean, called "is" to check status of boolean variable.
	public boolean isTouchScreen() {
		return touchScreen;
	}

	public void setTouchScreen(boolean touchScreen) {
		this.touchScreen = touchScreen;
	}

	@Override //ovveriding to make modifications to display according to chromebook display
	public void makeFrame(JFrame frame, JPanel panel, JPanel keyboard) {
		super.makeFrame(frame, panel, keyboard); //original frame is set up
	   
		frame.getContentPane().setBackground(Color.YELLOW);
		keyboard.setBounds(167, 320, 542, 289); //keyboard is adjusted
        
        JPanel extendedKeyboard = new JPanel(); //keyboard is extended, as laptops include mouses, and more with their keyboards
        extendedKeyboard.setBackground(new Color(0, 64, 128));
        extendedKeyboard.setBounds(0, 208, 542, 81);
        keyboard.add(extendedKeyboard);
        extendedKeyboard.setLayout(null);
        
        JButton powerButton = new JButton("Power"); //button to dispose the frame and return to the homepage
	    powerButton.setBounds(0, 0, 74, 23);
	    panel.add(powerButton);
	    powerButton.setBackground(new Color(255, 0, 0));
	    powerButton.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            frame.dispose();
	        }
	    }); 
	      
        JButton chargeButton = new JButton("Charge"); //button to "charge" the battery of the chromebook, another unique feature of chromebooks
        chargeButton.setBounds(393, 11, 125, 46);
        extendedKeyboard.add(chargeButton);
        chargeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	chargeBattery();//runs specialized charge method
            }
        });
        
        JButton touchScreenButton = new JButton("Touchscreen: " + isTouchScreen()); //button to show status of whether touchscreen is on or off, and to modify its status - using setter and getter
        touchScreenButton.setBounds(10, 11, 174, 46);
        extendedKeyboard.add(touchScreenButton);
        touchScreenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	modifyTouchScreen(touchScreenButton);
            }
        });
        
        //panel to display the mouse, integrated into the extended keyboard
        JPanel mousePanel = new JPanel();
        mousePanel.setBounds(194, 11, 167, 59);
        extendedKeyboard.add(mousePanel);
        mousePanel.setLayout(null);
        
        //left and right panels for the mouse, display purposes only
        JPanel leftClickPanel = new JPanel();
        leftClickPanel.setBackground(Color.BLUE);
        leftClickPanel.setBounds(0, 0, 84, 30);
        mousePanel.add(leftClickPanel);
        
        JPanel rightClickPanel = new JPanel();
        rightClickPanel.setBackground(Color.CYAN);
        rightClickPanel.setBounds(83, 0, 84, 30);
        mousePanel.add(rightClickPanel);
        
        frame.setVisible(true); // Make the frame visible after all components are added
	}
	
	public void modifyTouchScreen(JButton touchScreenButton) { //method to modify touchscreen status
		JFrame frame = new JFrame(); //new frame and panel to show this change in status, pened on click of button
		JPanel panel = new JPanel();
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel.setBounds(600, 200, 470, 243);
		panel.setLocation(35, 30);
        panel.setLayout(null);
        
		JLabel touchScreenLabel = new JLabel(""); //empty label is made, text will be set according to case
		touchScreenLabel.setBounds(56, 47, 475, 81);
		touchScreenLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
		touchScreenLabel.setHorizontalAlignment(SwingConstants.CENTER);
		touchScreenLabel.setVerticalAlignment(SwingConstants.CENTER);
        
        panel.add(touchScreenLabel);
		frame.getContentPane().add(panel);
		frame.setSize(600, 200); // Set frame size
		frame.setVisible(true);
    	
    	if (isTouchScreen() == false) { //if false and clicked, becomes true. Label is set to enabled message, button becomes yellow, and a yellow and blue frame is displayed.
    		setTouchScreen(true);
    		touchScreenLabel.setText("Touchscreen mode has been enabled.");
    		touchScreenLabel.setForeground(Color.YELLOW);
    		panel.setBackground(Color.BLUE);
    		touchScreenButton.setBackground(Color.YELLOW);
    		
    	}
    	else { //else (if true and clicked), becomes false. Label is set to disabled message, button becomes gray, and a gray and red frame is displayed.
    		setTouchScreen(false); 
    		touchScreenLabel.setText("Touchscreen mode has been disabled.");
    		touchScreenLabel.setForeground(Color.RED);
    		panel.setBackground(Color.LIGHT_GRAY);
    		touchScreenButton.setBackground(Color.GRAY);
    	}
    	touchScreenButton.setText("Touchscreen: " + isTouchScreen()); //button text showing status is updated
	}
	
	public void chargeBattery() { //method to show a frame informing the user that their battery is charged
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		//new frame
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel.setBackground(new Color(128, 64, 0));
		panel.setBounds(600, 200, 470, 243);
		panel.setLocation(35, 30);
        panel.setLayout(null);
        
		JLabel chargedLabel = new JLabel("Your battery is now fully charged!"); //simple label is displayed - will always show the same message
		chargedLabel.setForeground(Color.GREEN);
		chargedLabel.setBounds(56, 47, 475, 81);
		chargedLabel.setFont(new Font("Calibri", Font.PLAIN, 30));
        chargedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        chargedLabel.setVerticalAlignment(SwingConstants.CENTER);
        
        panel.add(chargedLabel);
		frame.getContentPane().add(panel);
		frame.setSize(600, 200); // Set frame size
		frame.setVisible(true);
	}

	public static void main(String[] args) {
	    
		JFrame frame = new JFrame();
	    JPanel panel = new JPanel();
	    JPanel keyboard = new JPanel();
		Chromebook chromebook = new Chromebook("205.128.7.36", 56346, "chromeOS", "ACER", 2023, "32GB", "Replit", false); //Chromebook is created with specifications
		chromebook.makeFrame(frame, panel, keyboard); //frame is made
    }
}	
