package com.dsa.BinaryTree.medium.diameterofbinarytree.optimal;

import com.dsa.BinaryTree.util.Node;

public class DiameterOfBinaryTree {
    public int height(Node node, int diameter) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left, diameter);
        int rightHeight = height(node.right, diameter);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(Node root) {
        int diameter = 0;
        height(root, diameter);
        return diameter;
    }
}
