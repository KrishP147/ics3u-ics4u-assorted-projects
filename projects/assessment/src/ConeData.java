/*
 * This is a program that calculates the surface area and volume of a cone, using their radius and height which is inputed by the user, displaying the result to the console.
 * Author: Krish Punjabi
 * Date: March 22, 2023
 */

//Importing instructions on how to use the scanner utility, along with the decimal rounding utility for the computer to apply in this program
import java.util.Scanner;
import java.text.DecimalFormat;

public class ConeData {

	public static void main(String[] args) {
		
		//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
			Scanner in = new Scanner(System.in);
				
		//Defining the command "TEXT_RED", as the recognized ANSI color code for the color red; will make text red.
			final String TEXT_RED  = "\u001B[31m";
				
		//Defining the command "TEXT_BLUE", as the recognized ANSI color code for the color blue; will make text blue.
			final String TEXT_BLUE  = "\u001B[34m";
				
		//Defining the command "TEXT_YELLOW, as the recognized ANSI color code for the color yellow; will make text yellow."
			final String TEXT_YELLOW = "\u001B[33m";
				
		//Defining the command "TEXT_YELLOW, as the recognized ANSI color code for the color green; will make text green."
			final String TEXT_GREEN = "\u001B[32m";
				
		//Defining the command "TEXT_RESET", as the recognized ANSI color code to reset the color of the text; will return other text back to default color.
			final String TEXT_RESET  = "\u001B[0m";
					
	//Introductory message to user, introducing them to the program
		System.out.println("Welcome. This program will calculate and output the " + (TEXT_YELLOW + "surface area" + TEXT_RESET) + " and " + (TEXT_GREEN + "volume" + TEXT_RESET) + " of a cone, with the appropriate " + (TEXT_RED + "radius" + TEXT_RESET) + " and " + (TEXT_BLUE + "height" + TEXT_RESET) + " input");
							
	//This line directs the user to input the radius value, storing it in a variable named "radius", which will be used in later calculations
		System.out.println("\n" + "Please input the " + (TEXT_RED + "radius" + TEXT_RESET) + " value (with the circular face of the cone):");
			double radius = in.nextDouble();
				
	//This line requests the user to input the height value, storing it in a variable named "height, which will be used in later calculations
		System.out.println("\n" + "Please input the " + (TEXT_BLUE + "height" + TEXT_RESET) + " value (the vertical height of the cone):");
			double height = in.nextDouble();
			
		//Using the radius and height values, the value of the slant height can be calculated (using the pythagoras theorem). The slant height must be calculated as it is used to calculate the surface area of the cone. This data is stored in a variable named "slant height"
			double slantHeight = Math.sqrt((radius * radius) + (height * height));
						
		//The radius , height, and slant height values are put together into the formula to calculate surface area, and stored into a variable named "surfaceArea".
			double surfaceArea = (Math.PI * radius * radius) + (Math.PI * radius * slantHeight);
				
		//The radius and height values are put together into the formula to calculate volume, and stored into a variable named "volume".
			double volume = (Math.PI * radius * radius * height)/3;
				
		//These following lines indicate that the format of the trailing decimal of the answer should be rounded to the nearest hundredth.
			DecimalFormat df = new DecimalFormat("0.00"); //instantiate an object df of class DecimalFormat
				
		//This line stores the value of the surface area of the cone as a rounded answer.
			String formattedSurfaceArea = df.format(surfaceArea);
				
		//This line stores the value of the volume of the cone as a rounded answer.
			String formattedVolume = df.format(volume);
				
	//This line displays the rounded answers to the console and user. Various colors are used to emphasize certain words, and answers.
		System.out.println("\n" + "This cone, with " + (TEXT_RED + "radius " + radius + TEXT_RESET) + " and " + (TEXT_BLUE + "height " + height + TEXT_RESET) + " has:" + "\n" + (TEXT_YELLOW + "Surface area" + TEXT_RESET) + " ≈ " + (TEXT_YELLOW + formattedSurfaceArea + " units squared "+ TEXT_RESET) + "\n" + (TEXT_GREEN + "Volume" + TEXT_RESET) + " ≈ " + (TEXT_GREEN + formattedVolume + " units cubed" + TEXT_RESET));
						
	//This line simply prints a thank you message to the user.
		System.out.println("\n" + "Thank you for interacting with this program! Goodbye!");
			
		//This line simply closes the scanner
			in.close();
	}
}

