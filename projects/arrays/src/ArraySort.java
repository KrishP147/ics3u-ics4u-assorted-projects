/*
* This is a simple program that sorts an array using JOPTIONPANE.
* Author: Krish Punjabi
* Date: May 12, 2023
*/

import java.text.DecimalFormat;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class ArraySort {
	
	public static void programDescription() {//This method displays a simple description of the program to the user.
		JOptionPane.showMessageDialog(null,"This program sorts an array of numerical values entered by the user in ascending and descending order, and dislays its average.");
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
					if (arrayLength < 0) {
					throw new ArrayIndexOutOfBoundsException (); //in the case that the answer is negative negative length of the array, a new exception will be thrown.
					}
				validInput = true; //since this line is executed 
				}
			catch(NumberFormatException e) {//shows error message and repeats loop until input is valid or program is exited
			JOptionPane.showMessageDialog(null,"You entered invalid input." + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
			}
			
			catch(ArrayIndexOutOfBoundsException i) {//in the case the input isn't positive, this message will show up
				JOptionPane.showMessageDialog(null,"You entered invalid input. "+ "\nP Please enter a positive length value", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);	
			}
		}
		return arrayLength;
	}
	public static double[] calculateAscending(int arrayLength) {//this methods initializes and returns an array
		double [] array = new double[arrayLength]; //array is initialized
		String userInput = ""; //user input variable is declared
			for(int i=0; i<array.length; i++) {
				try {//tries to convert string to double, if fails, catch block is executed
				userInput = JOptionPane.showInputDialog("Please enter numerical value "+(i+1)+":");
					if(userInput == null) { //cancel button selected
					goodBye();
					}
				//convert a String to double
				array[i]= Double.parseDouble(userInput); //in case of invalid input, the catch block will be executed
				}
				
				catch(Exception e) {
				JOptionPane.showMessageDialog(null,"You entered invalid input." + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
				i--;//decreased so that try block can be re-executed and data will be stored in same slot 
				} 
		} //for	
		Arrays.sort(array); //this will sort the array in ascending order
	return array; //return the ascending array
	}
	public static double calculateAverage(double []array) {	
		double sum = 0;
		for (int i = 0; i <= array.length - 1; i++) {
			sum = sum + array[i];
		}				
		return (sum/(array.length));
	}	
	public static double[] calculateDescending(double []ascending) {//this method calculates and returns the descending order (reverse) of an array (which is ascending).
		double[] descending = new double[ascending.length]; //new array with same length as initial one is initialized
		for (int j = 0, i = ascending.length - 1; j <= ascending.length - 1 && i >= 0; j++, i--) //while one integer increments, the other decrements (one starts at the min length, and one starts at the max for both arrays)
			descending[j] = ascending[i]; //the position of the smaller number getting bigger on the new array becomes equal to the position of the big number getting smaller on the initial array; the array is reversed.
		return descending;
	}
	public static void displayResult(double[] ascending, double average, double[] descending) {//this method displays the results - the array and its reverse
		String message1 = "The original array is " + Arrays.toString(ascending) + "!"; //arrays are converted to strings
		String message2 = "The array reversed is " + Arrays.toString(descending) + "!";;
			DecimalFormat df = new DecimalFormat("0.00");
		String message3 = "The average of the numbers in this array is ≈" + df.format(average); //formats the average
		JOptionPane.showMessageDialog(null, message1 + "\n" + message2 + "\n" + message3, "SUM", JOptionPane.INFORMATION_MESSAGE);
	}
	public static void goodBye() { //this method displays a goodbye message to the user
		JOptionPane.showMessageDialog(null,"Thank you for interacting with this program! Hope you had fun!");
		System.exit(0);//closes the program
	}

	public static void main(String[] args) {
		programDescription();//describes the program
		while (true) {	
			double[] ascending = calculateAscending(findArrayLength());
			displayResult((ascending), calculateAverage(ascending), calculateDescending(ascending));
		}
	} //main
}//class
