package com.dsa.BinarySearchTree.problems;

import com.dsa.BinaryTree.util.Node;

public class FloorInBST {
    /* floor is the value which is greatest value lesser than given key */
    public static int floorInBST(Node root, int key) {

        int floor = -1;
        while (root != null) {
            if (root.val == key) {
                floor = root.val;
                return floor;
            }
            if (key > root.val) {
                floor = root.val;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
}
