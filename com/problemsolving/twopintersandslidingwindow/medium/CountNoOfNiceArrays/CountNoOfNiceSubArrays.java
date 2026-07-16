package com.problemsolving.twopintersandslidingwindow.medium.CountNoOfNiceArrays;

public class CountNoOfNiceSubArrays {
    /*
     * Function to find the number of nice subarrays with k odd numbers
     */
    public int numberOfOddSubarrays(int[] nums, int k) {
        /*
         * Calculate the number of subarrays with sum exactly equal to k by using the
         * difference between
         * subarrays with sum less than or equal to k and those with sum less than or
         * equal to k-1
         */
        return helper(nums, k) - helper(nums, k - 1);
    }

    /*
     * Helper function to find number of nice subarrays with sum less than or equal
     * to goal
     */
    private int helper(int nums[], int goal) {
        int n = nums.length;

        /* If the goal is negative, there can't be any valid subarray sum */
        if (goal < 0)
            return 0;

        /* Pointers to maintain current window */
        int l = 0, r = 0;

        /* Variable to track current sum of elements in the window */
        int sum = 0;

        /* Variable to count the number of subarrays */
        int count = 0;

        while (r < n) {
            /*
             * If it's a even number modulo of 2 will be 0 so it will not contribute to the
             * sum anyways. So sum will consist of only odd numbers
             */
            sum += nums[r] % 2;

            /*
             * Shrink the window from the left side if sum exceeds goal
             */
            while (sum > goal) {
                sum -= nums[l] % 2;

                /* Move the pointer l forward */
                l += 1;
            }

            count += (r - l + 1);

            r += 1;
        }
        return count;
    }
}

/*
 * Time complexity : O(2 * 2N), where N is the size of the string. The outer
 * loop runs for N time and the inner while loop might be running for N time
 * throughout the program. So it becomes O(2N), also helper function is being
 * called twince so overall time complexity
 * O(2 * 2N)
 */