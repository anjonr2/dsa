package com.dsa.linkedList;

// add to a number represented by a linkedList
public class AddToLinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node reverse(Node head) {
        Node temp = head;
        Node front = temp.next;
        Node prev = null;

        while (temp != null) {
            temp.next = prev;
            prev = temp;
            temp = front;
            front = temp.next;
        }
        return prev;
    }
}
