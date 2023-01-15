public class Test {

	private static int palindromeInteger(int n, int rev) {
		if (n == 0) {
			return rev;
		}

		rev = (rev * 10) + (n % 10);
		return palindromeInteger(n / 10, rev);
	}

	public static void main(String args[]) {
		int n = 1213;

		int palindrome = palindromeInteger(1221, 0);

		if (n == palindrome) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}
}