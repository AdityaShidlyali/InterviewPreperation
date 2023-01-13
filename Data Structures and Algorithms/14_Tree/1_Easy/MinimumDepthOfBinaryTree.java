// Using DFS
/*
    Time Complexity: O(maximum depth of the tree)
    Auxiliary space: O(max height of tree + 1)
*/
class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        int lDepth = root.left != null ? 1 + minDepth(root.left) : Integer.MAX_VALUE;
        
        int rDepth = root.right != null ? 1 + minDepth(root.right) : Integer.MAX_VALUE;
        
        return lDepth < rDepth ? lDepth : rDepth;
    }
}

// Using BFS
/*
    Time complexity: O(number of nodes ie., minimum height of the binary tree)
    Space complexity: O(diameter of the tree)
*/
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int tillDepth = 1;
        int currDepth = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    return tillDepth;
                }

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
            ++tillDepth;
        }
        
        return tillDepth;
    }
}