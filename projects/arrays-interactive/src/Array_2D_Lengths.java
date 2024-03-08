/* This program creates a randomly generated 2d array with a specific number of rows and columns
 * Author: Krish Punjabi
 * Date: April 10 2024
 */

import javax.swing.JOptionPane;


public class Array_2D_Lengths{  
	    public static void programDescription() {
	        JOptionPane.showMessageDialog(null, "This class prompts the user to enter a desired number of rows and columns, then creates a randomly generated 2D array.\n","ARRAY_2D_LENGTHS", JOptionPane.INFORMATION_MESSAGE);
	    }

	    public static void goodBye() { // this method displays a goodbye message to the user
	        JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
	        System.exit(0);// closes the program
	    }

	    public static int validateInput(String message){ //this method simply receives input from the user and validates it
	    	final int MAX_VALUE = 15; //max number of rows/columns
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

	    public static int[][] initializeArray(int rows, int columns) { //method to initialize 2d array
	    	
	    	final int MAX_RANGE = 99; //max value for randomly generated elements, so that all elemnts have 2 digits
	    	final int MIN_RANGE = 10; //min value for randomly generated elements
	    	
	    	int[][] arr = new int [rows][columns];  //2d array is created, with specific number of rows and columns
	        for (int i = 0; i < rows; i++) { 
	        	for (int j = 0; j < columns; j++) { //for each row, elements are stored in a spot for each column
	            arr[i][j] = (int) ((Math.random()*(MAX_RANGE-MIN_RANGE+1)) + MIN_RANGE); //will choose numbers from 10 to 99
	        	}
	        }
	        return arr;
	    }
	    
	    public static String TwoDArraysToString(int[][] arr) {
			//since Arrays.toString doesn't work for 2D arrays, creating a new method to make the 2d array a string
	    	String stringArray = ""; //initial string
	    	for (int i = 0; i < arr.length; i++) {
	        	for (int j = 0; j < arr[0].length; j++) {
	            stringArray += arr[i][j] + " "; // the string is updated for each spot in the array, plus a space
	        	}
	        stringArray += "\n";
	        }
			return stringArray;
		}
	    
	    public static void displayResults(int[][] arr) {
			// simply displays the string containing the 2d array, and the number of rows and columns in the array
			JOptionPane.showMessageDialog(null, "2D Array:\n\n" + TwoDArraysToString(arr) + "\nRow count: " + arr.length + "\nColumn count: " + arr[0].length, "ARRAY_2D_LENGTHS", JOptionPane.INFORMATION_MESSAGE);
		}
	    
	    public static void main(String[] args) {
	    	
	    	int rows;
		    int columns;
		    int[][] arr;
	    
			programDescription();

			while (true) {
				rows = validateInput("Please enter the number of rows you would like in your 2D array:"); //validates input for rows
				columns = validateInput("Please enter the number of columns you would like in your 2D array:"); //validates input for columns
				arr = initializeArray(rows, columns); //array is created
				displayResults(arr); //results are displayed
			}
	    
	    }
	}
