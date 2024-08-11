package com.dsa.linkedList.utils;

public class DoublyLinkedList {
    static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node arr2DLLNode(int arr[]) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i], null, prev);
            prev.next = node;
            prev = node;
        }
        return head;
    }

    public static void traverse(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Node deleteHead(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node prev = head;
        head = head.next;
        head.prev = null;
        prev.next = null;
        return head;
    }

    public static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.prev;
        tail.prev = null;
        prev.next = null;
        return head;
    }

    public static Node removeKthElement(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                break;
            }
            temp = temp.next;
        }
        Node back = temp.prev;
        Node front = temp.next;

        if (back == null && front == null) {
            return null;
        } else if (back == null) {
            deleteHead(temp);
        } else if (front == null) {
            deleteTail(temp);
        } else {
            back.next = temp.next;
            front.prev = temp.prev;
            temp.prev = null;
            temp.next = null;
        }
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 5, 6, 8, 9, 20, 56 };
        Node node = arr2DLLNode(arr);
        System.out.println(node.data);
        traverse(node);
        node = deleteTail(node);
        System.out.println("Doubly linked list after deleting tail---");
        traverse(node);

        Node head = removeKthElement(node, 2);
        System.out.println("Linked List after deleting 2nd element");
        traverse(head);
    }
}
