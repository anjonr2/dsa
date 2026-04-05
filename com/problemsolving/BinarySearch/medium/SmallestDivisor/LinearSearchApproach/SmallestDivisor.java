package com.problemsolving.BinarySearch.medium.SmallestDivisor.LinearSearchApproach;

public class SmallestDivisor {
    // Function to find the smallest divisor
    public int smallestDivisor(int[] nums, int limit) {
        // size of the array
        int n = nums.length;

        // find the maximum element in the array
        int maximum = Integer.MIN_VALUE;
        for (int num : nums) {
            maximum = Math.max(maximum, num);
        }

        // Find the smallest divisor
        for (int d = 1; d <= maximum; d += 1) {
            int sum = 0;

            /*
             * Calculate the sum of ceil
             * nums[i]/d for all elements of the array
             */

            for (int i = 0; i < n; i += 1) {
                sum += Math.ceil((double) nums[i] / (double) d);
            }

            if (sum <= limit)
                return d;
        }

        return -1;
    }
}
