package com.dsa.BinaryTree.medium.BalancedBinaryTree.optimal;

import com.dsa.BinaryTree.util.Node;

public class BalancedBinaryTree {
    public int getHeight(Node node) {
        if (node == null)
            return 0;
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(Node root) {
        return getHeight(root) != -1;
    }
}
