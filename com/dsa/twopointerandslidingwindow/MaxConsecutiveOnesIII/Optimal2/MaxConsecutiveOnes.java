package com.dsa.twopointerandslidingwindow.MaxConsecutiveOnesIII.Optimal2;

public class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int maxLength = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        int cntZeroes = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                cntZeroes += 1;
            }
            if (cntZeroes > k) {
                if (nums[left] == 0) {
                    cntZeroes -= 1;
                }
                left += 1;
            }
            if (cntZeroes <= k) {
                maxLength = Math.max(right - left + 1, maxLength);
            }
            right += 1;
        }
        return maxLength;
    }
}
