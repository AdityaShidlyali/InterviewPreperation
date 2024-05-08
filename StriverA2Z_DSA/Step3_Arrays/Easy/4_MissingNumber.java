/**
USING HASHING
Time Complexity: O(n)
Space Complexity: O(n) for hasing array
*/
class Solution {
    public int missingNumber(int[] nums) {
        int[] hash = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            hash[nums[i]]++;
        }

        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        return 0;
    }
}

/**
USING SUM OF NATURAL NUMBERS
Time Complexity: O(n)
Space Complexity: O(1)
*/
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sumOfNaturalNumbers = (n * (n + 1)) / 2;
        int sumOfArray = 0;
        for (int i = 0; i < n; i++) {
            sumOfArray += nums[i];
        }

        return sumOfNaturalNumbers - sumOfArray;
    }
}

/**
USING XOR PROPERTY OF NUMBERS
if any number XORed with itslef gived the zero
so if we go on XORing the array we are left with the missing number itself
so take XOR of 1 to N and XOR of array elements separately, then take XOR of both the results
*/
class Solution {
    public int missingNumber(int[] nums) {
        int xorOfArrayElements = 0;
        int xorOf1toN = 0;
        for (int i = 0; i < nums.length; i++) {
            xorOfArrayElements ^= nums[i];
            xorOf1toN ^= (i + 1);
        }

        return xorOf1toN ^ xorOfArrayElements;
    }
}
