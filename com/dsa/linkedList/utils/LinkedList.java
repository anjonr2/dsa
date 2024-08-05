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

    public static boolean searchInLinkedList(Node head, int val) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == val) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public static Node removeHead(Node head) {
        if (head == null)
            return head;
        head = head.next;
        return head;
    }

    public static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    public static Node removeKthElement(Node head, int k) {
        if (head == null)
            return null;
        Node temp = head;
        Node prev = null;
        int cnt = 0;
        if (k == 1) {
            head = head.next;
            return head;
        }
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node removeElement(Node head, int element) {
        if (head == null) {
            return head;
        }
        if (head.data == element) {
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.data == element) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    public static Node insertAtHead(Node head, int val) {
        Node temp = new Node(val, head);
        return temp;
    }

    public static Node insertAtTail(Node head, int val) {
        if (head == null) {
            return new Node(val);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node node = new Node(val);
        temp.next = node;
        return head;
    }

    public static Node insertAtPositionK(Node head, int val, int k) {
        if (head == null) {
            if (k == 1)
                return new Node(val);
        }
        if (k == 1) {
            return new Node(val, head);
        }
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k - 1) {
                Node node = new Node(val, temp.next);
                temp.next = node;
            }
            temp = temp.next;
        }
        return head;
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
