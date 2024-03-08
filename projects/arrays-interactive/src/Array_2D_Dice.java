/* This program simulates rolling two dice and tracks the results in a visual 2D array.
 * The user can choose the number of sides on each die, and can choose the number of rolls for both.
 * This is a simple JOption Pane and Console design, however this program makes use of multiple 2D arrays 
 * and recursive methods, along with an interesting star pattern layout
 * Author: Krish Punjabi
 * Date: April 13 2024
 */

import java.util.Arrays;

import javax.swing.JOptionPane;


public class Array_2D_Dice{ 
		public static int counter = 0; //counter to separate console output for each roll (only if rolls > 20)
		
	    public static void programDescription() {
	        JOptionPane.showMessageDialog(null, "This class simulates rolling two dice and tracks the results in a visual 2D array.\n","Array_2D_Dice", JOptionPane.INFORMATION_MESSAGE);
	    }

	    public static void goodBye() { // this method displays a goodbye message to the user
	        JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
	        System.exit(0);// closes the program
	    }

	    public static int validateInput(int maxValue, String message){ //this method simply receives input from the user and validates it
	    	final int MIN_VALUE = 1; //min number of rolls, rows and columns
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
	                if ((input < MIN_VALUE || input > maxValue)) {
    					throw new IllegalArgumentException(); // in the case that the answer is not within the specific range of acceptable answers, an exception will be thrown.
                    }
                    validInput = true; //since this line is executed
                }
                catch(NumberFormatException e) {//shows error message and repeats loop until input is valid (an integer) or program is exited
                    JOptionPane.showMessageDialog(null,"You entered invalid input. Please enter a integer" + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
                }
                catch (IllegalArgumentException f) {// in the case the input isn't within specified range, this message will show up
    				JOptionPane.showMessageDialog(null, "You entered invalid input. " + "\nPlease enter a value between " + MIN_VALUE + " and " + maxValue, "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	        return input;
	    }
	    
	    public static int[] rollDice(int firstDieSides, int secondDieSides) { 
	    	//alternatively, could have made this method only roll one die
			
	    	int[]rolls = new int [2]; //an array to store the results of the rolls, since there are two values
	    	//This method chooses a random number from a range specified by the user (the number of sides on the dice)
	    	final int MIN_RANGE = 1; //starting value for randomly generated elements
	    	
	    	rolls[0] = (int)((Math.random()*(firstDieSides-MIN_RANGE+1)) + MIN_RANGE); //first roll
	    	rolls[1] = (int)((Math.random()*(secondDieSides-MIN_RANGE+1)) + MIN_RANGE); //second roll
	    	
	    	return rolls;  //random number generator between 1 and 6
		}
	    
	    public static int[][] storeDiceRolls(int rows, int columns, int rolls) {
	        int[][] diceRolls = new int[rolls][2]; //array to contain each instance of the two rolls - an array in an array, a 2D array

	        for (int i = 0; i < rolls; i++) {
	            diceRolls[i] = rollDice(rows, columns); //dice are rolled
	        }

	        diceRolls = checkDuplicates(diceRolls, rows, columns, rolls); //results are checked for duplicates

	        return diceRolls;
	    }
	    
	    public static int[][] checkDuplicates(int[][] diceRolls, int rows, int columns, int rolls) {
	    	// Check for duplicates
	        for (int i = 0; i < rolls; i++) {
	            for (int j = i + 1; j < rolls; j++) { //starts at i+1 to avoid checking same array twice
	                if (Arrays.equals(diceRolls[i], diceRolls[j])) { //checks if any two results (pairs of two stored in the first array) are equal
	                    diceRolls[j] = rollDice(rows, columns); //re rolls second instance
	                    diceRolls = checkDuplicates(diceRolls, rows, columns, rolls); //this new result is checked once again (small possibility of it still being a duplicate), recursive method
	                }
	            }
	        }
	        return diceRolls;
	    }
	    
	    public static String[][] initializeArray(int[][] diceRolls, int rows, int columns, int rolls) { //method to initialize 2d array
	    	final int FIRST_ROLL = 0; //in arrays containing results, first roll corresponds to first roll in a pair (therefore index is 0)
	    	final int LAST_ROLL = 1; //corresponds to second roll index
	    	String[][] arr = new String [rows][columns];  //2d array is created, with specific number of rows and columns
		    for (int i = 0; i < arr.length; i++) { 
			    for (int j = 0; j < arr[0].length; j++) { //for each row, elements are stored in a spot for each column
			    		arr[i][j] = "(0, 0)"; //the empty values are stored everywhere
		        }
	        }
		   for (int i = 0; i < rolls; i++) { //in separate loop since checking i values that correspond to number of rolls, not number of sides
		    	//checking the visual array at the indices corresponding to the results (can be confusing, because using 2 different 2d arrays)
			    arr[(diceRolls[i][FIRST_ROLL])-1][(diceRolls[i][LAST_ROLL])-1] = ("(" + diceRolls[i][FIRST_ROLL] + "," + diceRolls[i][LAST_ROLL] + ")");
	       }
	        return arr;
	    }
	    
	    public static String TwoDArraysToString(String[][] arr) {
			//since Arrays.toString doesn't work for 2D arrays, creating a new method to make the 2d array a string
	    	final int SPACING = 12; //experimentally determined number that works for spacing between columns
	    	final int HEADER_OFFSET = 10; //experimentally determined number that works for offset towards right side
	    	final int STAR_OFFSET = 25; //experimentally determined number that works for offset towards right side for stars
	    	final int RESULT_OFFSET = 14; //experimentally determined number that works for offset towards right side for stars
	    	String header = String.format("%" + HEADER_OFFSET + "s", ""); //using string format to add specific number of spaces, consistent spacing
	    	String starRow = String.format("%" + STAR_OFFSET + "s", "***********");
	        
	    	for (int j = 0; j < arr[0].length; j++) {
	            header += String.format("%" + SPACING + "s", "COL " + (j + 1)); // using String.format for consistent spacing
	            starRow += "***********";
	        }
	        String stringArray = header + "\n " + starRow; // header and starRow are added to string 
	        for (int i = 0; i < arr.length; i++) {
	            stringArray += "\nROW " + (i+1) + "  *  "; //rows and solitary star are added
	        	for (int j = 0; j < arr[0].length; j++) {
	                stringArray += String.format("%-" + (j/6 + RESULT_OFFSET) +"s", (arr[i][j])); // array is added to the string
	        	}
	            stringArray += "\n " + starRow; //final star row is added
	        }
	        return stringArray;
	    }
	    
	    public static void displayResults(String[][] arr, int[][]diceRolls) {
	    	counter++; //counter is updated every time results are displayed
			String message = "";
			for (int i = 0; i < diceRolls.length; i++) {
	            message += "The dice rolled: " + diceRolls[i][0] + " and " + diceRolls[i][1] + ".\n"; //shows written results
	        }    
			if (diceRolls.length > 20) { //when the written results take up too much space, are printed to console instead
				System.out.println("Attempt " + counter); //counter value is shown to avoid confusion in case of multiple runs of program
				System.out.println(message);
		        message = "Please open the Console to view the results of all " + diceRolls.length + " rolls.\n"; // message is updated to direct user
		    } 
	    	JOptionPane.showMessageDialog(null, message + "\n2D Array:\n\n" + TwoDArraysToString(arr), "ARRAY_2D_DICE", JOptionPane.INFORMATION_MESSAGE);
	    }
	    
	    public static void main(String[] args) {
	    	
	    	final int MAX_SIDES = 9; //limit on max sides to avoid excessively large table
	    	int rolls;
	    	int rows;
	    	int columns;
		    String [][] arr; //array to display results in (x,y) format
		    int [][] diceRolls; //array to store pair of results for each roll
	    
			programDescription();

			while (true) {
				rows = validateInput(MAX_SIDES, "Please enter the number of sides your first dice has"); //validates input for rows
				columns = validateInput(MAX_SIDES, "Please enter the number of sides your second dice has"); //validates input for columns
				rolls = validateInput((rows*columns), "Please enter the number of times you would like to roll the two dice"); //validates input for rolls
				diceRolls = storeDiceRolls(rows, columns, rolls); //results are stored
				arr = initializeArray(diceRolls, rows, columns, rolls); //array is created
				displayResults(arr, diceRolls); //results are displayed
			}
	    
	    }
	}
