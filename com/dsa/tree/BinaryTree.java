package com.dsa.tree;

public class BinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    public static void main(String []args){
        Node root = new Node(1);
        Node right = new Node(2);
        Node left = new Node(3);
        root.left=left;
        root.right=right;
    }
}
