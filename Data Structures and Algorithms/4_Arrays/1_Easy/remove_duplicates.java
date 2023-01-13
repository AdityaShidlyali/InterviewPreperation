// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = input.nextInt();
		}

		Solution sol = new Solution();
		System.out.println(sol.removeDuplicates(nums));

		input.close();
	}
}

class Solution {
	public int removeDuplicates(int[] nums) {

		if (nums.length <= 1) {
			return nums.length;
		}

		int j = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != nums[i + 1]) {
				nums[j++] = nums[i];
			}
		}

		nums[j++] = nums[nums.length - 1];

		return j;
	}
}