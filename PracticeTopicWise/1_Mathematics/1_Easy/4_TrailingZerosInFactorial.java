// Time Complexity: 5^k <= n -> k <= log5n
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a number: ");

		int n = input.nextInt();

		System.out.println("The trailing in factorial are: " + countTrailingZeros(n));

		input.close();
	}

	private static int countTrailingZeros(int n) {

		int res = 0;

		for (int i = 5; i <= n; i = i * 5) {
			res = res + Math.floorDiv(n, i);
		}

		return res;
	}
}