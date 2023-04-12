/* 
 * This is a program that uses a sentinel-while loop to calculate the average of multiple numbers inputted by the user
 * Author: Krish Punjabi
 * Date: April 18, 2023
 */

//Importing instructions on how to use the scanner utility to apply in this program
import java.util.Scanner;

public class AverageValue {

	public static void main(String[] args) {
	
		//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
		Scanner in = new Scanner(System.in);
	
		//creating the variable to hold the current data value (value inputed by the user at the time), the total (accumulation of all data values) and the counter named i
		double currentDataValue = 1;
		double totalOfData = 0;
		int i = -1;
		
	System.out.println("Calculate Average Program - Enter 0 to Quit");
	
		//sentinel loop - when 0 is inputed, program displays average, then ends.
		while (currentDataValue != 0) {
			
			//this is repeated - asking the user to enter an integer, storing it in a temporary variable, adding the value of this variable to the total, then increasing the counter by 1.
			System.out.println("\nPlease enter an integer:");
				currentDataValue = in.nextDouble();
				totalOfData = totalOfData + currentDataValue;
				i++;
		}
	
	//This line prints the rounded average value out to the user
	System.out.printf("\nThe average of the preceding integers is " + "%.2f",  totalOfData/i);
	
	//This line simply prints a thank you message to the user
	System.out.println("\nThank you for interacting with this program! Hope you had fun!");
		
		//Closes the scanner
		in.close();
	}

}
