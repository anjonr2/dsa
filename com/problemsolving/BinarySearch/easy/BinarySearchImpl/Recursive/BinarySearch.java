package com.problemsolving.BinarySearch.easy.BinarySearchImpl.Recursive;

public class BinarySearch {
    public int search(int[] nums, int target, int low, int high) {
        // base case
        if (low > high)
            return -1;
        int ind; // to store the index of the target element if found
        int mid = low + (high - low) / 2;
        if (nums[mid] == target)
            ind = mid;
        else if (nums[mid] > target)
            ind = search(nums, target, low, mid - 1);
        else
            ind = search(nums, target, mid + 1, high);
        return ind;
    }
}

/*
 * Time Complexity : O(log n) where n is the number of elements in the input
 * array
 */