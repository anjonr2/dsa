package com.problemsolving.stackandqueue.basic;

import com.problemsolving.stackandqueue.util.Node;

public class StackUsingLinkedList {
    Node top; // top of the stack;
    int size;

    public StackUsingLinkedList() {
        top = null;
        size = 0;
    }

    public void push(int x) {
        // Creating a node
        Node element = new Node(x);

        top.next = element; // Updating the pointers
        top = element; // Updating the top

        // Increment size by 1
        size += 1;
    }

    public int pop() {
        // If the stack is empty
        if (top == null)
            return -1;

        int value = top.val; // Get the top value
        Node temp = top; // store the head or top of the stack temporarily
        top = top.next;
        temp = null;
        size -= 1;

        return value;
    }

    public int top() {
        if (top == null)
            return -1;
        return top.val;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

}
