/*
 * This is a program that collects 2 integers from the user, then calculates the gcf.
 * Author: Krish Punjabi
 * Date: April 25, 2023
 */

//Importing instructions on how to use the scanner utility, along with the decimal rounding utility for the computer to apply in this program
import java.util.Scanner;

public class GreatestCommonFactor {
	
	public static void programDescription() {
		//This method simply displays an introductory message to the user, with instructions on how to exit
		System.out.println("This program prompts the user to input two values, then displays their GCF. Enter 0 (for both values) to exit.");
	}

	public static int getData(Scanner in) {
		//This method gets data from the user using the scanner and returns it to the user
		System.out.println("\nPlease enter an integer: ");			
		return (in.nextInt());
	}
	
	public static int calculateGCF(int num1, int num2, int i, int GCF) {
		//This method calculates the GCF of the data, by searching for a number that when divided by i, has no remainder for both numbers
	  
	    for(i = 1; i <= num1 || i <= num2; i++) {
	    	if(num1 % i == 0 && num2 % i == 0)
	    		GCF = i;
	     }
		return (GCF);
	}
	
	public static void displayAnswer(int GCF) {
		//This method prints the GCF value
		
		System.out.println("\nThe GCF is: " + GCF);	
	}
	
	public static void goodBye() {
		//This method simply displays a goodbye message to the user
		System.out.println("\nThank you for interacting with this program! Hope you had fun!");
	}
	
	public static void main(String[] args) {
		
		programDescription(); //prints the description of the program
			Scanner in = new Scanner(System.in); //opens the new scanner
			int i = 0, GCF = 0; //declares the GCF and number i
			int num1 = getData(in);  //gets user input and saves it in an integer
			int num2 = getData(in);  //gets user input and saves it in an integer (again)
				
				//sentinel loop, runs until 0 is inputed
				while (!(num1 == 0 && num2 == 0)) {
					//this is what happens assuming both values aren't equal to 0
					GCF = calculateGCF(num1, num2, i, GCF);// GCF os calculated
					displayAnswer(GCF); //answer is displayed				
					num1 = getData(in);  //gets user input and saves it in an integer
					num2 = getData(in);  //gets user input and saves it in an integer	
				}

		goodBye();   //goodbye message	
		in.close(); //closes the scanner
	}

}