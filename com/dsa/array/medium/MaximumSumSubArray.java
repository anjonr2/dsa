package com.dsa.array.medium;

public class MaximumSumSubArray {
    public static long maxSubarraySum(int[] arr, int n) {
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
            }
            maximum = Math.max(maximum, sum);
        }
        return maximum;
    }
}
