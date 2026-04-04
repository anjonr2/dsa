package com.problemsolving.BinarySearch.medium.kokoEatingBananas.LinearSearchApproach;

public class KokoEatingBananas {
    // Helper function to find maximum element in the array
    private int findMax(int[] nums) {
        int maximum = Integer.MIN_VALUE;
        for (int num : nums) {
            maximum = Math.max(num, maximum);
        }
        return maximum;
    }

    /* Helper function to calculate total hours required at given hourly rates */
    private long calculateTotalHours(int[] nums, int hourly) {
        long totalH = 0;
        int n = nums.length;

        for (int i = 0; i < n; i += 1) {
            totalH += Math.ceil((double) nums[i] / (double) hourly);
        }

        return totalH;
    }

    // Function to find minimum hrs to eat all the bananas within h hours
    public int minimumRateToEatBananas(int[] nums, int h) {
        // Find maximum number of banans
        int maxi = findMax(nums);

        /* Find the minimum value of h that satisfies the condition */
        for (int i = 1; i <= maxi; i += 1) {
            long requiredTime = calculateTotalHours(nums, i);
            if (requiredTime <= (long) h)
                return i;
        }
        return maxi;
    }
}
