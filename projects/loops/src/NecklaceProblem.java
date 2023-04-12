/* 
 * This is a program that uses a while loop to calculate the solution to the necklace problem
 * Author: Krish Punjabi
 * Date: April 23, 2023
 */

//Importing instructions on how to use the scanner utility to apply in this program
import java.util.Scanner;

public class NecklaceProblem {

	public static void main(String[] args) {
	
		//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
		Scanner in = new Scanner(System.in);
	
		//initializing the variable that holds the counter, offset by 2 to account for the final two values that will be inputed manually at the end of the sequence.
		int counter = 2;
	
	//Introductory message to user
	System.out.println("Welcome to the Necklace Problem Calculator! Please enter 2 integers:");
	System.out.println("\nPlease enter the first starting integer:");
		
		//The first starting number is stored in a constant variable, which will be used later on. It is divided and converted to the absolute value to avoid an infinite loop.
		final int FIRST_STARTING_NUM = Math.abs((in.nextInt() % 10));
		//The first number in the sequence starts off being equal to the first starting number. This variable will change throughout the loop.
		int n1 = FIRST_STARTING_NUM;
				
	//Same process repeated for the second starting number
	System.out.println("\nPlease enter the second starting integer:");
			
		final int SECOND_STARTING_NUM = Math.abs((in.nextInt() % 10));
		int n2 = SECOND_STARTING_NUM;
		
		//The next number is the remainder of the sum of the first two numbers divided by 10. 
		int nextNum = (n1+n2) % 10;
		//The number after the 'next number' is the remainder of the sum of the second number and the 'next number' divided by 10.
		int nextNumPlusOne = (n2+nextNum) % 10;
	
	//The first two numbers are printed manually, not included in the loop
	System.out.print("\n" + FIRST_STARTING_NUM + " " + SECOND_STARTING_NUM);
		
		//Once the next number is equal to the first number, and the number after the next number is equal to the second number, this loop will terminate.
		while ((!(nextNum == FIRST_STARTING_NUM && nextNumPlusOne == SECOND_STARTING_NUM))) {
					
			//This loop constantly prints out the next number, adjusts the values of each variable for a new repetition of the loop, and increases the counter by 1.
			 System.out.print(" " + nextNum);
				 n1=n2;
				 n2=nextNum;
				 nextNum = (n1+n2) % 10;
				 nextNumPlusOne = (n2+nextNum) % 10;
				 counter++;	
		}	
		
	//This line prints out the first and second numbers manually at the end of the sequence since the loop terminates before these are printed.
	System.out.print(" " + FIRST_STARTING_NUM + " " + SECOND_STARTING_NUM);
	//This line prints out the value of the counter, which is equal to the number of steps taken to arrive at the same starting numbers.
	System.out.println("\n\nThe number of steps taken was: " + counter);
	//Thank you message.
	System.out.println("\nThank you for interacting with this program! Hope you had fun!");
		
		//Closes the scanner
		in.close();
	}

}
