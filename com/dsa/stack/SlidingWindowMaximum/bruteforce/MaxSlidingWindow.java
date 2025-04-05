package com.dsa.stack.SlidingWindowMaximum.bruteforce;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int result[] = new int[n - k + 1];
        int idx = 0;
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            result[idx++] = max;
        }
        return result;
    }
}
