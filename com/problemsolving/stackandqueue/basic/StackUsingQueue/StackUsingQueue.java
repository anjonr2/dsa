package com.problemsolving.stackandqueue.basic.StackUsingQueue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> queue = new LinkedList<>();

    /* Methods to push element in the stack */
    public void push(int x) {
        int s = queue.size();
        queue.add(x);

        /* move the elements before new element to the back */
        for (int i = 0; i < s; i += 1) {
            /*
             * retrieve and remove head of queue and then add it to queue behind the new
             * element
             */
            queue.add(queue.poll());
        }
    }

    public int pop() {
        // Get the front element
        int n = queue.peek();

        // Remove the front element
        queue.poll();

        return n;
    }

    public int top() {
        return queue.peek();
    }
}

/*
 * Time complexity
 * Push operation : O(n) where n is the number of elements in the queue at that
 * time. Because every time an element is pushed, all the elements in the queue
 * are popped from the front and added behind the new element
 * 
 * Pop and Top : O(1)
 */
