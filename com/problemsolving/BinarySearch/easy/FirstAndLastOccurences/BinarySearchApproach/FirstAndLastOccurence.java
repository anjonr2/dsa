package com.problemsolving.BinarySearch.easy.FirstAndLastOccurences.BinarySearchApproach;

public class FirstAndLastOccurence {
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurence(nums, target);
        int last = lastOccurence(nums, target);
        return new int[] { first, last };
    }

    private int lastOccurence(int[] nums, int target) {
        int last = -1;
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }

    private int firstOccurence(int[] nums, int target) {
        int first = -1;
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            // if the target element is found we update the first occurence to mid and
            // eliminate the right half to look for more smaller index where target is
            // present
            if (nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (nums[mid] < target) {
                // since the array is sorted if the mid element is less than target so
                // elemenents on the left of mid will also be smaller than target so we can
                // eliminate the left half
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return first;
    }
}
