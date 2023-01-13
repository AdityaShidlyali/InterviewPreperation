/*
Time complexity: O(n)
Auxiliary space: O(1)
*/
class Solution {
	public boolean linearSearch(int[] arr, int size, int key) {
		if (size == 0) {
			if (arr[size] == key) {
				return true;
			} else {
				return false;
			}
		}

		if (arr[size] == key) {
			return true;
		} else {
			return linearSearch(arr, size - 1, key);
		}
	}
}