package com.problemsolving.array.medium.maximumSumUsingKadane.better;

public class MaximumSumSubArray {
    public int maxSubArray(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i = 0; i < n; i += 1) {
            int sum = 0;
            for (int j = i; j < n; j += 1) {
                sum += nums[j];
                maximum = Math.max(maximum, sum);
            }
        }
        return maximum;
    }
}
