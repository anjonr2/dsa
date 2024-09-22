package com.dsa.linkedList.medium;

public class DeleteMiddleNode {
    public class Node {
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

    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            cnt++;
            temp = temp.next;
        }

        int res = cnt / 2;
        temp = head;

        while (temp != null) {
            res--;
            if (res == 0) {
                Node middle = temp.next;
                temp.next = middle.next;
                middle.next = null;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static Node deleteMiddle1(Node head) {
        if (head == null || head.next == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;
        Node prevMiddle = null;

        while (fast != null && fast.next != null) {
            prevMiddle = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        Node middle = prevMiddle.next;
        prevMiddle.next = middle.next;
        middle.next = null;
        return head;
    }
}
