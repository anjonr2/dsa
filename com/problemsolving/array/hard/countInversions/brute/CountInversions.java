package com.problemsolving.array.hard.countInversions.brute;

public class CountInversions {
    public long countInversions(int[] arr) {
        long count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i += 1) {
            for (int j = i + 1; j < n; j += 1) {
                // if left element is greater than right element then we have found an inversion
                if (arr[i] > arr[j]) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
