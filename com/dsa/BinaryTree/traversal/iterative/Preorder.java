package com.dsa.BinaryTree.traversal.iterative;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dsa.BinaryTree.util.Node;

/*root->left->right */
public class Preorder {
    public List<Integer> preorderTraversal(Node root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null) {
            return preOrder;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            preOrder.add(currentNode.val);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        return preOrder;
    }
}
