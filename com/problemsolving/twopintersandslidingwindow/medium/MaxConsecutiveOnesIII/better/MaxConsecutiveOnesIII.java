package com.problemsolving.twopintersandslidingwindow.medium.MaxConsecutiveOnesIII.better;

public class MaxConsecutiveOnesIII {
    /*
     * Function to find the length of the longest substring with at most k zeros
     */
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        /* Pointers for sliding window approach */
        int l = 0, r = 0;

        /* Variables to store count of zeros and maximum length */
        int zeros = 0, maxLen = 0;

        while (r < n) {
            if (nums[r] == 0) {
                zeros += 1;
            }

            while (zeros > k) {
                if (nums[l] == 0)
                    zeros -= 1;

                /* Move the left pointer towards right to shrink the window */
                l += 1;
            }

            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);

            /* Move right pointer to expand the window */
            r++;
        }
        return maxLen;
    }
}

/*
 * Time complexity : O(2N), where N is the size of the array
 */