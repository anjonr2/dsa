package com.dsa.linkedList.utils;

public class LinkedList {
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

    public static Node convertArr2LL(int arr[]) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node node = new Node(arr[i]);
            temp.next = node;
            temp = node;
        }
        return head;
    }

    public static void traverse(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static int length(Node head) {
        int cnt = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr = { 12, 5, 6, 8, 9, 20, 56 };
        Node head = convertArr2LL(arr);
        System.out.println("head data " + head.data);
        System.out.println("--------------------");
        System.out.println("Linked List Data are ");
        traverse(head);
        int length = length(head);
        System.out.println("--------------------");
        System.out.println("length of the linked list is");
        System.out.println(length);
    }
}
