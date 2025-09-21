package com.dsa.BinarySearchTree.problems;

import java.util.Stack;

import com.dsa.BinaryTree.util.Node;

public class BSTIterator {
    private Stack<Node> stack = new Stack<>();

    public BSTIterator(Node root) {
        pushAll(root);
    }

    public int next() {
        Node node = stack.pop();
        pushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void pushAll(Node node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
