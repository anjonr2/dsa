package com.dsa.BinaryTree.medium;

import com.dsa.BinaryTree.util.Node;

public class CheckIfTwoTreesAreIdentical {
    public boolean isSameTree(Node p, Node q) {
        if (p == null || q == null) {
            return (p == q);
        }
        return (p.val == q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
