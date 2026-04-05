package com.problemsolving.BinarySearch.medium.MinimumDaysToMakeMBouquets.LinearSearchApproach;

public class MinimumNumberOfBouquets {
    /*
     * Function to check if it's possible to make m bouquets with
     */
    private boolean possible(int[] nums, int day, int m, int k) {
        int n = nums.length;

        // count of flowers bloomed
        int cnt = 0;

        // count of bouquets formed
        int noOfB = 0;

        for (int i = 0; i < n; i += 1) {
            // checks if the bloom day of the flower at nums[i] is less than or equal to our
            // current day
            if (nums[i] <= day) {
                // Increment count of flowers that has bloomed
                cnt += 1;
            } else {
                // check how many bouquet can be made using cnt flower which has bloomed so far
                noOfB += cnt / k;

                // reset count of flower to 0. As to make bouquet we need adjacent bloomed
                // flower so this flower at nums[i] acts as break in streak so we need to reset
                // the count
                cnt = 0;
            }
        }

        // If the last flower from the array is bloomed then it will never go into else
        // block. Below line ensures that any flowers that we are holding when loop is
        // finished are processed into bouquets
        noOfB += cnt / k;

        /*
         * Returns true if enough bouquet can be formed
         */
        return noOfB >= m;
    }

    /*
     * Function to find the earliest day to make m bouquets of k flowers each
     * 
     * @Param n size of the array
     * 
     * @Param nums contains the day on which each roses will bloom
     * 
     * @Param k no of roses required to make a bouquet
     * 
     * @Param m no of bouquet required
     * 
     * @return minimum days to make m bouqet using k roses each
     */
    public int roseGarden(int n, int[] nums, int k, int m) {
        /* Calculate the minimum number of flowers required */
        long val = (long) m * k;

        /* Impossible case : not enough flowers to make m bouqets */
        if (val > n)
            return -1;

        /* Find the mininmum and maximum bloom days in the array */
        int mini = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i += 1) {
            mini = Math.min(mini, nums[i]);
            max = Math.max(max, nums[i]);
        }

        /* Linear search to find the earliest day to make m bouquets */
        for (int day = mini; day <= max; day += 1) {
            if (possible(nums, day, m, k))
                return day;
        }
        return -1;
    }
}

/*
 * Time complexity : O((max-min+1) * N), where max is the maximum element of the
 * array, min is the minimum element of the array, N is the size of the array
 * 
 * As running a loop to check answers that are in the range of [min, max]. For
 * every possible answer the possible() function is being called. Inside the
 * possible() function traversing the entire array which results in O(N)
 */