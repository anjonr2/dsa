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
    public static int length(Node node){
        int length=0;
        while (node!=null){
            length++;
            node=node.next;
        }
        return length;
    }
    public static Node deleteMiddle(Node head){
        if(head==null && head.next==null){
            return null;
        }
        Node temp = head;
        int length = length(temp);
        int res = length/2;
        temp=head;
        while (temp!=null){
            res--;
            if(res==0){
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
        return head;
    }
    public static void main(String []args){
        int arr[] = {2, 5, 6, 8, 4};
        Node head = convertArr2LL(arr);
        head=deleteMiddle(head);
        System.out.println("After deleting middle node");
        print(head);
    }
}
