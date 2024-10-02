package com.dsa.linkedList.medium;

public class DeleteAllOccurrencesOfAKey {
    public class Node {
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

    Node deleteAllOccurrences(Node head, int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                if (temp == head) {
                    head = head.next;
                }
                Node prev = temp.prev;
                Node next = temp.next;
                if (next != null)
                    next.prev = prev;
                if (prev != null)
                    prev.next = next;
                temp = next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
