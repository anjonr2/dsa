package com.dsa.linkedList.medium;

public class RemoveDuplicatesFromSortedDLL {
    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

    }

    public static Node removeDuplicates(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null) {
            Node nextNode = temp.next;
            while (nextNode != null && temp.data == nextNode.data) {
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if (nextNode != null)
                nextNode.prev = temp;
        }
        return head;
    }
}
