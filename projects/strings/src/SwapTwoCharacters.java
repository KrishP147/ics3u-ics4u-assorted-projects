/*
 * This is a program that asks for input in the form of a word from the user, then displays the word with the first and last characters swapped.
 * Author: Krish Punjabi
 * Date: March 27, 2023
 */

//Importing instructions on how to use the scanner utility for the computer to apply in this program.
import java.util.Scanner;

public class SwapTwoCharacters {

	public static void main(String[] args) {
		
		//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
		Scanner in = new Scanner(System.in);
		
				//Defining the command "TEXT_YELLOW, as the recognized ANSI color code for the color yellow; will make text yellow."
				final String TEXT_YELLOW = "\u001B[33m";
			
				//Defining the command "TEXT_YELLOW, as the recognized ANSI color code for the color green; will make text green."
				final String TEXT_GREEN = "\u001B[32m";
			
				//Defining the command "TEXT_RESET", as the recognized ANSI color code to reset the color of the text; will return other text back to default color.
				final String TEXT_RESET  = "\u001B[0m";
			
			//Introductory message to user, introducing them to the program
			System.out.println("Welcome. This program asks a user to enter a word," + "\n" + "which it displays with the " + (TEXT_YELLOW + "first" + TEXT_RESET) + " and " + (TEXT_YELLOW + "last" + TEXT_RESET) + " characters swapped," + "\n" + "and then with all its characters " + (TEXT_GREEN + "reversed" + TEXT_RESET) + "!");
											
			//This line directs the user to input a word, storing it in a string named "initialWord", which will be used later on.
			System.out.println("\n" + "Please enter a word:");
				String initialWord = in.nextLine();
				
				//This line replaces all the spaces that will be found in the word with an empty character, which will be used for the rest of the program.
				String word = initialWord.replaceAll(" ", "");
				
				//These lines store the first and last characters of the word, respectively, into char variables named "first" and "last".
				char first = (word.charAt(0));
				char last = word.charAt(word.length()-1);
			
			//These lines simply print the last character, a substring containing the letters between the first and last character, and the first character, in this sequence (the first and last characters are colored yellow).
			System.out.println("\n" + "Your word with the "+ (TEXT_YELLOW + "first" + TEXT_RESET) + " and " + (TEXT_YELLOW + "last" + TEXT_RESET) + " characters swapped is:");
			System.out.println((TEXT_YELLOW + last + TEXT_RESET) + word.substring (1, (word.length()-1)) + (TEXT_YELLOW + first + TEXT_RESET));
			
			//This line is displayed to explain the context of the next line to the console
			System.out.println("\n" + "Your word completely " + (TEXT_GREEN + "reversed" + TEXT_RESET) + " is:");
				
				//Here, the word, a string, is converted into a character array.
				char[] wordCharacters = word.toCharArray(); 
				
				//An integer is created to store the value of the length of the word minus 1. i cannot be less than 0. 
				for (int i = wordCharacters.length - 1; i >= 0; i--)
			
				//This value is then printed; the word, or the individual characters, all reversed, because the array is scanned starting from the last character (and the text is colored green).
				System.out.print((TEXT_GREEN + wordCharacters[i] + TEXT_RESET));
			
	        //This line simply prints a thank you message to the user. The extra line is used because the previous line isn't printed as an individual line, hence is used for spacing reasons 
			System.out.println(" ");
			System.out.println("\n" + "Thank you for interacting with this program! Hope you had fun!");
				
		//This line simply closes the scanner.
		in.close();
	}
}