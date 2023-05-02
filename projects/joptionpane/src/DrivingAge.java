/* 
 * This is a simple program that uses methods and JOPtion Pane to inform the user about their driving age.
 * Author: Krish Punjabi
 * Date: May 2, 2023
 */

//importing the J option pane
import javax.swing.JOptionPane;

public class DrivingAge {

	public static void programDescription() {
		//describes the programs functionality
		JOptionPane.showMessageDialog(null, "This program informs the user about his/her driving age!", "DRIVING AGE DESCRIPTION", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void goodBye() {
		//This method simply displays a goodbye message to the user
		JOptionPane.showMessageDialog(null, "\nThank you for interacting with this program! Hope you had fun!", "DRIVING AGE GOODBYE", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);  //terminate the program
	}
	
	public static int getAge() {
		//Get the input from the user
		String stringAge = JOptionPane.showInputDialog(null, "Please enter your age:");  //NullPointerException NOT handled!
		if (stringAge == null) //Cancel button selected
			goodBye();
		int intAge = Integer.parseInt(stringAge); //converts a String data type to an integer
		return intAge;
	}
	
	public static void displayAge(int intAge, final int MAX_DRIVE_AGE, final int MIN_DRIVE_AGE, final int MAX_POSS_AGE, final int MIN_POSS_AGE) { //Gets the age value and displays the corresponding message
        
		if (intAge >= MIN_DRIVE_AGE && intAge < MAX_DRIVE_AGE)
			//information message, used if age range is within driving age range
			JOptionPane.showMessageDialog(null, "Your age is " + intAge + ". Yes, you can drive. You can drive for a maximum of " + (MAX_DRIVE_AGE - intAge) + " more years.", "Let's check your age!", JOptionPane.INFORMATION_MESSAGE);
		
		else if (intAge < MIN_DRIVE_AGE && intAge > MIN_POSS_AGE)
			//warning message, used if age is below driving age range
			JOptionPane.showMessageDialog(null, "Your age is " + intAge + ". No, you are too young to drive. You can drive in a minimum of " + (MIN_DRIVE_AGE-intAge) + " years!", "Let's check your age", JOptionPane.WARNING_MESSAGE);
		
		else if (intAge >= MAX_DRIVE_AGE && intAge < MAX_POSS_AGE)
			//error message, used if age exceeds maximum age limit
			JOptionPane.showMessageDialog(null, "Your age is " + intAge + ". No, you can't drive. You are " + (intAge - (MAX_DRIVE_AGE - 1)) + " years too old!", "Let's check your age", JOptionPane.ERROR_MESSAGE);
	
		else
			//error message, if age is greater than the max possible age or less than the lowest possible age
			JOptionPane.showMessageDialog(null, "Your age is " + intAge + ". No, you can't drive. Are you sure this is your true age though?", "Let's check your age", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void main(String[] args) {
		
		final int MAX_POSS_AGE = 122; //using a constant for the maximum possible age
		final int MIN_POSS_AGE = 0; //same for minimum possible age
		final int MAX_DRIVE_AGE = 80; //using a constant for the maximum driving age
		final int MIN_DRIVE_AGE = 16; //same for minimum driving age
		
		programDescription(); //describes program
		while (true) { //forever
			displayAge(getAge(), MAX_DRIVE_AGE, MIN_DRIVE_AGE, MAX_POSS_AGE, MIN_POSS_AGE); //displays the age after getting it, goodbye command is integrated into getAge method
		}
	}
}