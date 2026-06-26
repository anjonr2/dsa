package com.problemsolving.array.easy.LongestSubArrayWithSumK.better;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    /*
     * In this approach, we use the concept of prefix sums to solve the problem of
     * finding the longest subarray with a sum equal to k. The prefix sum of a sub
     * array ending at index i is simply the sum of all the elements of that
     * subarray
     */
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i += 1) {
            // calculate the prefix sum till index i
            sum += nums[i];

            if (sum == k) {
                maxLength = Math.max(maxLength, i + 1);
            }

            // if sum != k calculate remaining sum
            int remainingSum = sum - k;

            if (prefixSumMap.containsKey(remainingSum)) {
                int length = i - prefixSumMap.get(remainingSum);
                maxLength = Math.max(remainingSum, length);
            }

            // update prefixSumMap only if sum already doesn't exists in the map. We are
            // doing this to store leftmost prefix sum possible so that we can have the
            // maxLength possible
            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }

        return maxLength;
    }
}
