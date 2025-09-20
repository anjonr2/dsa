package com.dsa.BinarySearchTree.problems;

import com.dsa.BinaryTree.util.Node;

public class CheckBSTOrBT {
    public boolean isValidBST(Node root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(Node root, long min, long max) {
        if (root == null)
            return true;
        if (root.val <= min || root.val >= max)
            return false;
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
