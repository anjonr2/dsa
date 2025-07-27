package com.dsa.BinaryTree.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.dsa.BinaryTree.util.Node;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> zigzagOrder = new ArrayList<>();
        if (root == null) {
            return zigzagOrder;
        }
        // queue to perform level order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>(Collections.nCopies(size, 0));
            for (int i = 0; i < size; i += 1) {
                Node node = queue.poll();
                int index = leftToRight ? i : size - 1 - i;
                level.set(index, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            leftToRight = !leftToRight;
            zigzagOrder.add(level);
        }
        return zigzagOrder;
    }
}
