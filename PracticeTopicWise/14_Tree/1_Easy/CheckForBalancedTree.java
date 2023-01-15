// https://practice.geeksforgeeks.org/batch-problems/check-for-balanced-tree/0/?track=DSA-Foundation-Tree&batchId=238#

//Naive Approach:
// Time complexity: O(n^2)
class Tree
{
    
    private static int findHeight(Node root) {
        if(root == null) {
            return 0;
        }
        
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));
    }
    
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
        if (root == null) return true;
        
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        
        if ((Math.abs(leftHeight - rightHeight)) > 1)
            return false;
        
        boolean leftCallResult = isBalanced(root.left);
        boolean rightCallResult = isBalanced(root.right);
        
        if (!leftCallResult || !rightCallResult) {
            return false;
        }
        
        return true;
    }
}

// Efficient approach:
// Time complexity: O(n)
class Tree
{
    
    int checkForHeight(Node root) {
        if (root == null)
            return 0;
            
        int leftHeight = checkForHeight(root.left);
        int rightHeight = checkForHeight(root.right);
        
        if (leftHeight == -1 || rightHeight == -1) return -1;
        
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
        if (root == null) return true;
        
        if (checkForHeight(root) == -1) {
            return false;
        } else {
            return true;
        }
    }
}