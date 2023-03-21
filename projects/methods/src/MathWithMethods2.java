/*
 * This is a program that collects a radius from the user, and use it to either calculate the area, circumference, or diameter, as chosen by the user, displaying the result to the console.
 * Author: Krish Punjabi
 * Date: March 21, 2023
 */

//Importing instructions on how to use the scanner utility, along with the decimal rounding utility for the computer to apply in this program
import java.util.Arrays;
import java.util.Scanner;

public class MathWithMethods2 {
	
	public static void programDescription() {
		//This method simply displays an introductory message to the user
		
		System.out.println("This program prompts the user to enter a message, then displays it back on the screen.");
	}

	public static int getData(Scanner in) {
		//This method prompts users to enter an integer, stores it in an integer variable using the scanner, and returns the number. It has the scanner as a parameter and returns an integer.
		//creating the variable to hold the current data value (value inputed by the user at the time), the total (accumulation of all data values) and the counter named i
				
		//creating the variable to hold the current data value (value inputed by the user at the time), the total (accumulation of all data values) and the counter named i				
			System.out.println("Please enter a numerical value. Enter 0 once you are finished");
					int data = in.nextInt();
					
		return (data);
	}
	
	public static int increaseCounter(int i) {
		
		i++;
					
		return (i);
	}
	
	public static int[] storeOption(int data, int i) {
		//This method prompts users to enter an integer, stores it in an integer variable using the scanner, and returns the number. It has the scanner as a parameter and returns an integer.
		//creating the variable to hold the current data value (value inputed by the user at the time), the total (accumulation of all data values) and the counter named i

		int[] JavaIntArray = new int[i];
		JavaIntArray[JavaIntArray.length-1] = data; 
		Arrays.sort(JavaIntArray);
		return (JavaIntArray);
	}
	
	public static void displayAverage(int[] data2, int i) {
		//This method prompts users to enter a radius, stores it in a double using the scanner, and returns the value. It has the scanner as a parameter and returns a double.
		

		System.out.println("\nThe maximum value of this data is: " + data2[data2.length-1]);
		System.out.println("\nThe minimum value of this data is: " + data2[0]);
	}
	
	public static void displayGreatestandLeast(int[] data2, int i) {
		//This method prompts users to enter a radius, stores it in a double using the scanner, and returns the value. It has the scanner as a parameter and returns a double.
		
		Arrays.sort(data2, 0, i-1);
		System.out.println("\nThe maximum value of this data is: " + data2[data2.length-1]);
		System.out.println("\nThe minimum value of this data is: " + data2[0]);
	}
	
	public static void goodBye() {
		//This method simply displays a goodbye message to the user
		System.out.println("\nThank you for interacting with this program! Hope you had fun!");
	}
	
	public static void main(String[] args) {
		
		programDescription(); //prints the description of the program
			Scanner in = new Scanner(System.in); //opens the new scanner
				int data = getData(in);  //gets user input and saves it in an integer
				int i = 0;
					i = increaseCounter(i);
				int[] data2 = storeOption(data, i);  //gets user input and saves it in an integer
			//sentinel loop, runs until 0 is inputed
			while (data != 0) { 
				data = getData(in);  //gets user input and saves it in an integer
				i = increaseCounter(i);
				data2 = storeOption(data, i);  //gets user input and saves it in an integer			}
			}
			displayGreatestandLeast(data2, i);
			in.close(); //closes the scanner
		goodBye();   //goodbye message
	}

}
