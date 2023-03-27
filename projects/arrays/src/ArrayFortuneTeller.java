/*
 * This is a simple program that uses an array to act as a fortune teller using JOPTIONPANE.
 * Author: Krish Punjabi
 * Date: May 18, 2023
 */

import javax.swing.JOptionPane;

public class ArrayFortuneTeller {

	public static void programDescription() {//This method displays a simple description of the program to the user.
		JOptionPane.showMessageDialog(null,"This program lets you ask a question about the future, then answers it.");
	}
	public static String askQuestion() {
		String key = JOptionPane.showInputDialog(null, "What is your question?");
		if (key == null) {//if cancel button is pressed, program terminates
			goodBye();
		}
		return key;
	}	
	public static String[] instantiateArray(int ARRAY_LENGTH) {//this methods initializes and returns an array
		String [] array = new String[ARRAY_LENGTH]; //array is initialized
		//different answers are saved at different locations in the array
		array[0] = "It is certain.";	
		array[1] = "It is decidedly so.";
		array[2] = "Without a doubt.";
		array[3] = "Yes definitely.";
		array[4] = "You may rely on it.";
		array[5] = "Most likely.";
		array[6] = "As I see it, yes.";
		array[7] = "Outlook good.";
		array[8] = "Yes.";
		array[9] = "Signs point to yes.";
		array[10] = "Reply hazy, try again.";	
		array[11] = "Ask again later.";
		array[12] = "Better not tell you now.";
		array[13] = "Cannot predict now.";
		array[14] = "Concentrate and ask again.";
		array[15] = "Don't count on it.";
		array[16] = "My reply is no.";
		array[17] = "My sources say no.";
		array[18] = "Outlook not so good.";
		array[19] = "Very doubtful.";
		return array; //return the array
	}
	public static void displayResult(String[] array) {//this method displays the results - the array and its reverse
		int i = (int)(Math.random()*(array.length - 1)); //a random index is picked for the array which holds one of the messages.
		String message = array[i]; //arrays are converted to strings
		if (i < 10) //this range of indices contain affirmative messages, hence they are information messages.
			JOptionPane.showMessageDialog(null, message, "RESULTS", JOptionPane.INFORMATION_MESSAGE);
		if (i < 15 && i >= 10) //this range of indices contain indecisive messages, hence they are warning messages.
			JOptionPane.showMessageDialog(null, message, "RESULTS", JOptionPane.WARNING_MESSAGE);
		if (i < 20 && i >= 15) //this range of indices contain negative messages, hence they are error messages.
			JOptionPane.showMessageDialog(null, message, "RESULTS", JOptionPane.ERROR_MESSAGE);
	}
	public static void goodBye() { //this method displays a goodbye message to the user
		JOptionPane.showMessageDialog(null,"Thank you for interacting with this program! Hope you had fun!");
		System.exit(0);//closes the program
	}

	public static void main(String[] args) {
		final int ARRAY_LENGTH = 20;
		programDescription();//describes the program
		while (true) {	//forever
			askQuestion(); //asks the user the question
			displayResult(instantiateArray(ARRAY_LENGTH)); //displays the result after instantiating the array
		} //while
	} //main
}//class
