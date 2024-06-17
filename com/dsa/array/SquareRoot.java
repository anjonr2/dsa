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

    public static int sqrtN(long N) {
        if (N == 0 || N == 1) {
            return (int) N;
        }
        long low = 1;
        long high = N;
        int ans = 1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid <= N) {
                ans = (int) mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
