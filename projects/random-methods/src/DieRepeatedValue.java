/* 
 * This is a simple program that uses methods to roll dice until the dice returns two consecutive results.
 * Author: Krish Punjabi
 * Date: May 1, 2023
 */

import java.util.Scanner;

public class DieRepeatedValue {

	public static void programDescription() {
		//describes the programs functionality
		System.out.println("This program simulates rolling a single die until 2 consecutive rolls are the same."
		+ "\nIt reports how many rolls were taken.");
	}
	
	public static int getNumberOfSides(Scanner in) {
		//This method prompts users to enter a range value (number of sides on the dice)
		System.out.println("\nPlease enter the number of sides on your die (0 to quit):");	
		return (in.nextInt());
	}
	
	public static int rollDie(int numOfSides) {
		//This method chooses a random number from a range specified by the user (the number of sides on the dice)
		return (int)(Math.random()*numOfSides) + 1;  //random number generator between 1 and 6
	}
	
	public static int increaseCounter(int counter) {
		//This method simply returns the value of the counter increased by 1
		return (counter+1);
	}
	
	public static void displayResult(int result1) {
		//This method prints the result to the user.
		System.out.println("\nThe die comes up as " + result1 + ".");
	}
	
	public static void displayAnswer(int counter, int result) {
		//This method prints the answer to the user.
		System.out.println("\nIt took " + counter + " rolls to get two equal conseceutive numbers (" + result + ")!");
	}
	
	public static void goodBye() {
		//This method simply displays a goodbye message to the user
		System.out.println("\nThank you for interacting with this program! Hope you had fun!");
	}
	
	public static void main(String[] args) {
		
		programDescription(); //prints the description of the program
			Scanner in = new Scanner(System.in); //opens the new scanner
			int numOfSides = getNumberOfSides(in);  //gets user input (number of sides) and saves it in an integer
			int result = rollDie(numOfSides);  //picks random value based on the number of sides
			int prevResult = 0; //declares the previous result
			int counter = 0; //declares the counter
			
			//creates a sentinel loop, if number of sides is inputed as 0, program, loop ends.
			while (numOfSides > 0) {
				//another loop, will continue to print result and calculate the previous result until the previous and current results are equal
				while (!(result == prevResult)) {
					prevResult = result; //calculates the previous result
					result = rollDie(numOfSides);  //re rolls to update result
					displayResult(result); //displays the result to user
					counter = increaseCounter(counter); //counter is increased and saved
				}
				
				displayAnswer(counter, result); //displays answers to user, with the number of tries it took
				numOfSides = getNumberOfSides(in);  //repeats process of getting number of sides, asks user
			}
			
		goodBye();   //goodbye message
		in.close(); //closes the scanner
	}
}


