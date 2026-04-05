package com.problemsolving.BinarySearch.medium.CapacityToShip.LinearSearchApproach;

public class CapacityToShipInDDays {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacityOfShip = 0, maxCapacityOfShip = 0;

        for (int weight : weights) {
            minCapacityOfShip = Math.max(minCapacityOfShip, weight);
            maxCapacityOfShip += weight;
        }

        for (int capacity = minCapacityOfShip; capacity <= maxCapacityOfShip; capacity += 1) {
            int requiredDays = 1;
            int currentLoad = 0;

            // Iterate over pkgs
            for (int weight : weights) {
                // If adding pkg exceeds capacity
                if (currentLoad + weight > capacity) {
                    // start a new day
                    requiredDays += 1;
                    currentLoad = weight;
                } else {
                    // Add to current day's load
                    currentLoad += weight;
                }
            }

            // If number of days fits allowed days, return capacity
            if (requiredDays <= days)
                return capacity;
        }

        return maxCapacityOfShip;
    }
}

/*
 * Time complexity :O((maxW-max(weights[]))*n), where n is the total number of
 * pkgs and maxW is the sum of all package weights. We try each possible
 * capacity from the maximum single pkg weight up to the total weight and for
 * each capacity we traverse all packages once
 */
