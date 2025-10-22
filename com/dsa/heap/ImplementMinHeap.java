package com.dsa.heap;

import java.util.List;

public class ImplementMinHeap {
    private List<Integer> arr; // list to store min-heap
    private int count; // number of elements in the heap

    public ImplementMinHeap(List<Integer> arr) {
        this.arr = arr;
        this.count = arr.size();
    }

    private void heapifyUp(List<Integer> arr, int index) {
        int parentIndex = (index - 1) / 2;
        if (index > 0 && arr.get(parentIndex) > arr.get(index)) {
            int temp = arr.get(parentIndex);
            arr.set(parentIndex, arr.get(index));
            arr.set(index, temp);
            heapifyUp(arr, parentIndex);
        }
        return;
    }

    private void heapifyDown(List<Integer> arr, int index) {
        int smallestIndex = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int n = arr.size();

        if (leftChildIndex < n && arr.get(leftChildIndex) < arr.get(smallestIndex)) {
            smallestIndex = leftChildIndex;
        }
        if (rightChildIndex < n && arr.get(rightChildIndex) < arr.get(smallestIndex)) {
            smallestIndex = rightChildIndex;
        }

        if (smallestIndex != index) {
            int temp = arr.get(index);
            arr.set(index, arr.get(rightChildIndex));
            arr.set(rightChildIndex, temp);
            heapifyDown(arr, smallestIndex);
        }
        return;
    }

    public void initializeMinHeap() {
        arr.clear();
        count = 0;
    }

    public void insert(int val) {
        arr.add(val);
        heapifyUp(arr, count);
        count += 1;
        return;
    }

    public void extractMin() {
        int ele = arr.get(0);

        int temp = arr.get(count - 1);
        arr.set(count - 1, ele);
        arr.set(0, temp);

        arr.remove(count - 1);
        count = count - 1;

        // Heapify down from root
        if (count > 0) {
            heapifyDown(arr, count);
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getMin() {
        return arr.get(0);
    }

    public int heapSize() {
        return count;
    }
}
