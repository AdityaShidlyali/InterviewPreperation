/*
Time Complexity: O(n*n)
Auxiliary Space: O(n)
*/

class Solution {

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void bubbleSort(int[] arr, int n) {
		if (n == 0 || n == 1) {
			return;
		}

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				swap(arr, i, i + 1);
			}
		}

		bubbleSort(arr, n - 1);
	}
}