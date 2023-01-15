/*
    Time Complexity: O(number of nodes)
    Auxiliary space: O(height of the tree + 1)
*/

// calling Math.max function is heavy task
int height(Node node) {
    if (node == null) {
        return 0;
    }

    // 1 is added because it represents the current node at which the recursion stack is pointing to
    return Math.max(height(node.left), height(node.right)) + 1;
}

// so use ternary operator or else any comparison operator to compare the heights manually
int height(Node node) {
    if (node == null) {
        return 0;
    }

    int lHeight = height(node.left) + 1;
    int rHeight = height(node.right) + 1;
    return lHeight < rHeight ? rHeight : lHeight;
}