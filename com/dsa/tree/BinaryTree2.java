package com.dsa.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
        Stack<Pair> stack = new Stack<Pair>();
        List<Integer> preorder = new ArrayList<Integer>();
        List<Integer> inorder = new ArrayList<Integer>();
        List<Integer> postorder = new ArrayList<Integer>();
        /*to start with
        * initially stack will have
        * root node and num as 1*/
        stack.push(new Pair(root,1));

        /*Need to keep traversing
        * till the stack
        * is not empty*/
        while (!stack.isEmpty()){
            Pair pair = stack.pop();

            /*this is part of pre order
            * check if data is 1
            * check if that node which is popped from stack
            * has a left node
            * then add that to the stack*/
            if(pair.data==1){
                preorder.add(pair.node.data);
                pair.data++;
                stack.push(pair);

                if(pair.node.left!=null){
                    stack.push(new Pair(pair.node.left,1));
                }
            }
            /*this is part of inorder
             * check if data is 2
             * check if that node which is popped from stack
             * has a right node
             * then add that to the stack*/
            if(pair.data==2){
                inorder.add(pair.node.data);
                pair.data++;
                stack.push(pair);

                if(pair.node.right!=null){
                    stack.push(new Pair(pair.node.right,1));
                }
            }
            else {
                postorder.add(pair.node.data);
            }
        }
    }
    /*maxDepth or height of a tree calculating recursively*/
    public static int maxDepth(Node root){
        if(root==null) return 0;
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);

        return 1 + Math.max(lh,rh);
    }
    public static boolean isBalanced(Node root){
        return true;
    }
    /*Calculating height of a given tree*/
    public static int height(Node root){
        if(root==null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
//    {
//        if(root==null) return true;
//
//        /*here checking the height difference*/
//        if((Math.abs(height(root.left)-height(root.right)))>1) return false;
//
//        /*recursively calling this to the left and right of the binary tree*/
//        return isBalanced(root.left) && isBalanced(root.right);
//    }
    public static boolean isBalanced2(Node root){
        return height2(root) !=-1;
    }
    public static int height2(Node node){
        if(node==null) return 0;
        int lh = height2(node.left);
        if(lh==-1) return -1;
        int rh=height2(node.right);
        if(rh==-1) return -1;
        if((Math.abs(lh-rh))>1) return -1;
        return 1 + Math.max(lh,rh);
    }
    public static int diameter(Node root){
        if(root==null) return 0;
        int option1 = height3(root.left)+height3(root.right);
        int option2 = diameter(root.left);
        int option3 = diameter(root.right);

        return Math.max(option1,Math.max(option2,option3));
    }
    public static int height3(Node root){
        if(root==null) return 0;
        int lh = height3(root.left);
        int rh = height3(root.right);

        return 1+Math.max(lh,rh);
    }
    public static boolean isSameTree(Node root1, Node root2){
        if(root1==null && root2==null){
            return (root1==root2);
        }
        return (root1.data==root2.data) && isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right);
    }
    public static void main(String []args){
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        Node node8 = new Node(9);
        Node node9 = new Node(10);
        root.left=node1;
        node1.left=node2;
        node1.right=node3;
        root.right=node4;
        node4.left=node5;
        node4.right=node6;
        node6.left=node7;
        node7.left=node8;
        node8.left=node9;

        int maxDepth = maxDepth(root);
        System.out.println("max depth is "+maxDepth);

        boolean isBalanced = isBalanced(root);
        System.out.println("given binary tree is balanced "+isBalanced);
    }
}
