package com.dsa.BinaryTree.hard;

import java.util.HashMap;
import java.util.Map;

import com.dsa.BinaryTree.util.Node;

public class BuildTreeFromPostAndInorder {
    public Node buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length)
            return null;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i += 1) {
            inorderMap.put(inorder[i], i);
        }
        Node root = buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
        return root;
    }

    public Node buildTree(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd,
            Map<Integer, Integer> inorderMap) {
        if (postStart > postEnd || inStart > inEnd)
            return null;
        Node root = new Node(postorder[postEnd]);
        int inRoot = inorderMap.get(root.val);
        int numsLeft = inRoot - inStart;
        root.left = buildTree(postorder, postStart, postStart + numsLeft - 1, inorder, inStart, inRoot - 1, inorderMap);
        root.right = buildTree(postorder, postStart + numsLeft, postEnd - 1, inorder, inRoot + 1, inEnd, inorderMap);
        return root;
    }
}
