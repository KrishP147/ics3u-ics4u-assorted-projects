/*
 * This is a program that uses methods to collect a radius from the user, and uses it to either calculate the area, circumference, or diameter, as chosen by the user, displaying the result to the console.
 * Author: Krish Punjabi
 * Date: April 23, 2023
 */

//Importing instructions on how to use the scanner utility, along with the decimal rounding utility for the computer to apply in this program
import java.util.Scanner;

public class CircleAreaWithMethods {
	public static void programDescription() {
		//This method simply displays an introductory message to the user
		
		System.out.println("This program prompts the user to enter a radius value and a specific type of operation, then completes the operation and reports the answer back to the user.");
	}

	public static int getOption(Scanner in) {
		//This method prompts users to enter an integer, stores it in an integer variable using the scanner, and returns the number. It has the scanner as a parameter and returns an integer.
		
		//Introductory message to user, directing them to choose a specific operation to perform identified by a specific integer from 0-3.
		System.out.println("\nInput a valid integer denoting the operation you would like to execute:");
		
		//This is a list of the 3 offered operations, which is to be displayed to the user.
		System.out.println("1. Calculate AREA ");
		System.out.println("2. Calculate CIRCUMFERENCE ");
		System.out.println("3. Calculate DIAMETER ");	
		System.out.println("0. QUIT ");
		
			//This line creates a variable to store the integer inputed by the user, in a variable appropriately named "option"
			int option = in.nextInt();
		return (option);
	}
	
	public static double getRadius(Scanner in) {
		//This method prompts users to enter a radius, stores it in a double using the scanner, and returns the value. It has the scanner as a parameter and returns a double.
		
		//This line requests the user to input the value of the radius, storing it in a variable named "radius"
		System.out.println("\nPlease input a valid radius value:");
			double radius = in.nextDouble();
		return (radius);
	}
	
	public static void displayAnswer(int option, double radius) {
		//This method uses the option integer and the radius value (parameters) to calculate an answer and display it to the user. 
		
			//These variables are initialized
			double answer = 0;
			String answerType = "N/A";
					
		//If the first option, area, is chosen, the program will perform the operation using the formula to calculate the area.
				if (option==1) {
					
					//The formula for area using the radius value is performed
					answer = radius * radius * Math.PI;
					answerType = "area";					
				}
				
				//The same process would be repeated for each of the options, with the exception being that different operations would be performed, depending on the user's choice (circumference or diameter).
				else if (option==2) {
					
					//The formula for circumference using the radius value is performed
					answer = radius * 2 * Math.PI;
					answerType = "circumference";
				}
				
				else if (option==3) {
					
					//The formula for diameter using the radius value is performed
					answer = radius * 2;
					answerType = "diameter";
				}
				
				//This line displays the rounded answer to the console and user.
				System.out.printf("\nThe " + answerType + " of this circle ≈ " + "%.2f", answer);
				System.out.print("\n");
	}
	
	public static void goodBye() {
		//This method simply displays a goodbye message to the user
		System.out.println("\nThank you for interacting with this program! Hope you had fun!");
	}
	
	public static void main(String[] args) {
		
		programDescription(); //prints the description of the program
			Scanner in = new Scanner(System.in); //opens the new scanner
				int option = getOption(in);  //gets user input and saves it in an integer
			
			//sentinel loop, runs until 0 is inputed
			while (option != 0) { 
					double radius = getRadius(in);  //gets user input and saves it in a double
			displayAnswer(option, radius); //displays the message, using the previous data as input
					option = getOption(in);  //gets user input and saves it in an integer
			}
			
			in.close(); //closes the scanner
		goodBye();   //goodbye message
	}
}
