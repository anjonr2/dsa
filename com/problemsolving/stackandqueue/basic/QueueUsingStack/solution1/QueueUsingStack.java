package com.problemsolving.stackandqueue.basic.QueueUsingStack.solution1;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> stack1, stack2;

    public QueueUsingStack() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    // Method to push element in the queue
    public void push(int element) {
        /*
         * Pop out the element from the first stack and push on top of the second stack
         */
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Insert the element
        stack1.push(element);

        // Pop the element from the second stack and push back on top of first stack
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    /* Method to pop element from the queue */
    public int pop() {
        // Edge case
        if (stack1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1; // Representing empty stack
        }

        // Get the top element
        int topElement = stack1.pop();
        return topElement;
    }

    public int peek() {
        if (stack1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack1.peek();
    }

    // Method to find whether queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}

/*
 * Time complexity : Push operation is O(N)
 * Space complexity : O(2N) using two stacks
 * 
 * To achieve First In, First Out (FIFO) order of a queue we are using two
 * stacks
 * By pushing elements onto one stack and then transferring them to another
 * stack before popping, the order of the elements is reversed twice.
 * This ensures that the first element pushed onto the stack is the first one to
 * be popped,
 * 
 * Push operation
 * Transfer all elements from stack1 to stack2
 * Add the new elements to stack1
 * Transfer all elements back from stack2 to stack1
 */