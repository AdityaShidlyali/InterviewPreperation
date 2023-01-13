import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter two number: ");

		int a = input.nextInt();
		int b = input.nextInt();

		System.out.println("GCD or HCF is: " + gcd(a, b));

		input.close();
	}

	private static int gcd(int a, int b) {
		int res = Math.min(a, b);

		while (res > 0) {
			if (a % res == 0 && b % res == 0) {
				break;
			}
			--res;
		}

		return res;
	}

	private static int gcdEuclidian(int a, int b) {
		while (a != b) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}

		return a;
	}

	private static int gcdEuclidianOptimised(int a, int b) {
		if (b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}
}