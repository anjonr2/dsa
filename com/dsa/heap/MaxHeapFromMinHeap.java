package com.dsa.heap;

public class MaxHeapFromMinHeap {
    private void heapifyDown(int[] arr, int index) {
        int n = arr.length;
        int largestIndex = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (leftChildIndex < n && arr[leftChildIndex] > arr[index]) {
            largestIndex = leftChildIndex;
        }
        if (rightChildIndex < n && arr[rightChildIndex] > arr[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != index) {
            int temp = arr[largestIndex];
            arr[largestIndex] = arr[index];
            arr[index] = temp;
            heapifyDown(arr, largestIndex);
        }
        return;
    }

    public int[] minToMaxHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i -= 1) {
            heapifyDown(arr, i);
        }
        return arr;
    }
}
