public class Test {

	private static boolean palindromeStringAux(String str, int start, int end) {
		if (start == end) {
			return true;
		}

		if (str.charAt(start) != str.charAt(end)) {
			return false;
		}

		if (start < end + 1) {
			return palindromeStringAux(str, start + 1, end - 1);
		}

		return true;
	}

	private static boolean palindromeString(String str, int start, int end) {
		int n = str.length();

		if (n == 0) {
			return true;
		}

		return palindromeStringAux(str, 0, n - 1);
	}

	public static void main(String args[]) {
		System.out.println(palindromeString("abba", 0, 3));
	}
}