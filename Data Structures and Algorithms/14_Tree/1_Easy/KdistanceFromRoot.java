// https://practice.geeksforgeeks.org/problems/k-distance-from-root/1/#
/*
Time complexity: O(height of the tree)
Auxiliary space: O(height of the tree + 1)
*/

class Tree {
    
    ArrayList<Integer> l = new ArrayList<Integer>();

    // Recursive function to print right view of a binary tree.
    ArrayList<Integer> Kdistance(Node root, int k) {
        if (root == null) {
            return l;
        }

        if (k == 0) {
            l.add(root.data);
        }

        Kdistance(root.left, k - 1);
        Kdistance(root.right, k - 1);
        return l;
    }
}