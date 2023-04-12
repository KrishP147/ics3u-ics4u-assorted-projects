/* 
 * This is a program that uses nested for loops to display a type of character in a fixed quantity decided by the user to the console
 * Author: Krish Punjabi
 * Date: April 12, 2023
 */

//Importing instructions on how to use the scanner utility to apply in this program
import java.util.Scanner;

public class SquareOfStars {

	public static void main(String[] args) {
	
		//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
		Scanner in = new Scanner(System.in);
		
	//This line requests the user to input their chosen to be displayed, storing it in a string
	System.out.println("Please input your chosen character(s):");
		String character = in.nextLine();
		
	//This line requests the user to input the number of rows for the character, storing it in an integer variable
	System.out.println("\nPlease input the number of rows you would like to print:");
		int rows = in.nextInt();
		
	//This line requests the user to input the number of columns for the character, storing it in an integer variable
	System.out.println("\nPlease input the number of columns you would like to print:");
		int columns = in.nextInt();
		
		//For the integer i to be between the values of 0 and the number of rows, it will perform some operations and continue to increase by 1
		for (int i=0; i<rows; i++) {
			
			 //For the number of columns inputted by the user, a new line will be created
			 System.out.print("\n");
			
			//Additionally, for each row, a certain number of stars (the number of columns will be printed
			for (int j=0; j<columns; j++) { //nested loop
		    
				 //The chosen character + a space will be printed for the amount of columns, or number of characters per row.
		    	 System.out.print(character + " ");
		     }
		}

		//Closes the scanner
		in.close();
	}

}
