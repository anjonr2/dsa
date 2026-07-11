package com.problemsolving.twopintersandslidingwindow.medium.BinarySubArrayWithSum;

public class BinarySubArraysWithSum {
    /*
     * Function to find number of subarrays with sum equal to goal
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        /*
         * Calculate the number of subarrays with sum exactly equal to goal by using the
         * difference between subarrays with sum less tha or equal to goal and those
         * with sum less than or equal to goal - 1
         */
        return numSubarraysWithSumLessEqualToGoal(nums, goal) - numSubarraysWithSumLessEqualToGoal(nums, goal - 1);
    }

    /*
     * Helper function to find the number of subarrays with sum less than or equal
     * to goal
     */
    private int numSubarraysWithSumLessEqualToGoal(int nums[], int goal) {

        int n = nums.length;

        /* if the goal is negative there can't be any subarray */
        if (goal < 0)
            return 0;

        /*
         * Pointers to maintain current window
         */
        int l = 0, r = 0;

        /* variable to track current sum of elements in the window */
        int sum = 0;

        /* variables to store count of subarrays */
        int count = 0;

        while (r < n) {
            sum += nums[r];

            /*
             * Shrink the window from the left side if sum exceeds goal
             */
            while (sum > goal) {
                sum -= nums[l];

                /* Move the left pointer forward */
                l += 1;
            }

            /* Count all subarrays ending at r */
            count += r - l + 1;

            r += 1;
        }
        return count;
    }
}
