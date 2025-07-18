package com.dsa.BinaryTree.util;

public class Node {
    public int val;
    public Node left;
    public Node right;

    Node() {
        this.val = 0;
        this.left = null;
        this.right = null;
    }

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
