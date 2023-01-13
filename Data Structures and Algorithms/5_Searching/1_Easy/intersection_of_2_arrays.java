// https://leetcode.com/problems/intersection-of-two-arrays/

class Solution {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> ansSet = new HashSet<>();

		Arrays.sort(nums1);

		for (int i = 0; i < nums2.length; i++) {
			if (BinarySearch(nums1, nums2[i])) {
				ansSet.add(nums2[i]);
			}
		}

		int[] ans = new int[ansSet.size()];

		int index = 0;
		for (int element : ansSet) {
			ans[index++] = element;
		}

		return ans;
	}

	private static boolean BinarySearch(int[] nums1, int nums2element) {
		int low = 0;
		int high = nums1.length - 1;
		int mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;

			if (nums1[mid] == nums2element) {
				return true;
			} else if (nums2element < nums1[mid]) {
				high = mid - 1;
			} else if (nums2element > nums1[mid]) {
				low = mid + 1;
			}
		}

		return false;
	}
}

// Efficient Solution
/*
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<nums1.length; i++){
            set.add(nums1[i]);
        }
        HashSet<Integer> res = new HashSet<>();
        for(int i=0; i<nums2.length; i++){
            if(set.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
        int arr[] = new int[res.size()];
        Iterator<Integer> itr = res.iterator();
        int i=0;
        while(itr.hasNext()){
            arr[i] = itr.next();
            i++;
        }
        return arr;
    }
}
*/