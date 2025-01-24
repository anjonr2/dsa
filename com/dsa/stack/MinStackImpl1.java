package com.dsa.stack;

import java.util.Stack;

public class MinStackImpl1 implements MinStack {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    @Override
    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            min = val;
        } else if (val > min) {
            stack.push(val);
        } else if (val < min) {
            min = val;
            stack.push(2 * val - min);
        }
    }

    @Override
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.peek();
        stack.pop();
        if (top < min) {
            // min is ths current minimum value(which is the original top value to be pushed
            // which was lesser than prevMin)
            min = 2 * min - top;
        }
    }

    @Override
    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        int top = stack.peek();
        if (top < min) {
            // top is a modified value if it is lesser than min
            // min is storing the original value of top
            return min;
        }
        return top;
    }

    @Override
    public int getMin() {
        return min;
    }

}
