package com.dsa.array;

public class LowerBound {
    public static int lowerBound(int[] arr, int n, int x) {
        int ans = n;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;
            if (arr[middle] >= x) {
                ans = middle;
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return ans;
    }
}
