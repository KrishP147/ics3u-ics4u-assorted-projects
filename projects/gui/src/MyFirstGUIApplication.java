/* This program creates & displays a JFrame object and several GUI components:
* JPanel, JLabel, JTextField and JButton.
* This is an introduction to basic GUI concepts
* Author: Krish Punjabi
* Date May 25 2024
*/

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MyFirstGUIApplication extends JFrame {
	public MyFirstGUIApplication() {
	} //all variables & methods are inherited from JFrame
	
		private static final long serialVersionUID = 1L;
		private JPanel panel;
		
		public MyFirstGUIApplication(int width, int height, String title, Color color) { //class constructor
	
		getContentPane().setLayout(null);  //absolute positioning; no layout manager
		setSize(width, height);     // set the JFrame size
		setTitle(title);            //set the JFrame title
		//iconLabel.setHorizontalAlignment(JLabel.CENTER);
		getContentPane().setBackground(color); //background color
		setLocationRelativeTo(null); //centers the JFrame on the screen
		setDefaultCloseOperation(EXIT_ON_CLOSE); //exit the program when closing the JFrame
	}
	
	public void showContent() {  // Very important method which makes your JFrame visible!
		setVisible(true);
	}
		
	//adds JPanel to the JFrame
	public void addJPanel(int xPos, int yPos, int width, int height, Color color) { 
		
		panel = new JPanel();
		panel.setBounds(xPos, yPos, width, height);
		panel.setBackground(color);
		panel.setLayout(null);
		getContentPane().add(panel);
	}
	
	//adds JLabel to the JPanel
    public void addJLabel(int xPos, int yPos, int width, int height, String message, Color color) {	
			
		JLabel label = new JLabel(message); 
		label.setForeground(color);
		label.setBounds(xPos, yPos, width, height);
		panel.add(label);           //add it to the panel	
	}
    
	//adds JButton to the JPanel
	public void addJButton(int xPos, int yPos, int width, int height, String message, Color color) {
		
		JButton button = new JButton(message);
		button.setBackground(color);
		button.setBounds(xPos, yPos, width, height);
		panel.add(button);              //add it to the panel	
	}
	
	//adds addJTextField to the JPanel
	public void addJTextField(int xPos, int yPos, int width, int height, String message, Color colorF, Color colorB) {
		
		JTextField tField = new JTextField(message);
		tField.setForeground(colorF);
		tField.setBackground(colorB);
		tField.setBounds(xPos, yPos, width, height);
		panel.add(tField);
	}
	public static void main(String[] args) {
        final int LENGTH = 900, WIDTH = 400; //constants for frame length and width
        
        MyFirstGUIApplication g = new MyFirstGUIApplication(LENGTH, WIDTH, "My First GUI Application", Color.GRAY);
        //NOTE the parameter list for every method call below is defined in MyFirstGui, where all class methods are implemented 
        
        //adds panel, label, and button to frame
        g.addJPanel(53, 24, 767, 315, Color.YELLOW); 
        g.addJLabel(600, 124, 157, 50, "THIS IS ANOTHER JLabel!", Color.BLUE);
        g.addJButton(229, 131, 349, 36, "JButton: Click on me, though nothing will happen yet.", Color.GREEN);
        
        //adds a pair of textfields and labels to go with each one
        g.addJTextField(29, 94, 161, 43, "TextField1", Color.BLACK, Color.MAGENTA);
        g.addJLabel(29, 56, 202, 36, "JTextField1 - Input something here:", Color.BLUE);
        g.addJTextField(29, 217, 161, 43, "TextField2", Color.BLACK, Color.MAGENTA);
        g.addJLabel(29, 178, 202, 36, "JTextField2 - Input something here:", Color.BLUE);
        
        //frame is set to visible
        g.showContent();
	}
}
