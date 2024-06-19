package com.dsa.array;

// You are given an integer array bloomDay, an integer m and an integer k.
// You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
public class MinDaysToBloom {
    public boolean possible(int[] arr, int day, int m, int k) {
        int cnt = 0;
        int noOfB = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) {
                cnt++;
            } else {
                noOfB += (cnt / k);
                cnt = 0;
            }
        }
        noOfB += (cnt / k);
        return noOfB >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int val = m * k;
        int length = bloomDay.length;

        if (val > length)
            return -1;

        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            minimum = Math.min(maximum, bloomDay[i]);
            maximum = Math.max(maximum, bloomDay[i]);
        }

        int low = minimum;
        int high = maximum;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(bloomDay, mid, m, k) == true) {
                ans = mid;
                // since we need the minimum day so eliminate right half
                high = mid - 1;
            } else {
                // if the number is too small then we need to increase the day
                // move to right side
                high = mid + 1;
            }
        }
        return low;
    }
}
