import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter two number: ");

		int a = input.nextInt();
		int b = input.nextInt();

		System.out.println("LCM is: " + lcm(a, b));

		input.close();
	}

	private static int lcm(int a, int b) {
		int res = Math.max(a, b);

		while (true) {
			if (res % a == 0 && res % b == 0) {
				return res;
			}
			res++;
		}
	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}

	private static int lcmEfficient(int a, int b) {
		return a * b / (gcd(a, b));
	}
}