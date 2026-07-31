package com.problemsolving.DoublyLinkedList.util;

public class Node {
    public int data;

    /* pointer to next node */
    public Node next;

    /* pointer to prev node */
    public Node prev;

    /* Constructor when data, next and previous are provided */
    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    /* Constructor when only data is provided */
    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
