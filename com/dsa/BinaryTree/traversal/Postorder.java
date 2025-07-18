package com.dsa.BinaryTree.traversal;

import java.util.ArrayList;
import java.util.List;

import com.dsa.BinaryTree.util.Node;

/* left->right->root */
public class Postorder {
    public void postorderTraversalHelper(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            postorderTraversalHelper(node.left, result);
        }
        if (node.right != null) {
            postorderTraversalHelper(node.right, result);
        }
        result.add(node.val);
    }

    public List<Integer> postorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversalHelper(root, result);
        return result;
    }
}
