// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {

	public int[] searchRange(final int[] A, int B) {

		int[] answer = new int[2];

		answer = Solution.findFirstLastOccurrence(A, B);

		return answer;
	}

	public static int[] findFirstLastOccurrence(int[] A, int B) {
        
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        
		int low = 0, high = A.length - 1, mid;

		while (low <= high) {
			mid = (low + high) / 2;
			if (A[mid] > B) {
				high = mid - 1;
			} else if (A[mid] < B) {
				low = mid + 1;
			} else {
				ans[0] = mid;
				high = mid - 1;
			}
		}
        
        low = 0;
        high = A.length - 1;
        while (low <= high) {
			mid = (low + high) / 2;
			if (A[mid] > B) {
				high = mid - 1;
			} else if (A[mid] < B) {
				low = mid + 1;
			} else {
				ans[1] = mid;
				low = mid + 1;
			}
		}

		return ans;
	}
}