// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

import java.util.Scanner;

public class LeetCode {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the number of elements: ");
		int n = input.nextInt();
		int[] numbers = new int[n];

		System.out.println("Enter the elements one by one: ");
		for (int i = 0; i < n; i++) {
			numbers[i] = input.nextInt();
		}

		System.out.println("Enter the target number: ");
		int target = input.nextInt();

		Solution solution = new Solution();

		int[] answer = solution.twoSum(numbers, target);
		System.out.println(answer[0] + " " + answer[1]);

		input.close();
	}
}

class Solution {
	public int[] twoSum(int[] numbers, int target) {

		int[] answer = new int[2];

		int start = 0;
		int end = numbers.length - 1;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[start] + numbers[end] == target) {
				answer[0] = start + 1;
				answer[1] = end + 1;
				break;
			} else if (numbers[start] + numbers[end] < target) {
				start = start + 1;
			} else {
				end = end - 1;
			}
		}

		return answer;
	}
}