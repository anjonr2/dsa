package com.dsa.tree;

public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node search(Node root, int value) {
        while (root != null && root.data != value) {
            root = value < root.data ? root.left : root.right;
        }
        return root;
    }

    public static int findCeil(Node root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.data == key) {
                ceil = key;
                return ceil;
            }
            if (key > root.data) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}
