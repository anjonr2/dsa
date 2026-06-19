package com.problemsolving.stackandqueue.medium.SumOfSubArrayRanges.brute;

public class SumOfSubArrayRanges {

    /*
     * Function to find the sum of subarray ranges in each subarray
     */
    public long subArrayRanges(int[] arr) {

        // size of the array
        int n = arr.length;

        long sum = 0;

        for (int i = 0; i < n; i += 1) {

            // To store smallest value of subarray
            int smallest = arr[i];

            // To store largest value of subarray
            int largest = arr[i];

            /*
             * Nested loop to get all subarrays starting from index i
             */
            for (int j = i; j < n; j += 1) {
                smallest = Math.min(smallest, arr[j]);
                largest = Math.max(largest, arr[j]);

                sum += (largest - smallest);
            }
        }
        return sum;
    }
}

/*
 * Time complexity : O(N^2) for nested loops
 */