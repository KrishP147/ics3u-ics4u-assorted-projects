/*
 * This is a program that asks for input in the form of the users full name in one string, then displays the first, middle and last names along with the count of each of their characters to the console..
 * Author: Krish Punjabi
 * Date: March 27, 2023
 */

//Importing instructions on how to use the scanner utility for the computer to apply in this program.
import java.util.Scanner;

public class NameLengths {

	public static void main(String[] args) {
		
		//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
		Scanner in = new Scanner(System.in);
		
			//Introductory message to user, introducing them to the program.
			System.out.println("Welcome. This program will ask you to enter your full name, then will give you some interesting output!");
			
			//Asking user if they have a middle name - depending on answer, format of answer will differ.
			System.out.println("\n" + "Do you have a middle name? Type YES if you do and NO if you don't.");
			String question = in.nextLine();
			
			//This line directs the user to input a word, storing it in a string named "initialWord", which will be used later on.
			System.out.println("\n" + "Please enter your full name:");
				String initialWord = in.nextLine();
				
				//This line stores the trimmed version of the initial name, eliminating leading and trailing spaces.
				String word = (initialWord.trim());
	
				//The users first name is determined by storing the characters between the index of the first character and the index of the first space.
				String firstName = word.substring(0, (word.indexOf(" ")));
				
				//The users last name is determined by storing the characters between the index of the last space and the index of the last character.
				String lastName = word.substring(((word.lastIndexOf(" ")) + 1), (word.length()));
			
					if (question.equals("YES")) {
						
			//The users first name and length of this name is printed to the console, using the saved data.
			System.out.println("\n" + "Your first name is " + firstName.toUpperCase() + ".");
			System.out.println("The length of your first name is " + firstName.length() + " characters.");
				
				//If the user has a middle name, then the characters between the index of first space + 1 and the index of the last space are stored.
				String initialMiddleName = word.substring(((word.indexOf(" ")) + 1), (word.lastIndexOf(" ")));
				
				//The leading and trailing spaces are removed from this data.
				String middleName = (initialMiddleName.trim());
			
			//The users middle name and length of this name is printed to the console, using the saved data.
			System.out.println("\n" + "Your middle name is " + middleName.toUpperCase() + ".");
			System.out.println("The length of your middle name is " + middleName.length() + " characters.");
			
			//The users last name and length of this name is printed to the console, using the saved data.
			System.out.println("\n" + "Your last name is " + lastName.toUpperCase() + ".");
			System.out.println("The length of your last name is " + lastName.length() + " characters."); }
					
					else {
		
			//If the user doesn't have a middle name, the same is process is applied, simply without any of the middle name related operations.	
			//The users first name and length of this name is printed to the console, using the saved data.
			System.out.println("\n" + "Your first name is " + firstName.toUpperCase() + ".");
			System.out.println("The length of your first name is " + firstName.length() + " characters.");
			
			//The users last name and length of this name is printed to the console, using the saved data.
			System.out.println("\n" + "Your last name is " + lastName.toUpperCase() + ".");
			System.out.println("The length of your last name is " + lastName.length() + " characters."); }
			
			//This line simply prints a thank you message to the user. 
			System.out.println("\n" + "Thank you for interacting with this program! Hope you had fun!");
			
		//This line simply closes the scanner.
		in.close();
				
	}
	
}
