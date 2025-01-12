package com.dsa.queue;

public interface Queue {
    public void enqueue(int x);

    public int dequeue();

    public int front();

    public int size();
}
