/*
 * This is a program that continuously collects numbers from the user, displaying the number that precedes and succeeds each number along with some other details.
 * Author: Krish Punjabi
 * Date: April 27, 2023
 */

//Importing instructions on how to use the scanner utility, along with the decimal rounding utility for the computer to apply in this program
import java.util.Scanner;

public class PrevAndNext {
	
	public static void programDescription() {
		//This method simply displays an introductory message to the user
		System.out.println("This program prompts the user to input an integer, then displays its preceding and succeeding numbers." 
		+ "\nThe program terminates when 0 is entered.");
	}

	public static int getData(Scanner in) {
		//This method gets data from the user using the scanner and returns it to the user
		System.out.println("\nPlease enter a number:");			
		return (in.nextInt());
	}
	
	public static int calculatePreceding(int num) {
		//This method calculates the preceding number by subtracting 1 from the input value	
		return (num-1);
	}
	
	public static int calculatesucceeding(int num) {
		//This method calculates the succeeding number by adding 1 to the input value	
		return (num+1);
	}
	
	public static int calculateSum(int num, int precedingNum, int succeedingNum) {
		//This method calculates the sum of the data, by adding the the input, preceding, and succeeding numbers. An alternate way of doing this would be to multiply the input by 3.
		return (num + precedingNum + succeedingNum);
	}
	
	public static int calculateProduct(int num, int precedingNum, int succeedingNum) {
		//This method calculates the product of the three values
		return (num * precedingNum * succeedingNum);
	}
	
	public static int calculateSquare(int num) {
		//This method calculates the square of the input
		return (num * num);
	}
	
	public static void displaySpecialCase(int num) {
		//This method displays a special message to the user, only to be used with a certain input value
		System.out.println("\nDid you know that this sequence of numbers is special? These three numbers can represent the side lengths of a right-angled triangle, " + 
		"\nbecause the sum of the squares of the two smaller sides is equal to the square of the larger side. \n9 + 16 = 25");
	}
	
	public static void displayAnswers(int num, int precedingNum, int succeedingNum, int sum, int product, int squareOfNum, int squareOfPreceding, int squareOfsucceeding) {
		//This method prints out all the previous data that has been collected
		
		System.out.println("\nThe number you inputed: " + num);
		System.out.println("Preceding number: " + precedingNum);
		System.out.println("Succeeding number: " + succeedingNum);
		System.out.println("The sum of the three numbers: " + sum);
		System.out.println("The product of the three numbers: " + product);
		System.out.println("The square of the number inputed: " + squareOfNum);
		System.out.println("The square of the preceding number: " + squareOfPreceding);
		System.out.println("The square of the succeeding number: " + squareOfsucceeding);
	}
	
	public static void goodBye(Scanner in) {
		//This method simply displays a goodbye message to the user
		System.out.println("\nThank you for interacting with this program! Hope you had fun!");
		in.close(); //closes the scanner
	}
	
	public static void main(String[] args) {
		
		programDescription(); //prints the description of the program
			Scanner in = new Scanner(System.in); //opens the new scanner
			int num = 1;
			int precedingNum;
			int succeedingNum;
			
				//sentinel loop, runs until 0 is inputed
				while (num != 0) {
					num = getData(in);  //gets user input and saves it in an integer, is put at end of cycle because is already executed once outside of loop
					precedingNum = calculatePreceding(num); //preceding number is recalculates
					succeedingNum = calculatesucceeding(num); //succeeding number is recalculated	
					
						displayAnswers(num, precedingNum, succeedingNum, calculateSum(num, precedingNum, succeedingNum), calculateProduct(num, precedingNum, succeedingNum), calculateSquare(num), calculateSquare(precedingNum), calculateSquare(succeedingNum)); //all data is displayed
						//In the case the input is 4, the special message is displayed
						if (num == 4) {	
							displaySpecialCase(num);
						}
				
				}		
		goodBye(in); //goodbye message	
	} //main

} //class