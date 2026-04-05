package com.problemsolving.BinarySearch.medium.MinimumDaysToMakeMBouquets.BinarySearchApproach;

public class MinimumNumberOfBouquets {
    private boolean possible(int[] nums, int day, int m, int k) {
        int noOfB = 0;
        return noOfB >= m;
    }

    /* Function to find the earliest day to make m bouquets of k flowers each */
    public int roseGarden(int n, int[] nums, int k, int m) {

        /* Calculate minimum number of flowers required */
        long val = (long) k * m;

        /* Impossible case : not enough flower to make m bouquet */
        if (val > n)
            return -1;

        /* Find the minimum and maximum bloom days in the array */
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i += 1) {
            mini = Math.min(mini, nums[i]);
            maxi = Math.max(maxi, nums[i]);
        }

        /* binary search to find the earliest day to make m bouquets */
        int low = mini, high = maxi;

        int ans = -1;
        while (low <= high) {
            // Calculate middle day
            int mid = (low + high) / 2;

            /* Check if it's possible to make m bouquets on day mid */
            if (possible(nums, mid, m, k)) {
                ans = mid;

                // Try for a smaller day
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

/* Time complexity : O(log(max-min+1)*N) */