package com.dsa.BinaryTree.hard;

import com.dsa.BinaryTree.util.Node;

public class FlattenBinaryTree {
    /*
     * postorder = root->left->right
     * reverse postorder = right->left->root
     * we can use reverse postorder to flatten the tree
     */
    Node prev = null;

    public void flatten(Node root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
