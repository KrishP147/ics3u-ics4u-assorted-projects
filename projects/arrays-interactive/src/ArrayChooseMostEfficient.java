/* This is a program designed to perform either linear or binary search for a 1-d array of length 2^n, where n is a whole number. 
 * In light of the patterns that follow arrays arrays sorted with consecutive integers of this length, this program is able to predict 
 * the efficiency of both searches using some simple math, and with this information, chooses and performs the appropriate search. 
 * This program embodies the idea of using the smart answer for the right answer - however, with this example, the computer
 * has been given the power to make this decision.
 * Author: Krish Punjabi
 * Date: March 8, 2024
 */

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ArrayChooseMostEfficient	{  
	
	public static int numOfBinaryIter = 0; //tracks the number of iterations through the array; it is a static variable modified
	                                 //in the binarySearch method. Since that method must return the key index, it cannot return 
	                                 //numOfIter as well. Therefore, this variable is declared as static
	
	public static int numOfLinearIter = 0; //tracks the number of iterations through the array; it is a static variable modified
    								//in the lineaarSearch method. Since that method must return the key index, it cannot return 
									//numOfIter as well. Therefore, this variable is declared as static
	
	public static void programDescription() { //introduces program to user
		JOptionPane.showMessageDialog(null, "This class anaylzes user input, and accordingly applies a linear or a binary search algorithm, with arrays of length 2^n!","BINARY SEARCH", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void goodBye() { // this method displays a goodbye message to the user
		JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
		System.exit(0);// closes the program
	}
	
	public static void resetIters() { // this method resets the number of iterations together - since these are static variables, they 
		//need to be manually reset upon each iteration of the while loop running the program in the main
		numOfBinaryIter = 0;
		numOfLinearIter = 0;
	}
	
	public static int countFactors(int key) { // this method calculates the amount of a specific factors that a specific number has, and returns this number to the user
		int i; //a variable to hold the count of the number of factors
		final int FACTOR = 2; //the number of the factor we are looking for is 2. This is because binary search divides arrays into two
		for (i = 0; (key % FACTOR == 0); i++) { // for the duration that the key is perfectly divisible by a specific factor (2), int i will be increased.  
			  key = key/FACTOR; //as i is increased, the key will be divided by the factor that has just been checked to work
			} // for
		return i;
	}
	
	public static String predictIters(int arrayLength, int key) { // this method performs a prediction for the number of iterations it will take to find a specific key using very simple calculations
		// based on this prediction, the program will be able to decide which searching algorithm will be more efficient
		numOfLinearIter = key; // the linear prediction is simply based on the fact that the number of iterations is equal to the value of the key
		if (key == arrayLength) { // if this is the case, the array length will be equal to log2n + 1 - this is due to the fact that the last number of an array with an even length
        //takes one extra iteration for an edge case - here, the edge case is the last number, since the middle number is determined through integer division (effectively rounding down).
			numOfBinaryIter = (int) (Math.log(arrayLength)/Math.log(2)) + 1; //predictions are temporarily stored in static variable for number of iterations
		}
		else { //otherwise, the number of iterations is equal to log2x, where x is the length of the array, minus the number of factors of two of the specific key. 
			//This is because binary search works by dividing arrays into two - and since the length of the array is 2^n, the midpoint of the array would be 2^n-1
			//this n - 1 value is essentially the number we are finding for the specific key - n being log2x of the length of the array, n - 1 being the number of factors of 2, and 1 
			//being the number of iterations it took to find that number
			numOfBinaryIter = (int) ((Math.log(arrayLength))/((Math.log(2))) - (countFactors(key)));
		}
		if (numOfBinaryIter < numOfLinearIter) { //the first part calculates the iterations, this returns the name of the type of search based on which takes less iterations
			return "BINARY SEARCH";
		}
		else {
			return "LINEAR SEARCH";
		}
	}
	public static int doSearch(int arr[], int key, String searchType){ // this method takes the input from the prediction method, and simply performs the more efficient search
		if (searchType.equals("BINARY SEARCH")) // if the return is binary, it will do a binary search, if not, it will do a linear search - returning their outputs.
			return binarySearch(arr, key);
		else
			return linearSearch(arr, key);
	} 
	public static int validateInput(int arrayRange, String message, int startingValue, String extraError){ //this method simply receives input from the user and validates it
		
		int input = 0; 
		
		boolean validInput = false; //will become true after passing try and catch
		String userInput = ""; //declaring String input variable
		while (!validInput) { //will run while input is not valid, will try and catch value	
			try { //tries to convert string to integer, if fails, catch block is executed
				userInput = JOptionPane.showInputDialog(null, message + " (max " + arrayRange + "):");
				if (userInput == null)//if cancel button is pressed, program terminates
					goodBye();
				input = Integer.parseInt(userInput);
				if (input < startingValue || input > arrayRange)
					throw new Exception (); //in the case that the answer is not within the range of the array, an exception will be thrown.
				validInput = true; //since this line is executed 
			}
			catch(NumberFormatException e) {//shows error message and repeats loop until input is valid (an integer) or program is exited
				JOptionPane.showMessageDialog(null,"You entered invalid input. Please enter an integer" + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception f) {//in the case the input isn't within the range of the array, this message will show up
				JOptionPane.showMessageDialog(null,"You entered invalid input. "+ "\nPlease enter a value between " + startingValue + " and " + arrayRange + extraError, "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);	
			}
		}
		return input;
	}
	public static int[] initializeArray(int arrayLength) {
	    int[] arr = new int [(int) Math.pow(2 , arrayLength)];  //array is sorted through initialization - 2 to the power of the array length inputted by the user
	    for (int i = 0; i <= arr.length - 1; i++) { // for each index of the array, the number that is 1 + that index is stored - ex: at 0, 1 is stored, etc, to have an array of consecutive integers from 1 - 2^n
	    	arr[i] = (i + 1); 
		} // for
		return arr;
	}
		
	//the following method is the binary search algorithm
	//it returns the index of the key found or -1 if the key is not found
	public static int binarySearch(int arr[], int key){ 
		numOfBinaryIter = 0; //this must be reset due to its static nature, before this it was being used to hold and display the predicted values of the iterations through math formulas
		// now it will hold the true results from the search
		int index = -1;   //returns -1 if key not found
		int first = 0, middle = 0, last = arr.length-1;
		while( first <= last ) { // this is repeated until the entire array has been checked - of course, numbers outside the array bounds have already been dealt with
			numOfBinaryIter++;
			middle = (first + last)/2;  //determine the middle index: int division - no decimals
			if (key == arr[middle]) {//the key is found
				index = middle;  //the key is found
            	break; // exit the loop once key is found
			}
			if (key < arr[middle]) last = --middle; //the key is in the first half	     
			else first = ++middle;                  //the key is in the second half
		}	
		return index;
	} 

	public static int linearSearch(int arr[], int key){ 
		numOfLinearIter = 0; //resetting this, was initially used for predictions
		int index = -1;   //returns -1 if key not found
		int first = 0, last = arr.length-1;
		while( first <= last ) {  //similar to binary, runs till all keys have been checked (or key is found)
			numOfLinearIter++;
			if (key == arr[first]) {
			index = first;  //the key is found
        	break; // exit the loop once key is found;  //the key is found	
			}
			else ++first;                  //the array is effectively shortened, the key is still ahead.
		} 
		return index;
	}  
	
	public static void displayResults(final int KEY, int keyIndex, int[] arr, String searchType) { // this method displays the results of the search, along with some additional info
	    int fasterIter = numOfBinaryIter; // binary is assumed to be faster by default, however, if not is updated with if condition
	    int slowerIter = numOfLinearIter;
	    String nonSearchType = "linear search"; // this is the name of the inefficient search type - included in the analysis
		
	    if (numOfLinearIter <= numOfBinaryIter) { // if linear is more efficient (lower number of iterations), all values are reversed.
	    	fasterIter = numOfLinearIter;
	    	slowerIter = numOfBinaryIter;
	    	nonSearchType = "binary search";
	    }
	    
		String title = searchType + " RESULTS"; //type of search becomes title
	    String message1 = "The key " + KEY + " is found at the index " + keyIndex + " in the array \ncontaining consecutive numbers from " + arr[0] + " to " + arr[arr.length - 1] + "."; //displays key and index where it was found
	    JLabel message = new JLabel ("<html>" + message1 // stored as a JLabel so that program can assign colors to specific words - to clearly demonstrate efficiency
	    		//Using html colours to accomplish this 
				+ "<br><br>Using <font size ='4' color=green> " + searchType + " </font> it took <font size ='4' color=green>" + fasterIter + " iterations </font> to find key " + KEY
				+ "!<br><br>It would have taken <font size ='4' color=red>" + slowerIter + " iterations </font> using <font size ='4' color=red>" + nonSearchType + " to find your key.</font>"
				+ "<br><br>This program just <font size ='4' color=green> saved </font>your CPU from running <font size ='4' color=green>" + (slowerIter - fasterIter) + " additional iterations! </font>"
				+ "<br><br>I think you should clap for me.</html>"); //all info is displayed. Note that at any time, only one search is conducted. The value for the opposing search's iterations comes from the prediction
	    		//since its value would have only been reset if its search had been performed.

	    char messageType = JOptionPane.INFORMATION_MESSAGE;

	  /*  if (keyIndex == -1) { //not necessary here since exceptions are handled through validate input
	        message1 = "The key " + KEY + " is NOT found in the array " + Arrays.toString(arr);
	        messageType = JOptionPane.WARNING_MESSAGE;
	    } */
	   
	    JOptionPane.showMessageDialog(null, message, title, messageType); //displaying message
	    resetIters(); //iterations reset
	}
	
	public static void main(String args[]){  
		
		int key; //will store key
		int index = 0; //will act as constant for number 0 and also will hold index later on
		int[] arr; //array is declared
		int arrayN; //this will hold the value of n in 2^n, to determine the length of the array
		String searchType; //String is declared to hold search type
		final int MEMORY_ADJUSTMENT = 2; //memory adjustment, can be increased to align with memory capacity of respective computer
		final int MAXN = (int) ((Math.log(Integer.MAX_VALUE))/(Math.log(2)) - MEMORY_ADJUSTMENT); // upper bounds on n values, will work for the log 2 of the max integer value
		final int STARTING_VALUE = 1; //starting value for consecutive numbers, necessary to validate input as minimum value
		final int ZERO = 0; //starting value for consecutive numbers, necessary to validate input as minimum value
		//memory adjustment had to be included due to limited memory capacity on my computer
		
		programDescription(); // initial description message
		
		while (true) {
		arrayN = validateInput(MAXN, "Please enter n, where array length = 2^n", ZERO, ". "); //finds n, where 2^n is the length of the array
		arr = initializeArray(arrayN); //array is initialized with length
		key = validateInput(arr.length, "Please enter your key", STARTING_VALUE, ". This intger will not be found in this array."); //key is stored from user input
		searchType = predictIters(arr.length, key); //predicts search type, returns type of search
		index = doSearch(arr, key, searchType); //search is done depending on prediction, index is returned
		displayResults(key, index, arr, searchType); //results are displayed
		}
	}  
}  