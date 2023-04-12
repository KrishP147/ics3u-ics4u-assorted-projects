/* 
 * This is a program that uses a while loop to display applied interest on an initial amount over a certain amount of time to the console
 * Author: Krish Punjabi
 * Date: April 12, 2023
 */

//Importing instructions on how to use the scanner utility to apply in this program
import java.util.Scanner;

public class CompoundInterestInvestment {

	public static void main(String[] args) {
	
		//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
		Scanner in = new Scanner(System.in);
	
		//initializing the variable that holds the principall value
		double principal = 1;

	System.out.println("Welcome. This program will calculate an amount using an initial value with interest applied on it.");
	
		//using the principal as a sentinel value, when the principal vlalue equals 0, the program will end
		while (principal != 0) {
			
			//storing the principal value in the previously initialized double
			System.out.println("\n\nPlease enter your investment amount ($):");
				principal = in.nextDouble();
				
			//storing the interest rate value in a double
			System.out.println("\nPlease enter your annual interest rate (%):");
				double interest = in.nextDouble();
		
			//storing the number of years in a double
			System.out.println("\nPlease enter the number of years:");
				int years = in.nextInt();
				
				//initializing a variable that acts as a counter
				int i=0;
				
				//while the counter is less than or equal to the number of years:
				while (i<=years) {
					
					 //This principal is printed out along with the counter at the current time, rounded to two decimal places
					 System.out.printf("\nInvestment value after " + i + " year(s): $" + "%.2f", principal);
					 //the principal value will updated to its value after a year (1 cycle) after applying the interest rate
					 principal = principal + principal*interest/100;
					 //the counter increases by 1 and the cycle repeats
					 i++;	
				}
		}
		
	//this line simply prints a thank you message to the user.
	System.out.println("\n\nThank you for interacting with this program! Hope you had fun!");
		
		//closes the scanner
		in.close();
	}

}
