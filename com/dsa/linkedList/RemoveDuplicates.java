package com.dsa.linkedList;

public class RemoveDuplicates {
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

    // remove duplicates from a sorted list
    public Node removeDuplicate(Node head) {
        Node prev = head;
        Node curernt = prev.next;

        // run a loop till the end of the list
        while (curernt != null) {
            // check if the current value is duplicate of the previous one
            // by comparing it with the previous value
            if (prev.data == curernt.data) {
                continue;
            }

            // else make previous node point to next unique node
            prev.next = curernt;

            // update previous to point to current node
            prev = curernt;

            // move current node to next for next iteration
            curernt = curernt.next;
        }
        prev.next = null;
        return head;
    }

}
