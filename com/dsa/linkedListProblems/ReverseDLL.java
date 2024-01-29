package com.dsa.linkedListProblems;

public class ReverseDLL {
    static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data,Node next, Node prev){
            this.data = data;
            this.next=next;
            this.prev=prev;
        }
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    static Node reverseDLL(Node head){
        if(head == null || head.next == null) return head;
        Node current = head, prevNode=null;
        while (current !=null){
            prevNode = current.prev;
            current.prev=current.next;
            current.next = prevNode;
        }
        return prevNode.prev;
    }
    static void print(Node head){
        while (head!=null){
            System.out.print(head.data+" ");
            head = head.next;
        }
    }
    static Node convertArr2LL(int arr[]){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node node = new Node(arr[i],null,temp);
            temp.next=node;
            temp=node;
        }
        return head;
    }
    public static void main(String []args){
        int arr[] = {12, 5, 6, 8, 4};
        Node head = convertArr2LL(arr);
        print(head);
//        Node reversedHead = reverseDLL(head);
        System.out.println("LinkedList after reversal");
//        print(reversedHead);

    }
}
