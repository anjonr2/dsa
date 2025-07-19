package com.dsa.BinaryTree.traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import com.dsa.BinaryTree.util.Node;
import com.dsa.BinaryTree.util.Pair;

public class PrePostInorder {
    public List<List<Integer>> treeTraversal(Node root) {
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        if (root == null) {
            return Arrays.asList(preorder, inorder, postorder);
        }
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));
        while (!stack.isEmpty()) {
            Node currentNode = stack.peek().node;
            if (currentNode.val == 1) {
                preorder.add(currentNode.val);
                stack.push(new Pair(currentNode, 2));
                if (currentNode.left != null) {
                    stack.push(new Pair(currentNode.left, 1));
                }
            } else if (currentNode.val == 2) {
                inorder.add(currentNode.val);
                stack.push(new Pair(currentNode, 3));
                if (currentNode.right != null) {
                    stack.push(new Pair(currentNode.right, 1));
                }
            } else {
                postorder.add(currentNode.val);
            }
        }
        return Arrays.asList(preorder, inorder, postorder);
    }
}
