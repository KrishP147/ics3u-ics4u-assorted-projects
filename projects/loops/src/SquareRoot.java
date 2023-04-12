/* 
 * This is a program that uses a sentinel-while loop to run a repeating square root program that terminates when the user enters a negative number
 * Author: Krish Punjabi
 * Date: April 18, 2023
 */

//Importing instructions on how to use the scanner utility to apply in this program
import java.util.Scanner;

public class SquareRoot {

	public static void main(String[] args) {
	
		//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
		Scanner in = new Scanner(System.in);
	
		//creating the variable to hold the input
		double input = 1;
		
	System.out.println("This program calculates the square root of the number you entered.\n" + "It terminates when a negative number is entered.");
	
	do {
		
		//this is repeated - asking the user to enter an integer, storing it in variable, then printing a phrase including the input and its square root
		System.out.println("\n\nPlease enter an number:");
			input = in.nextDouble();
		System.out.printf("\nThe square root of " + input + " is " + "%.2f", Math.sqrt(input));
		
		}
		
		//sentinel loop - when a number less that 0 is inputed, program displays non existent square root, then ends.
		while (input >= 0); 
	
	//This line simply prints a thank you message to the user
	System.out.println("\nThank you for interacting with this program! Hope you had fun!");
		
		//Closes the scanner
		in.close();
	}

}
