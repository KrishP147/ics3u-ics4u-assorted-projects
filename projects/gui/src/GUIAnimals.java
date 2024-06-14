/* This program creates & displays a JFrame object with a few GUI components:
* JPanel, JLabel, and JLabel with an image.
* Author: Krish Punjabi
* Date May 25 2024
*/

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class GUIAnimals extends JFrame {
	public GUIAnimals() {
	} //all variables & methods are inherited from JFrame
	
		private static final long serialVersionUID = 1L;
		private JPanel panel;
		
		public GUIAnimals(int width, int height, String title, Color color) { //class constructor
	
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
    public void addJLabel(int xPos, int yPos, int width, int height, String message, Color color, String font, int fontStyle, int fontSize) {	
			
		JLabel label = new JLabel(message); 
		label.setFont(new Font(font, fontStyle, fontSize));
		label.setForeground(color);
		label.setBounds(xPos, yPos, width, height);
		panel.add(label);           //add it to the panel	
	}
    
    //adds an image JLabel to the JPanel
    public void addJLabel(int xPos, int yPos, int width, int height, String imageFile) {	
	 	
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(imageFile)); //make sure the imageFile exists in the project's folder!
		label.setBounds(xPos, yPos, width, height);
		panel.add(label);          // add JLabel to JPanel
		panel.validate();         //ensures that dimensions of the JLabel fit the text	
	}
    
	public static void main(String[] args) {
        final int LENGTH = 900, WIDTH = 400;
        GUIAnimals g = new GUIAnimals(LENGTH, WIDTH, "GUI Animals", Color.YELLOW);
        //NOTE the parameter list for every method call below is defined in MyFirstGui, where all class methods are implemented 
       
        g.addJPanel(53, 24, 767, 315, Color.LIGHT_GRAY); //creates panel
        g.addJLabel(313, 18, 159, 50, "I LOVE ANIMALS!", Color.BLUE, "Tahoma", Font.BOLD, 16); //creates header label
        
        //creates image labels
        g.addJLabel(38, 79, 202, 225, "lion.jpg");     
        g.addJLabel(279, 79, 202, 225, "tiger.jpg");
        g.addJLabel(524, 79, 202, 225, "horse.jpg");
        
        //frame is made visible
        g.showContent();
	}
}
