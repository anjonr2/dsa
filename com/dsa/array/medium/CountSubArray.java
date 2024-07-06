package com.dsa.array.medium;

// probelm descr : https://leetcode.com/problems/subarray-sum-equals-k/description/
public class CountSubArray {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int l = i; l <= j; l++) {
                    sum += nums[l];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
