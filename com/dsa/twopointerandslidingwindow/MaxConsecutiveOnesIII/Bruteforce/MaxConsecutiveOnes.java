package com.dsa.twopointerandslidingwindow.MaxConsecutiveOnesIII.Bruteforce;

public class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int cntZeroes = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    cntZeroes++;
                }
                if (cntZeroes > k) {
                    break;
                }
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }
}
