// Approach 1:
class Solution {
    public void sortColors(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i : nums) {
            if (i == 0) {
                ++count0;
            } else if (i == 1) {
                ++count1;
            } else {
                ++count2;
            }
        }

        int i = 0;
        while (count0-- != 0) {
            nums[i] = 0;
            i++;
        }

        while (count1-- != 0) {
            nums[i] = 1;
            i++;
        }

        while (count2-- != 0) {
            nums[i] = 2;
            i++;
        }
    }
}

// Approach 2:
class Solution {
    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0: {
                    swap(low, mid, nums);
                    ++low;
                    ++mid;
                    break;
                }
                case 1: {
                    ++mid;
                    break;
                }
                case 2: {
                    swap(mid, high, nums);
                    --high;
                    break;
                }
            }
        }
    }
}