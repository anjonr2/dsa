package com.problemsolving.twopintersandslidingwindow.medium.MaxConsecutiveOnesIII.optimal;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;

        /* pointers for sliding window approach */
        int l = 0, r = 0;

        /* variable to store maximum length and count of zeros */
        int maxLen = 0, zeros = 0;

        /* Iterate through the array using sliding window approach */
        while (r < n) {
            if (nums[r] == 0) {
                zeros += 1;
            }
            if (zeros > k) {
                if (nums[l] == 0) {
                    zeros -= 1;
                }
                /*
                 * irrespective of whether nums[l] == 0 or not we move left pointer towards
                 * right by one place
                 */
                l += 1;
            }

            if (zeros <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r += 1;
        }
        return maxLen;
    }
}

/*
 * Time complexity : O(N), where N is the size of the array
 */