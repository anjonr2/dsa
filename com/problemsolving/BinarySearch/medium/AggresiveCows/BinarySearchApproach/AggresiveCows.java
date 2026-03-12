package com.problemsolving.BinarySearch.medium.AggresiveCows.BinarySearchApproach;

import java.util.Arrays;

public class AggresiveCows {
    private boolean canPlace(int[] stalls, int d, int cows) {
        int count = 1;
        // place the first cow at first stall so count is 1
        int lastPosition = stalls[0];
        for (int i = 1; i < stalls.length; i += 1) {
            // if current stall is atleast d distance away from last placed cow the
            // increment cows count placed by 1
            if (stalls[i] - lastPosition >= d) {
                count += 1;
                lastPosition = stalls[i];
            }
            // this condition checks if all the cows are sucessfully placed or not
            if (count >= cows)
                return true;
        }
        return false;
    }

    public int aggressiveCows(int[] stalls, int cows) {
        Arrays.sort(stalls);
        int n = stalls.length;
        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canPlace(stalls, mid, cows)) {
                ans = mid;
                // if all the cow can be placed at mid distance so any distance left to mid can
                // also place all the given cows so to find maximum we can move to right and
                // eliminate the left
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
