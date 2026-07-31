package com.problemsolving.LinkedList.basics;

import com.problemsolving.LinkedList.util.Node;

public class LinkedList {
    /* Function to insert a new node at the head */
    public Node insertAtHead(Node head, int data) {
        /* Create a new node whose next points to new node */
        Node newNode = new Node(data, head);

        /* return the new node as head */
        return newNode;
    }

    /* Function to delete tail node of the linked list */
    public Node deleteTail(Node head) {

        /* If the list is empty or has one node */
        if (head == null || head.next == null) {
            return null;
        }

        Node curr = head;

        /* Traverse till the 2nd last node */
        while (curr.next.next != null) {
            curr = curr.next;
        }

        /* Delete tail node by removing link from 2nd last node next to tail node */
        curr.next = null;
        return head;
    }

    /* Function to find the length of the linked list */
    public int lengthOfLinkedList(Node head) {
        /* Initialize the counter to 0 */
        int count = 0;

        /* Initialize a temporary pointer to head */
        Node temp = head;

        while (temp != null) {
            /* Increment the count for each node */
            count += 1;

            /* Move to the next node */
            temp = temp.next;
        }

        return count;
    }

    /* Function to search for a value in a linked list */
    public boolean searchValue(Node head, int value) {
        /* pointer to traverse the list */
        Node current = head;

        /* traverse till end */
        while (current != null) {
            if (current.data == value)
                return true;
            else
                current = current.next;
        }

        return false;
    }
}
