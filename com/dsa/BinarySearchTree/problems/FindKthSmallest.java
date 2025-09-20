package com.dsa.BinarySearchTree.problems;

import com.dsa.BinaryTree.util.Node;

public class FindKthSmallest {
    int result;
    int k;

    public int kthSmallest(Node root, int k) {
        this.result = -1;
        this.k = k;
        inorder(root);
        return result;
    }

    public void inorder(Node root) {
        while (root != null) {
            inorder(root.left);
            if (--k == 0) {
                result = root.val;
                return;
            }
            inorder(root.right);
        }
    }
}
