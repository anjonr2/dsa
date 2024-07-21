package com.dsa.array;

public class CountInversion {
    public static int numberOfInversions(int[] a, int n) {
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}
