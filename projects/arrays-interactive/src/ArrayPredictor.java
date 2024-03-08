/* This is a program designed to perform either linear or binary search for a 1-d array of length 2^n, where n is a whole number. 
 * In light of the patterns that follow arrays arrays sorted with consecutive integers of this length, this program is able to predict 
 * the efficiency of both searches using some simple math, presents this information to the user, 
 * and allows the user to choose and performs the search they wish to choose. 
 * This program embodies the idea of using the smart answer for the right answer - however, with this example, the user
 * has been given the power to make this decision.
 * Author: Krish Punjabi
 * Date: March 8, 2024
 */

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ArrayPredictor	{  
	
	public static int numOfBinaryIter = 0; //tracks the number of iterations through the array; it is a static variable modified
	                                 //in the binarySearch method. Since that method must return the key index, it cannot return 
	                                 //numOfIter as well. Therefore, this variable is declared as static
	
	public static int numOfLinearIter = 0; //tracks the number of iterations through the array; it is a static variable modified
    								//in the linearSearch method. Since that method must return the key index, it cannot return 
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
	
	public static boolean predictIters(int arrayLength, int key) { // this method performs a prediction for the number of iterations it will take to find a specific key using very simple calculations
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
		if (numOfBinaryIter < numOfLinearIter) { //the first part calculates the iterations, this returns the a tru or false result base on the type of search based on which takes less iterations
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String compareAndChooseSearchType(int arrayLength, int key) { // this method compares the efficiency of the search types using the number of iteration, and assigns one as the
		//faster process and one as the slower.
		boolean binaryFaster = predictIters(arrayLength, key); //receives true or false result - true for binary efficiency, false for linear
		String faster = "binary search"; //sets variables as if condition was true. if not, values are reversed
		int fasterIter = numOfBinaryIter;
		String slower = "linear search";
		int slowerIter = numOfLinearIter;
		String temp = ""; //since faster and slower might need to swap values, and they aren't static, a temporary variable is needed
		if (binaryFaster == false) { //values swapped
			temp = faster;
			faster = slower;
			slower = temp;
			fasterIter = numOfLinearIter;
			slowerIter = numOfBinaryIter;
		}
		return chooseProcedure(faster, fasterIter, slower, slowerIter); //with this info, choose procedure method is run and results are returned - user will know which search is more efficient
		//and will be able to choose which one they would prefer to use.
		// this will be on same dialog box as information about each array
	}
	
	public static String chooseProcedure(String faster, int fasterIter, String slower, int slowerIter) { // this method allows the user to choose the procedure after displaying all the info
		JLabel message = new JLabel ("<html>Based on the array length and key you have inputted, this program believes that\n" + faster + " will be more efficient than " + slower + " by approximately " + (slowerIter - fasterIter) + " iterations."
				+ "<br><br><font size ='4' color=green>  " + faster.toUpperCase() + " PREDICTED ITERATION COUNT: " + fasterIter + " </font>"
				+ "<br><br><font size ='4' color=red>" + slower.toUpperCase() + " PREDICTED ITERATION COUNT: " + slowerIter + " </font></html>"
				+ "<br><br>Choose how you would like to proceed:"); //stored as JLabel and uses html codes to colour more efficient and less efficient search to distinguish + aesthetic appeal
		String[] options = {"LINEAR","BINARY","BOTH","CANCEL"}; //using showOptionDialogue, to choose which search to proceed with. User also has option to do both searches side by side
		int choice = JOptionPane.showOptionDialog(null, message, "Prediction!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (choice == 0) {// linear button, linear message is sent out
			return "LINEAR SEARCH";
		}
		if (choice == 1) {// binary button, binary message is sent out
			return "BINARY SEARCH";
		}
		else if (choice == 2) {// if both is pressed, corresponding message
			return "BOTH SEARCHES'";
		}
		else {// if index of input is the final index (cancel button) or -1 (x button), program is terminated
			goodBye(); //closes program
			return null; // to satisfy method return values, will never get to this point because of goodbye
		}
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
			else ++first; //the array is effectively shortened, the key is still ahead.
		} 
		return index;
	}  
	
	public static int doSearch(String searchType, int arr[], int key){ // this method takes the input and executes the specific csearch - linear, binary or both
		int index = 0;
		if (searchType.equals("LINEAR SEARCH"))
			return linearSearch(arr, key);
		if (searchType.equals("BINARY SEARCH"))
			return binarySearch(arr, key);
		else { // will do both searches, the index will be taken for the binary search (doesn't matter, which one is taken, both will be equal)
			linearSearch(arr, key);
			index = binarySearch(arr, key);
			return index;
		}
	} 
	
	public static void displayResults(final int KEY, int keyIndex, int[] arr, String searchType) { //results are displayed
	    String title = searchType + " RESULTS"; //title is updted according to search type
	    String message1 = "The key " + KEY + " is found at the index " + keyIndex + " in the array \ncontaining consecutive numbers from " + arr[0] + " to " + arr[arr.length - 1] + "."; //shows index of key
	    String message2 = "The binary process took " + numOfBinaryIter + " iterations!\nThe linear process took " + numOfLinearIter + " iterations!"; //by default, will show both messages.
	    //if only one search is requested, will take specific substring
	    String binarySubstring = message2.substring(0, (message2.lastIndexOf("T"))); //substring of binary message above
	    String linearSubstring = message2.substring(message2.lastIndexOf("T"), message2.length()); //substring of linear message
	    JLabel messageLabels = chooseColour(message2, searchType, binarySubstring, linearSubstring); //label is created with substrings to add colour

	    char messageType = JOptionPane.INFORMATION_MESSAGE;

	    /*  if (keyIndex == -1) { //not necessary here since exceptions are handled through validate input
        message1 = "The key " + KEY + " is NOT found in the array " + Arrays.toString(arr);
        messageType = JOptionPane.WARNING_MESSAGE;
    	} */
	    messageLabels.setText("<html>" + message1 + "<br>" + messageLabels.getText() + "</html>"); //sets message into place with html codes and line break
	    
	    JOptionPane.showMessageDialog(null, messageLabels, title, messageType); // this message is displayed to the user
	    resetIters();
	}

	
	public static JLabel chooseColour(String message, String searchType, String binarySubstring, String linearSubstring) { //this method assigns colours to the specific substrngs depending on efficiency
	    String red = "color=red>";
	    String green = "color=green>";
	    String colour1 = "";
	    String colour2 = "";
		JLabel[] messageLabel = new JLabel [3]; //array of JLabels is created
	    if (numOfBinaryIter < numOfLinearIter) { //specific cases are assigned
	    	colour1 = green;
	    	colour2 = red;
	    }
	    else {
	    	colour2 = green;
	    	colour1 = red;
	    }
	
	    messageLabel [0] = new JLabel("<html><font size ='3' "  + colour1 + binarySubstring + "</font></html>"); //binary JLabel
	    messageLabel [1] = new JLabel("<html><font size ='3' "  + colour2 + linearSubstring + "</font></html>"); //linear JLabel
	    messageLabel [2] = new JLabel("<html><font size ='3' " + colour1 + binarySubstring + "</font><br><font size ='3' " + colour2 + linearSubstring + "</font></html> "); //both messages in one JLabel
	    
	    if (searchType.equals("BINARY SEARCH")) //returns corresponding JLabel
	        return messageLabel[0];
	    else if (searchType.equals("LINEAR SEARCH"))
	        return messageLabel[1];
	    else
	    	return messageLabel[2];
	}

	public static void main(String args[]){  
		
		int key; //will store key
		int index = 0; //will act as constant for number 0 and also will hold index later on
		int startingValue = 1; //starting value for consecutive numbers, necessary to validate input as minimum value
		int[] arr; //array is declared
		int arrayN; //this will hold the value of n in 2^n, to determine the length of the array
		String searchType; //String is declared to hold search type
		final int MEMORY_ADJUSTMENT = 2; //memory adjustment, can be increased to align with memory capacity of respective computer
		final int MAXN = (int) ((Math.log(Integer.MAX_VALUE))/(Math.log(2)) - MEMORY_ADJUSTMENT); // upper bounds on n values, will work for the log 2 of the max integer value
		//memory adjustment had to be included due to limited memory capacity on my computer
		
		programDescription(); // initial description message
		
		while (true) {
		arrayN = validateInput(MAXN, "Please enter n, where array length = 2^n", index, ". "); //finds n, where 2^n is the length of the array
		arr = initializeArray(arrayN); //array is initialized with length
		key = validateInput(arr.length, "Please enter your key", startingValue, ". This intger will not be found in this array."); //key is stored from user input
		searchType = compareAndChooseSearchType(arr.length, key); //chooses search type, returns type of search
		index = doSearch(searchType, arr, key); //search is done depending on prediction, index is returned
		displayResults(key, index, arr, searchType); //results are displayed
		}
	}  
}  