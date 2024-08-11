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

    public static void main(String[] args) {
        int arr[] = { 12, 5, 6, 8, 9, 20, 56 };
        Node node = arr2DLLNode(arr);
        System.out.println(node.data);
        traverse(node);
    }
}
