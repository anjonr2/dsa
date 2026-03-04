package com.problemsolving.BinarySearch.easy.SearchInARotatedArrayI.LinearSearchApproach;

public class SearchInARotatedArrayI {
    public int search(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i += 1) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
