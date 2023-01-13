// https://leetcode.com/problems/number-of-good-pairs/

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = input.nextInt();
		}

		Solution sol = new Solution();
		System.out.print(sol.numIdenticalPairs(nums));

		input.close();
	}
}

class Solution {
	public int numIdenticalPairs(int[] nums) {
		Arrays.sort(nums);
		int count = 0, i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] == nums[j]) {
				count += (j - i);
			} else {
				i = j;
			}
		}
		return count;
	}
}