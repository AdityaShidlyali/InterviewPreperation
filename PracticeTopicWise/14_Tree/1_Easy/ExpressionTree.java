// https://practice.geeksforgeeks.org/problems/expression-tree/1
class Solution {
    public int evalTree(Node root) {
        if (root == null) {
            return 0;
        }
        
        int leftData = evalTree(root.left);
        int rightData = evalTree(root.right);
        
        if (root.data.equals("+")) {
            return leftData + rightData;
        }
        
        if (root.data.equals("-")) {
            return leftData - rightData;
        }
        
        if (root.data.equals("*")) {
            return leftData * rightData;
        }
        
        if (root.data.equals("/")) {
            return leftData / rightData;
        }
        
        return Integer.parseInt(root.data);
    }
}