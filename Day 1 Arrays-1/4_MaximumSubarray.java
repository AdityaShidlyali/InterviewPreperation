class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxTillAns = Integer.MIN_VALUE, maxEnd = 0;

        // to print the array you can use these variables
        int start = 0, end = 0, sTillNow;

        for (int i = 0; i < n; i++) {
            maxEnd = maxEnd + nums[i];

            if (maxTillAns < maxEnd) {
                maxTillAns = maxEnd;
                start = sTillNow;
                end = i;
            }

            if (maxEnd < 0) {
                maxEnd = 0;
                sTillNow = i + 1;
            }
        }

        return maxTillAns;
    }
}