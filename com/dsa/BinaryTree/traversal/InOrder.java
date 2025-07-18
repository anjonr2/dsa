package com.dsa.BinaryTree.traversal;

import java.util.ArrayList;
import java.util.List;

import com.dsa.BinaryTree.util.Node;

public class InOrder {
    public void inOrderHelper(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrderHelper(node.left, result);
        }
        result.add(node.val);
        if (node.right != null) {
            inOrderHelper(node.right, result);
        }
    }

    public List<Integer> inorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }
}
