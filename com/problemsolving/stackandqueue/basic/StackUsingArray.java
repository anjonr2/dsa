package com.problemsolving.stackandqueue.basic;

public class StackUsingArray {
    // Array to store stack elements
    private int[] stack;

    // Maximum capacity
    private int capacity;

    // Index of the top element
    private int topIndex;

    public StackUsingArray() {
        capacity = 10;
        stack = new int[capacity];
        // Initialize stack as empty
        topIndex = -1;
    }

    public void push(int element) {
        if (topIndex >= capacity - 1) {
            System.out.println("Stack overflow");
            return;
        }

        stack[++topIndex] = element;
    }

    // Removes and returns top element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return stack[topIndex--];
    }

    public boolean isEmpty() {
        return (topIndex == -1);
    }
}
