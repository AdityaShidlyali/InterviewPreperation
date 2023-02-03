// Using HashMap
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int maxFreq = 0, ans = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > maxFreq) {
                ans = e.getKey();
                maxFreq = e.getValue();
            }
        } 

        return ans;
    }
}

// Space optimised
class Solution {
    public int majorityElement(int[] nums) {
        int element = 0;
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (count == 0) {
                element = nums[i];
            }

            if (element == nums[i]) {
                ++count;
            } else {
                --count;
            }
        }

        return element;
    }
}