package com.dsa.doublyLinkedList;

public class DLL {
    static class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data, Node next, Node prev){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    static Node convert2DLL(int arr[]){
        Node head = new Node(arr[0]);
        Node temp = head;
        for(int i=1;i<arr.length; i++){
            Node node = new Node(arr[i],null,temp);
            temp.next=node;
            temp = node;
        }
        return head;
    }
    static void printDoublyLinkedList(Node head){
        while (head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
    static Node deleteHead(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        return head;
    }
    static Node deleteTail(Node head){
        if(head == null || head.next == null){
            return null;
        }
        Node tail = head;
        while (tail.next != null){
            tail = tail.next;
        }
        Node node = tail.prev;
        tail.prev = null;
        node.next = null;
        return head;
    }
    static Node removeKthElement(Node head, int k){
        if(head == null){
            return null;
        }
        int cnt = 0;
        Node temp = head;
        while (temp !=null){
            cnt ++;
            if(k==cnt) break;
            else temp = temp.next;
        }
        Node nodePrev = temp.prev;
        Node nodeNext = temp.next;
        if(nodePrev == null && nodeNext == null){
            /*if both nodeNext and nodePrev null it says DLL has only one node*/
            return null;
        }
        else if(nodePrev == null){
            /*if nodePrev is null it says it is head node of the DLL*/
            deleteHead(head);
        }else if(nodeNext == null){
            /*if nodeNext is null it says it is tail node of the DLL*/
            deleteTail(head);
        }else {
            nodePrev.next = nodeNext;
            nodeNext.prev = nodePrev;
            temp.next = null;
            temp.prev=null;
        }
        return head;
    }
    public static void main(String []args){
        int arr[] = {15,5,8,7,2,3,4};
        Node head = convert2DLL(arr);
        System.out.println("Array after converting it to Doubly Linked List");
        printDoublyLinkedList(head);

        head= deleteHead(head);
        System.out.println("Linked List after deleting head node");
        printDoublyLinkedList(head);

        head= deleteTail(head);
        System.out.println("Linked List after deleting tail node");
        printDoublyLinkedList(head);

        head = removeKthElement(head,6);
        System.out.println("Linked List after deleting 3rd node");
        printDoublyLinkedList(head);
    }
}
