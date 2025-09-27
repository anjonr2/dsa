package com.dsa.BinarySearchTree.problems;

import com.dsa.BinaryTree.util.Node;

public class RecoverBST {
    private Node first;
    private Node middle;
    private Node last;
    private Node prev;

    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                last = root;
            }
            prev = root;
            inorder(root.right);
        }
    }

    public void recoverTree(Node root) {
        first = middle = last = null;
        prev = new Node(Integer.MIN_VALUE);
        inorder(root);
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && middle != null) {
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
}
