package com.problemsolving.BinarySearch.easy.CountOccurences.LinearSearchApproach;

public class CountOccurences {
    public int countOccurences(int[] nums, int target) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i += 1) {
            if (nums[i] == target)
                count += 1;
        }
        return count;
    }
}
