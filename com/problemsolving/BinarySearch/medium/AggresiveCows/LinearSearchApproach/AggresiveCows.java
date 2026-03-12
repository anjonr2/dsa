package com.problemsolving.BinarySearch.medium.AggresiveCows.LinearSearchApproach;

import java.util.Arrays;

//naive approach would be to use linear search to check all possible distances from 1 to (max-min)
//where max is the maximum element of the array and min is the minimum
public class AggresiveCows {
    public boolean canPlace(int[] stalls, int cows, int distance) {
        int countOfCowsCanBePlaced = 1;
        // place the first cow at the fist stall
        int lastPosition = stalls[0];

        // try placing the remaining cows starting from stalls present at 1st index
        for (int i = 1; i < stalls.length; i += 1) {
            // if there is a gap of atleast 'distance' between current stall and last
            // position then we can place a cow
            if (stalls[i] - lastPosition >= distance) {
                countOfCowsCanBePlaced += 1;
                lastPosition = stalls[i];
            }
            if (countOfCowsCanBePlaced >= cows)
                return true;
        }
        return false;
    }

    public int aggresiveCows(int[] stalls, int cows) {
        // sort the stalls based on distances
        Arrays.sort(stalls);

        int n = stalls.length;
        // get the maximum possible distance
        int maxDist = stalls[n - 1] - stalls[0];

        int ans = 0;

        // Try all possible distances starting from d=1 to d = limit
        for (int d = 1; d <= maxDist; d += 1) {
            if (canPlace(stalls, cows, d)) {
                ans = d;
            }
        }
        return ans;
    }
}
