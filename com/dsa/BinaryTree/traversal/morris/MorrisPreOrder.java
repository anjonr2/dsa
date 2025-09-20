package com.dsa.BinaryTree.traversal.morris;

import java.util.ArrayList;
import java.util.List;

import com.dsa.BinaryTree.util.Node;

public class MorrisPreOrder {
    public List<Integer> morrisPreorderTraversal(Node root) {
        List<Integer> preorder = new ArrayList<>();
        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                preorder.add(curr.val);
                curr = curr.right;
            } else {
                Node prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    preorder.add(curr.val);
                    curr = curr.left;
                } else {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return preorder;
    }
}
