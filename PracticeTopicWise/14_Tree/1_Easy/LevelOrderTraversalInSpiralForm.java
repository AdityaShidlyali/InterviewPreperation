// https://practice.geeksforgeeks.org/batch-problems/level-order-traversal-in-spiral-form/0/?track=DSA-Foundation-Tree&batchId=238#

// using one stack and one queue
class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        ArrayList<Integer> ansList = new ArrayList<Integer>();
        
        if (root == null) {
            return ansList;
        }
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        
        // stack which is used to store elements level wise
            // this is used as the store elements will be popped in reverse order
        // so that we can store them in the ansList in reverse order.
        Stack<Integer> stack = new Stack<Integer>();
        
        // toggle to whether to store directly to the ansList or to store the elements in the stack
        boolean levelToggle = true;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for (int i = 0; i < levelSize; i++) {
                Node currNode = queue.poll();
                
                if (levelToggle == false) {
                    ansList.add(currNode.data);
                } else {
                    stack.push(currNode.data);
                }
                
                if (currNode.left != null) {
                    queue.add(currNode.left);
                }
                if (currNode.right != null) {
                    queue.add(currNode.right);
                }
            }
            
            levelToggle = !levelToggle;
            
            while (!stack.isEmpty()) {
                ansList.add(stack.pop());
            }
        }
        
        return ansList;
    }
}

// using two stacks:
class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form. 
    ArrayList<Integer> findSpiral(Node root) 
    {
        ArrayList<Integer> ansList = new ArrayList<Integer>();
        
        if (root == null) {
            return ansList;
        }
        
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        
        s1.push(root);
        
        while (!s1.isEmpty() || !s2.isEmpty()) {
            
            while (!s1.isEmpty()) {
                Node currNode = s1.pop();
            
                ansList.add(currNode.data);
            
                // first store the right and then left child nodes of currNode
                    // so that we can traverse it in reverse order to spiral
                if (currNode.right != null) {
                    s2.push(currNode.right);
                }
                if (currNode.left != null) {
                    s2.push(currNode.left);
                }
            }
            
            while (!s2.isEmpty()) {
                Node currNode = s2.pop();
            
                ansList.add(currNode.data);
            
                // first store the left and then right child nodes of currNode
                    // so that we can traverse it in reverse order to spiral
                if (currNode.left != null) {
                    s1.push(currNode.left);
                }
                if (currNode.right != null) {
                    s1.push(currNode.right);
                }
            }
        }
        
        return ansList;
    }
}