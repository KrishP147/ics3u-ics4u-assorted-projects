/* This program uses an OOP approach in combination with 
* recursive methods to run a countdown from a specified number to 0.
* This program simply uses the scanner to display the results to the console.
* Author: Krish Punjabi
* Date: June 5 2024
*/

public class Countdown {
	private int startingNumber;

	// Constructor - the number is equivalent to the starting point of the
	// countdown, and is an attribute of the countdown
	public Countdown(int startingNumber) {
		this.startingNumber = startingNumber;
	}

	// getter for the starting number
	public int getNumber() {
		return startingNumber;
	}

	// setter for the starting number
	public void setNumber(int startingNumber) {
		this.startingNumber = startingNumber;
	}

	// the method to actually run the countdown
	public void countdown() {
		int n = getNumber(); // starting number is stored in a variable for easy reusability

		if (n <= 0) { // base case, once the number has reached 0, instead of going into another
						// recursive case, will simply execute this code
			System.out.println("0!"); // will print the final number, 0, ending the countdown
			return; // exiting the method
		}

		System.out.print(n + ", "); // will simply print the current number
		setNumber(getNumber() - 1); // number is decremented

		countdown(); // recursive call, after number has been updated, method is rerun
	}

	// this is a method to start the countdown with error handling - will "try" to
	// run the countdown method
	// if it fails (due to a stack overflow error, due to an excessively large
	// starting number), will print the out of memory space message
	public void startCountdown() {
		try {
			countdown(); // trying to countdown - will run the recursive sequences, and will come back to
							// the catch once the stack overflow error occurs
		} catch (StackOverflowError e) {
			System.out.println("Out of memory space"); // error message
		}
	}

	public static void main(String[] args) {
		final int STARTING_NUMBER = 100; // This value corresponds to the first number in the countdown.

		Countdown countdown = new Countdown(STARTING_NUMBER); // instantiating the countdown class
		countdown.startCountdown(); // starting the countdown, the method that includes exception handling
	}
}
