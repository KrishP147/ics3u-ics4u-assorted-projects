/* 
 * This is a simple program that uses methods to print out a message that is inputed by the user
 * Author: Krish Punjabi
 * Date: April 18, 2023
 */

import java.util.Scanner;

public class MessageWithMethods {

	public static void programDescription() {
		//This method simply displays an introductory message to the user
		
		System.out.println("This program prompts the user to enter a message, then displays it back on the screen. Type out the message 'exit' if you wish to terminate the program");
	}
	
	public static String getMessage(Scanner in) {
		//This method prompts users to enter a message, stores it in a string using the scanner, and returns the message. It has the scanner as a parameter and returns a string
		
		System.out.println("\nPlease enter a message:");	
			String message = in.nextLine();
		return (message);
	}
	
	public static void displayMessage(String message) {
		//This message prints the message to the user. It has the message string as a parameter
		
		System.out.println("\n" + message);
	}
	
	public static void goodBye() {
		//This method simply displays a goodbye message to the user
		System.out.println("\nThank you for interacting with this program! Hope you had fun!");
	}
	
	public static void main(String[] args) {
		
		programDescription(); //prints the description of the program
			Scanner in = new Scanner(System.in); //opens the new scanner
			String message = getMessage(in);  //gets user input and saves it in a string
			
			//creates a sentinel loop, if message exit is typed, loop ends.
			while (!(message.equalsIgnoreCase("EXIT"))) {
			displayMessage (message);  //displays the message, using the previous string as input
				message = getMessage(in);  //resets value of message
			}
			
		goodBye();   //goodbye message
		in.close(); //closes the scanner
	}
}


