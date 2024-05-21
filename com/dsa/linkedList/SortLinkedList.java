package com.dsa.linkedList;

// sort a linked list of 0's 1's and 2's
public class SortLinkedList {
    static class Node {
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

    public Node sort(Node head) {
        Node temp = head;
        int cnt0 = 0;
        int cnt1 = 0;
        int cnt2 = 0;

        while (temp != null) {
            if (temp.data == 0)
                cnt0++;
            if (temp.data == 1)
                cnt1++;
            if (temp.data == 2)
                cnt2++;
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (cnt0 > 0) {
                temp.data = 0;
                cnt0--;
            } else if (cnt1 > 0) {
                temp.data = 1;
                cnt1--;
            } else {
                temp.data = 2;
                cnt2--;
            }
            temp = temp.next;
        }
        return head;
    }
}
