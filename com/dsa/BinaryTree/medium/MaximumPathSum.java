package com.dsa.BinaryTree.medium;

import com.dsa.BinaryTree.util.Node;

public class MaximumPathSum {
    public int findMaxPathSum(Node node, int[] maxSum) {
        if (node == null) {
            return 0;
        }
        int leftPathSum = Math.max(0, findMaxPathSum(node.left, maxSum));
        int rightPathSum = Math.max(0, findMaxPathSum(node.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], leftPathSum + rightPathSum + node.val);

        return Math.max(leftPathSum, rightPathSum) + node.val;
    }

    public int maxPathSum(Node root) {
        int maxSum[] = { Integer.MIN_VALUE };
        findMaxPathSum(root, maxSum);
        return maxSum[0];
    }
}
