package com.dsa.tree;

public class BinaryTree2 {
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data=data;
        }
    }
    static class Pair{
        Node node;
        int data;
        public Pair(Node node, int data){
            this.node=node;
            this.data=data;
        }
    }
    public void preInPostTraversal(Node root){

    }
    public static void main(String []args){
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);

        root.left=node1;
        node1.left=node2;
        node1.right=node3;
        root.right=node4;
        node4.left=node5;
        node4.right=node6;
    }
}
