/* This program creates a randomly generated 2d array with a specific number of rows and columns,
 * and calculates the average of each row, displaying and formatting the results to the user with
 * JOPtion Pane.
 * Author: Krish Punjabi
 * Date: April 12 2024
 */

import java.text.DecimalFormat;

import javax.swing.JOptionPane;


public class Array_2D_Average{  
	    public static void programDescription() {
	        JOptionPane.showMessageDialog(null, "This class randomly generates a 2D array, and calculates the average of the elements in each row.\n","ARRAY_2D_AVERAGE", JOptionPane.INFORMATION_MESSAGE);
	    }

	    public static void goodBye() { // this method displays a goodbye message to the user
	        JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
	        System.exit(0);// closes the program
	    }

	    public static int validateInput(String message){ //this method simply receives input from the user and validates it
	    	final int MAX_VALUE = 9; //max number of rows/columns
	    	final int MIN_VALUE = 1; //min number of rows/columns
	        int input = 0; 

	        boolean validInput = false; //will become true after passing try and catch
	        String userInput = ""; //declaring String input variable
	        while (!validInput) { //will run while input is not valid, will try and catch value  
	            try { //tries to convert string to integer, if fails, catch block is executed
	                userInput = JOptionPane.showInputDialog
	                		(null, message);
	                if (userInput == null)//if cancel button is pressed, program terminates
	                    goodBye();
	                input = Integer.parseInt(userInput);
	                if ((input < MIN_VALUE || input > MAX_VALUE)) {
    					throw new IllegalArgumentException(); // in the case that the answer is not within the specific range of acceptable answers, an exception will be thrown.
                    }
                    validInput = true; //since this line is executed
                }
                catch(NumberFormatException e) {//shows error message and repeats loop until input is valid (an integer) or program is exited
                    JOptionPane.showMessageDialog(null,"You entered invalid input. Please enter a integer" + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
                }
                catch (IllegalArgumentException f) {// in the case the input isn't within specified range, this message will show up
    				JOptionPane.showMessageDialog(null, "You entered invalid input. " + "\nPlease enter a value between " + MIN_VALUE + " and " + MAX_VALUE, "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	        return input;
	    }

	    public static double[][] initializeArray(int rows, int columns) { //method to initialize 2d array
	    	
	    	final int MAX_RANGE = 9; //max value for randomly generated elements, so that all elements have 2 digits
	    	final int MIN_RANGE = 0; //min value for randomly generated elements
	    	double rowSum;
	    	double[][] arr = new double [rows][columns + 1];  //2d array is created, extra column for average
	        for (int i = 0; i < arr.length; i++) { 
	        	rowSum = 0;
	        	for (int j = 0; j < (arr[0].length - 1); j++) { //for each row, elements are stored in a spot for each column
	            arr[i][j] = (int) ((Math.random()*(MAX_RANGE-MIN_RANGE+1)) + MIN_RANGE); //will choose numbers from 10 to 99
	        	rowSum += arr[i][j]; //row sum is updated for each column spot in the row
	        	}
	        	arr[i][arr[0].length-1] = (rowSum/(arr[0].length - 1)); //at the final index of the row (average), the rowSum/the length of the row is stored
	        }
	        return arr;
	    }
	    
	    public static String TwoDArraysToString(double[][] arr) {
			//since Arrays.toString doesn't work for 2D arrays, creating a new method to make the 2d array a string
	    	final int SPACING = 12; //experimentally determined number that works for spacing between columns
	    	final int HEADER_OFFSET = 10; //experimentally determined number that works for offset towards right side
	    	final int STAR_OFFSET = 25; //experimentally determined number that works for offset towards right side for stars
	    	final int RESULT_OFFSET = 14; //experimentally determined number that works for offset towards right side for stars
	    	String header = String.format("%" + HEADER_OFFSET + "s", ""); //using string format to add specific number of spaces, consistent spacing
	    	String starRow = String.format("%" + STAR_OFFSET + "s", "***********");
	        
	    	for (int j = 0; j < arr[0].length - 1; j++) {
	            header += String.format("%" + SPACING + "s", "COL " + (j + 1)); // using String.format for consistent spacing
	            starRow += "***********";
	        }
	        header += String.format("%" + (SPACING) + "s" , "AVERAGE"); //spacing applied for last column, average
	        String stringArray = header + "\n " + starRow; // header and starRow are added to string 
	        DecimalFormat df = new DecimalFormat("0.00"); //to format doubles to two decimal places
	        for (int i = 0; i < arr.length; i++) {
	            stringArray += "\nROW " + (i+1) + "  *  "; //rows and solitary star are added
	        	for (int j = 0; j < arr[0].length; j++) {
	                stringArray += String.format("%-" + (j/6 + RESULT_OFFSET) +"s", df.format(arr[i][j])); // array is added to the string
	        	}
	            stringArray += "\n " + starRow; //final star row is added
	        }
	        return stringArray;
	    }
	    
	    public static void displayResults(double[][] arr) {
			// simply displays the string containing the 2d array, and the average of the elements in each row
			JOptionPane.showMessageDialog(null, "2D Array:\n\n" + TwoDArraysToString(arr), "ARRAY_2D_AVERAGE", JOptionPane.INFORMATION_MESSAGE);
		}
	    
	    public static void main(String[] args) {
	    	
	    	int rows;
		    int columns;
		    double[][] arr;
	    
			programDescription();

			while (true) {
				rows = validateInput("Please enter the number of rows you would like in your 2D array:"); //validates input for rows
				columns = validateInput("Please enter the number of columns you would like in your 2D array:"); //validates input for columns
				arr = initializeArray(rows, columns); //array is created
				displayResults(arr); //results are displayed
			}
	    
	    }
	}
