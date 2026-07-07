package com.problemsolving.twopintersandslidingwindow.medium.MaxConsecutiveOnesIII.brute;

public class MaxConsecutiveOnesIII {
    /*
     * Function to find the length of the longest substring with at most k zeros
     */
    public int longestOnes(int[] nums, int k) {

        int n = nums.length;

        int maxLen = 0;

        /*
         * Variable to keep count of the number of zeros in the current substring window
         */
        int zeros = 0;

        /*
         * Iterate through all the possible starting point of the substring
         */
        for (int i = 0; i < n; i += 1) {
            zeros = 0;

            /*
             * Expand the window from starting point i to the end of the array
             */
            for (int j = i; j < n; j += 1) {
                if (nums[j] == 0) {

                    /*
                     * Increment count of zeros if there's any zero encountered in the current
                     * window[i..j]
                     */
                    zeros += 1;
                }

                /*
                 * If zeros count is within the allowed limit(k), update maxLen
                 */
                if (zeros <= k) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else
                    break;
            }
        }
        return maxLen;
    }
}

/*
 * Time complexity : O(n^2)
 */