package com.dsa.array;

public class CapacityOfShip {
    public int noOfDaysRequired(int[] weights, int capacityOfShip) {
        int day = 1;
        int load = 0;
        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > capacityOfShip) {
                day = day + 1;
                load = weights[i];
            } else {
                load += weights[i];
            }
        }
        return day;
    }

    public int shipWithinDays(int[] weights, int days) {
        int maximum = Integer.MIN_VALUE;
        int sum = 0;
        int n = weights.length;

        for (int i = 0; i < n; i++) {
            maximum = Math.max(maximum, weights[i]);
            sum += weights[i];
        }
        int low = maximum;
        int high = sum;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (noOfDaysRequired(weights, mid) <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
