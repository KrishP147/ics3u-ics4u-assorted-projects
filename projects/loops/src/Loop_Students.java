/* 
 * This is a simple program that uses three different loops to print "Hi there" to the console.
 * Author: Krish Punjabi
 * Date: April 13, 2023
 */
public class Loop_Students {

	public static void main(String[] args) {
		
		//The counter is intially set to 1, which will be compared to the total number of times we want, 5
		int counter = 1;
		final int NUMBER_OF_TIMES = 5;
		
		System.out.print("WHILE LOOP: ");
		
		//While the counter (1) is less than or equal to 5, it will print out "Hi there" and increase by 1 (5 times)
		while (counter <= NUMBER_OF_TIMES ) 
		{
			System.out.print("Hi there ");
			counter++; //increment the counter to avoid an infinite loop
		}
		
		System.out.print("\nDO-WHILE LOOP: ");
		
		//Resetting the counter back to 1 to use for new loop
		counter = 1;
		
		////Print out "Hi there" and increase by counter by 1 while the counter (1) is less than or equal to 5 (5 times)
		do {
			System.out.print("Hi there ");
			counter++; //increment the counter to avoid an infinite loop
		} 
		
		while (counter <= NUMBER_OF_TIMES ); 
		
		System.out.print("\nFOR LOOP: ");
		
		//For counter is equal to 1, and the counter is less thant the number of times, increase the counter, and print "Hi there"
		for (counter = 1 ; counter <= NUMBER_OF_TIMES ; counter++)
		{
			System.out.print("Hi there ");
		}
		
		System.out.print("\n");
		
		
	}

}
