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

    public int KthLargest(Node root, int k) {
        int ans = -1;
        solve(root, k, ans);
        return ans;
    }

    public void solve(Node root, int k, int ans) {
        int counter = 1;
        if (root == null)
            return;
        solve(root.right, k, ans);
        if (counter == k) {
            ans = root.data;
            counter++;
            return;
        }
        counter++;
        solve(root.left, k, ans);
    }

    public boolean isValidBST(Node root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(Node root, long minVal, long maxVal) {
        if (root == null)
            return true;
        if (root.data >= maxVal || root.data <= minVal)
            return false;
        return isValidBST(root.right, root.data, maxVal) && isValidBST(root.left, minVal, root.data);
    }

    // this function finds the lca of two given node
    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null)
            return null;
        int curr = root.data;
        // if both the node p and q is greater than root then it lies on the right
        if (curr < p.data && curr < q.data) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (curr > p.data && curr > q.data) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
