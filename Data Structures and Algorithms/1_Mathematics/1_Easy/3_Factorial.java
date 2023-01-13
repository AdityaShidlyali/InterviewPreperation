import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number: ");
		int n = input.nextInt();
		
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		
		System.out.println("Factorial is: " + fact);
		
		input.close();
	}

	// Recursive approach
	private static int factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}

		return n * factorial(n - 1);
	}
}
