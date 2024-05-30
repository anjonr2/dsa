package com.dsa.linkedList;

public class MergeSortedLinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node sort(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        Node t1 = head1;
        Node t2 = head2;

        while (t1.next != null && t2.next != null) {
            if (t1.data < t2.data) {
                temp.next = t1;
                temp = t1;
                t1 = t1.next;
            } else {
                temp.next = t2;
                temp = t2;
                t2 = t2.next;
            }
        }
        if (t1 != null) {
            temp.next = t1;
        }
        if (t2 != null) {
            temp.next = t2;
        }
        return dummy.next;
    }
}
