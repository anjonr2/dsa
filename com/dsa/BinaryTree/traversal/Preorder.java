package com.dsa.BinaryTree.traversal;

import java.util.ArrayList;
import java.util.List;

import com.dsa.BinaryTree.util.Node;

/*root->left->right */
public class Preorder {
    public List<Integer> preorderTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        preOrderHelper(root, result);
        return result;
    }

    public void preOrderHelper(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        if (node.left != null) {
            preOrderHelper(node.left, result);
        }
        if (node.right != null) {
            preOrderHelper(node.right, result);
        }
    }
}
