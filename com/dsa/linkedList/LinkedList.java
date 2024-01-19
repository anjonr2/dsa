package com.dsa.linkedList;

public class LinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String []args){
        int arr[] = {2,5,6,8};
        Node node = new Node(arr[0]);
        System.out.println("Node data "+node.data);
    }
}
