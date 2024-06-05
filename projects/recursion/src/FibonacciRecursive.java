public class FibonacciRecursive { // object oriented version

	private long n1, n2, n3;
	private String fibSequence = "";

	FibonacciRecursive(int count) { // class constructor
		n1 = 0;
		n2 = 1;
		n3 = 1;
		if (count < 0)
			fibSequence = "Fibonacci sequence UNDEF for negative numbers!";
		if (count == 0)
			fibSequence = "0";
		if (count >= 1)
			fibSequence = "0 1";

	}

	public void fibonacci(int count) {
		if (count > 0) {
			n3 = n1 + n2; // add two preceding terms
			n1 = n2;
			n2 = n3;
			fibSequence = fibSequence.concat(" " + n3);
			fibonacci(count - 1);
		}

		else
			System.out.println("Fibonacci Sequence: " + fibSequence); // base case
	}

	public static void main(String[] args) {
		final int COUNT = 5; // change this constant to test other numbers

		FibonacciRecursive fr = new FibonacciRecursive(COUNT); // class constructor
		fr.fibonacci(COUNT - 1); // lower numbers accounted for in the class constructor
	}
}
