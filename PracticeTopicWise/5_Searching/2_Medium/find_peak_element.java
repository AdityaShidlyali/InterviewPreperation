// https://leetcode.com/problems/find-peak-element/

import java.util.Scanner;

public class LeetCode {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		input.close();
	}
}

class Solution {
	public int findPeakElement(int[] nums) {

		int start = 0;
		int end = nums.length - 1;
		int mid = 0;

		while (start < end) {

			mid = (start + end) / 2;

			if (nums[mid] < nums[mid + 1]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return end;
	}
}