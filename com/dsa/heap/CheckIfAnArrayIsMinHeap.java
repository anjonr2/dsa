package com.dsa.heap;

public class CheckIfAnArrayIsMinHeap {
    public boolean isMinHeap(int[] nums) {
        int n = nums.length;
        for (int i = n / 2 - 1; i >= 0; i -= 1) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;

            if (leftChildIndex < n && nums[i] > nums[leftChildIndex]) {
                return false;
            }
            if (rightChildIndex < n && nums[i] > nums[rightChildIndex]) {
                return false;
            }
        }
        return true;
    }
}
