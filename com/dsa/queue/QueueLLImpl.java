package com.dsa.queue;

import com.dsa.util.Node;

public class QueueLLImpl implements Queue {
    // points to start of the queue
    Node front = null;
    // points to the end of the queue
    Node rear = null;
    int size = 0;

    @Override
    public void enqueue(int x) {
        Node node = new Node(x);

        // checks if the queus is empty
        if (front == null) {
            front = node;
            rear = node;
            size += 1;
        } else {
            rear.next = node;
            rear = node;
            size += 1;
        }
    }

    @Override
    public int dequeue() {
        if (front == null) {
            return -1;
        }
        Node node = front;
        front = front.next;
        node.next = null;
        size -= 1;
        return front.data;
    }

    @Override
    public int front() {
        if (front == null) {
            return -1;
        }
        return front.data;
    }

    @Override
    public int size() {
        return size;
    }

}
