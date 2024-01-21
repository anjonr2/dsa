package com.dsa.LinkedList2;

public class InsertionLL {
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
    static Node convertarr2LL(int arr[]){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node node = new Node(arr[i]);
            temp.next = node;
            temp = temp.next;
        }
        return head;
    }
    static void traverse(Node head){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    static Node insertAtHead(Node head, int value){
        Node temp = new Node(value,head);
        return temp;
    }
    static Node insertAtTail(Node head, int value){
        if(head == null){
            return new Node(value);
        }
        Node temp = head;
        Node node = new Node(value);
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        return head;
    }
    public static void main(String []args){
        int arr[] = {12,5,8,7};
        Node head = convertarr2LL(arr);
        System.out.println("After converting the array to LinkedList");
        traverse(head);
        head = insertAtHead(head,6);
        System.out.println("After insertion linkedlist");
        traverse(head);
        head = insertAtTail(head,11);
        System.out.println("linkedlist after insertion at tail");
        traverse(head);
    }
}
