/*
 * This is a program that collects three numerical values from the user and prints them out in ascending order, using an if statement and displaying the result to the console.
 * Author: Krish Punjabi
 * Date: April 1, 2023
 */

//Importing instructions on how to use the scanner utility to apply in this program
import java.util.Scanner;

public class Comp3Numbers {

	public static void main(String[] args) {
		
			//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
			Scanner in = new Scanner(System.in);
				
		//Introductory message to user
		System.out.println("This program prompts the user for three integers, then displays them in ascending order.");
				
		//This line requests the user to input the first numerical value, storing it in a variable named "firstNum"
		System.out.println("\nPlease input your first integer:");
			int firstNum = in.nextInt();
			
			//The integer holding the greatest number is initialized, temporarily holding the first number value
			int greatestNum = firstNum;
			
		//This line requests the user to input the second numerical value, storing it in a variable named "secondNum"
		System.out.println("\nPlease input your second integer:");
			int secondNum = in.nextInt();
			
			//The integer holding the middle number is initialized, temporarily holding the second number value
			int middleNum = secondNum;
						
		//This line requests the user to input the third numerical value, storing it in a variable named "thirdNum"
		System.out.println("\nPlease input your third integer:");
			int thirdNum = in.nextInt();
			
			//The integer holding the smallest number is initialized, temporarily holding the third number value
			int smallestNum = thirdNum;
		
			//In the case that the first number is greater than or equal to both other numbers, then nothing needs to be done, as the firstNum value is already stored as the greatesNum
			if ((firstNum >= secondNum) && (firstNum >= thirdNum)) {
					
					//After determining that the first number is the greatest, there are two more possibilities, one of which is covered while initializing the variables; hence, only the second case needs to be addressed
					if (thirdNum > secondNum) {
						
						middleNum = thirdNum;
						smallestNum = secondNum;
					}
			}
			
			//In the case that the second number is greater than the first and greater than or equal to the second
			else if ((secondNum > firstNum) && (secondNum >= thirdNum)) {
				
				//The second number is the greatest
				greatestNum = secondNum;
					
					//In this case, the first number is the middle number, while the third number stays as the smallest
					if (firstNum >= thirdNum) {
						
						middleNum = firstNum;
					}
					
					//In this case the third number is the middle number, and the first number is the smallest
					else {
						
						middleNum = thirdNum;
						smallestNum = firstNum;
					}
			}
			
			//If not the first or second, the third number must be the greatest
			else {
				
				//The third number is stored as the greatest number
				greatestNum = thirdNum;
				
					//In this case, the first number is stored as the middle number, and the second is stored as the smallest
					if (firstNum >= secondNum) {
						
						middleNum = firstNum;
						smallestNum = secondNum;
					}
					
					//If not the above case, the first number is simply stored as the smallest, while the second number stays as the middle number.
					else {
						
						smallestNum = firstNum;
					}
			}
		
		//This line simply prints out the greatest, middle, and lowest number, which are determined by the above conditions
		System.out.println("\nThe ordered list from lowest to highest integer is: " + smallestNum + " " + middleNum + " " + greatestNum);
				
		
		//This line simply prints a thank you message to the user.
		System.out.print("\nThank you for interacting with this program! Hope you had fun!");
		
			//Closes the scanner
			in.close();
	}
}