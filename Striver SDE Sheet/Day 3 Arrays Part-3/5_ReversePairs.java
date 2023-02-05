// Bruteforce
class Solution {
    public int reversePairs(int[] arr) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > 2 * arr[j]) {
                    ++count;
                }
            }
        }

        return count;
    }
}

// Optimised approach (using merge sort)
class Solution {

    private static int mergeAndCount(int[] nums, int low, int mid, int high) {
        int cnt = 0, i = low, j = mid + 1;

        /*
        * However the left and right subarrays during merge sort are already sorted,
        * so here if j reaches the end of right subarray then if nums[i] > 2*nums[j] then,
        * the count will be
        * */
        while (i <= mid) {
            while (j <= high && nums[i] > (2 * (long) nums[j])) {
                j++;
            }
            cnt += (j - (mid + 1));

            i++;
        }

        ArrayList<Integer> temp = new ArrayList<>();
        i = low;
        j = mid + 1;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp.add(nums[i++]);
            } else {
                temp.add(nums[j++]);
            }
        }

        while (i <= mid) {
            temp.add(nums[i++]);
        }
        while (j <= high) {
            temp.add(nums[j++]);
        }

        for (i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
        return cnt;
    }

    private static int mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            int count = mergeSort(arr, low, mid);
            count += mergeSort(arr, mid + 1, high);
            count += mergeAndCount(arr, low, mid, high);

            return count;
        } else {
            return 0;
        }
    }

    public int reversePairs(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }
}