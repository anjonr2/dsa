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

    public static long maxSubarraySum1(int[] arr, int n) {
        int maximum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum > maximum) {
                maximum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        if (maximum < 0)
            maximum = 0;
        return maximum;
    }

    public static int[] maxSumSubarray(int[] arr, int n) {
        int maximum = Integer.MIN_VALUE;
        int sum = 0;
        int[] ans = new int[2];
        int start = -1;
        int startIdx = -1;
        int endIdx = -1;
        for (int i = 0; i < n; i++) {
            if (sum == 0)
                start = i;
            sum += arr[i];
            if (sum > maximum) {
                maximum = sum;
                startIdx = start;
                endIdx = i;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        if (maximum < 0)
            maximum = 0;
        return new int[] { startIdx, endIdx };
    }
}
