/* 
 * This is a program that uses for loops to display a variety of different sequences to the console
 * Author: Krish Punjabi
 * Date: April 12, 2023
 */
public class ForLoops {

	public static void main(String[] args) {
		
			//This line is for formatting - indicating the start of the first sequence with a letter
			System.out.print("a) ");
		
		//For integers 0 - 25, with the integer increasing by 1 each time, the integer + a space will be printed
		for (int i = 0 ; i <= 25 ; i++)
		{
			System.out.print(i + " ");
		}
		
			//This line prints out two spaces and indicates the start of the second sequence using a letter
			System.out.print("\n\nb) ");
		
		//Same as previous sequence, except between integers 5 - 25
		for (int i = 5 ; i <= 20 ; i++)
		{
			System.out.print(i + " ");
		}
		
			System.out.print("\n\nc) ");
		
		for (int i = 30 ; i <= 50 ; i++)
		{
			System.out.print(i + " ");
		}

			System.out.print("\n\nd) ");
		
		//Sequence prints the integers in decreasing order
		for (int i = 12 ; i >= 1 ; i--)
		{
			System.out.print(i + " ");
		}
			
			System.out.print("\n\ne) ");
			
		for (int i = 100 ; i >= 85 ; i--)
		{
			System.out.print(i + " ");
		}

			System.out.print("\n\nf) ");
		
		//This sequence prints every two characters 
		for (int i = 2 ; i <= 26 ; i+=2)
		{
			System.out.print(i + " ");
		}
		

			System.out.print("\n\ng) ");
	
		//This sequence prints every 5 characters
		for (int i = 5 ; i <= 70 ; i+=5)
		{
			System.out.print(i + " ");
		}

			System.out.print("\n\nh) ");
		
		//This sequence prints out different characters for the amount of times indicated by the integers
		for (int i = 1 ; i <= 12 ; i++)
		{
			System.out.print("< > ");
		}

			System.out.print("\n\ni) ");
		
		for (int i = 10 ; i >= 1 ; i--)
		{
			System.out.print(i + " ");
		}
		
			//This line prints out a line immediately after the sequence, outside the loop because it happens only once
			System.out.print(" ... BLAST OFF!");
			System.out.print("\n\nj) ");
		
		//This sequence repeats this patter the number of times indicated by the integers
		for (int i = 1 ; i <= 10 ; i++)
		{
			System.out.print("1 0 ");
		}
		
			System.out.print("\n\nk) ");
		
		//This sequence prints out the integer as a numerator with the integer + 1 as the denominator in a fraction
		for (int i = 1 ; i <= 8 ; i++)
		{
			System.out.print(i + "/" + (i+1) + " ");
		}
	}

}
