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

// OR

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Time Complexity O(log n)

import java.util.Scanner;

public class LeetCode {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		int n = input.nextInt();

		int[] A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = input.nextInt();
		}

		int B = input.nextInt();

		Solution solution = new Solution();
		int[] answer = solution.searchRange(A, B);
		System.out.println(answer[0] + " " + answer[1]);

		input.close();
	}
}

class Solution {

	public int[] searchRange(final int[] A, int B) {

		int[] answer = new int[2];

		answer[0] = Solution.findFirstOccurence(A, B);
		answer[1] = Solution.findLastOccurence(A, B);

		return answer;
	}

	public static int findFirstOccurence(int[] A, int B) {

		int res = -1, low = 0, high = A.length - 1, mid;

		while (low <= high) {
			mid = (low + high) / 2;
			if (A[mid] > B) {
				high = mid - 1;
			} else if (A[mid] < B) {
				low = mid + 1;
			} else {
				res = mid;
				high = mid - 1;
			}
		}

		return res;
	}

	public static int findLastOccurence(int[] A, int B) {

		int res = -1, low = 0, high = A.length - 1, mid;

		while (low <= high) {
			mid = (low + high) / 2;
			if (A[mid] > B) {
				high = mid - 1;
			} else if (A[mid] < B) {
				low = mid + 1;
			} else {
				res = mid;
				low = mid + 1;
			}
		}

		return res;
	}
}
