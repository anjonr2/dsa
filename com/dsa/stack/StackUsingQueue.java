package com.dsa.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue implements Stack {
    private Queue<Integer> q = new LinkedList<>();

    @Override
    public void push(int x) {
        int size = q.size();
        q.add(x);
        for (int i = 0; i < size; i++) {
            q.add(q.remove());
        }
    }

    @Override
    public int pop() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.remove();
    }

    @Override
    public int top() {
        if (q.isEmpty()) {
            return -1;
        }
        return q.peek();
    }

    @Override
    public int size() {
        return q.size();
    }

}
