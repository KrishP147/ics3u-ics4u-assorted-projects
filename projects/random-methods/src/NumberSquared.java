/* 
 * This is a simple program that uses methods to print out a message that is inputed by the user
 * Author: Krish Punjabi
 * Date: April 25, 2023
 */

import java.util.Scanner;

public class NumberSquared {

	public static void programDescription() {
		//This method chooses a random number from a range specified by the user, then displays both the number and its square
		
		System.out.println("This program prompts the user to enter an integer range value, then calculates a random number between the range of 1 to the number."
				+ "\nIt then displays this number and its square. Enter a range value that is less than 0 to quit");
	}
	
	public static int getRange(Scanner in) {
		//This method prompts users to enter a range value	
		System.out.println("\n\nPlease enter a value to which the random number can range to (1 - x):");	
		return (in.nextInt());
	}
	
	public static int pickRandom(int range) {
		//This method chooses a random number from a range specified by the user, then displays both the number and its square
		return ((int)(range*Math.random()) + 1);
	}
	
	public static int calculateSquare(int random) {
		//This method calculates the square of the random number
		return (random*random);
	}
	
	public static void displayAnswers(int random, int square) {
		//This method prints the data to the user.
		System.out.println("\nA random number in this range is " + random + ". and its square is " + square + ".");
	}
	
	public static void goodBye() {
		//This method simply displays a goodbye message to the user
		System.out.println("\nThank you for interacting with this program! Hope you had fun!");
	}
	
	public static void main(String[] args) {
		
		programDescription(); //prints the description of the program
			Scanner in = new Scanner(System.in); //opens the new scanner
			int range = getRange(in);  //gets user input (range) and saves it in a string
			
			//creates a sentinel loop, if message exit is typed, loop ends.
			while ((range > 0)) {
				int random = pickRandom(range);  //picks random value using the range
				int square = calculateSquare(random);  //calculates square using random number
				displayAnswers(random, square); //displays answers to user
				range = getRange(in);  //gets user input (range) and saves it in a string
			}
			
		goodBye();   //goodbye message
		in.close(); //closes the scanner
	}
}


