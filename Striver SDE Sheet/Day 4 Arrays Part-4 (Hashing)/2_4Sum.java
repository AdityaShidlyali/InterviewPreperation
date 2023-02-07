// Bruteforce Optimised
class Solution {

    private static int binarySearch(int[] nums, long key, int n, int startIndex) {
        int low = startIndex, high = n - 1, mid = 0;
        while (low <= high) {
            mid = low + ((high - low) / 2);

            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    long key = (long) target - nums[i] - nums[j] - nums[k];
                    int keyIndex = binarySearch(nums, key, n, k + 1);
                    if (keyIndex != -1) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        tempList.add(nums[keyIndex]);

                        set.add(tempList);
                    }
                }
            }
        }

        List<List<Integer>> ansList = new ArrayList<>();
        for (List<Integer> list : set) {
            ansList.add(list);
        }
        return ansList;
    }
}

// Optimised 1
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int low = j + 1, high = n - 1;

                while (low < high) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[low] + (long)nums[high];
                    if (sum == target) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[low]);
                        tempList.add(nums[high]);

                        ++low;
                        --high;

                        set.add(tempList);
                    } else if (sum < target) {
                        ++low;
                    } else {
                        --high;
                    }
                }
            }
        }

        List<List<Integer>> ansList = new ArrayList<>();
        for (List<Integer> list : set) {
            ansList.add(list);
        }
        return ansList;
    }
}

// Optimised 2
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ansList = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

		// Apply two sum way of solving the right half of the array
                int low = j + 1, high = n - 1;

                while (low < high) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[low] + (long) nums[high];
                    if (sum == target) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[low]);
                        tempList.add(nums[high]);

                        ansList.add(tempList);

			// skip the duplicate numbers by comparing existing numbers with numbers already added in anserwer list
                        while (low < high && tempList.get(2) == nums[low]) ++low;
                        while (low < high && tempList.get(3) == nums[high]) --high;

                    } else if (sum < target) {
                        ++low;
                    } else {
                        --high;
                    }
                }

                while (j + 1 < n && nums[j + 1] == nums[j]) ++j;
            }

            while (i + 1 < n && nums[i + 1] == nums[i]) ++i;
        }

        return ansList;
    }
}
