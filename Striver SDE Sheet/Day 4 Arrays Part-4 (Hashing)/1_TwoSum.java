// Bruteforce
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

// Optimised approach using Hashing
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                answer[0] = i;
                answer[1] = map.get(target - nums[i]);
                return answer;
            }
            map.put(nums[i], i);
        }

        return answer;
    }
}