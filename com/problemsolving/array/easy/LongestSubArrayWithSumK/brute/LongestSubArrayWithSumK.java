package com.problemsolving.array.easy.LongestSubArrayWithSumK.brute;

public class LongestSubArrayWithSumK {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;

        for (int startIndex = 0; startIndex < n; startIndex += 1) {
            int currentSum = 0;
            for (int endingIndex = startIndex; endingIndex < n; endingIndex += 1) {
                currentSum += nums[endingIndex];
                if (currentSum == k)
                    maxLength = Math.max(maxLength, endingIndex - startIndex + 1);
            }
        }

        return maxLength;
    }
}
