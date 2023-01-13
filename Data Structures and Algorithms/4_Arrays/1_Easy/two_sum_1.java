// https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];

		for (int i = 0; i < nums.length - 1; i++) {
			int a = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] + a == target) {
					ans[0] = i;
					ans[1] = j;
					break;
				}
			}
		}

		return ans;
    }
}

// Efficient Solution
/*
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Integer already added.");
        }
        Map<Integer, Integer> expectedNumberMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (expectedNumberMap.containsKey(nums[i])) {
                return new int[]{expectedNumberMap.get(nums[i]), i};
            } else {
                expectedNumberMap.put(target - nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }
}
*/