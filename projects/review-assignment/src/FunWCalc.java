/*
 * This is a program that serves a dual-functionality: it can calculate the equation of a line tangent to a specific point on a polynomial and 
 * runs a calculus-themed hangman game, collecting various inputs from the user and displaying the results to the user using JOPTIONPANE.
 * Firstly, it calculates the equation of the tangent line to any point on a polynomial function by collecting input from the user.
 * The program does this calculation using the Power Rule, a fundamental calculus theorem used to calculate the IROC of polynomial functions.
 * Secondly, 
 * Author: Krish Punjabi and Isimbi Karama
 * Date: February 20, 2024
 */

import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FunWCalc {

	public static int programDescription(String instructions, ImageIcon photo, int intInput) {// This method is used to describe the specific program to the user
		
		String []options = {"Proceed", "Back", "Cancel"}; //user is given opportunity to proceed, go back after understanding what the program does, or cancel
		intInput = JOptionPane.showOptionDialog(null, instructions, "WELCOME", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, photo, options, options[0]);
		if (intInput == (options.length - 1) || intInput == ((options.length - 1) - (options.length))) {// if index of input is the final index (cancel button) or -1 (x button), program is terminated
			goodBye();
		}
		return intInput; //this value is returned so that the main will know whether to reset loop (back button) or proceed
	}
	
	public static int chooseProcedure(int intInput) {// This method chooses which procedure to go through, using option buttons
		
		String []options = {"Equation of the Tangent Calculator", "Hangman", "Cancel"}; // can either choose the calculator, game, or to cancel
		intInput = JOptionPane.showOptionDialog(null, "Would you like to calculate the Equation of the Tangent or play Hangman?", "How would you like to proceed?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (intInput == (options.length - 1) || intInput == ((options.length - 1) - (options.length))) {// same idea as above, if index is final or -1, will terminate (cancel button or null)
			goodBye();
		}
		return intInput; // communicating procedure type
	}
	
	public static double validateNumericalInput(double input, double maxValue, double minValue, String message) { // this method receives numerical input from the user and validates it.
		
		boolean validInput = false; // will become true after passing try and catch
		String userInput = ""; // declaring String input variable
		while (!validInput) { // will run while input is not valid, will try and catch value
			try { // tries to convert string to double, if fails, catch block is executed
				userInput = JOptionPane.showInputDialog(null, message);
				if (userInput == null)// if cancel button is pressed, program terminates
					goodBye();
				input = Double.parseDouble(userInput); // double, but will work for integers as well, if indicated
				if ((input < minValue || input > maxValue)) {
					throw new IllegalArgumentException(); // in the case that the answer is not within the specific range of acceptable answers, an exception will be thrown.
				}
				validInput = true; // since this line is executed
			} catch (NumberFormatException e) {// shows error message and repeats loop until input is valid (a double) or program is exited
				JOptionPane.showMessageDialog(null, "You entered invalid input. Please enter a rational numerical" + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
			} catch (IllegalArgumentException f) {// in the case the input isn't within specified range, this message will show up
				JOptionPane.showMessageDialog(null, "You entered invalid input. " + "\nPlease enter a value between " + minValue + " and " + maxValue, "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
			}
		}
		return input;
	}

	public static double[] storeCoefficients(double inputtedCoeffecients, int degree, String message, final double MAX_COEFFICIENT, final double MIN_COEFFICIENT) {// This method is exclusively used for the calculator procedure. It initializes and returns a double array to store the various coefficients of the initial function
		double[] storedCoeffecients = new double[degree + 1]; // you can have a max of degree + 1 coefficients in a polynomial, hence this will be the length of the array
		String writtenDegree = "";
		for (int i = degree; i >= (0); i--) { // for simplicity, index number = degree of term, as user inputs coeffcient, degree will decrease until complete
			writtenDegree = " (degree " + i + ")"; // adding a specification to which degree the inputed coefficient will correspond with to the message
			storedCoeffecients[i] = validateNumericalInput(inputtedCoeffecients, MAX_COEFFICIENT, MIN_COEFFICIENT, (message + writtenDegree)); // will validate all input then will store in array at index corresponding to degree
		} // for
		return storedCoeffecients; // return the array
	}

	public static double[] calculateEquation(int degree, double[] initialCoeffecients, double xCoordinate) {// This method is for the calculator. It will calculate the equation of the tangent with the given information
		
		double[] derivativeCoeffecients = new double[degree]; // derivative will have one less term/coefficient than original, hence is equal to degree rather than degree + 1
		double IROC = 0; //IROC = instantaneous rate of change, slope of tangent line
		double yCoordinate = initialCoeffecients[0]; //initializing yCoordinate as constant value of equation (at index/degree 0) since for loop will not have i = 0
		double[] tangentValues = new double[2]; // new array to export IROC and "b" values together
		for (int i = degree; i > 0; i--) { // going through degree values using power law to find derivative coefficients (for f(x) = ax^n, f'(x) = anx^n-1)
			derivativeCoeffecients[i - 1] = ((initialCoeffecients[i]) * (i)); // since we are dealing with i - 1 here, i can never be equal to 0, hence initial array value at [0] is stored as initial yCoordainate value
			IROC += ((derivativeCoeffecients[i - 1]) * Math.pow(xCoordinate, (i - 1))); // solving for IROC by inserting in x coordinate and applying operations in terms of the initial function's degree (i), hence using i - 1, summing IROC values for each degree reduction in coordination with for loop
			yCoordinate += ((Math.pow(xCoordinate, i)) * (initialCoeffecients[i])); // solving for y through initial coefficient, degree and x, summing for each degree through for loop as i--
		} // for
		tangentValues[0] = (int) IROC; // IROC, slope or "m" value
		tangentValues[1] = (int) (yCoordinate - IROC * xCoordinate); // Y intercept,, x^0, or "b" value

		return tangentValues; // return the array
	}
	
	public static String choosePhoto(double leadingCoefficient, int degree, String photoName, String randWord, int lastGuess, StringBuilder guessedWord, boolean fun) {// This method chooses specified photos for the final result of both procedures. There are a lot of parameters because this method must include the information for both procedures, regardless if only one is being used
		
		// A boolean is used to determine which image files to work with, depending on which procedure is running
	   if (fun == false) { //using the boolean fun because the game is probably more fun - fun is false, indicating to the program that the calculator is being used
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
	   if (fun == true) { //the game is being played, can deal with its image files
		   if (guessedWord.toString().equals(randWord) || lastGuess > 0) {
			   photoName = "youWin";
		   }
		   if (lastGuess == 0) {
			   photoName = "youLose";
		   }
	   }
	 return photoName; // array value at this index is returned
	}
	
	public static void displayCalculation(double[] initialCoefficients, double[] tangentCoeffcients, double x, ImageIcon graph) {// this method displays the calculations for the calculator procedure - the equation of the tangent, the initial equation, the y coordinate, etc.
		
		DecimalFormat df = new DecimalFormat("0.00"); //rounding numbers to two decimals
		double m = tangentCoeffcients[0]; //slope value
		double b = tangentCoeffcients[1]; // y-intercept value
		double y = m * x + b; // solving for y using stored m, x and b values in array, rather than importing another variable
		String initialFunction = df.format(initialCoefficients[initialCoefficients.length - 1]) + "x^" + (initialCoefficients.length - 1); // initializing string function value with first term, since there will be one more term than + sign in equation (for loop will require an even number of both + signs and terms).
		for (int i = (initialCoefficients.length - 2); (i >= 0); i--) {
			initialFunction += " + " + df.format(initialCoefficients[i]) + "x^" + (i); // using stored coefficient values at specific positions to formulate complete initial function as a string
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

		String[] words = { "polynomial", "derivative", "tangent", "integral", "discontinuity", "limit", "minimum", "maximum", "product",
				"quotient", "calculus", "conjugate", "indeterminate", "differential", "asymptote", "function", "continuity", "instantaneous", "average",  };
		return words;

	}

	public static String getRandomWord(String[] words) {// method to find random word

		int randomIndex = (int) (Math.random() * words.length); // to find a select a random index from the string of words
		return words[randomIndex];
	}

	public static StringBuilder startGame(String randWord) {// to build String based on letters in the random word selected
		
		StringBuilder guessedWord = new StringBuilder("_".repeat(randWord.length())); // string builder replaces letters within the word with _ the word is not revealed
		return guessedWord;
	}

	public static int selectDifficulty() { 

		final int EASY_MODE = 0;// constant for easy mode
		final int MED_MODE = 1;// constant for med mode
		final int HARD_MODE = 2;// constant for hard mode
		int attempts = 0;

		String[] options = { "EASY", "MEDIUM", "HARD","CANCEL" };
		int selection = JOptionPane.showOptionDialog(null, "Select one:", "Let's play a game!" ,JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

		    //once selection is chosen, a coresponding mode assigned by an integer will determine how much attempts a user can incorrectly guess
			if (selection == EASY_MODE) {

				attempts = 7; 
			}
			else if (selection == MED_MODE) { 

				attempts = 5;
			}
		else if (selection == HARD_MODE) { 

			attempts = 3;
		}
		else {
			goodBye();
		}	    

		return attempts;//Attempts based on mode is returned and will be used in the play game sequence. 
	}

	public static int playGame(int counter, StringBuilder guessedWord, String randWord, String photoName) {// main portion of the code to play game

		final int MAX_ATTEMPTS_REACHED = 0;//Static Variable for one max attempts are reached
		final int ONE_LETTER_GUESS = 1;//Static variable to represent a guess that equals one letter
		
		ImageIcon hungman = null;//Image Icon to update when hangman game is playing
		
		
		while (counter > MAX_ATTEMPTS_REACHED) {// while counter is greater than the max attempts, player can play the game
			// To display guessed word progress and number of guesses left after every attempt
			String displayMessage = "Current Word: " + guessedWord + "\nIncorrect guesses left: " + counter;
			
			try {
				String input = JOptionPane.showInputDialog(null, displayMessage + "\nEnter a letter or a word:", null);
				
				if (input == null) { // if Cancel button selected
					goodBye();
				}
				
				String guess = input.toLowerCase();// guess is set to lowercase so if character/word is typed in uppercase, it can still be excepted
				
				if (guess.length() == MAX_ATTEMPTS_REACHED || !Character.isLetter(guess.charAt(0)) || !guess.matches("[a-zA-Z]+")) {// Conditions to make sure only alphabetical input is entered
					throw new IllegalArgumentException("Only letters/ words"); // if alphabetical input is entered, arguement will be sent to catch block and will be evaluated as invalid input
				}
				
				if (guess.equals(randWord)) {// for word guess that equal
					return counter;
				} else if ((!(guess.length() == ONE_LETTER_GUESS))) {//if a guess is longer than 1 letter, but not the mystery word, counter gets decremented
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
				hungman = new ImageIcon(photoName + counter + ".png"); // this will save the icon with the name of the photo, its index, and the .png ending
				JOptionPane.showMessageDialog(null, "You have " + counter + " incorrect guesses left" , "Hangman", JOptionPane.WARNING_MESSAGE, hungman);
			
			} catch (IllegalArgumentException e) {//To catch invalid input
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

		else if (lastGuess == MAX_ATTEMPTS) {// if the last guess is equal to 0, the user looses 
			JOptionPane.showMessageDialog(null, "Game over! The word was: " + randWord, "¿¿¿HANGMAN???", JOptionPane.INFORMATION_MESSAGE, photo);
		}
	}
	
	public static void main(String[] args) {
		
		final int MAX_DEGREE = 10; //upper limit on degree values for calculator
		final int MIN_DEGREE = 1; //lower limit for degree values
		final double MAX_DOUBLE = Double.POSITIVE_INFINITY; //maximum value that can be inputed for numerical input
		final double MIN_DOUBLE = Double.NEGATIVE_INFINITY; //minimum value that can be inputed
		double doubleInput = 0; // declaring numerical input, used throughout to temporarily store numerical input from user
		int intInput = 1; // declaring integer input, used throughout to hold logical, indirect input from user. Set to 1 to run the program description loop, will escape once 'proceed' button is pressed
		int procedureType = 0; // integer variable indicating which procedure to run is declared
		int numberOfGuesses = 0; // integer variable indicating the number of guesses left for the user in the game is declared
		boolean fun; // boolean indicating whether game is running or not (otherwise calculator is running)
		String stringOutput = "This is a fun calculus-themed program with two functionalities:\nto calculate equation of the tangent line for any polynomial,\nand to play a calculus-themed hangman game!"; // message value is declared, this is the introductory message
		String photoName = ""; // the variable that will store name of the photo is declared
		StringBuilder guessedWord = new StringBuilder(); // isimbi explain this
		double[] inputtedCoefficients = new double[MAX_DEGREE]; // (array is initialized), must be declared here rather than inside loop, will hold coefficients of inputed function terms
		double[] tangentCoefficients = new double[2]; // (array is initialized), must be declared here rather than inside loop, will hold coefficients of tangent line terms to display final result
		ImageIcon imageOutput = new ImageIcon (""); // initializing image object
		while (intInput == 1) { //will run until proceed button at index 2 is pressed, back button at index 1 will keep loop repeating
			intInput = programDescription(stringOutput, imageOutput, intInput);// describes the program
		} // while
		while (true) {// forever
			procedureType = chooseProcedure(intInput); //choosing procedure based on input, storing it
			if (procedureType == 0) { //the calculator is chosen
				fun = false; //false, indication for other methods
				stringOutput = "This is a tool designed to calculate the equation of the tangent line\nfor any numerical point on any polynomial function(with degree less than 10).\nThe program will prompt users for the degree of the polynomial (between 1 and 10),\nthe coeffcients of each term, and the x-coordinate of the point."; //string output message to describe procedure
				photoName = "calcPhoto"; //photo file is updated
				imageOutput = new ImageIcon(photoName + ".png"); //creating new icon using specific image name, for procedure description
				intInput = programDescription(stringOutput, imageOutput, intInput); //getting input after description, will determine if user wants to proceed or go back
					
				if (intInput == 1) { //user wants to go back
					continue; // returns to homepage, start of loop, choosing procedure again
				} // if
				
				stringOutput = "Please enter the degree of your polynomial (max degree of " + MAX_DEGREE + "):"; // message value is reset for first message to be used (degree, between 1 and 10, integers)
				intInput = (int) validateNumericalInput(intInput, MAX_DEGREE, MIN_DEGREE, stringOutput); // degree of polynomial function is validated, using integers
				stringOutput = "Please enter your coefficient: ";// message is changed to indicate to user to input coefficients 
				inputtedCoefficients = storeCoefficients(doubleInput, intInput, stringOutput, MAX_DOUBLE, MIN_DOUBLE); //coefficients are stored, stored as double array values
				stringOutput = "Please enter your x-coordinate"; //updating message to ask user for x coordinate of specific point on function
				doubleInput = validateNumericalInput(doubleInput, MAX_DOUBLE, MIN_DOUBLE, stringOutput); // asking for and validating x coordinate
				tangentCoefficients = calculateEquation(intInput, inputtedCoefficients, doubleInput); // array with tangent coefficients is saved, to use them together when results are required to be displayed
				photoName = choosePhoto(inputtedCoefficients[intInput], intInput, photoName, stringOutput, numberOfGuesses, guessedWord, fun); // photo file is chosen depending on inputed function characteristics, indicated that it is being used for calculator
				imageOutput = new ImageIcon(photoName + ".png"); //creating new icon using specific image name
				displayCalculation(inputtedCoefficients, tangentCoefficients, doubleInput, imageOutput); // displays the results with the initial coefficients, tangent coefficients, and x-coordinate
			} // if
			
			if (procedureType == 1) { //the game is chosen
				fun = true; //true, indication for other methods
				stringOutput = "Welcome to Hangman.\nIn this game you will be given a mystery word, \nand it's your task to find it by guessing letter by letter,\nif you feel confident, guess the word too!"; // string output message to describe procedure
				photoName = "HangMan"; //photo file is updated
				imageOutput = new ImageIcon(photoName + ".png"); //creating new icon using specific image name
				intInput = programDescription(stringOutput, imageOutput, intInput);// To tell the user about the program, getting input after description, will determine if user wants to proceed or go back
				
				if (intInput == 1) { // user wants to go back
					continue; // returns to homepage, start of loop, choosing procedure again
				} // if
				
				stringOutput = getRandomWord(wordBank()); // method to find a word from Static Word Bank
				intInput = selectDifficulty(); //difficulty is stored in intInput variable
				guessedWord = startGame(stringOutput);// Method that creates a blank string that can be filled									
				numberOfGuesses = playGame(intInput, guessedWord, stringOutput, photoName); // Method that goes through the Hangman game,
				photoName = choosePhoto(inputtedCoefficients[intInput], intInput, photoName, stringOutput, numberOfGuesses, guessedWord, fun); //method to choose the photo file is used, depending if user won or lost, indicated that it is being used for game procedure
				imageOutput = new ImageIcon(photoName + ".png"); //creating new icon using specific image name
				displayGameResults(stringOutput, numberOfGuesses, guessedWord, imageOutput);// will display game results
			} // if
		} // while
	} // main
}// class