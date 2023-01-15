import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");

		int a = input.nextInt();

		System.out.println("this is: " + isPrime(a));

		input.close();
	}

	// Time complexity O(n)
	private static boolean isPrime(int n) {
		if (n == 0 || n == 1) {
			return false;
		}

		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	// Time complexity O(root(n))
	private static boolean isPrimeEfficient(int n) {
		if (n == 0 || n == 1) {
			return false;
		}

		for (int i = 2; i * i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	private static boolean isPrimeMoreEfficient(int n) {
		if (n == 0 || n == 1) {
			return false;
		}

		if (n == 2 || n == 3) {
			return true;
		}

		if (n % 2 == 0 && n % 3 == 0) {
			return false;
		}

		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}

		return true;
	}
}