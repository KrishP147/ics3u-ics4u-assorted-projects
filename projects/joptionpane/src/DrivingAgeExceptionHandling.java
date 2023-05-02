/* 
 * This is a simple program that uses methods and JOPtion Pane to inform the user about their driving age.
 * This program also incorporates error messages in the case of invalid input
 * Author: Krish Punjabi
 * Date: May 8, 2023
 */

//importing the J option pane
import javax.swing.JOptionPane;

public class DrivingAgeExceptionHandling {

	public static void programDescription() {
		//describes the programs functionality
		JOptionPane.showMessageDialog(null, "This program informs the user about his/her driving age!", "DRIVING AGE DESCRIPTION", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void goodBye() {
		//This method simply displays a goodbye message to the user
		JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!", "DRIVING AGE GOODBYE", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);  //terminate the program
	}
	
	public static int getAge() throws Exception {
		//Get the input from the user
		boolean validInput = false; //will become true after passing try and catch
		int intAge = 0; //declaring input variable
		
		while (!validInput) { //will run while input is not valid, will try and catch value
			try {
				String stringAge = JOptionPane.showInputDialog(null, "Please enter your age:");  //NullPointerException NOT handled!
				if (stringAge == null) { //if cancel button is pressed, program terminates
					goodBye();
				}
				//convert a String to integer
				intAge = Integer.parseInt(stringAge); //in case of invalid input, the catch block will be executed
				if (intAge < 0 || intAge > 125) {
					throw new Exception ();
				}
				validInput = true; //since this line is executed 
			}
			
			catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,"Please enter an integer!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);		
			}
			catch(Exception i) {
				JOptionPane.showMessageDialog(null,"Please enter a valid age value!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);		
			}
		}
		return intAge;
	}
	
	public static void displayAge(int intAge, final int MAX_DRIVE_AGE, final int MIN_DRIVE_AGE) { //Gets the age value and displays the corresponding message
        
		if (intAge >= MIN_DRIVE_AGE && intAge < MAX_DRIVE_AGE)
			//information message, used if age range is within driving age range
			JOptionPane.showMessageDialog(null, "Your age is " + intAge + ". Yes, you can drive. You can drive for a maximum of " + (MAX_DRIVE_AGE - intAge) + " more years.", "Let's check your age!", JOptionPane.INFORMATION_MESSAGE);
		
		else if (intAge < MIN_DRIVE_AGE)
			//warning message, used if age is below driving age range
			JOptionPane.showMessageDialog(null, "Your age is " + intAge + ". No, you are too young to drive. You can drive in a minimum of " + (MIN_DRIVE_AGE-intAge) + " years!", "Let's check your age", JOptionPane.WARNING_MESSAGE);
		
		else if (intAge >= MAX_DRIVE_AGE)
			//error message, used if age exceeds maximum age limit
			JOptionPane.showMessageDialog(null, "Your age is " + intAge + ". No, you can't drive. You have been retired from driving for " + (intAge - (MAX_DRIVE_AGE)) + " years!", "Let's check your age", JOptionPane.ERROR_MESSAGE);
	}
	
	public static void main(String[] args) throws Exception {
		
		final int MAX_DRIVE_AGE = 80; //using a constant for the maximum driving age
		final int MIN_DRIVE_AGE = 16; //same for minimum driving age
		
		programDescription(); //describes program
		while (true) { //forever
			displayAge(getAge(), MAX_DRIVE_AGE, MIN_DRIVE_AGE); //displays the age after getting it, goodbye command is integrated into getAge method
		}
	}
}