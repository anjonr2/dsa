package com.problemsolving.array.hard.LargestSubArrayWithSumZero.brute;

public class LargestSubArrayWithSumZero {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLength = 0;

        /*
         * we will check for all the possible subarrays and calculate their sum
         * and if the sum is zero then we will update the maxLength
         */
        for (int start = 0; start < n; start += 1) {
            int sum = 0;
            for (int end = start; end < n; end += 1) {
                sum += nums[end];
                if (sum == 0) {
                    maxLength = Math.max(maxLength, end - start + 1);
                }
            }

        }
        return maxLength;
    }
}

/*
 * Time complexity : O(n^2) used two nested loops to check for all the possible
 * subarrays
 * Space Complexity : O(1)
 */