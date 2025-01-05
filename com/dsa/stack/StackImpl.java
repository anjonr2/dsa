package com.dsa.stack;

import com.dsa.util.Node;

public class StackImpl implements Stack {
    Node top = null;
    int size = 0;

    @Override
    public void push(int x) {
        Node node = new Node(x);
        node.next = top;
        top = node;
        size += 1;
    }

    @Override
    public int pop() {
        Node temp = top;
        top = top.next;
        temp.next = null;
        size -= 1;
        return temp.data;
    }

    @Override
    public int top() {
        return top.data;
    }

    @Override
    public int size() {
        return size;
    }

}
