public class RecursionHello {

	public static void print(int NUMBER, int count) {

		if (count > NUMBER)
			return; // base case
		System.out.println("hello " + count);
		count++;
		print(NUMBER, count); // recursive call

	}

	public static void main(String[] args) {
		final int NUMBER = 5; // alternatively declare NUMBER as a static variable
		int count = 1; // declare this variable outside of the recursive method
		print(NUMBER, count);
	}
}
