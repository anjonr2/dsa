package com.problemsolving.stackandqueue.medium.SumOfSubArrayRanges.optimal;

import java.util.Stack;

public class SumOfSubArrayRanges {
    /*
     * Function to find indices of next smaller elements
     */
    private int[] findNse(int[] arr) {
        int n = arr.length;

        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        /* Start traversing from the back */
        for (int i = n - 1; i >= 0; i -= 1) {
            int currentElement = arr[i];

            /*
             * Pop the elements from the stack until the stack is not empty
             * and the top element is not the smaller element
             * Since in the stack we are storing indices only and since we have to compare
             * against element and not the indices
             * so we get the next or previous element using arr[stack.peek()]
             */

            while (!stack.isEmpty() && arr[stack.peek()] >= currentElement) {
                stack.pop();
            }

            ans[i] = !stack.isEmpty() ? stack.peek() : n;

            /* Push the index of current element to the stack */
            stack.push(i);
        }
        return ans;
    }

    /*
     * Function to find indices of next greater element
     */
    private int[] findNGE(int[] arr) {
        int n = arr.length;

        int ans[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        /* Start traversing from the back */
        for (int i = n - 1; i >= 0; i -= 1) {
            int currentElement = arr[i];

            /*
             * Pop the elements in the stack until the stack is not empty and top of the
             * stack is not greater than current element
             */
            while (!stack.isEmpty() && arr[stack.peek()] <= currentElement) {
                stack.pop();
            }

            ans[i] = !stack.isEmpty() ? stack.peek() : n;

            /*
             * Push the index of current element in the stack
             */
            stack.push(i);
        }
        return ans;
    }

    /*
     * Function to find indices of previous smaller element or equal elements
     */
    private int[] findPSEE(int[] arr) {
        int n = arr.length;

        int ans[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i += 1) {
            int currentElement = arr[i];

            while (!stack.isEmpty() && arr[stack.peek()] > currentElement) {
                stack.pop();
            }

            ans[i] = !stack.isEmpty() ? stack.peek() : -1;

            stack.push(i);

        }
        return ans;
    }

    /*
     * Function to find the indices of previous greater or equal element
     */
    private int[] findPGEE(int[] arr) {
        int n = arr.length;

        int ans[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i += 1) {
            int currentElement = arr[i];

            /*
             * Pop the elements in the stack until the stack is not empty and the top
             * elements are smaller than the current element
             */
            while (!stack.isEmpty() && arr[stack.peek()] < currentElement) {
                stack.pop();
            }

            ans[i] = !stack.isEmpty() ? stack.peek() : -1;

            stack.push(i);
        }

        return ans;
    }

    /*
     * Function to find the sum of the minimum value in each subarray
     */
    private long sumSubArrayMins(int arr[]) {
        int[] nse = findNse(arr);
        int[] psee = findPSEE(arr);

        int n = arr.length;

        long sum = 0;

        for (int i = 0; i < n; i += 1) {
            int left = i - psee[i];

            int right = nse[i] - i;

            /* Count of subarrays where current element is minimum */
            long freq = left * right * 1L;

            /* Contribution due to current element */
            long value = (freq * arr[i] * 1L);

            sum += value;

        }
        return sum;
    }

    /*
     * Function to find the sum of the maximum value in each subarray
     */
    private long subArraySumMaxs(int[] arr) {
        int nge[] = findNGE(arr);

        int pgee[] = findPGEE(arr);

        int n = arr.length;

        long sum = 0;

        for (int i = 0; i < n; i += 1) {
            int left = i - pgee[i];
            int right = nge[i] - i;

            /* Count of subarrays where current element is maximum */
            long freq = left * right * 1L;

            /* Contribution due to current element */
            long value = freq * arr[i] * 1L;

            sum += value;
        }

        return sum;
    }

    /*
     * Function to find the sum of subarray ranges in each subarray
     */
    public long subArrayRanges(int[] arr) {
        return (subArraySumMaxs(arr) - sumSubArrayMins(arr));
    }
}

/*
 * Time complexity : O(N) (where N is the size of the given array)
 * 
 * Calculating the sum of subarray maximums takes O(N) time
 * Calculating the sum of subarray minimums takes O(N) time
 * 
 * Space complexity : O(N)
 * 
 * Calculating the sum of subarray maximums requires O(N) space
 * Calculating the sum of subarray minimums requires O(N) space
 */