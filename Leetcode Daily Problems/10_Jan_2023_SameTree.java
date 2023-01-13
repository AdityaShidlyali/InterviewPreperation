class Solution {
    class Pair {
        TreeNode node1, node2;

        Pair(TreeNode node1, TreeNode node2) {
            this.node1 = node1;
            this.node2 = node2;
        }
    }

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

        if ((p.left == null && q.left != null) || (p.left != null && q.left == null))
            return false;

        if ((p.right == null && q.right != null) || (p.right != null && q.right == null))
            return false;

        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(p);
        queue2.offer(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if (node1.val != node2.val) {
                return false;
            }

            if ((node1.left == null && node2.left != null) || (node1.left != null && node2.left == null))
                return false;

            if ((node1.right == null && node2.right != null) || (node1.right != null && node2.right == null))
                return false;

            if (node1.left != null && node2.left != null) {
                queue1.offer(node1.left);
                queue2.offer(node2.left);
            }

            if (node1.right != null && node2.right != null) {
                queue1.offer(node1.right);
                queue2.offer(node2.right);
            }
        }

        return true;
    }
}

// Or

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