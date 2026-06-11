package com.problemsolving.stackandqueue.basic.QueueUsingStack.solution2;

import java.util.Stack;

public class QueueUsingStack {
    private Stack<Integer> input, output;

    // initialize data structure
    public QueueUsingStack() {
        this.input = new Stack<>();
        this.output = new Stack<>();
    }

    public void push(int element) {
        input.push(element);
    }

    // Removes the element from infront of the queue and returns that element
    public int pop() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        if (output.isEmpty()) {
            System.out.println("Queue is empty, cannot pop");
            return -1;
        }

        return output.pop();
    }

    // get the front element of the queue
    public int peek() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        if (output.isEmpty()) {
            return -1;
        }

        return output.peek();
    }

    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }

}

/*
 * Time complexity : O(1) for push operation
 * but O(n) for pop and peek operation
 * 
 * Space complexity : O(2n)
 */

/*
 * Intuition :
 * The concept of using two stacks to create a queue relies on the idea of
 * reversing the ordder of elements twice to achieve the desired first in first
 * out behavior. Stacks naturally follow Last In, First out order, meaning the
 * last element added
 * is the first one removed. By using two stacks elements can be added in one
 * stack and then moved to another to reverse their order. When it's time to
 * remove an element,transferring elements to the second stack ensures that the
 * first element added to the stack
 * becomes first one removed from the stack . This double reversal effectively
 * mimics the behavior of a queue using the LIFO nature of stacks
 */