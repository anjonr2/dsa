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
        // result.add(addLeftNode(root.left, result));
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

    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int line = pair.vertical;
            map.put(line, pair.node.data);
            if (pair.node.left != null) {
                queue.add(new Pair(pair.node.left, line - 1));
            }
            if (pair.node.right != null) {
                queue.add(new Pair(pair.node.right, line + 1));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public List<Integer> rightSideView(Node root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(Node root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }
        if (level == list.size())
            list.add(root.data);
        rightView(root.right, list, level + 1);
        rightView(root.left, list, level + 1);
    }

    public boolean isSymmetric(Node root) {
        return root == null || isSymmetricHelp(root.left, root.right);
    }

    public boolean isSymmetricHelp(Node left, Node right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.data != right.data)
            return false;
        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
    }

    public boolean getPath(Node root, ArrayList<Integer> res, int value) {
        if (root == null)
            return false;
        res.add(root.data);
        if (root.data == value)
            return true;
        if (getPath(root.left, res, value) || getPath(root.right, res, value))
            return true;
        res.remove(res.size() - 1);
        return false;
    }

    public ArrayList<Integer> solve(Node root, int value) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        getPath(root, result, value);
        return result;
    }

    // function to return lowest common ancestor of two nodes
    public static Node lca(Node root, Node n1, Node n2) {
        if (root == null)
            return null;
        if (root.data == n1.data || root.data == n2.data)
            return root;
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);
        if (left == null)
            return right;
        if (right == null)
            return left;

        return root;
    }

    // this will be used to calculate the maximum width of a binary tree
    public static class Pair1 {
        Node node;
        int index;

        public Pair1(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    // function to calculate maximum width of a binary tree
    public static int widthOfBinaryTree(Node root) {
        if (root == null)
            return 0;
        int maxWidth = 0;
        // to do the level order traversal
        Queue<Pair1> queue = new LinkedList<>();

        queue.offer(new Pair1(root, 0));
        while (!queue.isEmpty()) {
            // this is to get no of nodes/elements in every level
            int size = queue.size();

            // this will give the minimum index in every level
            int min = queue.peek().index;

            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                int currentIdx = queue.peek().index - min;
                Node node = queue.peek().node;
                // remove element at the front
                queue.poll();
                if (i == 0)
                    first = currentIdx;
                if (i == size - 1)
                    last = currentIdx;
                if (node.left != null) {
                    queue.offer(new Pair1(node.left, currentIdx * 2 + 1));
                }
                if (node.right != null) {
                    queue.offer(new Pair1(node.right, currentIdx * 2 + 2));
                }
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        return maxWidth;
    }

    // this function returns list of all nodes
    // from a target node that are present in a distance of K
    public static List<Integer> distanceK(Node root, Node targetNode, int k) {
        // a map of parent and it's child node
        Map<Node, Node> parent_track = new HashMap<>();
        markParents(root, parent_track, targetNode);
        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(targetNode);
        visited.put(targetNode, true);
        // this variable will be storing the distance moved
        int currentLevel = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currentLevel == k)
                break;
            currentLevel++;
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null && visited.get(current.left) == null) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && visited.get(current.right) == null) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if (parent_track.get(current) != null && visited.get(parent_track.get(current)) == null) {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            result.add(current.data);
        }
        return result;
    }

    // doing a level order traversal
    public static void markParents(Node root, Map<Node, Node> parentMap, Node targetNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                // key is child node
                // value is parent node
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    public int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if (leftDepth == rightDepth) {
            return (int) Math.pow(2, rightDepth) - 1;
        }
        return 1 + countNodes(root.right) + countNodes(root.left);
    }

    private int rightDepth(Node root) {
        int depth = 0;
        while (root != null) {
            root = root.right;
            depth++;
        }
        return depth;
    }

    private int leftDepth(Node root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }

    // If preorder and in order traversal is given form an unique binary tree
    public Node buildTree(int[] preOrder, int[] inOrder) {
        // map to store all elements of in order traversal
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        Node root = buildTree(preOrder, 0, 0, inOrder, 0, 0, map);
        return root;
    }

    public Node buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd,
            Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd)
            return null;
        // first element of preOrder will always be the root node
        // of the unique binary tree
        Node root = new Node(preOrder[preStart]);
        int rootPositionInInorder = inMap.get(root.data);
        int numsLeft = rootPositionInInorder - inStart;
        root.left = buildTree(preOrder, preStart + 1, preStart + numsLeft, inOrder, inStart, rootPositionInInorder - 1,
                inMap);
        root.right = buildTree(preOrder, preStart+numsLeft+1, preEnd, inOrder, rootPositionInInorder+1, inEnd, inMap)
    }

    // build a binary tree from a given
    // pre order and in order traversal
    public Node buildBinaryTree(int[] inOrder, int[] preOrder) {
        // this is to identify where does root of the binary tree exists in in order
        // traversal
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        // this map will store array elements as its key and indexes of array as its
        // value
        // this map will help avoid iterating in order array again and again
        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndexMap.put(inOrder[i], i);
        }
        // here rootIndex is passed as 0 because root is the very first element in a pre
        // order traversal array
        // left bound is the starting index of in order traversal
        // right bound is the ending index of the in order traversal
        return splitTree(preOrder, inOrderIndexMap, 0, 0, inOrder.length - 1);
    }

    public Node splitTree(int[] preOrder, Map<Integer, Integer> inorderIndexMap, int rootIndex, int left, int right) {
        Node root = new Node(preOrder[rootIndex]);

        // this returns position of root node from in order traversal array
        int mid = inorderIndexMap.get(root.data);
        if (mid > left) {
            root.left=splitTree(preOrder, inorderIndexMap, rootIndex+1, left, mid-1);
            root.right=splitTree(preOrder, inorderIndexMap, rootIndex+mid-left+1, mid+1, right)
        }
        return root;
    }

    // post order and in order traversal is given
    public Node buildBinaryTreeFromTraversal(int[] inOrder, int[] postOrder) {
        if (inOrder.length != postOrder.length)
            return null;
        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderIndexMap.put(inOrder[i], i);
        }
        return buildTreePostIn(inOrder, 0, inOrder.length-1, postOrder, 0, postOrder.length-1, inOrderIndexMap)
    }

    // is = starting point of in order traversal array
    // ie = ending point of the in order traversal array
    // ps=starting point of post order traversal array
    // pe = ending point of post order traversal array
    private Node buildTreePostIn(int[] inOrder, int is, int ie, int postOrder[], int ps, int pe,
            Map<Integer, Integer> inorderIndexMap) {
        if (ps > pe || is > ie)
            return null;
        Node root = new Node(postOrder[pe]);

        // this gives the index of root the element from inorder traversal
        int inRoot = inorderIndexMap.get(root.data);
        // this gives total number of element present on the left of root element
        int numsLeft = inRoot - is;
        root.left=buildTreePostIn(inOrder, is, inRoot-1, postOrder, ps, ps+numsLeft-1, inorderIndexMap);
        root.right=buildTreePostIn(inOrder, inRoot+1, ie, postOrder, ps+numsLeft, pe-1, inorderIndexMap)
        return root;
    }

    // flattern a given binary tree
    public void flatten(Node root) {
        if (root == null)
            return;
        Node left = root.left;
        // to keep a track of the right node
        Node right = root.right;
        flatten(root.left);
        root.right = root.left;
        root.left = null;
        Node prev = null;

    }

    public static void main(String[] args) {

    }
}
