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
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
    public static Node convertarr2LL(int []arr){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1; i<arr.length; i++){
            Node node = new Node(arr[i]);
            temp.next=node;
            temp=node;
        }
        return head;
    }
    public static Node groupOddEven(Node head){
        if(head == null || head.next == null) return head;
        Node odd = head, even = head.next, evenHead = even;
        while (even !=null && even.next.next==null){
            odd.next = odd.next.next;
            even.next=even.next.next;
            odd = odd.next;
            even=even.next.next;
        }
        odd.next=evenHead;
        return head;
    }
    public static void main(String []args){
        int arr[] = {2, 5, 6, 8, 4};
        Node head = convertarr2LL(arr);
        System.out.println("After converting array to list");
        print(head);
        head = groupOddEven(head);
        System.out.println("After grouping odd and even nodes together");
        print(head);
    }
}
