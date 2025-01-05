package com.dsa.stack;

public class StackArrayImpl implements Stack {
    int size = 0;
    int capacity = 10;
    int stack[] = new int[capacity];
    int top = -1;

    @Override
    public void push(int x) {
        // checks if stack is not full
        if (size != capacity) {
            top += 1;
            stack[top] = x;
            size += 1;
        }
    }

    @Override
    public int pop() {
        int el = -1;
        // checks if stack is not empty
        if (top != -1) {
            el = stack[top];
            top -= 1;
            size -= 1;
        }
        return el;
    }

    @Override
    public int top() {
        int el = -1;
        if (top != -1) {
            return stack[top];
        }
        return el;
    }

    @Override
    public int size() {
        return size;
    }

}
