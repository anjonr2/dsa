package com.dsa.BinarySearchTree.problems;

import com.dsa.BinaryTree.util.Node;

public class FindCeiling {
    public int findCeil(Node root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.val == key) {
                ceil = root.val;
                return ceil;
            }
            if (key > root.val) {
                root = root.right;
            } else {
                ceil = root.val;
                root = root.left;
            }
        }
        return ceil;
    }
}
