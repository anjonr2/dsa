package com.dsa.tree;

public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node search(Node root, int value) {
        while (root != null && root.data != value) {
            root = value < root.data ? root.left : root.right;
        }
        return root;
    }

    public static int findCeil(Node root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.data == key) {
                ceil = key;
                return ceil;
            }
            if (key > root.data) {
                root = root.right;
            } else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }

    public static int floorInBST(Node root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.data == key) {
                floor = key;
                return floor;
            }
            if (key > root.data) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }

    public Node insert(Node root, int value) {
        // if the root is null return that value itself as the root of the tree
        if (root == null)
            return new Node(value);
        Node temp = root;
        while (true) {
            if (temp.data <= value) {
                if (temp.right != null)
                    temp = temp.right;
                else
                    temp.right = new Node(value);
                break;
            } else {
                if (temp.left != null)
                    temp = temp.left;
                else
                    temp.left = new Node(value);
                break;
            }
        }
        return root;
    }

    public Node deleteNode(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (root.data == value) {
            return helper(root);
        }
        Node temp = root;
        while (root != null) {
            if (root.data > value) {
                if (root.left != null && root.left.data == value) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.data == value) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return temp;
    }

    public Node helper(Node root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        }
        Node rightChild = root.right;
        Node lastRight = findLastRight(root.left);
        lastRight.right = rightChild;
        return root.left;
    }

    public Node findLastRight(Node root) {
        if (root.right == null)
            return root;
        return findLastRight(root.right);
    }
}