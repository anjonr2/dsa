package com.problemsolving.array.easy.LinearSearch;

public class LinearSearch {
    public int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] == target)
                return i;
        }
        return -1;
    }
}
