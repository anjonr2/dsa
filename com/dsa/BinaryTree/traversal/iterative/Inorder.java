package com.dsa.BinaryTree.traversal.iterative;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dsa.BinaryTree.util.Node;

public class Inorder {
    public List<Integer> inorderTraversal(Node root) {
        List<Integer> inOrder = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        while (true) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                Node node = stack.pop();
                inOrder.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return inOrder;
    }
}
