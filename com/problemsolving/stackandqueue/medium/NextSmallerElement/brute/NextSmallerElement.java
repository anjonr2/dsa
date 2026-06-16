package com.problemsolving.stackandqueue.medium.NextSmallerElement.brute;

import java.util.Arrays;

public class NextSmallerElement {
    // Function to find next smaller elements
    public int[] nextSmallerElement(int arr[]) {
        int n = arr.length;

        // array to store next smaller elements
        int ans[] = new int[n];

        // Initialize an answer array filled with -1
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i += 1) {
            int current = arr[i];

            // Look to the right of arr[i] to find next smaller element
            for (int j = i + 1; j < n; j += 1) {
                if (arr[j] < current) {
                    // Store and break on finding the next smaller element
                    ans[i] = arr[j];
                    break;
                }
            }
        }
        return ans;
    }
}

/*
 * Time complexity : O(N^2)
 * Space complexity : O(N)
 */