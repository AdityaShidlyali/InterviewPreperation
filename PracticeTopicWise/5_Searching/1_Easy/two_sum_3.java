// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
		int[] answer = new int[2];

		int start = 0, end = numbers.length - 1;
		while (start < end) {
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