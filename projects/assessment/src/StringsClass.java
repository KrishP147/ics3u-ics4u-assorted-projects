/*
 * This is a program that asks for input in the form of the three words in one string, then displays various facts about the input.
 * Author: Krish Punjabi
 * Date: April 3, 2023
 */

//Importing instructions on how to use the scanner utility for the computer to apply in this program.
import java.util.Scanner;

public class StringsClass {

	public static void main(String[] args) {
		
		//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
		Scanner in = new Scanner(System.in);
		
			//Introductory message to user, introducing them to the program.
			System.out.println("Welcome. This program will ask you to enter three words, then will give you some interesting output!");
			
			//This line directs the user to input three words, storing them in a single string which will be used throughout the program.
			System.out.println("\n" + "Please enter 3 words:");
				String initialThreeWords = in.nextLine();
				
				//This line stores the trimmed version of the three words, eliminating leading and trailing spaces.
				String threeWords = (initialThreeWords.trim());
	
				//The first word is determined by storing the characters between the index of the first character and the index of the first space.
				String firstWord = threeWords.substring(0, (threeWords.indexOf(" ")));
														
				//The second word is determined by storing the characters between the index of first space + 1 and the index of the last space are stored.
				String initialSecondWord = threeWords.substring(((threeWords.indexOf(" ")) + 1), (threeWords.lastIndexOf(" ")));
				
				//The leading and trailing spaces are removed from this data, the second word.
				String secondWord = (initialSecondWord.trim());
				
				//The third word is determined by storing the characters between the index of the last space and the index of the last character.
				String thirdWord = threeWords.substring(((threeWords.lastIndexOf(" ")) + 1), (threeWords.length()));
				
				//The three words are stored together with a space to separate each individual word; proper formatting
				String threeWordsProperSpacing = firstWord + " " + secondWord + " " + thirdWord;
				
				//The three words are stored without any spaces
				String threeWordsWithoutSpaces = firstWord + secondWord + thirdWord;
			
			//Using the length method, the length of the initial three words, the formatted three words, and the three words without spaces are displayed.
			System.out.println("\n" + "The length of your input: " + initialThreeWords.length() + " characters");
			System.out.println("The length of your input with proper spacing: " + threeWordsProperSpacing.length() + " characters");
			System.out.println("The length of your input without the spaces: " + threeWordsWithoutSpaces.length() + " characters");
			
			//Using the upper and lower case methods, the formatted three words are displayed with all upper case and lower case characters
			System.out.println("\n" + "Your input in uppercase letters: " + threeWordsProperSpacing.toUpperCase());
			System.out.println("Your input in lowercase letters: " + threeWordsProperSpacing.toLowerCase());
			
			//Using the index and last index methods, the index of the first and last spaces, in both the initial and formatted versions of the three words are displayed
			System.out.println("\n" + "The index of the first empty space in your input: " + initialThreeWords.indexOf(" "));
			System.out.println("The index of the first empty space in your formatted input: " + threeWordsProperSpacing.indexOf(" "));
			System.out.println("\n" + "The index of the last empty space in your input: " + initialThreeWords.lastIndexOf(" "));
			System.out.println("The index of the last empty space in your formatted input: " + threeWordsProperSpacing.lastIndexOf(" "));
			
			////Using the character at method, the first and last two characters of the three formatted words are displayed
			System.out.println("\n" + "The first two characters of your formatted input: " + threeWordsProperSpacing.charAt(0) + threeWordsProperSpacing.charAt(1) );
			System.out.println("The last two characters of your formatted input: " + threeWordsProperSpacing.charAt((threeWordsProperSpacing.length()-2)) + threeWordsProperSpacing.charAt((threeWordsProperSpacing.length()-1)));
			
			//Using the replace method, the formatted three words have their two spaces in between replaced with a +, then a - sign
			System.out.println("\n" + "Your formatted input with empty spaces between words replaced by a + sign: " + threeWordsProperSpacing .replace(" ", "+"));
			System.out.println("Your formatted input with empty spaces between words replaced by a - sign: " + threeWordsProperSpacing .replace(" ", "-"));
			
			//Similar facts are displayed about the first word: the first and last character, along with the length of the word, and the word in all upper case
			System.out.println("\n" + "Your first word is: " + firstWord);
			System.out.println("Your first word in uppercase is: " + firstWord.toUpperCase());
			System.out.println("The first character of your first word: " + firstWord.charAt(0));
			System.out.println("The last character of your first word: " + firstWord.charAt(firstWord.length()-1));
			System.out.println("The length of your first word is: " + firstWord.length() + " characters");
				
			//Similar facts are displayed about the second word: the first and last character, along with the length of the word, and the word in all upper case
			System.out.println("\n" + "Your second word is " + secondWord);
			System.out.println("Your second word in uppercase is: " + secondWord.toUpperCase());
			System.out.println("The first character of your second word: " + secondWord.charAt(0));
			System.out.println("The last character of your second word: " + secondWord.charAt(secondWord.length()-1));
			System.out.println("The length of your second word is " + secondWord.length() + " characters");
			
			//Similar facts are displayed about the third word: the first and last character, along with the length of the word, and the word in all upper case
			System.out.println("\n" + "Your third word is " + thirdWord);
			System.out.println("Your third word in uppercase is: " + thirdWord.toUpperCase());
			System.out.println("The first character of your last word: " + thirdWord.charAt(0));
			System.out.println("The last character of your last word: " + thirdWord.charAt(thirdWord.length()-1));
			System.out.println("The length of your third word is " + thirdWord.length() + " characters"); 
			
				//Using the equals method, if there are two of the same word, the program displays a special message!
				if (firstWord.equals(secondWord) || firstWord.equals(thirdWord) || secondWord.equals(thirdWord)) {
					
					//If all the words are the same, this is the message
					if ((firstWord.equals(secondWord) && firstWord.equals(thirdWord))) {
						
						System.out.println("\n" + "All your words are the same!");
					}
					
					//OOtherwise, this is the message (only 2 words are the same)
					else {
					
						System.out.println("\n" + "You have two of the same word!");
					}
				}
		
			//This line simply prints a thank you message to the user. 
			System.out.println("\n" + "Thank you for interacting with this program! Hope you had fun!");
			
		//This line simply closes the scanner.
		in.close();
				
	}
	
}
