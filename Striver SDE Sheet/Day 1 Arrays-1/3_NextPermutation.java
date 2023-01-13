class Solution {

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            ++i;
            --j;
        }
    }

    public void nextPermutation(int[] arr) {
        int n = arr.length, pivot1Ind, pivot2Ind;

        for (pivot1Ind = n - 2; pivot1Ind >= 0; pivot1Ind--) {
            if (arr[pivot1Ind] < arr[pivot1Ind + 1]) {
                break;
            }
        }

        if (pivot1Ind < 0) {
            reverse(arr, 0, arr.length - 1);
        } else {
            for (pivot2Ind = n - 1; pivot2Ind > pivot1Ind; pivot2Ind--) {
                if (arr[pivot2Ind] > arr[pivot1Ind]) {
                    break;
                }
            }

            swap(arr, pivot1Ind, pivot2Ind);

            reverse(arr, pivot1Ind + 1, arr.length - 1);
        }
    }
}