package com.problemsolving.stackandqueue.basic.MinStack.brute;

import java.util.Stack;

//class to implement minimum stack
public class MinStack {
    /*
     * Initialize a stack of array two store two elements. Each index of the stack
     * will have an array of two elements
     * where first element of the array is input element itself and second element
     * of the array is the minimum element of the stack
     */
    private Stack<int[]> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int value) {
        if (stack.isEmpty()) {
            // if stack is empty push current value as minimum
            stack.push(new int[] { value, value });
            return;
        }

        int minimum = Math.min(getMin(), value);

        stack.push(new int[] { value, minimum });
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        if (stack.isEmpty())
            return -1;
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }
}

/*
 * Time complexity : O(1)
 * Space complexity : O(2n)
 * Since all the numbers in stack are stored in pairs so this led to a space
 * complexity of O(2n)
 */