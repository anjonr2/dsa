package com.dsa.BinaryTree.hard;

import java.util.HashMap;
import java.util.Map;

import com.dsa.BinaryTree.util.Node;

public class BuildTreeFromPreAndInorder {
    public Node buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i += 1) {
            inorderMap.put(inorder[i], i);
        }
        Node root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
        return root;
    }

    public Node buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        Node root = new Node(preorder[preStart]);
        int inRoot = inorderMap.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, inRoot - 1, inorderMap);
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd, inorder, inRoot + 1, inEnd, inorderMap);
        return root;
    }
}
