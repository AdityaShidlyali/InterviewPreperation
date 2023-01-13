
// https://leetcode.com/problems/same-tree/
// https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/0/?track=DSA-Foundation-Tree&batchId=238
/*
    Time Complexity: O(n), n is the number of nodes
    Auxiliary space: O(height of tree (longest path from root to leaf node) + 1)
*/
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        
        if (p == null || q == null) {
            return false;
        }
        
        if (p.val != q.val) {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}