package com.dsa.BinaryTree.traversal.morris;

import java.util.ArrayList;
import java.util.List;

import com.dsa.BinaryTree.util.Node;

public class MorisInorder {
    public List<Integer> morrisInorderTraversal(Node root) {
        List<Integer> inorder = new ArrayList<>();
        Node curr = root;
        while (curr != null) {
            if (curr.left == null) {
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                Node prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    inorder.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return inorder;
    }
}
