package com.problemsolving.stackandqueue.hard.StockSpanProblem.optimal;

import java.util.Stack;

public class StockSpanProblem {
    /*
     * Function to find indices of previous greater element for each element in the
     * array
     */
    private int[] findPGE(int[] arr) {
        int n = arr.length; // size of array

        // to store the previous greater element
        int ans[] = new int[n];

        // monotonic stack
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i += 1) {
            int currentElement = arr[i];

            /*
             * Pop the elements from the stack until the stack is not empty and the top
             * element is not greater element than current element
             */
            while (!stack.isEmpty() && arr[stack.peek()] <= currentElement) {
                stack.pop();
            }

            if (stack.isEmpty())
                ans[i] = -1;

            // Push the current index in the stack
            stack.push(i);
        }

        return ans;
    }

    public int[] stockSpan(int[] arr, int n) {
        int[] PGE = findPGE(arr);

        int[] ans = new int[n];

        for (int i = 0; i < n; i += 1) {
            ans[i] = i - PGE[i];
        }

        return ans;
    }
}

/*
 * Time complexity : O(2N) to find previous greater element
 * O(N) : Traversing the array once to find previous greater element
 * 
 * Space complexity : O(N)
 */