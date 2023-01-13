
// the following solution uses the inner for loop(inside while loop) for eliminating the null values.
class Solution {
    // Function to get the maximum width of a binary tree.
    int getMaxWidth(Node root) {
        if (root == null) {
            return 0;
        }
        
        if (root.left == null || root.right == null) {
            return 1;
        }
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                Node currNode = queue.poll();
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            
            maxWidth = Math.max(maxWidth, levelSize);
        }
        
        return maxWidth;
    }
}