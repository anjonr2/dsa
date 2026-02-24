package com.problemsolving.array.hard.subArraysWithxorK.brute;

public class SubArraysWithXorK {
    public int countSubArraysWithXorK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        // Step 1 : Generate subarrays
        for (int i = 0; i < n; i += 1) {
            for (int j = i; j < n; j += 1) {
                int xor = 0;
                // calculate xor of all the elements in the subarray
                for (int l = i; l <= j; l += 1) {
                    xor = xor ^ nums[l]
                }
                if(xor == k) count +=1;
            }
        }
        return count;
    }
}

/*
 * Time Complexity : O(n^3) since we are using three nested loops
 */