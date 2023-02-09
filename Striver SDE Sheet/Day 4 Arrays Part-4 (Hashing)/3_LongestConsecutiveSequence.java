// Bruteforce
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int bestLen = 1, currLen = 1;
        for (int i = 1; i < list.size(); i++) {
            if (Objects.equals(list.get(i), list.get(i - 1) + 1)) {
                ++currLen;
                bestLen = Math.max(bestLen, currLen);
            } else {
                currLen = 1;
            }
        }

        return bestLen;
    }
}

// Opitmised using HashSet
class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int ansLength = 0, tempLength = 0;
        for (int i = 0; i < nums.length; i++) {

            if (!set.contains(nums[i] - 1)) {
                tempLength = 0;

                int checkNumber = nums[i];

                while (set.contains(checkNumber)) {
                    ++tempLength;
                    ++checkNumber;
                }

                ansLength = Math.max(ansLength, tempLength);
            }
        }

        return ansLength;
    }
}