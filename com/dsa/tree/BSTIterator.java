package com.dsa.tree;

import java.util.Set;
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

    // two sum
    // public boolean isPairPresent(Node root, int target) {

    // }

    // public boolean util(Node root, int target, Set<Integer> set) {
    // if (root == null)
    // return false;
    // if (util(root.left, target, set) == true)
    // return true;
    // if(set.contains(root.data-s))
    // }
    class NodeValue {
        public int maxNode, minNode, maxSize;

        public NodeValue(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    }

    public int largestBSTSubtree(Node root) {
        return largestBSTSubtreeHelper(root).maxSize;
    }

    private NodeValue largestBSTSubtreeHelper(Node root) {
        // An empty tree is a BST of size 0
        if (root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeValue left = largestBSTSubtreeHelper(root.left);
        NodeValue right = largestBSTSubtreeHelper(root.right);

        if (left.maxNode < root.data && right.minNode > root.data) {
            // it's a BST
            return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode),
                    left.maxSize + right.maxSize + 1);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
}