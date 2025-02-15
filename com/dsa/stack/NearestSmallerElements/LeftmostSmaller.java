package com.dsa.stack.NearestSmallerElements;

public class LeftmostSmaller {
    public static int[] leftMostSmallerElement(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] < arr[i]) {
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        return ans;
    }
}
