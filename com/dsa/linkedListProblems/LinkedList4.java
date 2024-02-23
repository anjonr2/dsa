package com.dsa.linkedListProblems;

public class LinkedList4 {
    static class Node{
        int data;
        Node next;
        public Node(int data, Node next){
            this.data=data;
            this.next=next;
        }
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node convertArr2LL(int arr[]){
        Node head=new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node node = new Node(arr[i]);
            temp.next=node;
            temp=node;
        }
        return head;
    }
    public static void print(Node head){
        while (head!=null){
            System.out.print(" "+head.data+" ");
            head=head.next;
        }
    }
    public static void main(String []args){
        System.out.println("test");
    }
}
