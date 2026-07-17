package com.problemsolving.twopintersandslidingwindow.hard.SubArraysWithKDifferentIntegers.optimal;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDistinctIntegers {
    /* Helper function to count subarrays with at most k distinct integers */
    private int atMostK(int[] nums, int K) {
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;
        int left = 0, count = 0;

        for (int right = 0; right < n; right += 1) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            while (freq.size() > K) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0)
                    freq.remove(nums[left]);
                left += 1;
            }

            if (freq.size() <= K) {
                count = right - left + 1;
            }
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
}
