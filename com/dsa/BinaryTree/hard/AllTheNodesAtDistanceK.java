package com.dsa.BinaryTree.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dsa.BinaryTree.util.Node;

public class AllTheNodesAtDistanceK {
    Map<Node, Node> parentMap;
    List<Integer> result;
    Set<Node> visited;

    public List<Integer> distanceK(Node root, Node target, int k) {
        parentMap = new HashMap<>();
        result = new ArrayList<>();
        visited = new HashSet<>();
        parentMapping(root, null);
        findNodesAtDistanceK(target, k);
        return result;
    }

    private void findNodesAtDistanceK(Node node, int k) {
        if (node == null || visited.contains(node)) {
            return;
        }
        visited.add(node);
        if (k == 0) {
            result.add(node.val);
            return;
        }
        findNodesAtDistanceK(node.left, k - 1);
        findNodesAtDistanceK(node.right, k - 1);
        findNodesAtDistanceK(parentMap.get(node), k - 1);
    }

    private void parentMapping(Node currentNode, Node parentNode) {
        if (currentNode == null) {
            return;
        }
        parentMap.put(currentNode, parentNode);
        parentMapping(currentNode.left, currentNode);
        parentMapping(currentNode.right, currentNode);
    }
}
