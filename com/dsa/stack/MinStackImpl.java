package com.dsa.stack;

import java.util.Stack;

public class MinStackImpl {
    Stack<Pair> stack;

    class Pair {
        int first;
        int second;

        public int getFirst() {
            return this.first;
        }

        public int getSecond() {
            return this.second;
        }

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public MinStackImpl() {
        this.stack = new Stack<>();
    }

    public void push(int val) {
        int min;
        if (stack.isEmpty()) {
            min = val;
        } else {
            Pair pair = stack.peek();
            min = Math.min(val, pair.getSecond());
        }
        stack.push(new Pair(val, min));
    }

    public int peek() {
        return stack.peek().getFirst();
    }

    public void pop() {
        stack.pop();
    }

    public int getMin() {
        return stack.peek().getSecond();
    }
}
