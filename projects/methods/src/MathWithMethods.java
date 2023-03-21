/*
 * This is a program that continuously collects data from the user, and terminated, prints out various facts about the data.
 * Author: Krish Punjabi
 * Date: April 24, 2023
 */

//Importing instructions on how to use the scanner utility, along with the decimal rounding utility for the computer to apply in this program
import java.util.Scanner;

public class MathWithMethods {
	
	public static void programDescription() {
		//This method simply displays an introductory message to the user
		System.out.println("This program prompts the user to input various numerical values, then displays some facts about the data.");
	}

	public static double getData(Scanner in) {
		//This method gets data from the user using the scanner and returns it to the user
		System.out.println("Please enter a numerical value. Enter 0 once you are finished");			
		return (in.nextDouble());
	}
	
	public static int increaseCounter(int counter) {
		//This method simply returns the value of the counter increased by 1
		return (counter+1);
	}
	
	public static double compareGreatest(double data, double greatestData) {
		//This method compares the data to the greatest value and makes any changes if necessary, returning the greates value
			if (data > greatestData)
			{
				greatestData = data;	
			}
		return(greatestData);
	}
	
	public static double compareLeast(double data, double leastData) {
		//This method compares the data to the least value and makes any changes if necessary, returning the smallest value
			if (data < leastData)
			{
				leastData = data;	
			}	
		return(leastData);
	}
	
	public static double calculateSum(double data, double sum) {
		//This method calculates the sum of the data, y adding the previous sum and the new data together, returning the new value of the sum
		return (sum + data);
	}
	
	public static double calculateAverage(double sum, int counter) {
		//This method calculates the average of the data by dividing the sum of the data by the counter	
		return (sum/counter);
	}
	
	public static double calculateRange(double greatestData, double leastData) {
		//This method calculates and returns the range of the data using the greatest and least values
		return (greatestData - leastData);
	}
	
	public static void displayAnswers(double greatestData, double leastData, double sum, double average, double range, int counter) {
		//This method prints out all the previous data that has been collected
		
		System.out.print("\nYou have inputed " + counter + " data values.");
		System.out.printf("\nThe maximum value of this data is: " + "%.2f", greatestData);
		System.out.printf("\nThe minimum value of this data is: " +  "%.2f", leastData);
		System.out.printf("\nThe sum value of this data is: " + "%.2f", sum);
		System.out.printf("\nThe average value of this data is: " + "%.2f", average);
		System.out.printf("\nThe range value of this data is: " + "%.2f", range);		
	}
	
	public static void goodBye() {
		//This method simply displays a goodbye message to the user
		System.out.println("\n\nThank you for interacting with this program! Hope you had fun!");
	}
	
	public static void main(String[] args) {
		
		programDescription(); //prints the description of the program
			Scanner in = new Scanner(System.in); //opens the new scanner
			int counter = 0; //declares the counter
			double sum = 0; //declares the sum
			double greatestData = Double.MIN_VALUE; //declares the maximum value, by saving it as the lowest possible value for a double, guarantees that it will be changed
			double leastData = Double.MAX_VALUE; //declares the minimum value, by saving it as the greatest possible value for a double, guarantees that it will be changed
			double data = getData(in);  //gets user input and saves it in an integer

				//sentinel loop, runs until 0 is inputed
				while (data != 0) {
					//the data obtained in the loop is data that must constantly be updated, because every piece of input data is not being saved
					counter = increaseCounter(counter); //counter is increased and saved
					greatestData = compareGreatest(data, greatestData); //greatest data is obtained and saved
					leastData = compareLeast(data, leastData); //least data is obtained and saved
					sum = calculateSum(data, sum); //sum is obtained and saved
					data = getData(in);  //gets user input and saves it in an integer, is put at end of cycle because is already executed once outside of loop
				}
			
			//this is the data that doesn't need access to the whole data set concurrently to be obtained, as it depends on the other dependent data
			double average = calculateAverage(sum, counter); //average is calculated and saved
			double range = calculateRange(greatestData, leastData); //range is calculated and saved
		displayAnswers(greatestData, leastData, sum, average, range, counter); //all data is displayed
		goodBye();   //goodbye message	
			in.close(); //closes the scanner
	}

}