package com.problemsolving.array.easy.LargestElement.brute;

import java.util.Arrays;

public class LargestElement {
    public static int largestElement(int[] nums) {
        Arrays.sort(nums);

        /* largest number will be at the last index of the array */
        return nums[nums.length - 1];
    }
}
