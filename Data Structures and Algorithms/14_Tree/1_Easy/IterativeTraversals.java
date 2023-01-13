/*
Iterative Preorder
*/
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<Integer>();
        if (root == null) {
            return preorder;
        }

        // push the initial root
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        // iterate till stack is empty
        while (!stack.isEmpty()) {
            
            // pop the current root from top of the stack
            root = stack.pop();
            
            // add to the list of preorder traversal array
            preorder.add(root.val);
            
            /** check if the root's left and right children are 
            null or not push only they are not null*/
            // first the right child is to be pushed so that left child is at the top
            // and left child can be traversed first after popping from the stack
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return preorder;
    }
}

/*
Iterative Inorder
*/