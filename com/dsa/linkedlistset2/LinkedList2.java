package com.dsa.linkedlistset2;

public class LinkedList2 {
    static class Node{
        int data;
        Node next;
        public Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
        public Node(int data){
            this.data = data;
        }
    }
    public static void print(Node head){
        while (head!=null){
            System.out.println(head.data+" ");
            head=head.next;
        }
    }
    public static Node convertarr2LL(int []arr){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node node = new Node(arr[i]);
            temp.next=node;
        }
        return head;
    }
    public static void main(String []args){

    }
}
