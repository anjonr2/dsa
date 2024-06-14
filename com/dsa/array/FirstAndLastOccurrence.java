package com.dsa.array;

public class FirstAndLastOccurrence {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurrence = -1;
        int lastOccurrence = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                firstOccurrence = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                lastOccurrence = i;
                break;
            }
        }
        return new int[] { firstOccurrence, lastOccurrence };
    }

    public int binarySearch(int[] arr, int target, boolean isSearchingLeft) {
        int idx = -1;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                idx = mid;
                if (isSearchingLeft == true) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return idx;
    }

    public int[] searchRange1(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        return new int[] { left, right };
    }
}
