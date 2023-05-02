/* 
 * This is a simple program that displays the integer the user inputs back to the user.
 * This program uses JOptionPane, methods, a cancel button and try and catch blocks.
 * Author: Krish Punjabi
 * Date: May 8, 2023
 */

import javax.swing.JOptionPane;

public class ExceptionsJOptionPaneWithCancel {

	public static void programDescription() {
		//describes the programs functionality
		JOptionPane.showMessageDialog(null, "This program checks user input, and dislpays it back to the user", "PROGRAM DESCRIPTION", JOptionPane.INFORMATION_MESSAGE);
	}
	
	//always end your program with a goodbye message
	public static void goodBye() {
		//This method simply displays a goodbye message to the user
		JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!", "DRIVING AGE GOODBYE", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);  //terminate the program
	}
	
	public static int getAge() {
		
		boolean validInput = false; //will become true after passing try and catch
		int intInput = 0; //declaring input variable
		
		while (!validInput) { //will run while input is not valid, will try and catch value
			try {
				String stringInput = JOptionPane.showInputDialog("Please enter an integer:");
				if (stringInput == null) { //if cancel button is pressed, program terminates
					goodBye();	
				}
				//convert a String to integer
				intInput = Integer.parseInt(stringInput); //in case of invalid input, the catch block will be executed
				validInput = true; //since this line is executed 
			}
			
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Please enter an integer!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE); //invalid message
			} //catch
		} //while
		
		return intInput;
	}
	
	public static void displayAge(int intInput) { //Gets the age value and displays the corresponding message
        
		JOptionPane.showMessageDialog(null, "Your input is " + intInput + ".", "Let's check your input!", JOptionPane.INFORMATION_MESSAGE);	
	}
	
	public static void main(String[] args) {
		
		programDescription(); //describes program
		while (true) { //forever
			displayAge(getAge()); //displays the age after getting it, goodbye command is integrated into getAge method
		} //while loop
	} //main
} //class