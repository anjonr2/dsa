package com.problemsolving.BinarySearch.easy.SearchInARotatedSortedArrayII;

public class SearchInARotatedSortedArrayII {
    // Function to search for the target element in a rotated sorted array with
    // duplicates
    public boolean searchInARotatedSortedArrayII(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return true;

            // if both low , high and mid have duplicates then trim the search space
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }

            // checks if the left half is sorted
            if (nums[low] <= nums[mid]) {
                // check if the target exists in the left search space
                if (nums[low] <= target && target <= nums[mid]) {
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
        return false;
    }
}
