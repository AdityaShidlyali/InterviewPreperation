
// https://leetcode.com/problems/binary-tree-level-order-traversal/
/*
    Time Complexity: O(N), where N is the number of nodes in the Tree.
    Space Complexity: O(N), where N is the number of nodes in the Tree.
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ll = new ArrayList();
        
        if (root == null) {
            return ll;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
    
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<Integer>();
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode tempNode = queue.poll();
                levelList.add(tempNode.val);
            
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
            
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
            
            ll.add(levelList);
        }
        
        return ll;
    }
}

// https://practice.geeksforgeeks.org/problems/level-order-traversal/0/?track=DSA-Foundation-Tree&batchId=238
/*
    Time Complexity: O(N), where N is the number of nodes in the Tree.
    Space Complexity: O(N), where N is the number of nodes in the Tree.
*/
class Solution {
    private static void solve(Node node, ArrayList<Integer> list) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            list.add(tempNode.data);

            if (tempNode.left != null)
                queue.add(tempNode.left);

            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
    }

    //Function to return the level order traversal of a tree.
    static ArrayList<Integer> levelOrder(Node node) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        solve(node, ans);
        return ans;
    }
}