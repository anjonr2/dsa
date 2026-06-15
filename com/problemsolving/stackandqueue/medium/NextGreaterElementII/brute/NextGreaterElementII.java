package com.problemsolving.stackandqueue.medium.NextGreaterElementII.brute;

import java.util.Arrays;

public class NextGreaterElementII {
    public int[] nextGreaterElement(int[] arr) {
        int n = arr.length;

        // ans array stores next greater element for each element in the array
        int ans[] = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i += 1) {
            int currentElement = arr[i];
            for (int j = i + 1; j < n; j += 1) {
                // index of the circular array
                int index = (i + j) % n;
                if (arr[index] > currentElement) {
                    arr[i] = arr[index];
                    break;
                }
            }
        }
        return ans;
    }
}
