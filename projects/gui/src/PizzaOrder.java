/* This program creates a JFrame object to calculate
* the price of a pizza, depending on diameter and number of toppings.
* This program uses JTextFields and JButtons, with Action Listeners to respond to user input.
* Author: Krish Punjabi
* Date May 31 2024
*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PizzaOrder extends JFrame implements ActionListener {
	public PizzaOrder() {
	} //all variables & methods are inherited from JFrame
	
		private static final long serialVersionUID = 1L;
		private JPanel panel;
		private JButton button;
		private JTextField tField1;
		private JTextField tField2;
		
		public PizzaOrder(int width, int height, String title, Color color) { //class constructor
	
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
	
	//adds an image JLabel to the JPanel
    public void addJLabel(int xPos, int yPos, int width, int height, String imageFile) {	
	 	
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon(imageFile)); //make sure the imageFile exists in the project's folder!
		label.setBounds(xPos, yPos, width, height);
		panel.add(label);          // add JLabel to JPanel
		panel.validate();         //ensures that dimensions of the JLabel fit the text	
	}
    
	//adds JLabel to the JPanel
    public void addJLabel(int xPos, int yPos, int width, int height, String message, Color color) {	
			
		JLabel label = new JLabel(message); 
		//label.setFont(new Font(font, fontStyle, fontSize));
		label.setForeground(color);
		label.setBounds(xPos, yPos, width, height);
		panel.add(label);           //add it to the panel	
	}
    
    //adds addJTextField to the JPanel
  	public void addJTextField(int xPos, int yPos, int width, int height, Color colorB, String message) {
  		
  		JTextField tField = new JTextField(message);
  		//tField.setForeground(colorF);
  		tField.setBackground(colorB);
  		tField.setBounds(xPos, yPos, width, height);
  		panel.add(tField);
	  		if (message.equals("diameter")) { //assigning this specific textfield to one of the two global variables
	            tField1 = tField; //diameter textfield is assigned as textfield 1
	        } else {
	            tField2 = tField;
	        }
  	}
    
	//adds JButton to the JPanel
	public void addJButton(int xPos, int yPos, int width, int height, String message) {
		
		button = new JButton(message);
		//button.setBackground(color);
		button.setBounds(xPos, yPos, width, height);
        button.addActionListener(this);
		panel.add(button);              //add it to the panel	
				
	}
	
    public void actionPerformed(ActionEvent e) {  //the action to be performed upon a click
        if (e.getSource() == button) {
            try {
                double diameter = Double.parseDouble(tField1.getText()); //diameter is stored in textfield1
                int toppings = Integer.parseInt(tField2.getText()); //toppings are stored in textfield2 (number of toppings)
                double cost = (0.5 * (diameter) + 0.75 * (toppings)) * 1.15; //cost is calculated; 50 cents per cm, 75 cents per topping, 15% tax
                button.setText("$" + formatNum(cost)); //cost is formatted and displayed as the text on the $$$ button
            } catch (NumberFormatException ex) { //in the case that operations cannot be performed, non numerical input
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for diameter and toppings.", "Input Error", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }
	
	public String formatNum(double num) { //method to formmat the output to two decimal places (money)
		DecimalFormat df = new DecimalFormat("0.00"); //to format doubles to two decimal places
		return df.format(num);
	}
	
	public static void main(String[] args) {          
	    
		final int WIDTH = 900, HEIGHT = 400;
		PizzaOrder g = new PizzaOrder(WIDTH, HEIGHT, "TIME FOR PIZZA!", Color.YELLOW);
		g.addJPanel(40, 30, 800 , 300, Color.PINK);
		g.addJLabel(320, 5, 400, 30, "PIZZA ORDER", Color.BLUE);
		g.addJLabel(50, 99, 200, 30, "Diameter of your pizza ($0.50/cm):", Color.BLUE);
		g.addJTextField(50, 120, 200, 30, Color.MAGENTA, "diameter"); //diameter textfield, tField1
		g.addJLabel(50, 149, 200, 30, "How many toppings (each $0.75)?", Color.BLUE);
		g.addJTextField(50, 170, 200, 30, Color.MAGENTA, "topping"); //toppings textfield, tField2
		g.addJLabel(320, 120, 190, 30, "GRAND TOTAL", Color.BLUE);
		g.addJButton(270, 145, 190, 30, "$$$$$$"); //JButton, will display total cost
		g.addJLabel(480, 50, 230, 220, "20. pizza.jpg"); //Image JLabel
		g.showContent(); //displays content to user, important
	}

}
