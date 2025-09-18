package com.dsa.BinarySearchTree.problems;

import com.dsa.BinaryTree.util.Node;

public class InsertIntoBST {
    public Node insertIntoBST(Node root, int val) {
        if (root == null)
            return new Node(val);
        Node curr = root;
        while (true) {
            if (val >= curr.val) {
                if (curr.right != null)
                    curr = curr.right;
                else {
                    curr.right = new Node(val);
                    break;
                }
            } else {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new Node(val);
                    break;
                }
            }
        }
        return root;
    }
}
