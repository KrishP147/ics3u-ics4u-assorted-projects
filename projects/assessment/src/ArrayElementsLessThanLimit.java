/*
 * This is a simple program that displays 2 random arrays, except the second only contains elements of the first that are less than 10 an array using JOPTIONPANE.
 * Author: Krish Punjabi
 * Date: May 19, 2023
 */

import java.util.Arrays;
import javax.swing.JOptionPane;

public class ArrayElementsLessThanLimit {

	public static void programDescription(int ARRAY_RANDOM, int LESS_THAN) {//This method displays a simple description of the program to the user.
		JOptionPane.showMessageDialog(null,"This program prompts the user for the length of an array, then returns an array of randomly generated numbers from 1 - " + ARRAY_RANDOM + ".\nThen this program returns a second array displaying only the numbers from the first array that are less than " + LESS_THAN + ".");
	}
	public static int findArrayLength() {
		boolean validInput = false; //will become true after passing try and catch
		String userInput = ""; //declaring String input variable
		int arrayLength = 0; //declaring integer input variable

		while (!validInput) { //will run while input is not valid, will try and catch value	
			try { //tries to convert string to integer, if fails, catch block is executed
				userInput = JOptionPane.showInputDialog(null, "Input your array length");
				if (userInput == null) {//if cancel button is pressed, program terminates
					goodBye();
				}
				arrayLength = Integer.parseInt(userInput);
				if (arrayLength <= 0) {
					throw new Exception (); //in the case that the answer is negative negative length of the array, a new exception will be thrown.
				}
				validInput = true; //since this line is executed 
			}
			catch(NumberFormatException e) {//shows error message and repeats loop until input is valid or program is exited
				JOptionPane.showMessageDialog(null,"You entered invalid input." + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
			}

			catch(Exception i) {//in the case the input isn't positive, this message will show up
				JOptionPane.showMessageDialog(null,"You entered invalid input. "+ "\nPlease enter a length value that is greater than 0", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);	
			}
		}
		return arrayLength;
	}
	public static int[] calculateArray(int ARRAY_LENGTH, int ARRAY_RANDOM) {//this methods initializes and returns an array
		int [] array = new int[ARRAY_LENGTH]; //array is initialized
		for(int i=0; i<ARRAY_LENGTH; i++) {
			array[i]= ((int)(Math.random()*ARRAY_RANDOM) + 1); //random values in the range of 1-20 are stored in the array
		} //for	
		return array; //return the array
	}
	public static int findNewArrayLength(int [] array, int ARRAY_RANDOM, int LESS_THAN) {//this methods calculates the length of the new array
		int newLength = array.length;
		for(int i=0; i<array.length; i++) {
			if (array[i] >= LESS_THAN)
				newLength--; //in case of invalid input, the catch block will be executed
		} //for

		return newLength; //return the array
	}
	public static int[] calculateNewArray(int [] array, int newLength, int LESS_THAN) {//this methods initializes and returns a new array
		int [] array2 = new int[newLength]; //array is initialized	
		for(int i = 0, j = 0; i<array2.length && j<array.length; j++) { //two integers are created, i is the characters that go into the new array and j is the characters of the first array. i only increases if the value is less than 10. otherwise, it never saves the value
			array2[i] = array[j];
			if (array2[i] < LESS_THAN) 
				i++;
		} //for	
		return array2; //return the array
	}
	public static void displayResult(int[] array, int[] array2) {//this method displays the results - the array and its reverse	
		String message = "The original array: " + Arrays.toString(array) + "!"; //first array is converted to string
		message+= "\nThe array elements < 10: " + Arrays.toString(array2) + "!";; //second array is converted to string
		JOptionPane.showMessageDialog(null, message, "RESULTS", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void goodBye() { //this method displays a goodbye message to the user
		JOptionPane.showMessageDialog(null,"Thank you for interacting with this program! Hope you had fun!");
		System.exit(0);//closes the program
	}

	public static void main(String[] args) {
		final int ARRAY_RANDOM = 20; //numbers from 1 - this number will be chosen
		final int LESS_THAN = 10; //numbers less than this number will be used in the second array
		int [] array; //array is initialized
		programDescription(ARRAY_RANDOM, LESS_THAN);//describes the program
		while (true) {	//runs forever
			array = calculateArray(findArrayLength(), ARRAY_RANDOM); //array is saved after getting the length and calculations
			displayResult(array, calculateNewArray(array, findNewArrayLength(array, ARRAY_RANDOM, LESS_THAN), LESS_THAN)); //result is displayed with first array and calculation of second array

		}//while
	} //main
}//class
