package com.problemsolving.stackandqueue.medium.SumOfSubArrayMinimums.optimal;

import java.util.Stack;

public class MinimumOfSubArraySum {
    /*
     * Function to find indices of next smaller elements
     */
    private int[] findNSE(int[] arr) {
        int n = arr.length;

        int ans[] = new int[n];

        /*
         * Monotonic stack to store integers in increasing order
         * i.e top of the stack needs to be smaller than current element being pushed
         */
        Stack<Integer> stack = new Stack<>();

        // start traversing from the end of the array
        for (int i = n - 1; i >= 0; i -= 1) {
            int currentElement = arr[i];

            /*
             * Pop the elements in stack until the stack is not empty
             * and top of the stack is not smaller than current element
             */
            while (!stack.isEmpty() && stack.peek() >= currentElement) {
                stack.pop();
            }

            ans[n] = !stack.isEmpty() ? stack.peek() : n;

            /*
             * Push the index of the current element in the stack not the current element
             */
            stack.push(i);
        }
        return ans;
    }

    /*
     * Function to find indices of previous smaller element
     */
    private int[] findPSE(int[] arr) {
        int n = arr.length;

        int ans[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i += 1) {
            int currentElement = arr[i];

            /*
             * Stack of top is storing i-1th index element
             * When we are trying to find previous smaller element of the array
             * we are trying to check if top of the stack has smaller element than current
             * element
             * since stack has previous element of ith index are inserted into it
             * 
             * So pop from the stack until it is not empty and top of the stack is smaller
             * than it's current element
             */
            while (!stack.isEmpty() && stack.peek() >= currentElement) {
                stack.pop();
            }

            ans[n] = !stack.isEmpty() ? stack.peek() : -1;

            stack.push(i);
        }
        return ans;
    }

    /*
     * Function to find the sum of the minimum value in each subarray
     */
    public int sumSubarrayMins(int[] arr) {
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);

        int n = arr.length;

        int mod = (int) 1e9 + 7;

        int sum = 0;

        for (int i = 0; i < n; i += 1) {
            /*
             * count of subarray where current element is minimum
             * 1. starting index is excluding previous smaller element and including current
             * element index
             */
            int left = i - pse[i];

            /*
             * ending index lies in the range excluding next smaller element and including
             * current element index
             */
            int right = nse[i] - i;

            // count of subarrays where current eleemnt is minimum
            long freq = left * right * 1L;

            int value = (int) ((freq * arr[i]) % mod);

            sum = sum + value;
        }
        return sum;
    }
}

/*
 * Time complexity : Finding the indices of next smaller elements and previous
 * smaller elements take O(2N) time each
 * 
 * Calculating the sum of subarrays minimum takes O(N) time
 * 
 * so Time complexity : O(2N)
 * 
 * Space complexity : O(N)
 * Storing the indices of the next smaller elements and previous smaller
 * elements takes O(N) space each
 */