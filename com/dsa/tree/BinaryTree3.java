package com.dsa.tree;

import java.util.*;

public class BinaryTree3 {
    static class Node{
        int data;
        Node right;
        Node left;
        public Node(int data){
            this.data=data;
        }
    }
    public static List<List<Integer>> zigzagLevelOrder(Node root){
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        /*queue to store nodes*/
        Queue<Node> queue = new LinkedList<>();
        /*this flag is to traverse
        * right to left side of tree
        * for zigzag level order*/
        boolean flag = false;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            for(int i=0; i<size; i++){
                Node node = queue.poll();

                if(flag) stack.add(node.data);
                level.add(node.data);

                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            /*after for loop completed
            * means one level is completed
            * so reverse the flag
            * to traverse right to left*/
            flag = !flag;
            if(!stack.isEmpty()){
                level.add(stack.pop());
            }

            result.add(level);
        }
        return result;
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

        System.out.println("Testing");
    }
}
