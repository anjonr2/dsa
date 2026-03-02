package com.problemsolving.BinarySearch.easy.FindFloorAndCeil;

public class FindFloorAndCeil {
    private int findFloor(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                ans = nums[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return ans;
    }

    // finding ceil is same as implementing lower bound
    private int findCeil(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                ans = nums[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
