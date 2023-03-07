/* 
 * This is a program that displays my name, arranged with asterisks and various colors to the console.
 * Author: Krish Punjabi
 * Date: March 07, 2023
 */

public class MyName {
		
	public static void main(String[] args) {	
	
		//Defining the command "TEXT_RED, as the recognized ANSI color code for the color red; will make text red."
		final String TEXT_RED    = "\u001B[31m";
		
		//Defining the command "TEXT_GREEN, as the recognized ANSI color code for the color green; will make text green."
		final String TEXT_GREEN  = "\u001B[32m";

		//Defining the command "TEXT_BLUE, as the recognized ANSI color code for the color blue; will make text blue."
		final String TEXT_BLUE   = "\u001B[34m";
		
		//Defining the command "TEXT_YELLOW, as the recognized ANSI color code for the color yellow; will make text yellow."
		final String TEXT_YELLOW = "\u001B[33m";
		
		//Defining the command "TEXT_BG_BLACK, as the recognized color code for the color black; will make text background black."
		final String TEXT_BG_BLACK  = "\u001B[40m";
		
		//Displaying my name "KRISH", on the console in asterisks using the previously defined color variables of TEXT_RED, TEXT_BLUE, TEXT_GREEN, TEXT_YELLOW, and TEXT_BG_BLACK
		
		//Here, the command to make text red has been applied for this line, along with the command to make the background black for all 8 lines, with the pre-designed line of asterisks.
		System.out.println(TEXT_RED + TEXT_BG_BLACK + "***             ***      *** *** *** ***          *** *** *** ***        *** *** *** ***      ***         ***" );
		System.out.println(TEXT_RED + "***         ***          *** *** *** ***          *** *** *** ***        *** *** *** ***      ***         ***");
		
		//From here, I do the same thing, with three other colors; blue, yellow, and black.
			
		System.out.println(TEXT_GREEN + "***     ***              ***         ***                ***              *** ***              ***         ***");
		System.out.println(TEXT_GREEN + "*** ***                  *** *** *** ***                ***              *** *** *** ***      *** *** *** ***");
			
		System.out.println(TEXT_BLUE + "*** ***                  *** *** ***                    ***              *** *** *** ***      *** *** *** ***");
		System.out.println(TEXT_BLUE + "***     ***              ***        ***                 ***                      *** ***      ***         ***");
					
		System.out.println(TEXT_YELLOW +"***         ***          ***           ***        *** *** *** ***        *** *** *** ***      ***         ***");
		System.out.println(TEXT_YELLOW +"***             ***      ***              ***     *** *** *** ***        *** *** *** ***      ***         ***");
				 
	}

}
