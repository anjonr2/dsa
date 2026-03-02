package com.problemsolving.BinarySearch.easy.LowerBound;

//Find lower idx such that nums[idx] >= target
public class LowerBound {
    public int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = nums.length;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                // Search left half since we need to find the smalles index
                high = mid - 1;
            } else {
                // Search right half if arr[mid] < target
                low = mid + 1;
            }
        }
        return ans;
    }
}
