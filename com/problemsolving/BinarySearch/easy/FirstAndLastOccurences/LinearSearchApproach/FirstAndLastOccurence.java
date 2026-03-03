package com.problemsolving.BinarySearch.easy.FirstAndLastOccurences.LinearSearchApproach;

public class FirstAndLastOccurence {
    public int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        int n = nums.length;
        for (int i = 0; i < n; i += 1) {
            if (nums[i] == target) {
                if (first == -1) {
                    first = i;
                }
                last = i;
            }
        }
        return new int[] { first, last };
    }
}

/*
 * Time Complexity : O(n)
 */