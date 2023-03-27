/*
 * This is a program that asks for input in the form of a word from the user, then displays some facts about the word, using various string functionalities.
 * Author: Krish Punjabi
 * Date: March 27, 2023
 */

//Importing instructions on how to use the scanner utility for the computer to apply in this program.
import java.util.Scanner;

public class Word {

	public static void main(String[] args) {
		
		//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
		Scanner in = new Scanner(System.in);
		
			//Introductory message to user, introducing them to the program
			System.out.println("Welcome. This program asks a user to enter a word; then displays its length," + "\n" + "first & last character, the word without the first and last character," + "\n" + "and finally, the word in all uppercase and lowercase letters! ");
									
			//This line directs the user to input a word, storing it in a string named "initialWord", which will be used later on.
			System.out.println("\n" + "Please enter a word:");
				String initialWord = in.nextLine();
				
				//This line stores the trimmed version of the initial word, which will be used for the rest of the program.
				String word = (initialWord.trim());
			
			//This line uses the string length method to output the length of the word chosen by the user.
			System.out.println("\n" + "The length of your word is " + word.length() + " characters.");
			
			//This line uses the string index method to output the first character of the word chosen by the user.
			System.out.println("\n" + "The first character of your word is " + word.charAt(0) + ".");
			
			//This line uses the substring method to print out the word without the first character.
			System.out.println("Your word without the first character is " + word.substring(1) + ".");
				
			//This line uses the string index method to output the last character of the word chosen by the user.
			System.out.println("\n" + "The last character of your word is " + word.charAt(word.length()-1) + ".");
			
			//This line uses the substring method to print out the word without the last character.
			System.out.println("Your word without the last character is " + word.substring(0, ((word.length()-1))) + ".");
				
			//This line uses the string uppercase method to output the characters of the word chosen by the user, in uppercase format.
			System.out.println("\n" + "Your word in uppercase letters is " + word.toUpperCase() + ".");
			
			//This line uses the string lowercase method to output the characters of the word chosen by the user, in uppercase format.
			System.out.println("\n" + "Your word in lowercase letters is " + word.toLowerCase() + ".");
				
			//This line simply prints a thank you message to the user.
			System.out.println("\n" + "Thank you for interacting with this program! Hope you had fun!");
			
		//This line simply closes the scanner.
		in.close();
	}
}