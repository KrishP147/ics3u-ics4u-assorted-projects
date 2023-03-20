/*
 * This is a program that collects four numerical values from the user using the console, and use them to perform specific statistical operations, as chosen by the user, displaying the result to the console.
 * Author: Krish Punjabi
 * Date: March 23, 2023
 */

//Importing instructions on how to use the scanner utility, along with the decimal rounding utility for the computer to apply in this program
import java.util.Scanner;
import java.text.DecimalFormat;

public class Average {

	public static void main(String[] args) {
		
			//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
			Scanner in = new Scanner(System.in);
				
		//Introductory message to user, directing them to choose a specific operation to perform identified by a specific integer from 1-5.
		System.out.println("Welcome. This program calculates the approximate sum, mean, range, and median of your data set containing 4 numbers.");
		
		//This line instructs the user to type data in increasing order, for the simplicity of calculating the median and range.
		System.out.println("\n" + "Please input your numbers in increasing order (smallest to largest)");
		
		//This line requests the user to input the first numerical value, storing it in a variable named "firstNum"
		System.out.println("\n" + "Please input your first numerical value:");
			double firstNum = in.nextDouble();
			
		//This line requests the user to input the second numerical value, storing it in a variable named "secondNum"
		System.out.println("\n" + "Please input your second numerical value:");
			double secondNum = in.nextDouble();
			
		//This line requests the user to input the first numerical value, storing it in a variable named "thirdNum"
		System.out.println("\n" + "Please input your third numerical value:");
			double thirdNum = in.nextDouble();
				
		//This line requests the user to input the second numerical value, storing it in a variable named "fourthNum"
		System.out.println("\n" + "Please input your fourth numerical value:");
			double fourthNum = in.nextDouble();
			
				//These following lines indicate that the format of the trailing decimal of the answer should be rounded to the nearest hundredth.
				DecimalFormat df = new DecimalFormat("0.00"); //instantiate an object df of class DecimalFormat
				
			//The four numbers are added together
			double sum = firstNum + secondNum + thirdNum + fourthNum;
			
				//This line stores the value of the sum of the four numbers as a rounded answer.
				String formattedSum = df.format(sum);
			
		//This line displays the rounded sum to the console and user.
		System.out.println("\n" + "The sum of these two numbers ≈ " + formattedSum);
			
			//The average, or mean is calculated; the sum of the 4 numbers equally divided by 4
			double mean = sum/4;
			
				//This line stores the value of the mean of the four numbers as a rounded answer.
				String formattedMean = df.format(mean);
						
		//This line displays the rounded mean to the console and user.
		System.out.println("\n" + "The mean of these two numbers ≈ " + formattedMean);
			
			//The median is calculated, the central number in the data set, the two middle values averaged.
			double median = (secondNum + thirdNum)/2;
			
				//This line stores the value of the median of the four numbers as a rounded answer.
				String formattedMedian = df.format(median);
			
		//This line displays the rounded median to the console and user.
		System.out.println("\n" + "The median of these two numbers ≈ " + formattedMedian);
									
			//The range is calculated, the highest number - the lowest number
			double range = fourthNum - firstNum;
					
				//This line stores the value of the range of the four numbers as a rounded answer.
				String formattedRange = df.format(range);
						
		//This line displays the rounded range to the console and user.
		System.out.println("\n" + "The range of these two numbers ≈ " + formattedRange);
	
		//This line simply prints a thank you message to the user.
		System.out.print("\n" + "Thank you for interacting with this program! Hope you had fun!");
		
		//This line simply closes the scanner
		in.close();
	}
}

