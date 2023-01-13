// Approach 2: Using stacks
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int n = intervals.length;

        Stack<int[]> stack = new Stack<>();
        int low = intervals[0][0];
        int high = intervals[0][1];
        stack.push(new int[]{low, high});

        for (int[] i : intervals) {
            int[] top = stack.peek();
            if (top[1] < i[0]) {
                stack.push(new int[]{i[0], i[1]});
            } else if (top[1] < i[1]) {
                stack.pop();
                top[1] = i[1];
                stack.push(top);
            }
        }

        for (int[] i : stack) {
            System.out.println(i[0] + " " + i[1]);
        }

        int[][] ans = new int[stack.size()][2];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        return ans;
    }
}

// Approach 3: Space optimised
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> overlaps = new ArrayList<>();
        int n = intervals.length;

        int low = intervals[0][0];
        int high = intervals[0][1];

        for (int[] i : intervals) {
            if (i[0] <= high) {
                high = Math.max(high, i[1]);
            } else {
                overlaps.add(new int[]{low, high});
                low = i[0];
                high = i[1];
            }
        }

        overlaps.add(new int[]{low, high});
        int[][] ans = new int[overlaps.size()][2];
        int j = 0;
        for (int[] i : overlaps) {
            ans[j++] = i;
        }
        
        return ans;
    }
}