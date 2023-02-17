// https://leetcode.com/problems/running-sum-of-1d-array/

class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        
        return sum;
    }
}

// Efficient one:
/*
class Solution {
    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        int value  =0;
        for(int i=0;i<nums.length;i++){
            result[i] = value + nums[i];
            value += nums[i];
        }
        return result;
        
    }
}
*/