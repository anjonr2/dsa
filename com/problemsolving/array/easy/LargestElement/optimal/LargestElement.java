package com.problemsolving.array.easy.LargestElement.optimal;

public class LargestElement {
    public static int largestElement(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i += 1) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
