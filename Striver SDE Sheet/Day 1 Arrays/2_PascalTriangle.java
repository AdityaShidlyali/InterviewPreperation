class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return new ArrayList();
        List<List<Integer>> res = new ArrayList();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    int left = res.get(i - 1).get(j - 1);
                    int right = res.get(i - 1).get(j);
                    row.add(left + right);
                }
            }
            res.add(row);
        }
        
        return res;
    }
}