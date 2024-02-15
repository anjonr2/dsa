package com.dsa.linkedListProblems;

public class LinkedList3 {
    static class Node{
        int data;
        Node next;
        public Node(int data,Node next){
            this.data=data;
            this.next=next;
        }
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static void traverse(Node head){
        while (head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    public static Node convertArr2LL(int arr[]){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node node = new Node(arr[i]);
            temp.next=node;
            temp=node;
        }
        return head;
    }
    public static Node reverse(Node head){
        Node temp = head;
        Node back = null;
        while (temp!=null){
            Node front = temp.next;
            temp.next=back;
            back=temp;
            temp=front;
        }
        return back;
    }
    public static void main(String []args){
        int arr[] = {2, 5, 6, 8, 4};
        Node head = convertArr2LL(arr);
        System.out.println("After converting array to LinkedList");
        traverse(head);

        head = reverse(head);
        System.out.println("After reversing the linkedList");
        traverse(head);
    }
}
