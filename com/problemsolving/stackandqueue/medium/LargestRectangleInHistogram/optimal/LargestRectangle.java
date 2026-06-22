package com.problemsolving.stackandqueue.medium.LargestRectangleInHistogram.optimal;

import java.util.Stack;

public class LargestRectangle {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> stack = new Stack<>();

        int largestArea = 0;

        // To store current area
        int area;

        /* To store the indices of next smaller and previous smaller elements */
        int nse, pse;

        for (int i = 0; i < n; i += 1) {
            /*
             * Pop the elements from the stack until the stack is not empty and the top
             * element is not smaller than current element of the array
             */
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                // get the index of the top of the stack
                int ind = stack.pop();

                /* Update the index of the previous smaller element */
                pse = stack.isEmpty() ? -1 : stack.peek();

                /* Next smaller index for the popped element is the current index */
                nse = i;

                area = (heights[nse] - heights[pse] - 1) * heights[ind];

                largestArea = Math.max(largestArea, area);

            }

            // push the current index i in the stack
            stack.push(i);
        }

        /*
         * For elements that are not popped from the stack
         */
        while (!stack.isEmpty()) {
            // NSE for such element is the length of the heights array
            nse = n;

            // Get the index of the top of the stack
            int ind = stack.pop();

            pse = stack.isEmpty() ? -1 : stack.peek();

            area = heights[ind] * (nse - pse - 1);

            largestArea = Math.max(largestArea, area);
        }
        return largestArea;
    }
}

/*
 * 
 * Time complexity : O(N)
 * Traversing all the elements of the array takes O(N) time
 * All the elements are pushed in and popped out from the stack once taking O(N)
 * time
 * 
 * Space complexity : O(N)
 * The stack space used to find the previous smaller element during traversal
 * can go up to O(N)
 */