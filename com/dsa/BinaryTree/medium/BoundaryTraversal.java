package com.dsa.BinaryTree.medium;

import java.util.ArrayList;
import java.util.List;

import com.dsa.BinaryTree.util.Node;

public class BoundaryTraversal {
    public boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }

    public void addLeftBoundary(Node node, List<Integer> boundary) {
        Node current = node.left;
        while (current != null) {
            if (!isLeaf(current)) {
                boundary.add(current.val);
            }
            if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }

    public void addRightBoundary(Node node, List<Integer> boundary) {
        Node current = node.right;
        List<Integer> temp = new ArrayList<>();
        while (current != null) {
            if (!isLeaf(current)) {
                temp.add(current.val);
            }
            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; i -= 1) {
            boundary.add(temp.get(i));
        }
    }

    public void addLeaves(Node node, List<Integer> boundary) {
        if (isLeaf(node)) {
            boundary.add(node.val);
            return;
        }
        if (node.left != null) {
            addLeaves(node.left, boundary);
        }
        if (node.right != null) {
            addLeaves(node.right, boundary);
        }
    }

    public List<Integer> boundary(Node root) {
        List<Integer> boundary = new ArrayList<>();
        if (root == null) {
            return boundary;
        }
        if (!isLeaf(root)) {
            boundary.add(root.val);
        }
        addLeftBoundary(root.left, boundary);
        addLeaves(root, boundary);
        addRightBoundary(root.right, boundary);
        return boundary;
    }
}
