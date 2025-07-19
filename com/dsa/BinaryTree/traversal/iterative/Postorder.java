package com.dsa.BinaryTree.traversal.iterative;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.dsa.BinaryTree.util.Node;

public class Postorder {
    public List<Integer> postorderTraversal(Node root) {
        List<Integer> postOrder = new ArrayList<>();
        if (root == null) {
            return postOrder;
        }
        Stack<Node> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            postOrder.add(currentNode.val);
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }
        Collections.reverse(postOrder);
        return postOrder;
    }
}
