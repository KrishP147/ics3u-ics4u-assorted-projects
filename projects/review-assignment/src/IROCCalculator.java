/*
 * This is a program that calculates the equation of the tangent line to any point on a polynomial function, collecting input from the user and displaying the result to the user using JOPTIONPANE.
 * The program does this calculation using the Power Rule, a fundamental calculus theorem used to calculate the IROC of polynomial functions.
 * Author: Krish Punjabi and Isimbi Karama
 * Date: February 8, 2024
 */

import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class IROCCalculator {

	public static void programDescription() {// This method displays a simple description of the program to the user.
		JOptionPane.showMessageDialog(null, "This is a tool designed to calculate the equation of the tangent line for any numerical point on any polynomial function (with degree less than 10).\nThe program will prompt users for the degree of the polynomial (between 1 and 10), the coeffcients of each term, and the x-coordinate of the point.");
	}

	public static int validateIntegerInput(int input, int maxValue, int minValue, String message) { // this method receives the input from the user and validates it. This method is to calculate the degree of the polynomial, which must be an integer
		boolean validInput = false; // will become true after passing try and catch
		String userInput = ""; // declaring String input variable
		while (!validInput) { // will run while input is not valid, will try and catch value
			try { // tries to convert string to integer, if fails, catch block is executed
				userInput = JOptionPane.showInputDialog(null, message);
				if (userInput == null)// if cancel button is pressed, program terminates
					goodBye();
				input = Integer.parseInt(userInput);
				if ((input < minValue || input > maxValue)) {
					throw new Exception(); // in the case that the answer is not within the specific range of acceptable answers, an exception will be thrown.
				}
				validInput = true; // since this line is executed
			} catch (NumberFormatException e) {// shows error message and repeats loop until input is valid (an integer) or program is exited
				JOptionPane.showMessageDialog(null, "You entered invalid input. Please enter an integer" + "\nPlease try again!", "INPUT INVALID!",JOptionPane.ERROR_MESSAGE);
			} catch (Exception f) {// in the case the input isn't within specified range, this message will show up
				JOptionPane.showMessageDialog(null, "You entered invalid input. " + "\nPlease enter a value between " + minValue + " and " + maxValue, "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
			}
		}
		return input;
	}
	
	public static double validateDoubleInput(double input, String message) { // this method receives the input from the user and validates it. This method is used multiple times, to verify double values (for the x coordinate and the coefficients of the polynomial)
		boolean validInput = false; // will become true after passing try and catch
		String userInput = ""; // declaring String input variable
		while (!validInput) { // will run while input is not valid, will try and catch value
			try { // tries to convert string to double, if fails, catch block is executed
				userInput = JOptionPane.showInputDialog(null, message);
				if (userInput == null)// if cancel button is pressed, program terminates
					goodBye();
				input = Double.parseDouble(userInput);
				validInput = true; // since this line is executed
			} catch (NumberFormatException e) {// shows error message and repeats loop until input is valid (a double) or program is exited
				JOptionPane.showMessageDialog(null, "You entered invalid input. Please enter a double value (can use decimals)" + "\nPlease try again!", "INPUT INVALID!",JOptionPane.ERROR_MESSAGE);
			} 
		}
		return input;
	}

	public static double[] storeCoefficients(double inputtedCoeffecients, int degree, String message) {// this methods initializes and returns a double  array to store the various coefficients of the initial function
		double[] storedCoeffecients = new double[degree + 1]; // you can have a max of degree + 1 coefficients in a polynomial, hence this will be the length of the array
		String writtenDegree = "";
		for (int i = degree; i >= (0); i--) { // for simplicity, index number = degree of term, as user inputs coeffcient, degree will decrease until complete
			writtenDegree = " (degree " + i + ")"; // adding a specification to which degree the inputed coefficient will correspond with to the message
			storedCoeffecients[i] = validateDoubleInput(inputtedCoeffecients,(message + writtenDegree)); // will validate all input then will store in array at index corresponding to degree
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
	
	public static String chooseImage(double leadingCoefficient, int degree, String photoName) {// this method chooses the name of the image file depending on the characteristics of the initial function
		photoName = "";
		// Using the switch command to display different messages depending on the specific case
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
		return photoName; // array value at this index is returned
	}
	public static void displayResult(double[] initialCoefficients, double[] tangentCoeffcients, double x, ImageIcon graph) {// this method displays the results - the equation of the tangent, the initial equation, the y coordinate, etc.
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

	public static void main(String[] args) {
		final int MAX_DEGREE = 10;
		final int MIN_DEGREE = 1;
		double userInput = 0; // declaring input
		int degree = 0; // declaring degree value
		double x = 0; // declaring x-coordinate
		String message = ""; // message value is declared
		String photoName = ""; // the variable that will store name of the photo is declared
		double[] initialArray = new double[MAX_DEGREE]; // (array is initialized), must be declared here rather than inside loop
		double[] tangentArray = new double[2]; // (array is initialized), must be declared here rather than inside loop
		ImageIcon graph; // initializing image object
		programDescription();// describes the program
		while (true) {// forever
			message = "Please enter the degree of your polynomial (max degree of " + MAX_DEGREE + "):"; // message value is reset for first message to be used (degree, between 1 and 10, integers)
			degree = validateIntegerInput(degree, MAX_DEGREE, MIN_DEGREE, message); // degree of polynomial function  is found using validateIntegerInput method, first message is used
			message = "Please enter your coefficient: ";// message is changed for use of validateDoubleInput 
			initialArray = storeCoefficients(userInput, degree, message); //coefficients are stored, stored as double array values
			message = "Please enter your x-coordinate"; //updating message for second use of ValidateDoubleInput
			x = validateDoubleInput(userInput, message); // finding x coordinate using validate double input method, third message is used
			tangentArray = calculateEquation(degree, initialArray, x); // array with tangent coefficients is saved
			photoName = chooseImage(initialArray[degree], degree, photoName); // will pick photo file depending on function characteristics
			graph = new ImageIcon(photoName + ".png"); // creating new icon using specific image name
			displayResult(initialArray, tangentArray, x, graph); // displays the results with the initial coefficients, tangent coefficients, and x-coordinate
		} // while
	} // main
}// class