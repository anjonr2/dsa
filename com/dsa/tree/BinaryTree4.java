package com.dsa.tree;

import java.util.*;

public class BinaryTree4 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<Node> queue = new LinkedList<Node>();
        /* start with root node */
        queue.add(root);
        /* traverse through this queue until it's empty */
        while (!queue.isEmpty()) {
            /* size denotes how many nodes does current level has */
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                currentLevel.add(Integer.valueOf(node.data));

                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(currentLevel);
        }
        return result;
    }

    public static ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        /* In boundary first element will come root node element */
        result.add(Integer.valueOf(root.data));
        result.add(addLeftNode(root.left, result));
        return result;
    }

    static boolean isLeafNode(Node node) {
        return node.left == null && node.right == null;
    }

    static void addLeftNode(Node node, ArrayList<Integer> result) {
        Node current = node;
        while (current != null) {
            /* Add only left nodes excluding leaf nodes */
            if (!isLeafNode(current)) {
                result.add(Integer.valueOf(current.data));
            }
            if (current.left != null) {
                current = current.left;
            } else if (current.right != null) {
                current = current.right;
            }
        }
    }

    static void addRightNode(Node node, ArrayList<Integer> result) {
        ArrayList<Integer> temp = new ArrayList<>();
        Node current = node;
        while (current != null) {
            result.add(Integer.valueOf(current.data));
            if (current.right != null) {
                current = current.right;
            } else if (current.left != null) {
                current = current.left;
            }
        }
        Collections.reverse(temp);
        for (int el : temp) {
            result.add(Integer.valueOf(el));
        }
    }

    static void addLeafNode(Node node, ArrayList<Integer> result) {
        if (isLeafNode(node)) {
            result.add(Integer.valueOf(node.data));
        }
        if (node.left != null) {
            addLeafNode(node.left, result);
        }
        if (node.right != null) {
            addLeafNode(node.right, result);
        }
    }

    static class Tuple {
        Node node;
        int row;
        int col;

        public Tuple(Node node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    // public static List<List<Integer>> verticalOrderTraversal(Node root){
    // TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new
    // TreeMap<>();
    // Queue<Tuple> queue = new LinkedList<Tuple>();
    // // adding root node to queue(row is level here and col is the vertical)
    // queue.offer(new Tuple(root, 0, 0));
    // //doing the level order traversal
    // while (!queue.isEmpty()) {
    // Tuple tuple = queue.poll();
    // Node node = tuple.node;
    // int x = tuple.row;
    // int y = tuple.col;

    // if()
    // }
    // }
    static class Pair {
        Node node;
        int vertical;

        public Pair(Node node, int vertical) {
            this.node = node;
            this.vertical = vertical;
        }
    }

    // function to return a list of nodes visible from the top view from left to
    // right in BinaryTree
    public static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        // TreeMap because to store in sorted order of key
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        // doing a level order traversal
        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int vertical = pair.vertical;
            Node temp = pair.node;
            if (map.get(vertical) == null)
                map.put(vertical, temp.data);
            if (temp.left != null) {
                queue.add(new Pair(temp.left, vertical - 1));
            }
            if (temp.right != null) {
                queue.add(new Pair(temp.right, vertical + 1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
