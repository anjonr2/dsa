package com.problemsolving.BinarySearch.medium.kokoEatingBananas.BinarySearchApproach;

/*
 * Searching for the slowest eating rate k such that totalH <= h
 */
public class KokoEatingBananas {
    private int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    private long calculateTotalHours(int[] nums, int hourly) {
        long totalHour = 0;
        int n = nums.length;

        for (int i = 0; i < n; i += 1) {
            totalHour += Math.ceil((double) nums[i] / (double) hourly);
        }
        return totalHour;
    }

    /* Function to find the minimum rate to eat bananas */
    public int minimumRateToEatBananas(int[] nums, int h) {
        // Initialize binary search bounds
        int low = 1, high = findMax(nums);
        while (low <= high) {
            int mid = (low + high) / 2;
            long totalHour = calculateTotalHours(nums, mid);
            if (totalHour <= h) {
                // this means current rate is fast enough. However it might not be the minimum
                // rate. To find a potentially smaller rate eliminate the right half by moving
                // the upper bound to left of mid
                high = mid - 1;
            } else {
                // current rate is too slow rate needs to be increased
                low = mid + 1;
            }
        }

        /* low points to smallest integer that satisfies the condition */
        return low;
    }
}

/*
 * Time complexity : O(nlog(max)), where max is the maximum element in the array
 * and n is the size of the array. We are applying binary search for the range
 * [1, max] and for every value of 'mid' we are traversing the entire array
 * inside the function called calculateTotalHours
 */
