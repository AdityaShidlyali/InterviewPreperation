// https://practice.geeksforgeeks.org/tracks/DSASP-BitMagic/?batchId=154&tab=2
// Time complexity O(N)

class Solution {

	private static int checkBit(int pattern, int[] arr, int n) {
		int count = 0;

		for (int i = 0; i < n; i++) {
			if ((pattern & arr[i]) == pattern) {
				count++;
			}
		}

		return count;
	}

	public static int maxAND(int arr[], int n) {
		int res = 0, count = 0;

		for (int bit = 16; bit >= 0; bit--) {
			count = checkBit((res | (1 << bit)), arr, n);
			if (count >= 2) {
				res |= (1 << bit);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 8, 12, 16 };
		System.out.println(maxAND(arr, 4));
	}
}
