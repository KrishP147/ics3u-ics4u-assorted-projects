/*
* This is a simple program that generates a random array and finds a specific key from within the array and displays the result to the user using JOPTIONPANE.
* Author: Krish Punjabi
* Date: May 16, 2023
*/

import java.util.Arrays;
import javax.swing.JOptionPane;

public class ArrayCheckKeyRandom {
	
	public static void programDescription(int ARRAY_RANDOM) {//This method displays a simple description of the program to the user.
		JOptionPane.showMessageDialog(null,"This program prompts the user for a key, then returns the index for its first occurence \nin an array of 20 randomly generated numbers from 1 - " + ARRAY_RANDOM + ".");
	}
	public static int getKey(int ARRAY_RANDOM) {
		boolean validInput = false; //will become true after passing try and catch
		String userInput = ""; //declaring String input variable
		int key = 0; //declaring integer input variable
		
		while (!validInput) { //will run while input is not valid, will try and catch value	
			try { //tries to convert string to integer, if fails, catch block is executed
				userInput = JOptionPane.showInputDialog(null, "Please enter an integer key between 1 - " + ARRAY_RANDOM + ":");
					if (userInput == null) {//if cancel button is pressed, program terminates
					goodBye();
					}
				key = Integer.parseInt(userInput);
					if (key < 1 || key > 10) {
					throw new Exception (); //in the case that the answer is not within the range of the array, an exception will be thrown.
					}
				validInput = true; //since this line is executed 
				}
			catch(NumberFormatException e) {//shows error message and repeats loop until input is valid (an integer) or program is exited
			JOptionPane.showMessageDialog(null,"You entered invalid input. Please enter an integer" + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
			}
			
			catch(Exception i) {//in the case the input isn't within the range of the array, this message will show up
				JOptionPane.showMessageDialog(null,"You entered invalid input. "+ "\nPlease enter a value between 1 and " + ARRAY_RANDOM, "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);	
			}
		}
		return key;
	}	
	public static int[] calculateArray(int ARRAY_LENGTH, int ARRAY_RANDOM) {//this methods initializes and returns an array
		int [] array = new int[ARRAY_LENGTH]; //array is initialized
			for(int i=0; i<ARRAY_LENGTH; i++) {
				array[i]= ((int)(Math.random()*ARRAY_RANDOM) + 1); //for the length of the array, random numbers are generated within a specific range
			} //for	
	return array; //return the array
	}
	public static String calculateAnswer(int[] array, int key) {//this method calculates the answer - which changes depending on if the key is found within the array or not
		for(int i=0; i<array.length; i++) {
			if (array[i] == key)
				return "\nKey " + key + " found at index " + i + "\n" + Arrays.toString(array) + "!"; //arrays are converted to strings, displaying this if they key is found with the position of the key
		} //for	
			return "\nKey " + key + " not found" + "\n" + Arrays.toString(array) + "!"; //arrays are converted to strings, displaying this if the key is not found
	}
	public static void displayResult(String message) {//this method displays the results - the result depending on the outcome
		JOptionPane.showMessageDialog(null, message, "RESULTS", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void goodBye() { //this method displays a goodbye message to the user
		JOptionPane.showMessageDialog(null,"Thank you for interacting with this program! Hope you had fun!");
		System.exit(0);//closes the program
	}

	public static void main(String[] args) {
		final int ARRAY_LENGTH = 20; //length of array
		final int ARRAY_RANDOM = 10; //numbers from 1 to this number
		programDescription(ARRAY_RANDOM);//describes the program
		while (true) {//forever
			displayResult(calculateAnswer(calculateArray(ARRAY_LENGTH, ARRAY_RANDOM), getKey(ARRAY_RANDOM))); //runs the methods
		} //while
	} //main
}//class