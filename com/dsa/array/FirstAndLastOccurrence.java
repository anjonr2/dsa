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
}
