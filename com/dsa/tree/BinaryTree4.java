package com.dsa.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree4 {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data=data;
        }
    }
    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return  result;
        Queue<Node> queue = new LinkedList<Node>();
        /*start with root node*/
        queue.add(root);
        /*traverse through this queue until it's empty*/
        while (!queue.isEmpty()){
            /*pop first element and print data inside it*/
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0; i<size; i++){
                Node node = queue.poll();
                currentLevel.add(Integer.valueOf(node.data));

                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            result.add(currentLevel);
        }
        return result;
    }
    public static void main(String []args){
       
    }
}
