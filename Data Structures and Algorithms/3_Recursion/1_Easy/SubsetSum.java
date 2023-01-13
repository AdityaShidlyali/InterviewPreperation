// https://practice.geeksforgeeks.org/problems/subset-sums2234/1

public class Test {

	private static int subsetSum(int n, int[] arr, int sum) {
		if (n == 0) {
			if (sum == 0) {

				// at the leaf node if the sum of the included elements of array becomes zero
				// then return value as 1
				return 1;
			} else {
				return 0;
			}
		}

		// there are max two decisions for each of the elements in array
		// Either to include them in array or exclude them
		return subsetSum(n - 1, arr, sum) + subsetSum(n - 1, arr, sum - arr[n - 1]);
	}

	public static void main(String args[]) {
		int[] a = { 10, 2, 6, 5, 3, 1 };

		System.out.println(subsetSum(5, a, 8));
	}
}