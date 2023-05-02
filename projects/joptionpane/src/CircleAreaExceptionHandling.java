/*
 * This is a program that uses methods to collect a radius from the user, and uses it to either calculate the area, circumference, or diameter, as chosen by the user, displaying the result to the user.
 * This program uses various JOption pane windows to display messages, along with methods, and try and catch loops.
 * Author: Krish Punjabi
 * Date: May 8, 2023
 */

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class CircleAreaExceptionHandling {
	
	public static void programDescription() {
		//This method simply displays an introductory message to the user
		JOptionPane.showMessageDialog(null, "This program prompts the user to enter a radius value and a specific type of operation, then completes the operation and reports the answer back to the user.", "AREA OF A CIRCLE", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static int getOption() throws Exception {
		//Directs user to choose a specific operation to perform identified by a specific integer from 0-3.
		boolean validInput = false; //will become true after passing try and catch
		int intOption = 0; //declaring input variable
		
		while (!validInput) { //will run while input is not valid, will try and catch value
			try {
				String stringOption = JOptionPane.showInputDialog(null, "Input a valid integer denoting the operation you would like to execute:\n1. Calculate AREA\n2. Calculate CIRCUMFERENCE\n3. Calculate DIAMETER\n");  //NullPointerException NOT handled!	
				if (stringOption == null) { //Cancel button selected
					goodBye();
				}
				//convert a String to integer
				intOption = Integer.parseInt(stringOption); //in case of invalid input, the catch block will be executed
				
				if (!(intOption == 1 || intOption == 2 || intOption == 3))
				{
					throw new Exception (); //in the case that the answer isn't one of the three available options, a new exception will be thrown.
				}
				
				validInput = true; //since this line is executed 
			}
			
			catch(NumberFormatException e) { //in the case the input isn't an integer, this message will show up to the user.
				JOptionPane.showMessageDialog(null,"Please enter an integer!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);		
			}
			
			catch(Exception i) { //in the case the input isn't either 1 2 or 3, this message will show up
				JOptionPane.showMessageDialog(null,"Please enter an integer in the apppropriate range!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);		
			}
		}
		return intOption; //returns the chosen option
	}
	
	public static double getRadius() {
		//Directs user to choose a input a specific radius value.
		boolean validInput = false; //will become true after passing try and catch
		double doubleRadius = 0; //declaring input variable
				
		while (!validInput) { //will run while input is not valid, will try and catch value
			try {
				String stringRadius = JOptionPane.showInputDialog(null, "Please input a valid radius value:");  //NullPointerException NOT handled!	
				if (stringRadius == null) { //Cancel button selected
					goodBye();
				}
				//convert a String to double
				doubleRadius = Double.parseDouble(stringRadius); //in case of invalid input, the catch block will be executed						
				
				if (doubleRadius <= 0)
				{
					throw new Exception (); //in the case that the answer isn't one of the three available options, a new exception will be thrown.
				}
				
				validInput = true; //since this line is executed 
			}
					
			catch(NumberFormatException e) { //in the case the input isn't of type double - not a numerical value
				JOptionPane.showMessageDialog(null,"Please enter a valid numerical value!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);		
			}
			
			catch(Exception i) { //in the case the input isn't either 1 2 or 3, this message will show up
				JOptionPane.showMessageDialog(null,"Please enter a numerical value greater than 0!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);		
			}
		}
		return doubleRadius; //returns the radius value
	}
	
	public static void displayAnswer(double radius, int option) {
		//This method uses the option integer and the radius value (parameters) to calculate an answer and display it to the user. 
		
			//These variables are initialized
			double answer = 0;
			String answerType = "N/A";
					
				//If the first option, area, is chosen, the program will perform the operation using the formula to calculate the area.
				if (option==1) {
					
					//The formula for area using the radius value is performed
					answer = radius * radius * Math.PI;
					answerType = "area";					
				}
				
				//The same process would be repeated for each of the options, with the exception being that different operations would be performed, depending on the user's choice (circumference or diameter).
				else if (option==2) {
					
					//The formula for circumference using the radius value is performed
					answer = radius * 2 * Math.PI;
					answerType = "circumference";
				}
				
				else if (option==3) {
					
					//The formula for diameter using the radius value is performed
					answer = radius * 2;
					answerType = "diameter";
				}
				
				DecimalFormat df = new DecimalFormat("0.00");
				//This line displays the rounded answers to the console and user.
				JOptionPane.showMessageDialog(null, "With radius ≈ " + df.format(radius) + ", the " + answerType + " of this circle ≈ " + df.format(answer), answerType.toUpperCase() + " OF A CIRCLE", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void goodBye() {
		//This method simply displays a goodbye message to the user
		JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!", "DRIVING AGE GOODBYE", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);  //terminates the program
	}
	
	public static void main(String[] args) throws Exception {
		
		programDescription(); //prints the description of the program
			//loop that runs forever (terminating message is inputed into the getOption() and getRadius() methods.)
			while (true) { 
			displayAnswer(getRadius(), getOption()); //displays the message, using the previous data as input
			}
	}			
}
	
