// HashMap Approach
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int maxFreq = 0, ans = 0;
        List<Integer> ansList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map.getOrDefault(nums[i], 0) > n / 3) {
                if (!ansList.contains(nums[i])) ansList.add(nums[i]);
            }
        }

        return new ArrayList<>(ansList);
    }
}

// Moore's Voting Algorithm approach
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        int cnt1 = 0, cnt2 = 0;

        for (int num : nums) {
            if (ele1 != Integer.MIN_VALUE && num == ele1) {
                ++cnt1;
            } else if (ele2 != Integer.MIN_VALUE && num == ele2) {
                ++cnt2;
            } else if (cnt1 == 0) {
                ele1 = num;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                ele2 = num;
                cnt2 = 1;
            } else {
                --cnt1;
                --cnt2;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for (int i : nums) {
            if (ele1 != Integer.MIN_VALUE && i == ele1) {
                ++cnt1;
            } else if (ele2 != Integer.MIN_VALUE && i == ele2) {
                ++cnt2;
            }
        }

        List<Integer> ansList = new ArrayList<>();
        if (cnt1 > (n / 3)) {
            ansList.add(ele1);
        }
        if (cnt2 > (n / 3)) {
            ansList.add(ele2);
        }

        return ansList;
    }
}