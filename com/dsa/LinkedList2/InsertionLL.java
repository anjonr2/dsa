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
    static Node insertAtK(Node head, int value, int k){
        if(head == null){
            if(k==1) return new Node(value);
            else return head;
        }
        if(k==1){
            Node node = new Node(value,head);
            return node;
        }
        int cnt = 0;
        Node temp = head;
        while (temp != null){
            cnt++;
            if(cnt == k-1){
                Node node = new Node(value,temp.next);
                temp.next = node;
            }
            temp = temp.next;
        }
        return head;
    }
    static Node insertBeforeValue(Node head, int element, int value){
        if(head ==null) return null;
        if(head.data == value){
            return new Node(element,head);
        }
        Node temp = head;
        while (temp.next != null){
            if(temp.next.data == value){
                Node node = new Node(element,temp.next);
                temp.next = node;
            }
            temp = temp.next;
        }
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

        head = insertAtK(head,21,3);
        System.out.println("linkedlist after insertion at "+3);
        traverse(head);

        head = insertBeforeValue(head,34,11);
        System.out.println("linkedlist after insertion before "+11);
        traverse(head);
    }
}
