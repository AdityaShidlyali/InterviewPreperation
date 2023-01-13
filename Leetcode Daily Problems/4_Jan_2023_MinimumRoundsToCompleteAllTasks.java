import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumRounds(int[] tasks) {
        int n = tasks.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
        }

        int minRoundsAns = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int key = e.getKey();
            int value = e.getValue();
            if (value == 1) {
                return -1;
            } else if (value % 3 == 0) {
                minRoundsAns += value / 3;
            } else {
               minRoundsAns += value / 3 + 1;
            }
        }
        return minRoundsAns;
    }
}