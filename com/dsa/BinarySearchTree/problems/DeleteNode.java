package com.dsa.BinarySearchTree.problems;

import com.dsa.BinaryTree.util.Node;

public class DeleteNode {
    public Node deleteNode(Node root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            return helper(root);
        }
        Node curr = root;
        while (curr != null) {
            if (key < curr.val) {
                if (curr.left != null && curr.left.val == key) {
                    curr.left = helper(curr.left);
                    break;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right != null && curr.right.val == key) {
                    curr.right = helper(curr.right);
                    break;
                } else {
                    curr = curr.right;
                }
            }
        }
        return curr;
    }

    public Node helper(Node root) {
        if (root.left == null)
            return root.right;
        if (root.right == null)
            return root.left;
        Node rightChild = root.right;
        Node lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }

    public Node findLastRight(Node root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }
}
