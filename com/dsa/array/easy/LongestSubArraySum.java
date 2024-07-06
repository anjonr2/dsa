package com.dsa.array.easy;

public class LongestSubArraySum {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int length = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += nums[l];
                }
                if (sum == k) {
                    length = Math.max(length, j - i + 1);
                }
            }
        }
        return length;
    }
}
