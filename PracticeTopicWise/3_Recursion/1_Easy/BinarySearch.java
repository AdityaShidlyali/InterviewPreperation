/*
Time Complexity: O(log n)

Auxiliary Space: O(1)
*/

class Solution {

	public boolean binarySearch(int[] arr, int low, int high, int key) {
		if (low > high) {
			return false;
		}

		int mid = (low + high) / 2;
		if (arr[mid] == key)
			return true;
		else if (arr[mid] < key)
			return binarySearch(arr, mid + 1, high, key);
		else
			return binarySearch(arr, low, mid - 1, key);
	}
}