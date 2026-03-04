package com.problemsolving.BinarySearch.easy.SearchInARotatedArrayI.BinarySearchApproach;

public class SearchInARoatedArrayI {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;

            // check if the left half is sorted
            if (nums[low] <= nums[mid]) {
                // check if the target element is present in the left half
                if (nums[low] <= target && target <= nums[mid]) {
                    // Target exists in the left sorted half so reducing the search space down to
                    // low to mid-1
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}

/*
 * Time Complexity : O(log n)
 */