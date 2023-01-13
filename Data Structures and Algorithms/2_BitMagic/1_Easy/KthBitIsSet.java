public class Test {

	private static boolean isKthBitSetLeftShift(int n, int k) {
		if (((1 << k - 1) & n) != 0) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isKthBitSetRightShift(int n, int k) {
		if (((n >> k - 1) & 1) == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println(isKthBitSetLeftShift(5, 1));
		System.out.println(isKthBitSetRightShift(5, 2));
	}
}
