class Solution {
    public int minDeletionSize(String[] strs) {
        int arrLength = strs.length;
        int strLength = strs[0].length();
        int deleteCount = 0;
        for (int i = 0; i < strLength; i++) {
            for (int j = 1; j < arrLength; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    deleteCount++;
                    break;
                }
            }
        }
        
        return deleteCount;
    }
}