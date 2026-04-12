package com.problemsolving.BinarySearch.medium.PaintersPartition;

import java.util.Arrays;

public class PaintersPartition {
    /* Function to check if painters can paint within maxLen */
    private boolean canPaint(int[] C, int A, long maxLen) {
        long total = 0;
        int painters = 1;
        for (int len : C) {
            if (total + len > maxLen) {
                painters += 1;
                total = len;
                if (painters > A)
                    return false;
            } else {
                total += len;
            }
        }
        return true;
    }

    /* Function to find minimum time required */
    public int paint(int A, int B, int[] C) {
        /* At least one painter must handle the longest board */
        long low = Arrays.stream(C).max().getAsInt();

        /* If one painter does all boards */
        long high = Arrays.stream(C).sum();

        while (low <= high) {
            long mid = (low + high) / 2;
            if (canPaint(C, A, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }
}
