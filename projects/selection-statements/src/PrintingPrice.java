/*
 * This is a program that asks for a number of copies to print, then calculates and displays the corresponding price per copy and the total price, using if loops.
 * Author: Krish Punjabi
 * Date: April 1, 2023
 */

//Importing instructions on how to use the scanner utility, along with the decimal rounding utility for the computer to apply in this program
import java.util.Scanner;
import java.text.DecimalFormat;

public class PrintingPrice {

	public static void main(String[] args) {
		
			//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
			Scanner in = new Scanner(System.in);
		
		//Introductory message to user
		System.out.println("Welcome to the Printing Cost Calculator!");
			
		//Message asking for user input - number of copies to be printed
		System.out.println("\nEnter the number of copies to be printed:");
				
			//This line creates a variable to store the number of copies inputed by the user
			int numberOfCopies = in.nextInt();
			
		//If the number of copies is between 0 and 99, these steps are followed:
		if ((numberOfCopies >= 0) && (numberOfCopies <= 99)) {
			
			//The price for this range of copies is $0.3 per copy, which is displayed to the user
			System.out.println("\nPrice per copy is: $0.30:");
			
			//The total cost is calculated by multiplying price per copy by the number of copies
			double totalCost = 0.3 * numberOfCopies;
			
			//These following lines indicate that the format of the trailing decimal of the answer should be rounded to the nearest hundredth.
			DecimalFormat df = new DecimalFormat("0.00"); //instantiate an object df of class DecimalFormat
			
			//This line stores the value of the total price as a rounded answer.
			String roundedTotalCost = df.format(totalCost);
			
			//This line displays the rounded cost to the console and user.
			System.out.println("\nTotal cost is: " + roundedTotalCost);
			
		}
		
		//Number of copies is between 100 and 499,
		else if ((numberOfCopies >= 100) && (numberOfCopies <= 499)) {
					
			//Price for this range of copies is $0.28 per copy
			System.out.println("\nPrice per copy is: $0.28:");
			
			//Total cost is stored
			double totalCost = 0.28 * numberOfCopies;
					
			//These following lines indicate that the format of the trailing decimal of the answer should be rounded to the nearest hundredth.
			DecimalFormat df = new DecimalFormat("0.00"); //instantiate an object df of class DecimalFormat
					
			//This line stores the value of the total cost as a rounded answer.
			String roundedTotalCost = df.format(totalCost);
					
			//This line displays the rounded cost to the console and user.
			System.out.println("\nTotal cost is: " + roundedTotalCost);
					
		}
		
		//Number of copies is between 500 and 749,
		else if ((numberOfCopies >= 500) && (numberOfCopies <= 749)) {
							
			//Price for this range of copies is $0.27 per copy
			System.out.println("\nPrice per copy is: $0.27:");
			
			//Total cost is stored
			double totalCost = 0.27 * numberOfCopies;
							
			//These following lines indicate that the format of the trailing decimal of the answer should be rounded to the nearest hundredth.
			DecimalFormat df = new DecimalFormat("0.00"); //instantiate an object df of class DecimalFormat
							
			//This line stores the value of the total cost as a rounded answer.
			String roundedTotalCost = df.format(totalCost);
							
			//This line displays the rounded cost to the console and user.
			System.out.println("\nTotal cost is: " + roundedTotalCost);
							
		}
		
		//Number of copies is between 750 and 100,
		else if ((numberOfCopies >= 750) && (numberOfCopies <= 1000)) {
							
			//Price for this range of copies is $0.26 per copy
			System.out.println("\nPrice per copy is: $0.26:");
			
			//Total cost is stored
			double totalCost = 0.26 * numberOfCopies;
							
			//These following lines indicate that the format of the trailing decimal of the answer should be rounded to the nearest hundredth.
			DecimalFormat df = new DecimalFormat("0.00"); //instantiate an object df of class DecimalFormat
							
			//This line stores the value of the total cost as a rounded answer.
			String roundedTotalCost = df.format(totalCost);
							
			//This line displays the rounded cost to the console and user.
			System.out.println("\nTotal cost is: " + roundedTotalCost);
							
		}
		
		//Number of copies is greater than 1000,
		else if ((numberOfCopies > 1000)) {
							
			//Price for this range of copies is $0.25 per copy
			System.out.println("\nPrice per copy is: $0.25:");
			
			//Total cost is stored
			double totalCost = 0.25 * numberOfCopies;
							
			//These following lines indicate that the format of the trailing decimal of the answer should be rounded to the nearest hundredth.
			DecimalFormat df = new DecimalFormat("0.00"); //instantiate an object df of class DecimalFormat
							
			//This line stores the value of the total cost as a rounded answer.
			String roundedTotalCost = df.format(totalCost);
							
			//This line displays the rounded cost to the console and user.
			System.out.println("\nTotal cost is: " + roundedTotalCost);
							
		}
		
		//The only other possibility is if the number of copies is less than 0, and if so, an error message is displays
		else {
							
			System.out.println("/nYou have printed an invalid number of copies: " + numberOfCopies + "\nPlease restart this program.");		
							
		}
				
		//This line simply prints a thank you message to the user.
		System.out.print("\nThank you for using the Printing Cost Calculator! Hope you had fun!");
		
			//Closes the scanner
			in.close();
	}
}