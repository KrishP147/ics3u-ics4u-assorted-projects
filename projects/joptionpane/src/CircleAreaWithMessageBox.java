/* This program demonstrates a use of a JOptionPane dialog
 * Author: Natasha Rakocevic
 * Date: April 27, 2021
 */

import java.text.DecimalFormat;
import javax.swing.JOptionPane;


public class CircleAreaWithMessageBox {
	
	public static void programDescription() {
		
		//The following method displays a JOptionPane message box: 
		//The first argument:  always null for ICS3U
		//The second argument: the message to be displayed
		//The third argument: the title  
		//The fourth argument: the type of a message box
		JOptionPane.showMessageDialog(null, "This program calculates the area of a circle!", "AREA OF A CIRCLE", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void goodBye() {
		
		JOptionPane.showMessageDialog(null, "Terminating... \nBYE, BYE!", "AREA OF A CIRCLE", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);  //terminate the program
	}

	public static double calculateArea(double radius) {
		
		final int POWER = 2;
		//return the area of a circle
		return Math.pow(radius, POWER)*Math.PI;
	}
	
	public static void displayArea(double radius, double area) { //Formats and displays the area in the information message box
        
		DecimalFormat df = new DecimalFormat("0.00");
		//The following method displays a message dialog box:
		//First argument: null (for ICS3U), second argument: the message, third argument: the title, fourth argument: message box type
		JOptionPane.showMessageDialog(null, "Radius = " + df.format(radius) + " units, Area = " + df.format(area) + " units squared.", "AREA OF A CIRCLE", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static double getRadius() {
		
		//Get the input from the user
		
		String stringRadius = JOptionPane.showInputDialog(null, "Enter the radius of a circle:");  //NullPointerException NOT handled!
		if (stringRadius == null) //Cancel button selected
			goodBye();
		double doubleRadius = Double.parseDouble(stringRadius); //converts a String data type to a double
		return doubleRadius;
	}

	public static void main(String[] args) {

		//describe the purpose of the program
		programDescription();
		while(true) {
			//get the radius
			double radius = getRadius();
			//the next method displays the area - it requires two arguments: 
			//the radius, and the area (obtained as a return value from the getArea(radius) method
			displayArea(radius, calculateArea(radius));
		}
		//this method is now in get input method getRadius, as program terminates with a Cancel button
		//goodBye();
	}
}