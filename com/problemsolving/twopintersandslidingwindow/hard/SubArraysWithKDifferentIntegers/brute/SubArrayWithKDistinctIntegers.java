package com.problemsolving.twopintersandslidingwindow.hard.SubArraysWithKDifferentIntegers.brute;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDistinctIntegers {
    /*
     * Function to count subarrays with exactly k distinct integers
     */
    public int subarraysWithKDistinct(int[] nums, int k) {
        int count = 0;

        int n = nums.length;

        for (int i = 0; i < n; i += 1) {
            Map<Integer, Integer> frequencyMap = new HashMap<>();

            /* Iterate through all possible end points */
            for (int j = i; j < n; j += 1) {

                frequencyMap.put(nums[j], frequencyMap.getOrDefault(nums[j], 0) + 1);

                if (frequencyMap.size() == k)
                    count += 1;

                // If more than k distinct numbers present in the current window then break
                // early
                if (frequencyMap.size() > 2)
                    break;
            }
        }
        return count;
    }
}

/*
 * Time complexity : O(N^2*K)
 * We check all the possible subarray by iterating over all start and end
 * indices
 * For each subarray we count the number of distinct integers using a hashMap
 * which can take up to O(K) time per check
 * So overall it becomes O(N^2*k)
 * where N is the size of the array
 * K is the number of unique elements allowed
 * 
 * Space complexity : O(K)
 */