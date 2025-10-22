package com.dsa.heap;

import java.util.List;

public class ImplementMaxHeap {
    private List<Integer> arr;
    private int count;

    public ImplementMaxHeap(List<Integer> arr) {
        this.arr = arr;
        this.count = arr.size();
    }

    private void heapifyUp(List<Integer> arr, int index) {
        int parentIndex = (index - 1) / 2;
        if (index > 0 && arr.get(parentIndex) < arr.get(index)) {
            int temp = arr.get(index);
            arr.set(index, arr.get(parentIndex));
            arr.set(parentIndex, temp);
            heapifyUp(arr, parentIndex);
        }
        return;
    }

    private void heapifyDown(int index) {
        int n = arr.size();
        int largestIndex = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (leftChildIndex < n && arr.get(leftChildIndex) > arr.get(largestIndex)) {
            largestIndex = leftChildIndex;
        }
        if (rightChildIndex < n && arr.get(rightChildIndex) > arr.get(largestIndex)) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            int temp = arr.get(largestIndex);
            arr.set(largestIndex, arr.get(index));
            arr.set(index, temp);
            heapifyDown(arr, largestIndex);
        }
        return;
    }

    public void initializeMaxHeap() {
        arr.clear();
        count = 0;
    }

    public void insert(int val) {
        arr.add(val);
        // since in arrayList element is added at the end so need to heapify up
        heapifyUp(arr, val);
        count += 1;
        return;
    }

    public void changeKey(int index, int val) {
        if (arr.get(index) < val) {
            arr.set(index, val);
            heapifyUp(arr, index);
        } else {
            arr.set(index, val);
            heapifyDown(index);
        }
        return;
    }

    public void extractMax() {
        int element = arr.get(0);
        int temp = arr.get(count - 1);
        arr.set(count - 1, element);
        arr.set(0, temp);

        arr.remove(count - 1);
        count -= 1;

        if (count > 0) {
            // heapify down the root value
            heapifyDown(0);
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int getMax() {
        return arr.get(0);
    }

    public int heapSize() {
        return count;
    }
}
