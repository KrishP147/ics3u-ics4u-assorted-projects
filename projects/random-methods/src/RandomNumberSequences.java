/* 
 * This is a simple program that uses methods to generate 30 random numbers for 3 sequences
 * Author: Krish Punjabi
 * Date: May 1, 2023
 */

public class RandomNumberSequences {

	public static void programDescription() {
		//describes the programs functionality
		System.out.println("This program generates 30 random numbers using Math.random, for each of the following ranges:");
	}
	
	public static void printSequence() {
		//This method prints the first sequence to the user.
		System.out.print("\n{1, 2, 3,..., 10}:        "); //describing the range of the first sequence to the user
		for (int i = 1 ; i <= 30 ; i++) { //calculates the random number in the desired change and repeats it 30 times, printing out the result
			System.out.print(((int)(Math.random()*10) + 1) + " ");
		}
	}
	
	public static void printSequence2() {
		//This method prints the second sequence to the user.
		System.out.print("\n{5, 10, 15,..., 100}:     "); //describing the range of the second sequence to the user
		for (int i = 1 ; i <= 30 ; i++) { //calculates the random number in the desired change and repeats it 30 times, printing out the result
			System.out.print((5 * ((int)(Math.random()*20) + 1)) + " ");
		}
	}
	
	public static void printSequence3() {
		//This method prints the third sequence to the user.
		System.out.print("\n{-5, -4, -3,..., 5}:      "); //describing the range of the third sequence to the user
		for (int i = 1 ; i <= 30 ; i++) {
			System.out.print(((int)(Math.random()*10) - 5) + " "); //calculates the random number in the desired change and repeats it 30 times, printing out the result
		}
	}
	
	public static void goodBye() {
		//This method simply displays a goodbye message to the user
		System.out.println("\n\nThank you for interacting with this program! Hope you had fun!");
	}
	
	public static void main(String[] args) {
		
		programDescription(); //prints the description of the program
		printSequence(); //prints out the first sequence
		printSequence2(); //prints out the second sequence
		printSequence3(); //prints out the third sequence
		goodBye(); //goodbye message
	}
}
