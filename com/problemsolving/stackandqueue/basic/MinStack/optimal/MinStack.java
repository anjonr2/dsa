package com.problemsolving.stackandqueue.basic.MinStack.optimal;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private int minimum;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int value) {
        if (stack.isEmpty()) {
            minimum = value;
            stack.push(value);
            return;
        }

        // if value is greater than minimum then no need to update minimum
        if (value > minimum) {
            stack.push(value);
        } else {
            /*
             * Add the modified value to the stack
             * using formula newValue = 2 * value - minimum
             */
            stack.push(2 * value - minimum);
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;

        int top = stack.pop();

        // If the modified value was added to stack
        if (top < minimum) {
            // update the minimum. Because actual top value is the value that is stored in
            // minimum variable
            minimum = 2 * minimum - top;
        }
    }

    public int top() {
        if (stack.isEmpty())
            return -1;
        int top = stack.pop();

        // return top if top of the stack is greater than minimum. Which says top was
        // not modified it is as inserted as it came in input
        if (minimum < top)
            return top;

        return minimum;
    }

    public int getMin() {
        return minimum;
    }
}

/*
 * Time complexity : O(1)
 * Space complexity : o(2n)
 */