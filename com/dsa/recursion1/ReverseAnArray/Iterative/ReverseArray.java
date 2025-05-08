package com.dsa.recursion1.ReverseAnArray.Iterative;

public class ReverseArray {
    public int[] reverseArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left += 1;
            right -= 1;
        }
        return nums;
    }
}
