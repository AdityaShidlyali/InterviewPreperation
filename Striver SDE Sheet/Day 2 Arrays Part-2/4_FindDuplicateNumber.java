// Approach 1:
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length, ans = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    ans = nums[i];
                    break;
                }
            }
        }

        return ans;
    }
}

// Approach 2:
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length > 0) {
            int slow = nums[0];
            int fast = nums[nums[0]];

            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        } else {
            return -1;
        }
    }
}