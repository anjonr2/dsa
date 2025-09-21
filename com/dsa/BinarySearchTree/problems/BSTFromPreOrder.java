package com.dsa.BinarySearchTree.problems;

import com.dsa.BinaryTree.util.Node;

public class BSTFromPreOrder {
    public Node bstFromPreorder(int[] preorder) {
        return bstFromPreOrder(preorder, Integer.MAX_VALUE, new int[] { 0 });
    }

    public Node bstFromPreOrder(int[] preorder, int bound, int[] index) {
        if (index[0] == preorder.length || preorder[index[0]] > bound)
            return null;
        Node root = new Node(preorder[index[0] += 1]);
        root.left = bstFromPreOrder(preorder, root.val, index);
        root.left = bstFromPreOrder(preorder, bound, index);
        return root;
    }
}
