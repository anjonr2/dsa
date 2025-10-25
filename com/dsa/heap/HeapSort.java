package com.dsa.heap;

public class HeapSort {
    private void heapifyDown(int[] arr, int last, int ind) {
        int largestIndex = ind;
        int leftChildIndex = 2 * ind + 1;
        int rightChildIndex = 2 * ind + 2;
        if (leftChildIndex <= last && arr[leftChildIndex] > arr[largestIndex]) {
            largestIndex = leftChildIndex;
        }
        if (rightChildIndex <= last && arr[rightChildIndex] > arr[largestIndex]) {
            largestIndex = rightChildIndex;
        }

        if (largestIndex != ind) {
            int temp = arr[ind];
            arr[ind] = arr[largestIndex];
            arr[largestIndex] = temp;
            heapifyDown(arr, last, largestIndex);
        }
    }

    private void buildMaxHeap(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i -= 1) {
            heapifyDown(nums, n - 1, i);
        }
        return;
    }

    public void heapSort(int[] nums) {
        buildMaxHeap(nums);
        int last = nums.length - 1;
        while (last > 0) {
            int temp = nums[0];
            nums[0] = nums[last];
            nums[last] = temp;

            last -= 1;
            if (last > 0) {
                heapifyDown(nums, last, 0);
            }
        }
        return;
    }
}
