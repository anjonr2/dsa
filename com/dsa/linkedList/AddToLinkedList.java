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

    public Node add(Node head) { // total time complexity of this approach is O(3n)
        head = reverse(head); // O(n) - reverse in one pass
        Node temp = head;
        int carry = 1;

        while (temp != null) {
            // again this traversal O(n)
            temp.data = temp.data + carry;

            if (temp.data < 10) {
                carry = 0;
                break;
            } else {
                // since adding one 1 to linked list node data
                // so maximum value will be 10 not beyond that
                // hence temp.data = 0
                temp.data = 0;
                carry = 1;
            }
            temp = temp.next;
        }
        if (carry == 1) {
            Node node = new Node(1);
            head = reverse(head);
            node.next = head;
            head = node;
            return head;
        }
        // O(n)
        return reverse(head);
    }
}
