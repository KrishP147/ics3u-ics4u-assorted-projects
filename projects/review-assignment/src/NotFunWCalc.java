/*
 * This is a program that calculates the equation of the tangent line to any point on a polynomial function, collecting input from the user and displaying the result to the user using JOPTIONPANE.
 * The program does this calculation using the Power Rule, a fundamental calculus theorem used to calculate the IROC of polynomial functions.
 * Author: Krish Punjabi and Isimbi Karama
 * Date: February 8, 2024
 */

import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class NotFunWCalc {

	public static void programDescription(String instructions, ImageIcon photo) {// This method displays a simple description of the program to the user.
		JOptionPane.showMessageDialog(null, instructions, "WELCOME", JOptionPane.INFORMATION_MESSAGE, photo);
	}
	public static int chooseProcedure(int intInput) {// This method displays a simple description of the program to the user.
		String []options = {"Equation of the Tangent Calculator", "Hangman", "Cancel"};
		intInput = JOptionPane.showOptionDialog(null, "Would you like to calculate the Equation of the Tangent or play Hangman?", "How would you like to proceed?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (intInput == (options.length - 1)) {// if cancel button is pressed, program terminates
			goodBye();
		}
		return intInput;
	}
	public static double validateInput(double input, double maxValue, double minValue, String message) { // this method receives the input from the user and validates it. This method is to calculate the degree of the polynomial, which must be an integer
		boolean validInput = false; // will become true after passing try and catch
		String userInput = ""; // declaring String input variable
		while (!validInput) { // will run while input is not valid, will try and catch value
			try { // tries to convert string to integer, if fails, catch block is executed
				userInput = JOptionPane.showInputDialog(null, message);
				if (userInput == null)// if cancel button is pressed, program terminates
					return -1;
				input = Double.parseDouble(userInput);
				if ((input < minValue || input > maxValue)) {
					throw new IllegalArgumentException(); // in the case that the answer is not within the specific range of acceptable answers, an exception will be thrown.
				}
				validInput = true; // since this line is executed
			} catch (NumberFormatException e) {// shows error message and repeats loop until input is valid (an integer) or program is exited
				JOptionPane.showMessageDialog(null,
						"You entered invalid input. Please enter an integer" + "\nPlease try again!", "INPUT INVALID!",
						JOptionPane.ERROR_MESSAGE);
			} catch (IllegalArgumentException f) {// in the case the input isn't within specified range, this message will show up
				JOptionPane.showMessageDialog(null, "You entered invalid input. " + "\nPlease enter a value between "
						+ minValue + " and " + maxValue, "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
			}
		}
		return input;
	}

	public static double[] storeCoefficients(double inputtedCoeffecients, int degree, String message, final double MAX_COEFFICIENT, final double MIN_COEFFICIENT) {// this methods initializes and returns a double  array to store the various coefficients of the initial function
		double[] storedCoeffecients = new double[degree + 1]; // you can have a max of degree + 1 coefficients in a polynomial, hence this will be the length of the array
		String writtenDegree = "";
		for (int i = degree; i >= (0); i--) { // for simplicity, index number = degree of term, as user inputs coeffcient, degree will decrease until complete
			writtenDegree = " (degree " + i + ")"; // adding a specification to which degree the inputed coefficient will correspond with to the message
			storedCoeffecients[i] = validateInput(inputtedCoeffecients, MAX_COEFFICIENT, MIN_COEFFICIENT, (message + writtenDegree)); // will validate all input then will store in array at index corresponding to degree
		} // for
		return storedCoeffecients; // return the array
	}

	public static double[] calculateEquation(int degree, double[] initialCoeffecients, double xCoordinate) {// this method will calculate the equation of the tangent with the given information
		double[] derivativeCoeffecients = new double[degree]; // derivative will have one less term/coefficient than original, hence is equal to degree rather than degree + 1
		double IROC = 0; //IROC = instantaneous rate of change, slope of tangent line
		double yCoordinate = initialCoeffecients[0]; //initializing yCoordinate as constant value of equation (at index/degree 0) since for loop will not have i = 0
		double[] tangentValues = new double[2]; // new array to export IROC and "b" values together
		for (int i = degree; i > 0; i--) { // going through degree values using power law to find derivative coefficients (for f(x) = ax^n, f'(x) = anx^n-1)
			derivativeCoeffecients[i - 1] = ((initialCoeffecients[i]) * (i)); // since we are dealing with i - 1 here, i can never be equal to 0, hence initial array value at [0] is stored as initial yCoordainate value
			IROC = IROC + ((derivativeCoeffecients[i - 1]) * Math.pow(xCoordinate, (i - 1))); // solving for IROC by inserting in x coordinate and applying operations in terms of the initial function's degree (i), hence using i - 1, summing IROC values for each degree reduction in coordination with for loop
			yCoordinate = yCoordinate + ((Math.pow(xCoordinate, i)) * (initialCoeffecients[i])); // solving for y through initial coefficient, degree and x, summing for each degree through for loop as i--
		} // for
		tangentValues[0] = (int) IROC; // IROC, slope or "m" value
		tangentValues[1] = (int) (yCoordinate - IROC * xCoordinate); // Y intercept,, x^0, or "b" value

		return tangentValues; // return the array
	}
	
	public static String choosePhoto(double leadingCoefficient, int degree, String photoName, String randWord, int lastGuess, StringBuilder guessedWord, boolean fun) {// this method chooses the name of the image file depending on the characteristics of the initial function
		// Using the switch command to display different messages depending on the specific case
	   if (fun == false) {
		if (leadingCoefficient > 0) {
	    	if (degree % 2 == 0) { // positive leading coefficient with even degree will extend from quadrant 4 to 1
	    		photoName = "even+";
	    	}
	    	else { // positive leading coefficient with odd degree will go from quadrant 3 to 1
	    		photoName = "odd+";
	    	}  
	    }	
	    if (leadingCoefficient < 0) {
	    	if (degree % 2 == 0) { // negative leading coefficient with even degree will go from quadrant 3 to 2
	    		photoName = "even-";
	    	}
	    	else { // negative leading coefficient with odd degree will go from quadrant 4 to 2
	    		photoName = "odd-";
	    	}  
	    }
	   }
	   if (fun == true) {
		   if (guessedWord.toString().equals(randWord) || lastGuess > 0) {
			   photoName = "";
		   }
		   if (lastGuess == 0) {
			   photoName = "";
		   }
	   }
	 return photoName; // array value at this index is returned
	}
	public static void displayCalculation(double[] initialCoefficients, double[] tangentCoeffcients, double x, ImageIcon graph) {// this method displays the results - the equation of the tangent, the initial equation, the y coordinate, etc.
		DecimalFormat df = new DecimalFormat("0.00");
		double m = tangentCoeffcients[0];
		double b = tangentCoeffcients[1];
		double y = m * x + b; // solving for y using stored m, x and b values in array, rather than importing another variable
		String initialFunction = df.format(initialCoefficients[initialCoefficients.length - 1]) + "x^" + (initialCoefficients.length - 1); // initializing string function value with first term, since there will be one more term than + sign in equation (for loop will require an even number of both + signs and terms).
		for (int i = (initialCoefficients.length - 2); (i >= 0); i--) {
			initialFunction = initialFunction + " + " + df.format(initialCoefficients[i]) + "x^" + (i); // using stored coefficient values at specific positions to formulate complete initial function as a string
		} // for
		String tangentEquation = df.format(m) + "x + " + df.format(b); // putting numerical variable into string equation of tangent
		String message = "The equation of the tangent of\npoint (" + df.format(x) + ", " + df.format(y) + "), on the function " + initialFunction + "\nis " + tangentEquation + ".";
		JOptionPane.showMessageDialog(null, message, "RESULTS", JOptionPane.INFORMATION_MESSAGE, graph); // displaying combined message with numerical values
	}

	public static void goodBye() { // this method displays a goodbye message to the user
		JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
		System.exit(0);// closes the program
	}

	public static String[] wordBank() {// method to instantiate words used to guess

		String[] words = { "apple", "banana", "library", "sour", "bullet", "racecar", "element", "method", "light",
				"melt", "computer", "Mystery", "turtle", "hellicopter", "yellow", "ribbon" };
		return words;

	}

	public static String getRandomWord(String[] words) {// method to find random word

		int randomIndex = (int) (Math.random() * words.length); // to find a select a random index from the string of														// words
		JOptionPane.showMessageDialog(null, words[randomIndex], "¿¿¿HANGMAN???", JOptionPane.INFORMATION_MESSAGE);
		return words[randomIndex];
	}

	public static StringBuilder startGame(String randWord) {// to build String based on letters in the random word selected
		StringBuilder guessedWord = new StringBuilder("_".repeat(randWord.length())); // string builder replaces letters within the word with _ the word is not revealed
		return guessedWord;
	}

	public static int selectDifficulty() {// To select difficulty of the game

		// To initialize variables used in the method
		int level = 0;
		int attempts = 0;
		final int EASY_MODE = 1;// constant for easy mode
		final int MED_MODE = 2;// constant for med mode
		final int HARD_MODE = 3;// constant for hard mode

		while (true) {
			try {
				// Prompt the user to select a difficulty level (1, 2, or 3)
				String userInput = JOptionPane
						.showInputDialog("Let's get started! \nThere are 3 levels of difficulty..."
								+ "\nEasy = 1    Medium = 2    Hard = 3"
								+ "\n\nPlease enter your level of difficulty:");

				if (userInput == null) { // if Cancel button selected
					return -1;
				}
				// Convert the user's input to an integer
				level = Integer.parseInt(userInput);

				switch (level) {// To evaluate level entered and set the attempts corresponding to the level

				case EASY_MODE:// if user enters level 1, they enter easy mode with 7 attempts to guess
					attempts = 7;
					return attempts;
				case MED_MODE:// if user enters level 2, they enter easy mode with 5 attempts to guess
					attempts = 5;
					return attempts;
				case HARD_MODE:
					attempts = 3;// if user enters level 3, they enter easy mode with 3 attempts to guess
					return attempts;
				default:
					throw new Exception("Please enter a level from 1-3");// if user inputs out of range int
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,
						"Invalid input. Please enter an integer from 1-3 to select a level.", "INPUT INVALID!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public static int playGame(int counter, StringBuilder guessedWord, String randWord, String photoName) {// main portion of the code to play game

		final int MAX_ATTEMPTS_REACHED = 0;
		final int ONE_LETTER_GUESS = 1;
		int[] photoIndex = new int [counter];
		while (counter > MAX_ATTEMPTS_REACHED) {// while counter is greater than the max attempts, player can play the game
			// To display guessed word progress and number of guesses left after every attempt
			String displayMessage = "Current Word: " + guessedWord + "\nIncorrect guesses left: " + counter;
			ImageIcon hungman = new ImageIcon(photoName + photoIndex[counter-1] + ".png");
			try {
				String input = JOptionPane.showInputDialog(null, displayMessage + "\nEnter a letter or a word:", hungman);
				if (input == null) { // if Cancel button selected
					return -1;
				}
				String guess = input.toLowerCase();// guess is set to lowercase so if character/word is typed in uppercase, it can still be excepted
				if (guess.length() == MAX_ATTEMPTS_REACHED || !Character.isLetter(guess.charAt(0)) || !guess.matches("[a-zA-Z]+")) {// to make sure only alphabetical input is entered
					throw new IllegalArgumentException("Only letters/ words");
				}
				if (guess.equals(randWord)) {// for word guess
					return counter;
				} else if ((!(guess.length() == ONE_LETTER_GUESS))) {//
					counter--;
				}
				if (guess.length() == ONE_LETTER_GUESS) {// for single guess
					char guessedLetter = guess.charAt(0);
					if (randWord.contains(String.valueOf(guessedLetter))) {// if the random selected word has the letter guessed, the for loop can proceed
						for (int i = 0; i < randWord.length(); i++) { // This for loop fills in the guessed words blank spaces to be filled with the right letter to reveal to the user
							if (randWord.charAt(i) == guessedLetter) {
								guessedWord.setCharAt(i, guessedLetter);
							}
							if (guessedWord.toString().equals(randWord)) {// for filled in word
								return counter;
							}
						}
					}
					else {
						counter--;
					}
				}
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Invalid input. Please enter a single letter or word.",
						"INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
			}
		}
		return counter;
	}

	public static void displayGameResults(String randWord, int lastGuess, StringBuilder guessedWord, ImageIcon photo) {// method to display results

		int MAX_ATTEMPTS = 0;
		if (guessedWord.toString().equals(randWord) || lastGuess > MAX_ATTEMPTS) {// if the filled out word matches the random word selected than user wins
			JOptionPane.showMessageDialog(null, "Congratulations! You guessed the word: " + randWord, "¿¿¿HANGMAN???", JOptionPane.INFORMATION_MESSAGE, photo);
		}

		else if (lastGuess == MAX_ATTEMPTS) {
			JOptionPane.showMessageDialog(null, "Game over! The word was: " + randWord, "¿¿¿HANGMAN???", JOptionPane.INFORMATION_MESSAGE, photo);
		}
	}
	
	public static void main(String[] args) {
		final int MAX_DEGREE = 10;
		final int MIN_DEGREE = 1;
		final double MAX_DOUBLE = Double.MAX_VALUE;
		final double MIN_DOUBLE = Double.MIN_VALUE;
		double doubleInput = 0; // declaring input
		int intInput = 0; // declaring degree value
		int procedureType = 0;
		int numberOfGuesses = 0;
		boolean fun;
		String stringOutput = "This is a fun calculus-themed program with two functionalities:\nto calculate equation of the tangent line for any polynomial,\nand to play a calculus-themed hangman game!"; // message value is declared
		String photoName = ""; // the variable that will store name of the photo is declared
		StringBuilder guessedWord = new StringBuilder();
		double[] inputtedCoefficients = new double[MAX_DEGREE]; // (array is initialized), must be declared here rather than inside loop
		double[] tangentCoefficients = new double[2]; // (array is initialized), must be declared here rather than inside loop
		ImageIcon imageOutput = new ImageIcon (""); // initializing image object
		programDescription(stringOutput, imageOutput);// describes the program
		while (true) {// forever
			procedureType = chooseProcedure(intInput);
			if (procedureType == 0) {
				fun = false;
				stringOutput = "This is a tool designed to calculate the equation of the tangent line\nfor any numerical point on any polynomial function(with degree less than 10).\nThe program will prompt users for the degree of the polynomial (between 1 and 10),\n the coeffcients of each term, and the x-coordinate of the point.";
				photoName = "";
				imageOutput = new ImageIcon(photoName + ".png"); //creating new icon using specific image name
				programDescription(stringOutput, imageOutput);
				stringOutput = "Please enter the degree of your polynomial (max degree of " + MAX_DEGREE + "):"; // message value is reset for first message to be used (degree, between 1 and 10, integers)
				intInput = (int) validateInput(intInput, MAX_DEGREE, MIN_DEGREE, stringOutput); // degree of polynomial function  is found using validateIntegerInput method, first message is used
				if (intInput == -1) {
                    continue; // Return to homepage
                }
				stringOutput = "Please enter your coefficient: ";// message is changed for use of validateDoubleInput 
				inputtedCoefficients = storeCoefficients(doubleInput, intInput, stringOutput, MAX_DOUBLE, MIN_DOUBLE); //coefficients are stored, stored as double array values
				if (inputtedCoefficients[0] == -1) {
                    continue; // Return to homepage
                }
				stringOutput = "Please enter your x-coordinate"; //updating message for second use of ValidateDoubleInput
				doubleInput = validateInput(doubleInput, MAX_DOUBLE, MIN_DOUBLE, stringOutput); // finding x coordinate using validate double input method, third message is used
				if (doubleInput == -1) {
                    continue; // Return to homepage
                }
				tangentCoefficients = calculateEquation(intInput, inputtedCoefficients, doubleInput); // array with tangent coefficients is saved
				photoName = choosePhoto(inputtedCoefficients[intInput], intInput, photoName, stringOutput, numberOfGuesses, guessedWord, fun); // will pick photo file depending on function characteristics
				imageOutput = new ImageIcon(photoName + ".png"); //creating new icon using specific image name
				displayCalculation(inputtedCoefficients, tangentCoefficients, doubleInput, imageOutput); // displays the results with the initial coefficients, tangent coefficients, and x-coordinate
			}
			
			if (procedureType == 1) {
				fun = true;
				stringOutput = "Welcome to Hangman.\nIn this game you will be given a mystery word, \nand it's your task to find it by guessing letter by letter,\nif you feel confident, guess the word too!";
				photoName = "HangMan";
				imageOutput = new ImageIcon(photoName + ".png"); //creating new icon using specific image name
				programDescription(stringOutput, imageOutput);// To tell the user about the program
				stringOutput = getRandomWord(wordBank()); // method to find a word from Static Word Bank
				intInput = selectDifficulty();
				if (intInput == -1) {
                    continue; // Return to homepage
                }
				guessedWord = startGame(stringOutput);// Method that creates a blank string that can be filled												// through guess
				if (guessedWord.equals(-1)) {
                    continue; // Return to homepage
                }
				numberOfGuesses = playGame(intInput, guessedWord, stringOutput, photoName); // Method that goes through the Hangman game
				photoName = choosePhoto(inputtedCoefficients[intInput], intInput, photoName, stringOutput, numberOfGuesses, guessedWord, fun);
				imageOutput = new ImageIcon(photoName + ".png"); //creating new icon using specific image name
				displayGameResults(stringOutput, numberOfGuesses, guessedWord, imageOutput);// To display game results
			}
		} // while
	} // main
}// class