package com.problemsolving.DoublyLinkedList.basics;

import com.problemsolving.DoublyLinkedList.util.Node;

public class DoublyLinkedList {
    /* Function to convert an array to a doubly linked list */
    public static Node convertArr2DLL(int[] arr) {
        Node head = new Node(arr[0]);

        Node prev = head;

        for (int i = 1; i < arr.length; i += 1) {
            /* Create a new node */
            Node node = new Node(arr[i], prev, null);

            /* Set next of the previous node to the new node */
            prev.next = node;

            /* Move prev to the new node */
            prev = node;
        }

        return head;
    }

    /* Function to print the elements of the doubly linked list */
    public static void print(Node head) {
        while (head != null) {
            System.out.println(head.data + " ");
            head = head.next; // move to the next node
        }
    }

    /* Function to insert a node at the tail of the doubly linked list */
    public static Node insertAtTail(Node head, int k) {
        Node newNode = new Node(k);

        /* If the list is empty return the new node as the head */
        if (head == null)
            return newNode;

        Node curr = head;

        /* traverse till the last node of the doubly linked list */
        while (curr.next != null) {
            curr = curr.next;
        }

        /* connect the new node to the last node */
        curr.next = newNode;
        newNode.prev = curr; /* Set the back pointer of the new node to the previous node */

        return head;
    }

    /* Function to delete tail of doubly linked list */
    public Node deleteTail(Node head) {
        /* if the list is empty */
        if (head == null)
            return null;

        /* If only one node is present */
        if (head.next == null)
            return null;

        Node temp = head;

        /* traverse till the last node */
        while (temp.next != null) {
            temp = temp.next;
        }

        /* update the second last node's tail to null */
        temp.prev.next = null;

        return head;
    }
}
