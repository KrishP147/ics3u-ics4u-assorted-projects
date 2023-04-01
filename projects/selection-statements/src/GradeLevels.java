/*
 * This is a program that requests for a users grade level using a specific integer, then displays a corresponding message, using the switch statement.
 * Author: Krish Punjabi
 * Date: April 1, 2023
 */

//Importing instructions on how to use the scanner utility to apply in this program
import java.util.Scanner;

public class GradeLevels {

	public static void main(String[] args) {
		
			//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
			Scanner in = new Scanner(System.in);
				
		//Introductory message to user
		System.out.println("This program prompts the user to enter their grade level, then outputs the corresponding message.");
				
		//This line requests the user to input an integer value corresponding to their grade, storing the value"
		System.out.println("\nEnter your grade level 1-5:");
			int grade = in.nextInt();

			//Using the switch command to display different messages depending on the specific case
		    switch (grade) {
		        
		    	//For each case from integers 1 -5, a different a message is displayed.
		    	case 1:
		        	 System.out.println("\nYour grade is Insufficient");
		             break;
		        case 2:
		        	 System.out.println("\nYour grade is Poor");
		             break;
		        case 3:
		        	 System.out.println("\nYour grade is Good");
		             break;
		        case 4:
		        	 System.out.println("\nYour grade is Very Good");
		             break;
		        case 5:
		        	 System.out.println("\nYour grade is Excellent");
		             break;
		       
		        //If the input does not correspond to any of the above cases, an error message is displayed.
		        default:
		             System.out.println("\nInvalid grade: " + grade + "\nPlease restart this program.");
		     }
		
		    //This line simply prints a thank you message to the user.
		    System.out.print("\nThank you for interacting with this program! Hope you had fun!");
		     
				//Closing the scanner
			    in.close();
			
	}
}