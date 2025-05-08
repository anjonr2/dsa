package com.dsa.recursion1.CheckIfArraySorted.iterative;

import java.util.ArrayList;

public class SortedArrayCheck {
    public boolean isSorted(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return true; // An empty array or an array with one element is sorted
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false; // if the current element is smaller than previous one, array is not sorted
            }
        }
        return true;
    }
}
