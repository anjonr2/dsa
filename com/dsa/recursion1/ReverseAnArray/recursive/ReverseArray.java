package com.dsa.recursion1.ReverseAnArray.recursive;

public class ReverseArray {
    public static int[] reverseArray(int[] nums) {
        return reverseArrayHelper(nums, 0, nums.length - 1);
    }

    public static int[] reverseArrayHelper(int[] nums, int left, int right) {
        if (left >= right) {
            return nums;
        }
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

        return reverseArrayHelper(nums, left + 1, right - 1); // Recursive call with updated indices
    }
}
