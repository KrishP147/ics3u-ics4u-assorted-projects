/* The merge method merges two sorted arrays into a third larger sorted array
 * This algorithm works by comparing the first index of both arrays,
 * choosing the smaller element, and increasing the index of the chosen array by 1
 * and continuing to compare. If the length of one array is completely added,
 * the second array is automatically added for the rest of the length of the merged array.
 * This algorithm takes advantage of the fact that the initial two arrays are already sorted. 
 * Author: Krish Punjabi
 * Date: April 5, 2024
 */
import java.util.Arrays;
import javax.swing.JOptionPane;



public class MergeSortedArrays {
	//Krish's Version
	
	public static int[] mergeArrays(int[] a, int[] b, int response, String[]options) {
		
		int mergedArray[] = new int [a.length + b.length];
		int aIndex = 0, bIndex = 0;
		
		//from start to end of new array
		for (int i = 0; i < mergedArray.length; i++) {
			
			if (aIndex >= a.length) { //done with array "a", copy over "b"
				mergedArray[i] = b[bIndex]; //rest of merged array is equivalent to rest of array b
			    bIndex++; //index of b is incremented to match incrementing index of merged array.
			}
			else if (bIndex >= b.length) { //done with array "b", copy over "a"
				mergedArray[i] = a[aIndex]; //rest of merged array is equivalent to rest of array a
				aIndex++; //index of a is incremented to match incrementing index of merged array.
		    }
			else if (a[aIndex] < b[bIndex]) { //"a" is smaller, copy over a
				mergedArray[i] = a[aIndex]; // a is smaller, so the element at this index of a is inputed into the merged array.
				aIndex++; // the index of a is updated to allow for another comparison between a and b
			}
			else { //"b" is smaller, copy over b
				mergedArray[i] = b[bIndex]; //b is smaller (or is equal to a), so the element at this index of a is inputed into the merged array.
				bIndex++; // the index of a is updated to allow for another comparison between a and b
			}
		}
		response = JOptionPane.showOptionDialog(null, "The merged, sorted array is:\n" + Arrays.toString(mergedArray),"Merged Array", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		if (response == (options.length - 1) || response == ((options.length - 1) - (options.length))) {// if index of input is the final index (cancel button) or -1 (x button), program is terminated
			goodBye();
		}
		return mergedArray;
	}
	
	public static int[] mergeArraysTwo(int[] a, int[] b, int response, String[] options) {//alternatively, this method simply stores all the numbers from the first two arrays into one,
	//then simply sorts the merged array at the end
		
		int mergedArray[] = new int [a.length + b.length];
		int aIndex = 0, bIndex = 0;
		
		//from start to end of new array
		for (int i = 0; i < (mergedArray.length); i++) {
			
			if (aIndex < a.length) { //for the length of array a
				mergedArray[i] = a[aIndex]; //all of array a is stored into the merged array
				aIndex++; //index of a is incremented to match incrementing index of merged array.
			}
			else { //done with array "a", copy over "b"
				mergedArray[i] = b[bIndex]; //rest of merged array is equivalent to rest of array b
			    bIndex++; //index of b is incremented to match incrementing index of merged array.
			}
		}
		
		Arrays.sort(mergedArray); // array is sorted at the end
		response = JOptionPane.showOptionDialog(null, "The merged, sorted array is:\n" + Arrays.toString(mergedArray),"Merged Array", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		if (response == (options.length - 1) || response == ((options.length - 1) - (options.length))) {// if index of input is the final index (cancel button) or -1 (x button), program is terminated
			goodBye();
		}
		return mergedArray;
	}
	
	public static void programDescription() {
        JOptionPane.showMessageDialog(null, "This class generates two randomly initialized, sorted arrays, and merges them into one large array.\n","Array Merge", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void goodBye() { // this method displays a goodbye message to the user
        JOptionPane.showMessageDialog(null, "Thank you for interacting with this program! Hope you had fun!");
        System.exit(0);// closes the program
    }
    
    public static void results(int[] a, int[] b, int[] c, int response, String[] options) { // this method asks the user if they would like to proceed after one iteration of the loop
    	response = JOptionPane.showOptionDialog(null, "\nArray 1: " + Arrays.toString(a) + "\nArray 2: " + Arrays.toString(b) + "\nMerged Array: " + Arrays.toString(c),"Results", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		if (response == (options.length - 1) || response == ((options.length - 1) - (options.length))) {// if index of input is the final index (cancel button) or -1 (x button), program is terminated
			goodBye();
		}
    }
    
    public static int[] initializeArray(String order, int response, String[] options) {
    	final int MAX_SIZE = 10;
    	final int MIN_SIZE = 5;
    	final int MAX_RANGE = 100;
    	final int MIN_RANGE = 1;
    	
    	int size = (int) ((Math.random()*(MAX_SIZE-MIN_SIZE+1)) + MIN_SIZE); //will choose numbers from 5 to 10
    	int[] arr = new int [size];  //array is sorted through initialization - length is 1024
        	for (int i = 0; i <= arr.length - 1; i++) { // for each index of the array, the number that is 1 + that index is stored - ex: at 0, 1 is stored, etc, to have an array of consecutive integers from 1 - 1024
        		arr[i] = (int) ((Math.random()*(MAX_RANGE-MIN_RANGE+1)) + MIN_RANGE); //will choose numbers from 1 to 100 
        	} // for
        Arrays.sort(arr);
        response = JOptionPane.showOptionDialog(null, "The " + order.toLowerCase() + " sorted array is:\n" + Arrays.toString(arr), order + " Array", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		if (response == (options.length - 1) || response == ((options.length - 1) - (options.length))) {// if index of input is the final index (cancel button) or -1 (x button), program is terminated
			goodBye();
		}
        return arr;
    }
	
	public static void main(String[] args) {
		
		int[] a;
		int[] b;
		int[] c;
		int response = 0;
		String []options = {"Proceed", "Cancel"}; //user is given opportunity to proceed, or cancel
		
		programDescription();
		while (true) {
			a = initializeArray("First", response, options);
			b = initializeArray("Second", response, options);
			c = mergeArrays(a, b, response, options);
			//c = mergeArraysTwo(a, b, response, options); //alternative for above line, will perform same function
			results(a, b, c, response, options); // shows all three arrays together
		}
		
	}
}