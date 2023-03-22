/*
 * This is a program that picks a random number from a predetermined range of numbers and gives the user a certain number of guesses to guess the number, displaying the result to the user using JOPTIONPANE.
 * Author: Krish Punjabi
 * Date: June 1, 2023
 * Link to FlowChart: https://lucid.app/lucidchart/57560dc0-d543-4131-9845-6f2314edbdc3/edit?viewport_loc=-157%2C-1250%2C3053%2C1406%2C0_0&invitationId=inv_7044ede3-a0ed-4ac3-ab12-64357cac4832
 */

import java.util.Arrays;
import javax.swing.JOptionPane;

public class MysteryNumber {

	public static void programDescription(int ARRAY_LENGTH) {//This method displays a simple description of the program to the user.
		JOptionPane.showMessageDialog(null,"This is a guessing game.\nThe user has a certain number of guesses to guess a positive integer between 1 and another number.");
	}
	public static int[] calculateArray(int ARRAY_LENGTH, int arrayRange) {//this methods initializes and returns an array
		int [] array = new int[ARRAY_LENGTH]; //array is initialized
		for(int i=0; i<ARRAY_LENGTH; i++) {
			array[i]= (int)(Math.random()*arrayRange) + 1; //for the length of the array, random numbers are generated within a specific range
		} //for	
		Arrays.sort(array); //sorts the array in ascending order
		return array; //return the array
	}
	public static int pickRandomAnswer(int[] array) {//this method picks a random number from the array and uses it as the answer, to which the users guesses will be compared
		int i = ((int)(Math.random()*array.length)); //this integer is a random number from 0 - the length of the array - 1
		return array[i]; //array value at this index is returned
	}
	public static int validateInput(int input, int arrayRange, String message){ //this method simply receives input from the user and validates it
		boolean validInput = false; //will become true after passing try and catch
		String userInput = ""; //declaring String input variable
		while (!validInput) { //will run while input is not valid, will try and catch value	
			try { //tries to convert string to integer, if fails, catch block is executed
				userInput = JOptionPane.showInputDialog(null, message);
				if (userInput == null)//if cancel button is pressed, program terminates
					goodBye();
				input = Integer.parseInt(userInput);
				if (input < 1 || input > arrayRange)
					throw new Exception (); //in the case that the answer is not within the range of the array, an exception will be thrown.
				validInput = true; //since this line is executed 
			}
			catch(NumberFormatException e) {//shows error message and repeats loop until input is valid (an integer) or program is exited
				JOptionPane.showMessageDialog(null,"You entered invalid input. Please enter an integer" + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception f) {//in the case the input isn't within the range of the array, this message will show up
				JOptionPane.showMessageDialog(null,"You entered invalid input. "+ "\nPlease enter a value between 1 and " + arrayRange, "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);	
			}
		}
		return input;
	}	
	public static boolean compareGuessToAnswer(int numberOfGuesses, int answer, int userGuess, int arrayRange){ //this method takes the validated input and compares it to the answer for the number of guesses allowed
		boolean win = false; // this boolean will be returned so that the rest of the program can respond depending on the result
		String message = "Please enter your guess, an integer between 1 - " + arrayRange + ":"; //message is changed for this use of validateInput method
		//the order of the commands in the for loop is very important - the program should only send out comparative messages 4 times, with the fifth time displaying the result message, however, the input needs to be validated 5 times. 
		//Hence, the comparing goes before the actual validating command, running over the value of 0 and hence skipping both conditions - 4 more repetitions of the comparing, and 5 left for validating the input
		for (int i = 0; i < numberOfGuesses; i++) { //runs the comparing process for the number of guesses
			if (userGuess > answer) //in this case, message saying guess is higher than answer is displayed
				JOptionPane.showMessageDialog(null, userGuess + " is too high. Try a lower number", "Try again", JOptionPane.WARNING_MESSAGE);
			if (userGuess < answer && userGuess > 0) //in this case message saying guess is lower than answer is displayed. the extra condition of being > 0 is included so that no message shows up when userGuess is declared as 0
				JOptionPane.showMessageDialog(null, userGuess + " is too low. Try a higher number", "Try again", JOptionPane.WARNING_MESSAGE);
			userGuess = validateInput(userGuess, arrayRange, message); //the guess is validated here
			if (userGuess == answer) { //in this case, the boolean will be returned as true, and will exit out of this method
				win = true;
				return win;
			}
		}
		return win; //else, the boolean stays false
	}
	public static void displayResult(int[] array, int answer, boolean win, int guesses) {//this method displays the results - the result depending on the boolean value and the outcome
		//default message to be used
		String message = "Sorry, all your " +  guesses + " guesses are incorrect.\nThe mystery number is " + answer + "\nfrom array " + Arrays.toString(array); //arrays are converted to strings, displaying this if
		if (win) //however, if win is true, the message is changed
			message = "You guessed it.\nThe mystery number is " + answer + "\nfrom array " + Arrays.toString(array);
		JOptionPane.showMessageDialog(null, message, "RESULTS", JOptionPane.INFORMATION_MESSAGE); //the message is decided from one of the two options and used here
	}
	public static void goodBye() { //this method displays a goodbye message to the user
		JOptionPane.showMessageDialog(null,"Thank you for interacting with this program! Hope you had fun!");
		System.exit(0);//closes the program
	}

	public static void main(String[] args) {
		final int ARRAY_LENGTH = 20; //length of array
		int arrayRange = 0; // array range is declared 
		String message = ""; //message value is declared 
		int numberOfGuesses = 0; //numbers of guesses (repetitions of getting input and validating)
		int[] array = new int[ARRAY_LENGTH]; //(array is initialized), must be declared here rather than inside loop
		int answer = 0; //answer value is declared, must be declared here rather than inside loop
		int userInput = 0; //guess value is declared, this is so that the process in method compareGuessToAnswer runs smoothly (explained above)
		boolean result = false; //boolean is declared, must be declared here rather than inside loop
		programDescription(ARRAY_LENGTH);//describes the program
		while (true) {//forever
			arrayRange = Integer.MAX_VALUE; //max value so when validated, there is no upper limit to the possible range value
			message = "Please enter the range of numbers you wish to guess from (an integer greater than 0):"; //message value is reset for first message to be used
			arrayRange = validateInput(userInput, arrayRange, message); //array range is found using validate input method, first message is used
			array = calculateArray(ARRAY_LENGTH, arrayRange); //random array is saved
			message = "Please enter the number of guesses you want to have, an integer between 1 - " + arrayRange + ":"; //message is changed for second use of validateInput
			numberOfGuesses = validateInput(userInput, arrayRange, message); //number of guesses is gotten from user
			answer = pickRandomAnswer(array); //random answer from array is saved
			result = compareGuessToAnswer(numberOfGuesses, answer, userInput, arrayRange); //result is determined based on validated guesses which are obtained with a separated method then how they compare to the answer
			displayResult(array, answer, result, numberOfGuesses); //displays the results with the array, answer, and result
		} //while
	} //main
}//class