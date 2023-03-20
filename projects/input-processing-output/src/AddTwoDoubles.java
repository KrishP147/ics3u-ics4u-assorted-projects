/*
 * This is a program that collects two numerical values from the user using the console, and use them to perform a specific arithmetic operation, as chosen by the user, displaying the result to the console.
 * Author: Krish Punjabi
 * Date: March 20, 2023
 */

//Importing instructions on how to use the scanner utility, along with the decimal rounding utility for the computer to apply in this program
import java.util.Scanner;
import java.text.DecimalFormat;

public class AddTwoDoubles {

	public static void main(String[] args) {
		
			//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
			Scanner in = new Scanner(System.in);
				
		//Introductory message to user, directing them to choose a specific operation to perform identified by a specific integer from 1-5.
		System.out.println("Input the integer denoting the operation you would like to execute:");
		
		//This is a list of the 5 offered operations, which is to be displayed to the user.
		System.out.println("1. Calculate SUM ");
		System.out.println("2. Calculate DIFFERENCE ");
		System.out.println("3. Calculate PRODUCT ");
		System.out.println("4. Calculate QUOTIENT ");
		System.out.println("5. Calculate AVERAGE ");
		
			//This line creates a variable to store the integer inputed by the user, in a variable appropriately named "option"
			int option = in.nextInt();
		
		//This line requests the user to input the first numerical value, storing it in a variable named "firstNum"
		System.out.println("Please input your first numerical value");
			double firstNum = in.nextDouble();
			
		//This line requests the user to input the second numerical value, storing it in a variable named "secondNum"
		System.out.println("Please input your second numerical value");
			double secondNum = in.nextDouble();
		
		//If the first option, sum, is chosen, the program will perform the arithmetic operation of adding the two numerical values that have been stored.
		if (option==1) {
			
			//The two numbers are added together
			double sum = firstNum + secondNum;
			
			//These following lines indicate that the format of the trailing decimal of the answer should be rounded to the nearest hundredth.
			DecimalFormat df = new DecimalFormat("0.00"); //instantiate an object df of class DecimalFormat
			
			//This line stores the value of the sum of the two numbers as a rounded answer.
			String formattedNumber = df.format(sum);
			
			//This line displays the rounded answer to the console and user.
			System.out.println("The sum of these two numbers ≈ " + formattedNumber);
			
		}
		
		//The same process would be repeated for each of the options, with the exception being that different operations would be performed, depending on the user's choice.
		else if (option==2) {
			
			//The second number is subtracted from the first
			double difference = firstNum - secondNum;
			DecimalFormat df = new DecimalFormat("0.00"); //instantiate an object df of class DecimalFormat
			String formattedNumber = df.format(difference);
			System.out.println("The difference between these two numbers ≈ " + formattedNumber);
		}
		
		else if (option==3) {
			
			//The two numbers are multiplied together.
			double product = firstNum * secondNum;
			DecimalFormat df = new DecimalFormat("0.00"); //instantiate an object df of class DecimalFormat
	        String formattedNumber = df.format(product);
			System.out.println("The product of these two numbers ≈ " + formattedNumber);
			
		}
			
		else if (option==4) {
			
			//The first number is divided by the second.
			double quotient = firstNum / secondNum;
			DecimalFormat df = new DecimalFormat("0.00"); //instantiate an object df of class DecimalFormat
	        String formattedNumber = df.format(quotient);
			System.out.println("The quotient of these two numbers ≈ " + formattedNumber);
			
		}
		
		else if (option==5) {
			
			//The two numbers are added together, then divided by the number two: the mean, or average value of the tow numbers.
			double average = (firstNum + secondNum)/2;
			DecimalFormat df = new DecimalFormat("0.00"); //instantiate an object df of class DecimalFormat
	        String formattedNumber = df.format(average);
			System.out.println("The average of these two numbers ≈ " + formattedNumber);
		}
		
		//This line simply prints a thank you message to the user.
		System.out.print("\n" + "Thank you for interacting with this program! Hope you had fun!");
		
		
		in.close();
	}
}

