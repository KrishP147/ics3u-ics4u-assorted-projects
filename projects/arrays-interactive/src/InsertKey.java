/* This program demonstrates 1D array linear and binary search, of array length 1024
 * Author: Krish Punjabi
 * Date: March 8 2024
 */

import java.util.Arrays;

import javax.swing.JOptionPane;

public class InsertKey{  
	
	public static void programDescription() {
		JOptionPane.showMessageDialog(null, "This class prompts the user to insert elements in a randomly initialized, sorted array.\n","Key Insertion", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void goodBye() { // this method displays a goodbye message to the user
		JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
		System.exit(0);// closes the program
	}
	
	public static int validateInput(int[] arr, String message){ //this method simply receives input from the user and validates it
	
		int input = 0; 
		
		boolean validInput = false; //will become true after passing try and catch
		String userInput = ""; //declaring String input variable
		while (!validInput) { //will run while input is not valid, will try and catch value	
			try { //tries to convert string to integer, if fails, catch block is executed
				userInput = JOptionPane.showInputDialog(null, message + Arrays.toString(arr));
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
	    int[] arr = new int [10];  //array is sorted through initialization - length is 1024
	    for (int i = 0; i <= arr.length - 1; i++) { // for each index of the array, the number that is 1 + that index is stored - ex: at 0, 1 is stored, etc, to have an array of consecutive integers from 1 - 1024
	    	arr[i] = (int) ((Math.random()*100) + 1); 
		} // for
    	Arrays.sort(arr);
		return arr;
	}
	
	public static int[] searchArray(int []arr, int key, int index) {
		int [] newArr = new int [arr.length + 1];
		System.arraycopy(arr, 0, newArr, 0, index);
		System.arraycopy(arr, index, newArr, index+1, arr.length-index);
		newArr[index] = key;
		return newArr;
	}
	
	public static int linearSearch(int arr[], int key){ 
		 for (int i = 0; i < arr.length; i++) {
		        if (key <= arr[i]) {
		            return i; // Return the index if the key is less than or equal to the current element
		        }
		    }
		    return arr.length; // Return the index after the loop if the key is greater than all elements
		}

	public static void displayResults(final int KEY, int index, int[] arr, int[] newArr) { // this method displays the results of both searches along with the iterations for each search
		
		String title = "SEARCH RESULTS";
		String message1 = "Element " + KEY + " inserted at index " + index + ".\nOriginal array: " + Arrays.toString(arr) + ".\nNew array: " + Arrays.toString(newArr);
		char messageType = JOptionPane.INFORMATION_MESSAGE;		
	    JOptionPane.showMessageDialog(null, message1, title, messageType);
	}
	
	public static void main(String args[]){  
		
		int key;
		int index;
		int[] arr;
		int[] newArr;
		
		programDescription();
		arr = initializeArray();
		
		while (true) {
		key = validateInput(arr, "Enter an element to insert to: ");
		index = linearSearch (arr, key);
		newArr = searchArray(arr, key, index); 
		displayResults(key, index, arr, newArr);
		arr = newArr;
		}
	}  
}  