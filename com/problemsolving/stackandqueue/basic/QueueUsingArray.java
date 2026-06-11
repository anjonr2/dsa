package com.problemsolving.stackandqueue.basic;

public class QueueUsingArray {

    // Array to store queue elements
    int queue[];

    // Indices for start and end of the queue
    int start, end;

    int currentSize, capacity;

    public QueueUsingArray() {
        queue = new int[10];
        start = -1;
        end = -1;
        currentSize = 0;
        capacity = 10;
    }

    public void push(int element) {

        // Check if queue is full
        if (currentSize == capacity) {
            System.out.println("Queue is full can not add new elements");
        }

        // If queue is empty, initialize start and end
        if (end == -1) {
            start = 0;
            end = 0;
        } else {
            // Circular increment of end
            end = (end + 1) % capacity;
        }
        queue[end] = element;
        currentSize += 1;
    }

    public int pop() {
        if (start == -1) {
            System.out.println("Queue is empty");
            return -1;
        }

        int front = queue[start];

        // If the queue has only element reset start and end
        if (currentSize == 1) {
            start = end = -1;
        } else {
            start = (start + 1) % capacity;
        }

        currentSize -= 1;
        return front;
    }

    public int peek() {
        if (start == -1) {
            System.out.println("Queue is empty");
        }

        return queue[start];
    }
}

/*
 * Time complexity : O(1) as all individual queue operation is taking constant
 * time
 */