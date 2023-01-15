// https://practice.geeksforgeeks.org/batch-problems/children-sum-parent/0/?track=DSA-Foundation-Tree&batchId=238#

/*Complete the function below
Node is as follows:
class Node{
	int data;
	Node left,right;
	
	Node(int key)
	{
	    data = key;
	    left = right = null;
	}
}

*/
class Tree
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // if there is only root present
        if (root == null) {
            return 1;
        }
        
        // if there is null in both left and right nodes
        if (root.left == null && root.right == null) {
            return 1;
        }
        
        // variables to store left and right node's data
        int leftData = 0;
        int rightData = 0;
        
        // get the left node's data if that is not null
        if (root.left != null)
            leftData = root.left.data;
        
        // get the left node's data if that is not null
        if (root.right != null)
            rightData = root.right.data;
        
        // now call for left subtree
        int leftCallResult = isSumProperty(root.left);
        // and also call for right subtree
        int rightCallResult = isSumProperty(root.right);
        
        // check if root's data is equal to left and right node data and also with left and right recursion result
        if ((leftData + rightData) == root.data && (leftCallResult == 1) && (rightCallResult == 1))
            return 1;
        else
            return 0;
    }
}


// https://leetcode.com/problems/root-equals-sum-of-children/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean checkTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (root.left == null && root.right == null) {
            return true;
        }
        
        int leftData = 0;
        int rightData = 0;
        
        if (root.left != null) {
            leftData = root.left.val;
        }
        
        if (root.right != null) {
            rightData = root.right.val;
        }
        
        boolean leftCallResult = false, rightCallResult = false;
        
        leftCallResult = checkTree(root.left);
        rightCallResult = checkTree(root.right);
        
        if (root.val == (leftData + rightData) && leftCallResult == true && rightCallResult == true) {
            return true;
        } else {
            return false;
        }
    }
}