package com.problemsolving.stackandqueue.basic;

import com.problemsolving.stackandqueue.util.Node;

public class QueueUsingLinkedList {
    private Node start; // start or front of the queue
    private Node end; // end or back of queue
    private int size;

    public QueueUsingLinkedList() {
        start = end = null;
        size = 0;
    }

    // Method to push an element in the queue
    public void push(int x) {
        Node temp = new Node(x);

        // if it is the first element
        if (size == 0 || start == null) {
            start = end = temp;
        } else {
            end.next = temp; // end which is back of the queue pointing to the new element
            end = temp; // updating end or back of the queue to latest added or new element
        }

        size += 1;
    }

    public int pop() {
        // if the queue is empty
        if (start == null) {
            return -1;
        }

        int val = start.val; // Get the front value;
        start = start.next; // Update front to the next node;
        size--; // Decrement size;

        // if queue is empty both pointer should be null
        if (start == null) {
            end = null;
        }

        return val;
    }

    // Method to get the front element in the queue
    public int peek() {
        // if the queue is empty start element can not be returned
        if (start == null)
            return -1;

        return start.val; // return the front
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}

/*
 * Time complexity : O(1) because time complexity for pop, push, peek operation
 * is O(1)
 * 
 * Space complexity : O(n) where n is total no of element in the queue
 */