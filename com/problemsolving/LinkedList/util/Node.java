package com.problemsolving.LinkedList.util;

public class Node {
    public int data;
    public Node next;

    /* Constructor with data and next pointer */
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    /* Constructor with only data */
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
