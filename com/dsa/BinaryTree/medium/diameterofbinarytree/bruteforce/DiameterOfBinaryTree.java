package com.dsa.BinaryTree.medium.diameterofbinarytree.bruteforce;

import com.dsa.BinaryTree.util.Node;

public class DiameterOfBinaryTree {
    public int height(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public int diameterOfBinaryTree(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int currentDiameter = leftHeight + rightHeight;
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(currentDiameter, Math.max(leftDiameter, rightDiameter));
    }
}
