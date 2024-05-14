package com.dsa.tree;

import java.util.*;

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
    public static List<List<Integer>> levelrorder(Node root){
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        /*This queue is to process the tree*/
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root); //adding root node to queue
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            while (size-->0){
                Node current = queue.poll();
                currentLevel.add(current.data);
                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);
            }
            result.add(currentLevel);
        }
        return result;
    }
    public static List<Integer> iterativePreOrder(Node root){
        List<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node top = stack.pop();
            result.add(top.data);
            if(root.right!=null){
                stack.push(root.right);
            }
            if(root.left!=null){
                stack.push(root.left);
            }
        }
        return result;
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

        System.out.println("iterative pre order traversal ");
        List<Integer> result = iterativePreOrder(root);
        for(int e : result){
            System.out.println(e);
        }
        
    }
}
