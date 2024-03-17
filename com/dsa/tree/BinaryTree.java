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
    /*Root->Left->Right*/
    public static void preorder(Node root){
        if(root==null) return;
        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }
    /*left->root->right*/
    public static void inorder(Node root){
        if(root==null) return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    /*Left->right->root*/
    public static void postorder(Node root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }
    public static void main(String []args){
        Node root = new Node(1);
        Node right = new Node(2);
        Node left = new Node(3);
        root.left=left;
        root.right=right;
        System.out.println("pre order traversal");
        preorder(root);

        System.out.println("Inorder traversal");
        inorder(root);

        System.out.println("Post order traversal");
        postorder(root);
    }
}
