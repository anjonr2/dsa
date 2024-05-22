package com.dsa.linkedList;

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

    static class DLLNode {
        int data;
        DLLNode next;
        DLLNode prev;

        public DLLNode(int data) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    public Node rotate(Node head, int k) {
        int length = 1;
        Node tail = head;

        while (tail != null && tail.next != null) {
            length++;
            tail = tail.next;
        }
        if (k % length == 0) {
            return head;
        }
        k = k % length;
        Node newTailNode = findNthNode(head, length - k);
        tail.next = head;
        head = newTailNode.next;
        newTailNode.next = null;
        return head;
    }

    public Node findNthNode(Node node, int k) {
        int count = 1;
        while (node != null) {
            if (count == k)
                return node;
            count++;
            node = node.next;
        }
        return node;
    }
}
