/*
 * This is a program that collects two numerical values from the user and prints out the greater number, using an if statement and displaying the result to the console.
 * Author: Krish Punjabi
 * Date: April 1, 2023
 */

//Importing instructions on how to use the scanner utility to apply in this program
import java.util.Scanner;

public class Comp2Numbers {

	public static void main(String[] args) {
		
			//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
			Scanner in = new Scanner(System.in);
				
		//Introductory message to user
		System.out.println("This program prompts the user for two integers, then displays them in ascending order.");
				
		//This line requests the user to input the first numerical value, storing it in a variable named "firstNum"
		System.out.println("\nPlease input your first integer:");
			int firstNum = in.nextInt();
			
		//This line requests the user to input the second numerical value, storing it in a variable named "secondNum"
		System.out.println("\nPlease input your second integer:");
			int secondNum = in.nextInt();
		
			//In the case that value of the first number is greater than the second, the corresponding statement is printed out, including the difference between the two values.
			if (firstNum > secondNum) {
								
				System.out.println("\n" + firstNum + " is the greatest number, greater than " + secondNum + " by " + (firstNum - secondNum) + " unit(s)");
					
			}
			
			//Tn the case the value of the second number is greater than the first, the same statement with the values swapped out is displayed.
			else if (secondNum > firstNum) {
								
				System.out.println("\n" + secondNum + " is the greatest number, greater than " + firstNum + " by " + (secondNum - firstNum) + " unit(s)");
					
			}
			
			//In the final case, that both value are equal, a statement stating this is printed out.
			else  {
				
				System.out.println("\n" + firstNum + " is equal to " + secondNum + "!");
				
			}	
		
		//This line simply prints a thank you message to the user.
		System.out.print("\nThank you for interacting with this program! Hope you had fun!");
		
			//Closes the scanner
			in.close();
	}
}