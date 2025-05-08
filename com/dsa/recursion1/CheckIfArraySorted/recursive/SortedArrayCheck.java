package com.dsa.recursion1.CheckIfArraySorted.recursive;

public class SortedArrayCheck {
    public boolean isSorted(int[] nums) {
        return isSortedHelper(nums, 1); // start checking from the second element in the array
    }

    public boolean isSortedHelper(int[] nums, int index) {
        if (nums.length == 0 || nums.length == 1) {
            return true;
        }
        if (index >= nums.length) {
            return true; // if checked all elements, reached the end of the array return true
        }
        if (nums[index] < nums[index - 1]) {
            return false;
        }
        return isSortedHelper(nums, index + 1);
    }
}
