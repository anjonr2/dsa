package com.problemsolving.BinarySearch.easy.UpperBound;

//Find the smallest index such that nums[idx] > target
public class UpperBound {
    public int upperBound(int[] nums, int x) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > x) {
                ans = mid;
                // Search left half of the array since we need to find the smallest index
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }
}
