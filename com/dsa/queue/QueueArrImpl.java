package com.dsa.queue;

public class QueueArrImpl implements Queue {
    private int currSize = 0;
    private int front = -1, rear = -1;
    private int capacity = 10;
    int queue[] = new int[capacity];

    @Override
    public void enqueue(int x) {
        if (currSize == capacity) {
            return;
        }
        if (rear == -1) {
            front = 0;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = x;
        currSize += 1;
    }

    @Override
    public int dequeue() {
        if (currSize == 0) {
            return -1;
        }
        int el = queue[front];
        if (currSize == 1) {
            // checks if it's last element
            // then reset the queue
            front = -1;
            rear = -1;
        }
        front = (front + 1) % capacity;
        currSize -= 1;
        return el;
    }

    @Override
    public int front() {
        if (front == -1) {
            return -1;
        }
        return queue[front];
    }

    @Override
    public int size() {
        return currSize;
    }

}
