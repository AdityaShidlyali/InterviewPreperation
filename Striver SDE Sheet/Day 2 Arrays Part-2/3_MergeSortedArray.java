// Approach 1
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];

        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                ans[k++] = nums1[i++];
            } else {
                ans[k++] = nums2[j++];
            }
        }

        while (i < m) {
            ans[k++] = nums1[i++];
        }

        while (j < n) {
            ans[k++] = nums2[j++];
        }

        for (int x = 0; x < m + n; x++) {
            nums1[x] = ans[x];
        }
    }
}

// Approach 2
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lasti = m + n - 1;
        int i1 = m - 1;
        int i2 = n - 1;

        while (i1 >= 0 && i2 >= 0) {
            if (nums1[i1] < nums2[i2]) {
                nums1[lasti] = nums2[i2--];
            } else {
                nums1[lasti] = nums1[i1--];
            }

            --lasti;
        }

        while (i1 >= 0) {
            nums1[lasti--] = nums1[i1--];
        }

        while (i2 >= 0) {
            nums1[lasti--] = nums2[i2--];
        }
    }
}