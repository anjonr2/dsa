package com.problemsolving.array.medium.maximumSumUsingKadane.optimal;

public class MaximumSumSubArray {
    public int maxSubArray(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        int n = nums.length;
        int sum = 0;
        int start = -1;
        int ansStart = -1;
        int ansEnd = -1;
        for (int i = 0; i < n; i += 1) {
            if (sum == 0)
                start = i;
            sum += nums[i];
            if (sum > maximum) {
                maximum = sum;
                ansStart = start;
                ansEnd = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maximum;
    }
}
