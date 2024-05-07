package com.dsa.tree;

import java.util.Stack;

public class BSTIterator {
    private Stack<Node> stack = new Stack<>();

    public class Node {
        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
        }
    }

    public BSTIterator(Node root) {
        pushAll(root);
    }

    boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        Node temp = stack.pop();
        pushAll(temp.right);
        return temp.data;
    }

    private void pushAll(Node root) {
        for (; root != null; stack.push(root), root = root.left)
            ;
    }
}