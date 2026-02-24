package com.problemsolving.array.hard.subArraysWithxorK.better;

public class SubArraysWithXorK {
    public int countSubArraysWithXorK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i += 1) {
            int xor = 0;
            for (int j = i; j < n; j += 1) {
                xor = xor ^ nums[j];
                if (xor == k)
                    count += 1;
            }
        }
        return count;
    }
}

/*
 * Time Complexity : O(n^2) since we are using two nested loops
 */