package com.dsa.doublyLinkedList;

import java.util.ArrayList;
import java.util.List;

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
    /*Created a Pair class to return pair of list*/
    static class Pair<K,V>{
        K value1;
        V value2;
        public Pair(K value1, V value2){
            this.value1=value1;
            this.value2=value2;
        }

        public K getValue1() {
            return value1;
        }

        public void setValue1(K value1) {
            this.value1 = value1;
        }

        public V getValue2() {
            return value2;
        }

        public void setValue2(V value2) {
            this.value2 = value2;
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
            return deleteHead(head);
        }else if(nodeNext == null){
            /*if nodeNext is null it says it is tail node of the DLL*/
            return deleteTail(head);
        }else {
            nodePrev.next = nodeNext;
            nodeNext.prev = nodePrev;
            temp.next = null;
            temp.prev=null;
        }
        return head;
    }
    static Node insertBeforeHead(Node head, int value){
        Node node = new Node(value,head,null);
        head.prev = node;
        return node;
    }
    static Node insertBeforeTail(Node head,int value){
        Node temp = head;
        if(head.next == null){
            return insertBeforeHead(head,value);
        }
        while (temp.next != null){
            temp = temp.next;
        }
        Node prevNode = temp.prev;
        Node node = new Node(value,temp,prevNode);
        prevNode.next = node;
        temp.prev = node;
        return head;
    }
    static Node insertBeforeKthElement(Node head, int k,int value){
        if(k==1){
            return insertBeforeHead(head,value);
        }
        Node temp = head;
        int cnt = 0;
        while (temp != null){
            cnt++;
            if(cnt == k) break;
            temp = temp.next;
        }
        Node nodePrev = temp.prev;
        Node node = new Node(value,temp,nodePrev);
        nodePrev.next = node;
        temp.prev = node;
        return head;
    }
    /*Function to delete all occurrences of a given key*/
    public static Node deleteAllOccurrences(Node head,int key){
        Node temp = head;
        while (temp!=null){
                if(temp.data==key){
                    if(temp==head){
                        /*need to delete the head node so update head to its next node*/
                        head=head.next;
                    }
                    Node nextNode = temp.next;
                    Node prevNode = temp.prev;
                    if(nextNode!=null){
                        nextNode.prev=prevNode;
                    }
                    if(prevNode!=null){
                        prevNode.next=nextNode;
                    }
                    temp=nextNode;
                }else{
                    temp=temp.next;
                }
        }
        return head;
    }
    public static List<Pair<Integer,Integer>> findAllPairs(Node head, int sum){
        List<Pair<Integer,Integer>> res = new ArrayList<Pair<Integer,Integer>>();
        Node left = head;
        Node right = findTailNode(head);
        while (left.data<right.data){
            if(left.data+right.data==sum){
                res.add(new Pair<>(new Integer(left.data),new Integer(right.data)));
                left=left.next;
                right=right.prev;
            } else if (left.data+right.data<sum) {
                left=left.next;
            }else {
                right=right.prev;
            }
        }
        return res;
    }
    public static Node findTailNode(Node head){
        Node tail = head;
        while (tail!=null){
            tail=tail.next;
        }
        return tail;
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

        head = removeKthElement(head,3);
        System.out.println("Linked List after deleting 3rd node");
        printDoublyLinkedList(head);

        head = insertBeforeHead(head,1);
        System.out.println("Linked List after inserting before head node");
        printDoublyLinkedList(head);

        head = insertBeforeTail(head,6);
        System.out.println("Linked List after inserting before tail node");
        printDoublyLinkedList(head);

        head = insertBeforeKthElement(head,5,4);
        System.out.println("Linked List after inserting before 4th node");
        printDoublyLinkedList(head);

//        head=deleteAllOccurrences(head,8);
//        System.out.println("After deleting all occurrences of key "+8);
//        printDoublyLinkedList(head);
        List<Pair<Integer,Integer>> res = findAllPairs(head,15);
        System.out.println("Pairs with the given sum is "+res);
    }
}
