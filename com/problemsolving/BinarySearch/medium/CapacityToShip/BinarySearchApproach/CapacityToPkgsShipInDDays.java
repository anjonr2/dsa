package com.problemsolving.BinarySearch.medium.CapacityToShip.BinarySearchApproach;

import java.util.Arrays;

public class CapacityToPkgsShipInDDays {
    // Helper function to check all pkgs can be shipped withing given days
    private boolean canShip(int[] weights, int days, int capacity) {
        int requiredDays = 1;
        int currentLoad = 0;

        // Iterate through all weights
        for (int weight : weights) {
            // Start new day if capacity exceeded
            if (currentLoad + weight > capacity) {
                requiredDays += 1;
                currentLoad = weight;
            } else {
                currentLoad += weight;
            }
        }
        return requiredDays <= days;
    }

    // Find minimum ship capacity
    public int shipWithinDays(int[] weights, int days) {
        // Lower bound : maximum weight of a single pkg
        int low = Arrays.stream(weights).max().getAsInt();

        // Upper bound : sum of all weights
        int high = Arrays.stream(weights).sum();

        int ans = high;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canShip(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}

/*
 * Time complexity : O(log(maxW-max(weights))*n)
 */