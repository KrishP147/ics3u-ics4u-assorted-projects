/*
 * This is a program that asks for input in the form of a word from the user, then displays the word with the first and last characters swapped.
 * Author: Krish Punjabi
 * Date: March 27, 2023
 */

//Importing instructions on how to use the scanner utility for the computer to apply in this program.
import javax.swing.JOptionPane;

public class ArrayReverse3 {

	public static void goodBye() {
		JOptionPane.showMessageDialog(null,"Goodbye :( ");
		System.exit(0);//closes the program
		}
	
	public static void main(String[] args) {
		
			//Introductory message to user, introducing them to the program
			JOptionPane.showMessageDialog(null, "Welcome. This program asks a user to enter a word," + "\n" + "which it displays with the " + "first and last characters swapped," + "\n" + "and then with all its characters reversed!", "SUM", JOptionPane.INFORMATION_MESSAGE);								
			int ARRAY_SIZE = 0;
			String initialWord ="";
			String word = "";
			
			while (!(word == null)) {
				ARRAY_SIZE ++;
			int [] array = new int[ARRAY_SIZE];
				for(int i=0; i<array.length; i++) {
					try {
					initialWord = JOptionPane.showInputDialog("Please enter integer :");
					word = initialWord.replaceAll(" ", "");	
					//convert a String to integer
					array[i]= Integer.parseInt(word); //in case of invalid input, the catch block will be executed
					}
					
					catch(Exception e) {
					JOptionPane.showMessageDialog(null,"You entered invalid input." + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
					i--;//To decrement the counter when invalid input is entered 
					}
				}
				
				//This line replaces all the spaces that will be found in the word with an empty character, which will be used for the rest of the program.

				//Here, the word, a string, is converted into a character array.
				char[] wordCharacters = word.toCharArray(); 
				
				//An integer is created to store the value of the length of the word minus 1. i cannot be less than 0. 
				for (int j = wordCharacters.length - 1; j >= 0; j--)							
					
					//This line is displayed to explain the context of the next line to the console
					JOptionPane.showMessageDialog(null, "Your word completely reversed is: " + wordCharacters[j], "SUM", JOptionPane.INFORMATION_MESSAGE);		
			}

	}
}