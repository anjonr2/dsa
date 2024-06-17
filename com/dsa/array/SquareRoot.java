package com.dsa.array;

public class SquareRoot {
    public static int floorSqrt(int n) {
        int ans = 0;
        for (long i = 1; i <= n; i++) {
            long val = i * i;
            if (val <= (long) n) {
                ans = (int) i;
            } else {
                break;
            }
        }
        return ans;
    }
}
