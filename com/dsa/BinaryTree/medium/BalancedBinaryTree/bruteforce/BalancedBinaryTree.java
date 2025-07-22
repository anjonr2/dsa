package com.dsa.BinaryTree.medium.BalancedBinaryTree.bruteforce;

import com.dsa.BinaryTree.util.Node;

public class BalancedBinaryTree {
    public int getHeight(Node node) {
        if (node == null)
            return 0;
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(Node root) {
        if (root == null)
            return true;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }
}
