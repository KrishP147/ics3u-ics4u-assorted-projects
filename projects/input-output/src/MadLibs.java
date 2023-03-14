/*
 * This is a program that collects input from the user and uses it to create a Mad LIbs story, displayed on the console.
 * Author: Krish Punjabi
 * Date: March 14, 2023
 */

//Importing instructions on how to use the scanner utility for the computer to apply in this program
import java.util.Scanner;

public class MadLibs {

	public static void main(String[] args) {
		
		//Defining a new scanner, named "in", short for input, as the scanner is a tool that collects input from the user using the console.
		Scanner in = new Scanner(System.in);
		
		//Defining the command "TEXT_GREEN", as the recognized ANSI color code for the color green; will make text green.
		final String TEXT_GREEN  = "\u001B[32m";
		
		//Defining the command "TEXT_RESET", as the recognized ANSI color code to reset the color of the text; will return other text back to default color.
		final String TEXT_RESET  = "\u001B[0m";
		
		//Introductory message to user
		System.out.println("Lets play MadLibs!");
		
		//Text displayed asking user a question for a specific type of word (in this case, a name); will be seamlessly integrated into pre-written story
		System.out.println("What is your name?");
			
			//A string variable is specifically named and created to store user input, will come in use later to output data in story.
			String name = in.nextLine();
			
		//From here and onwards, the same process is repeated; text is displayed to the user asking for specific input, and is stored into separate, specific variables.
		System.out.println("\n" + "Give me a verb ending with -ing");
			String verb = in.nextLine();
		
		System.out.println("\n" + "Give me a pronoun (he, she, etc.)");
			String pronoun = in.nextLine();
			
			//Here, a dependent string variable is created: the possessive pronoun that is required in the story depends on the initial pronoun inputed to the user - hence, the value of this variable can be determined from the "pronoun" variable. This is accomplished using an "if" loop.
			
			//If the pronoun isn't specific, the value of the possessive pronoun is set to "their"
			String posspronoun = "their";
				
				//The pronoun "he" is related to the possessive pronoun "his"
				if (pronoun.equals("he"))
					posspronoun = "his";
				
				//The pronoun "she" is related to the possessive pronoun "her"
				if (pronoun.equals("she"))
					posspronoun = "her";
				
		//The same process, as described above, continues to repeat.
		System.out.println("\n" + "Give me the name of someone you know");
			String name2 = in.nextLine();
		
		System.out.println("\n" + "Give me the name of someone else you know");
			String name3 = in.nextLine();
			
		System.out.println("\n" + "Give me a verb ending with -ing");
			String verb2 = in.nextLine();
			
		System.out.println("\n" + "because they were...");
			String reason = in.nextLine();
			
		System.out.println("\n" + "Give me an adverb");
			String adverb = in.nextLine();
			
		System.out.println("\n" + "Give me a verb ending with -ing");
			String verb3 = in.nextLine();
			
		System.out.println("\n" + "Give me an adjective");
			String adjective = in.nextLine();
			
		System.out.println("\n" + "Give me an adjective");
			String adjective2 = in.nextLine();
			
		System.out.println("\n" + "Give me a noun");
			String noun = in.nextLine();
			
		//This question displayed to the user is special; it uses the data stored in the variables "name2" and "name3" to formulate a question. This decision affects how the story ends, or simply which closing line is displayed.
		System.out.println("\n" + "Do you want to help " + name2 + " and " + name3 + " with their problem? (Type YES or NO)");
			String help = in.nextLine();
		
		//These following lines display the story, made complete with the variable values collected from the user, with extra spaces to account for specific grammar rules. The variable values have been set to be displayed as green, so that they stand out form the rest of the text.
		System.out.println("\n " + (TEXT_GREEN + name + TEXT_RESET) + " was " + (TEXT_GREEN + verb +  TEXT_RESET) + " in " + (TEXT_GREEN + posspronoun + TEXT_RESET) + " room when " + (TEXT_GREEN + pronoun + TEXT_RESET) + " saw " + (TEXT_GREEN + name2 + TEXT_RESET) + " and " + (TEXT_GREEN + name3 + TEXT_RESET) + " " + (TEXT_GREEN + verb2 + TEXT_RESET) + " outside.");
		System.out.println(" " + (TEXT_GREEN + name + TEXT_RESET) + " immediately stopped what " + (TEXT_GREEN + pronoun + TEXT_RESET) + " was doing");
		System.out.println(" and went outside to get a better look at what was happening. ");
		System.out.println(" " + (TEXT_GREEN + name + TEXT_RESET) + " asked " + (TEXT_GREEN + name2 + TEXT_RESET) + " what was going on. " + (TEXT_GREEN + name3 + TEXT_RESET) + " told " + (TEXT_GREEN + name + TEXT_RESET) + " that they were " + (TEXT_GREEN + adverb + TEXT_RESET) + " " + (TEXT_GREEN + verb2 + TEXT_RESET));
		System.out.println(" because they were " + (TEXT_GREEN + reason + TEXT_RESET) + " and then asked " + (TEXT_GREEN + name + TEXT_RESET) + " to join them. ");
		
			//This "if" command is used in relation with the final question asked to the user - if the user answered with "YES", the following line will be displayed at the end of the story:
			if (help.equals("YES"))
				System.out.println(" " + (TEXT_GREEN + name + TEXT_RESET) + " said yes, grabbed a " + (TEXT_GREEN + adjective + TEXT_RESET) + ", " + (TEXT_GREEN + adjective2 + TEXT_RESET) + " " + (TEXT_GREEN + noun + TEXT_RESET) + " and started " + (TEXT_GREEN + verb2 + TEXT_RESET) + " with " + (TEXT_GREEN + name2 + TEXT_RESET) + " and " + (TEXT_GREEN + name3 + TEXT_RESET) + ".");
			
			//If any other response is received (ex: "NO"), the following line will be displayed at the end of the story.
			else 
				System.out.println(" " + (TEXT_GREEN + name + TEXT_RESET) + " said no, and instead, started " + (TEXT_GREEN + verb3 + TEXT_RESET) + " with a " + (TEXT_GREEN + adjective + TEXT_RESET) + ", " + (TEXT_GREEN + adjective2 + TEXT_RESET) + " " + (TEXT_GREEN + noun + TEXT_RESET) + ".");
			
		//This line simply prints a thank you message to the user, for playing this MadLibs game, addressing them using their name, already stored.
		System.out.print("\n Thank you for playing MadLibs " + (TEXT_GREEN + name + TEXT_RESET) + "! Hope you had fun!");
			
		//This line simply closes the scanner, not allowing the user to input any new data.
		in.close();
		
	}

}
