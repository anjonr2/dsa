package com.problemsolving.array.easy.CheckIfArrayIsSorted;

import java.util.ArrayList;
import java.util.List;

public class CheckIfArrayIsSorted {
    public boolean isSorted(ArrayList<Integer> nums) {
        // An array with size 0 or 1 is always sorted
        if (nums.size() <= 1) {
            return true;
        }

        // check if the array is sorted starting from index 0 to 1
        return sort(nums, 0, 1);
    }

    private boolean sort(ArrayList<Integer> nums, int left, int right) {
        // If we reach the end of the array that means array is sorted
        if (right >= nums.size())
            return true;

        // If we find a pair where left element is greater than the right element then
        // the array is not sorted
        if (nums.get(left) > nums.get(right))
            return false;

        // Move to the next pair of elements
        return sort(nums, left + 1, right + 1);
    }
}
