/* This program demonstrates 1D array linear and binary search, of array length 1024
 * This program has one small modification - numbers are rounded up
 * Author: Krish Punjabi
 * Date: March 8 2024
 */

import javax.swing.JOptionPane;

public class ArraySearchCeilModified{  
	
	public static int numOfBinaryIter = 0; //tracks the number of iterations through the array; it is a static variable modified
	                                 //in the binarySearch method. Since that method must return the key index, it cannot return 
	                                 //numOfIter as well. Therefore, this variable is declared as static
	public static int numOfLinearIter = 0; //tracks the number of iterations through the array; it is a static variable modified
    								//in the linearSearch method. Since that method must return the key index, it cannot return 
									//numOfIter as well. Therefore, this variable is declared as static
	
	public static void programDescription() {
		JOptionPane.showMessageDialog(null, "This class demonstrate a use of the linear, and binary search algorithms!\n","BINARY SEARCH", JOptionPane.INFORMATION_MESSAGE);
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
	
	public static int validateInput(int arrayRange, String message){ //this method simply receives input from the user and validates it
	
		int input = 0; 
		
		boolean validInput = false; //will become true after passing try and catch
		String userInput = ""; //declaring String input variable
		while (!validInput) { //will run while input is not valid, will try and catch value	
			try { //tries to convert string to integer, if fails, catch block is executed
				userInput = JOptionPane.showInputDialog(null, message);
				if (userInput == null)//if cancel button is pressed, program terminates
					goodBye();
				input = Integer.parseInt(userInput);
				validInput = true; //since this line is executed 
			}
			catch(NumberFormatException e) {//shows error message and repeats loop until input is valid (an integer) or program is exited
				JOptionPane.showMessageDialog(null,"You entered invalid input. Please enter an integer" + "\nPlease try again!", "INPUT INVALID!", JOptionPane.ERROR_MESSAGE);
			}
		}
		return input;
	}
	
	public static int[] initializeArray() {
	    int[] arr = new int [1024];  //array is sorted through initialization - length is 1024
	    for (int i = 0; i <= arr.length - 1; i++) { // for each index of the array, the number that is 1 + that index is stored - ex: at 0, 1 is stored, etc, to have an array of consecutive integers from 1 - 1024
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
			middle = (int) Math.ceil((first + last)/2); //middle number is found by rounding up
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
	
	public static void displayResults(final int KEY, int keyIndex, int[] arr) { // this method displays the results of both searches along with the iterations for each search
		
		String title = "SEARCH RESULTS";
		String message1 = "The key " + KEY + " is found at the index " + keyIndex + " in the array \ncontaining consecutive numbers from " + arr[0] + " to " + arr[arr.length - 1] + ".";
		String message2 = "The binary process took " + numOfBinaryIter + " iterations!";
		String message3 = "The linear process took " + numOfLinearIter + " iterations!";
		char messageType = JOptionPane.INFORMATION_MESSAGE;
		
		if (keyIndex == -1) { // in the case that they key was not found
			message1 = "The key " + KEY + " is NOT found in the array\ncontaining consecutive numbers from " + arr[0] + " to" + arr[arr.length - 1] + ".";
			message2 = "";
			message3 = "";
			messageType = JOptionPane.WARNING_MESSAGE;
		}
		
	    JOptionPane.showMessageDialog(null, message1 + "\n" + message3 + "\n" + message2 , title, messageType);
	}
	
	public static void main(String args[]){  
		
		int key;
		int binaryIndex;
		int[] arr;
		
		programDescription();
		
		while (true) {
		arr = initializeArray();
		key = validateInput(arr.length, "Please enter your key:");
		linearSearch (arr, key);
		binaryIndex = binarySearch(arr, key); 
		displayResults(key, binaryIndex, arr);
		resetIters();
		}
	}  
}  