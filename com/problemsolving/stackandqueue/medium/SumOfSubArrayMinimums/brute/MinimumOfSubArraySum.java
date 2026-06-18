package com.problemsolving.stackandqueue.medium.SumOfSubArrayMinimums.brute;

public class MinimumOfSubArraySum {
    /*
     * Function to find the sum of the minimum value in each subarray
     */
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int mod = (int) 1e9 + 7;

        int sum = 0;

        for (int i = 0; i < n; i += 1) {
            // to store minimum of subarrays
            int minimum = arr[i];

            for (int j = i; j < n; j += 1) {
                minimum = Math.min(minimum, arr[j]);
                sum += minimum % mod;
            }
        }
        return sum;
    }
}

/*
 * Time complexity : O(N^2) using two nested loops
 */
