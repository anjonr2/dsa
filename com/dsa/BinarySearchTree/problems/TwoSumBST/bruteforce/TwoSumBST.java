package com.dsa.BinarySearchTree.problems.TwoSumBST.bruteforce;

import java.util.ArrayList;
import java.util.List;

import com.dsa.BinaryTree.util.Node;

public class TwoSumBST {
    public boolean twoSumBST(Node root, int k) {
        List<Integer> sortedElements = inorder(root);
        int left = 0, right = sortedElements.size() - 1;
        while (left < right) {
            int sum = sortedElements.get(left) + sortedElements.get(right);
            if (sum == k)
                return true;
            else if (sum < k)
                left += 1;
            else
                right -= 1;
        }
        return false;
    }

    public List<Integer> inorder(Node root) {
        List<Integer> elements = new ArrayList<>();
        inorderHelper(root, elements);
        return elements;
    }

    private void inorderHelper(Node root, List<Integer> elements) {
        if (root == null)
            return;
        inorderHelper(root.left, elements);
        elements.add(root.val);
        inorderHelper(root.right, elements);
    }
}
