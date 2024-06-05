public class Factorial {

	public static long factorial(int n) { // long is a better choice then int - multiplication!
		if (n < 0)
			return -1; // undef for neg numbers
		if (n == 0)
			return 1; // base case or termination condition
		return (n * factorial(n - 1)); // recursive call
	}

	public static void main(String[] args) {
		final int NUM = 5; // change this number to test this program
		System.out.println("Factorial of " + NUM + " is: " + factorial(NUM));
	}
}
