package com.dsa.linkedList.medium;

public class RotateLinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static Node findNthNode(Node head, int n) {
        int cnt = 1;
        while (cnt != n && head != null) {
            cnt++;
            head = head.next;
        }
        return head;
    }

    public static Node rotate(Node head, int k) {
        if (head == null || k == 0)
            return head;
        Node tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        if (k % length == 0)
            return head;
        k = k % length;

        tail.next = head;
        Node newLastNode = findNthNode(head, length - k);
        Node newHead = newLastNode.next;
        newLastNode.next = null;
        return newHead;
    }
}
