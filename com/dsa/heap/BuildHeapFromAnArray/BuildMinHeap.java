package com.dsa.heap.BuildHeapFromAnArray;

public class BuildMinHeap {
    public void heapifyDown(int[] arr, int index, int n) {
        int smallest_index = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        if (leftChildIndex < n && arr[leftChildIndex] < arr[smallest_index]) {
            smallest_index = leftChildIndex;
        }
        if (rightChildIndex < n && arr[rightChildIndex] < arr[smallest_index]) {
            smallest_index = rightChildIndex;
        }

        if (smallest_index != index) {
            int temp = arr[index];
            arr[index] = arr[smallest_index];
            arr[smallest_index] = temp;
            heapifyDown(arr, smallest_index, n);
        }
    }

    public void buildMinHeap(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i -= 1) {
            heapifyDown(arr, i, n);
        }
    }
}
