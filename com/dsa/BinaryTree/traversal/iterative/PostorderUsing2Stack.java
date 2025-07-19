package com.dsa.BinaryTree.traversal.iterative;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dsa.BinaryTree.util.Node;

public class PostorderUsing2Stack {
    public List<Integer> postorderTraversal(Node root) {

        List<Integer> postOrder = new ArrayList<>();
        if (root == null) {
            return postOrder;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node currentNode = stack1.pop();
            stack2.push(currentNode);
            if (currentNode.left != null) {
                stack1.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack1.push(currentNode.right);
            }
        }
        while (!stack2.isEmpty()) {
            postOrder.add(stack2.pop().val);
        }
        return postOrder;
    }
}
