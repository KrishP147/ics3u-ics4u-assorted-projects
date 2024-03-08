
public class ArraySortMethods {
	
	public static int[] bubbleSort(int[] arr) {//bubble sort: if adjacent elements arr[j] > arr[j+1], then swap them
		// bubble sort = pairs of adjacent elements are compared, and the elements
		//		            swapped if they are not in order.
		
		//				 Quadratic time O(n^2)
		//				 small data set = okay-ish
		//				 large data set = BAD (plz don't)
		int temp; // temporary variable for swapping elements

		for (int i = 0; i < arr.length; i++)  {
			for (int j = 0; j < arr.length-1-i; j++) { 
				if (arr[j] > arr[j+1]) { //swap the elements
					temp =  arr[j]; 
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				} //if
			} //for j
		} //for i
        return arr;
	} //bubbleSort
	
	public static int[] insertionSort(int[] arr) {
	    
		// Insertion sort = after comparing elements to the left,
		//				shift elements to the right to make room to insert a value
		
		//				Quadratic time O(n^2)
		//				small data set = decent
		//				large data set = BAD
		
		//				Less steps than Bubble sort
		//				Best case is O(n) compared to Selection sort O(n^2)
		
		int n = arr.length;

	    for (int i = 1; i < n; i++) { //start at second element (index 1)
	        int key = arr[i]; //this is our key
	        int j = i - 1; //the second number is the one just behind the key

	        // Move elements of arr[0..i-1], that are greater than key,
	        // to one position ahead of their current position
	        while (j >= 0 && arr[j] > key) {//while the key behind it is larger, it is moved one spot to the right (keeps going until is smaller, key can be inserted)
	            arr[j + 1] = arr[j];// array at index of key is changed to value that was behind (according to while loop)
	            j--; //j is updated to check spot that is now two behind the key. process will continue with while loop
	        }
	        arr[j + 1] = key; //after moving all larger elements to the right, key is placed at new location (j was intially i - 1, so compensating for that with + 1)
	    }
	    return arr;
	}

	
	public static int[] selectionSort(int[] arr) {
        
		// selection sort = search through an array and keep track of the minimum value during 
		//			         each iteration. At the end of each iteration, we swap values.
		
		//				 Quadratic time O(n^2)
		//				 small data set = okay
		//				 large data set = BAD
		
		int n = arr.length; 

		for (int i = 0; i < n-1; i++)  {
			int min_idx = i; //current index that is being checked is stored as min index right off the bat
			for (int j = i + 1; j < n; j++) //arr[j] is the spot right after arr[i]
				if (arr[j] < arr[min_idx]) //if the next spot is less than the current spot, min_idx is updated. 
					//this can easily be changed to descending order, if this sign becomes a > sign (and update variable names)
					min_idx =  j; 

			int temp = arr[min_idx]; // temporary variable for swapping elements - after miidx is returned, need to replace first element with confirmed min element
			arr[min_idx] = arr[i];
			arr[i] = temp; //values swapped, first for loop goes to next index
		} //for i
        return arr;
	} //selectionSort
	
	public static int[] bubbleSortBro(int array[]) {
		
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = 0; j < array.length - i - 1; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}
	
	public static int[] insertionSortBro(int[] array) {
		
		for(int i = 1; i < array.length; i++) {
			int temp = array[i];
			int j = i - 1;
			
			while(j >= 0 && array[j] > temp) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = temp;
		}
		return array;
	}
	
	public static int[] selectionSortBro(int[] array) {
		
		for(int i = 0; i < array.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < array.length; j++) {
				if(array[min] > array[j]) {
					min = j;
				}
			}
			
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		return array;
	}
}