package com.dsa.queue;

import java.util.Stack;

public class QueueUsingStackImpl implements Queue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    @Override
    public void enqueue(int x) {
        while (s1.size() > 0) {
            s2.push(s1.peek());
            s1.pop();
        }
        s1.push(x);
        while (s2.size() > 0) {
            s1.push(s2.peek());
            s2.pop();
        }
    }

    @Override
    public int dequeue() {
        if (s1.size() == 0) {
            return -1;
        }
        return s1.pop();
    }

    @Override
    public int front() {
        if (s1.size() == 0) {
            return -1;
        }
        return s1.peek();
    }

    @Override
    public int size() {
        return s1.size();
    }

}
