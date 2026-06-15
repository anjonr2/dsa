package com.problemsolving.stackandqueue.medium.NextGreaterElement.brute;

import java.util.Arrays;

public class NextGreaterElement {
    /*
     * Function to find next greater element for each element in the array
     */
    public int[] nextGreaterElement(int[] arr) {
        int n = arr.length;

        // array to store next greater element for each element
        int ans[] = new int[n];
        Arrays.fill(ans, -1);

        for (int i = 0; i < n; i += 1) {
            // get the current element
            int currentElement = arr[i];

            for (int j = i + 1; j < n; j += 1) {
                if (arr[j] > currentElement) {
                    arr[i] = arr[j];

                    break;
                }
            }
        }
        return ans;
    }
}

/*
 * Time complexity : O(N^2)
 */