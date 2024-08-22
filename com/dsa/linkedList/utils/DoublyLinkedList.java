package com.dsa.linkedList.utils;

import java.util.Stack;

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

    public static Node insertBeforeHead(Node head, int val) {
        Node node = new Node(val, head, null);
        head.prev = node;
        return node;
    }

    public static Node insertBeforeTail(Node head, int val) {
        if (head.next == null) {
            return insertBeforeHead(head, val);
        }
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.prev;
        Node node = new Node(val, tail, prev);
        prev.next = node;
        tail.prev = node;
        return head;
    }

    public static Node insertBeforeKthElement(Node head, int k, int val) {
        if (k == 1) {
            return insertBeforeHead(head, val);
        }
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt += 1;
            if (cnt == k) {
                break;
            }
            temp = temp.next;
        }
        Node prev = temp.prev;
        Node node = new Node(val, temp, prev);
        prev.next = node;
        temp.prev = node;

        return head;
    }

    public static void insertBeforeNode(Node node, int val) {
        Node prev = node.prev;
        Node newNode = new Node(val, node, prev);
        prev.next = newNode;
        node.prev = newNode;
    }

    public static Node reverse(Node head) {
        Node temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = stack.pop();
            temp = temp.next;
        }
        return head;
    }

    public static Node reverse1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node prev = null;
        Node current = head;
        while (current != null) {
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            current = current.prev;
        }
        return prev.prev;
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

        head = insertBeforeHead(head, 11);
        System.out.println("Linked List after inserting before head");
        traverse(head);

        head = insertBeforeTail(head, 55);
        System.out.println("Linked List after inserting before tail node");
        traverse(head);

        head = reverse1(head);
        System.out.println("Linked List after reversing");
        traverse(head);
    }
}
