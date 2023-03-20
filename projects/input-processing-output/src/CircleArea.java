/*
 * This is a program that collects a radius from the user, and use it to either calculate the area, circumference, or diameter, as chosen by the user, displaying the result to the console.
 * Author: Krish Punjabi
 * Date: March 21, 2023
 */

//Importing instructions on how to use the scanner utility, along with the decimal rounding utility for the computer to apply in this program
import java.util.Scanner;
import java.text.DecimalFormat;

public class CircleArea {

	public static void main(String[] args) {
	
			//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
			Scanner in = new Scanner(System.in);
		
		//Introductory message to user, directing them to choose a specific operation to perform identified by a specific integer from 1-3.
		System.out.println("Input the integer denoting the operation you would like to execute:");
		
		//This is a list of the 3 offered operations, which is to be displayed to the user.
		System.out.println("1. Calculate AREA ");
		System.out.println("2. Calculate CIRCUMFERENCE ");
		System.out.println("3. Calculate DIAMETER ");
	   
			//This line creates a variable to store the integer inputed by the user, in a variable appropriately named "option"
			int option = in.nextInt();
		
		//This line requests the user to input the value of the radius, storing it in a variable named "radius"
		System.out.println("Please input your radius value.");
			double radius = in.nextDouble();
		
		//If the first option, area, is chosen, the program will perform the operation using the formula to calculate the area.
		if (option==1) {
			
			//The formula for area using the radius value is performed
			double area = radius * radius * Math.PI;
			
			//These following lines indicate that the format of the trailing decimal of the answer should be rounded to the nearest hundredth.
			DecimalFormat df = new DecimalFormat("0.00"); //instantiate an object df of class DecimalFormat
			
			//This line stores the value of the area, using the radius as a rounded answer.
			String formattedNumber = df.format(area);
			
			//This line displays the rounded answer to the console and user.
			System.out.println("The area of this circle ≈ " + formattedNumber);
		}
		
		//The same process would be repeated for each of the options, with the exception being that different operations would be performed, depending on the user's choice (circumference or diameter).
		else if (option==2) {
			
			//The formula for circumference using the radius value is performed
			double circumference = radius * 2 * Math.PI;
			DecimalFormat df = new DecimalFormat("0.00"); //instantiate an object df of class DecimalFormat
			String formattedNumber = df.format(circumference);
			System.out.println("The circumference of this circle ≈ " + formattedNumber);
		}
		
		else if (option==3) {
			
			//The formula for diameter using the radius value is performed
			double diameter = radius * 2;
			DecimalFormat df = new DecimalFormat("0.00"); //instantiate an object df of class DecimalFormat
	        String formattedNumber = df.format(diameter);
			System.out.println("The diameter of this circle ≈ " + formattedNumber);	
		
		}
		
		//This line simply prints a thank you message to the user.
		System.out.print("\n" + "Thank you for interacting with this program! Hope you had fun!");
		
		//The scanner utility is closed, so that no resource is leaked.
		in.close();
	}
}
