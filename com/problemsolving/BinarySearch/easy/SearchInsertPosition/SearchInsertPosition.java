package com.problemsolving.BinarySearch.easy.SearchInsertPosition;

//we can implement this using lower bound
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
