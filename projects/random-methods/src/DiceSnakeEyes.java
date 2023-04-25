/* 
 * This is a simple program that uses methods to roll two dice until both dice return two number 1's.
 * Author: Krish Punjabi
 * Date: May 1, 2023
 */

import java.util.Scanner;

public class DiceSnakeEyes {

	public static void programDescription() {
		//describes the programs functionality
		System.out.println("This program simulates rolling a pair of dice until 2 1's are rolled"
		+ "\n(snake eyes!) It reports how many rolls it took to get this result.");
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
	
	public static void displayResult(int result1, int result2) {
		//This method prints the results to the user.
		System.out.println("\nThe dice come up as " + result1 + " and " + result2 + ".");
	}
	
	public static void displayAnswer(int counter) {
		//This method prints the answer to the user.
		System.out.println("\nIt took " + counter + " rolls to get a pair of snake eyes!");
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
			int result2 = rollDie(numOfSides); //picks second random value and stores it in another value
			int counter = 0; //declares the counter
			
			//creates a sentinel loop, if number of sides is inputed as 0, program, loop ends.
			while (numOfSides > 0) {
				//another loop, will continue to print results until both are equal to 1
				while (!(result == 1 && result2 == 1)) {
					result = rollDie(numOfSides); //updates the result
					result2 = rollDie(numOfSides);  //updates the second result
					displayResult(result, result2); //displays the results to user
					counter = increaseCounter(counter); //counter is increased and saved
				}
				
				displayAnswer(counter); //displays answers to user, with the number of tries it took
				numOfSides = getNumberOfSides(in);  //repeats process of getting number of sides, asks user
				result = 0; //resets result values
				result2 = 1;
			}
			
		goodBye();   //goodbye message
		in.close(); //closes the scanner
	}
}


