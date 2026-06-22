package com.problemsolving.stackandqueue.medium.LargestRectangleInHistogram.brute;

import java.util.Stack;

public class LargestRectangle {
    /* Function to find indices of next smaller elements */
    private int[] findNSE(int[] arr) {
        int n = arr.length;

        int ans[] = new int[n];

        /* Monotonic stack to store arr elements in ascending order */
        Stack<Integer> stack = new Stack<>();

        /* traverse array backward for next smaller elements */
        for (int i = n - 1; i >= 0; i -= 1) {
            int currentElement = arr[i];

            /*
             * Pop the elements from the stack until stack is not empty and the top element
             * is not smaller element
             */
            while (!stack.isEmpty() && arr[stack.peek()] >= currentElement) {
                stack.pop();
            }

            ans[i] = !stack.isEmpty() ? stack.peek() : n;

            /* Push the index of current element in the stack */
            stack.push(i);
        }

        return ans;
    }

    /* Function to find indices of previous smaller elements */
    private int[] findPSE(int arr[]) {
        int n = arr.length;

        int ans[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i += 1) {
            int currentElement = arr[i];

            /*
             * Pop the elements from the stack until top of the stack is not smaller than
             * current element
             */
            while (!stack.isEmpty() && arr[stack.peek()] >= currentElement) {
                stack.pop();
            }

            ans[i] = !stack.isEmpty() ? stack.peek() : -1;

            stack.push(i);
        }
        return ans;
    }

    // Function to find largest rectangle area
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        /* Determine the next and previous smaller elements */
        int nse[] = findNSE(heights);
        int pse[] = findPSE(heights);

        int largestArea = 0;

        // to store current area
        int area;

        for (int i = 0; i < n; i += 1) {
            /*
             * calculate area of rectangle height * width
             * nse[i] - pse[i] - 1 gives width
             */
            area = (nse[i] - pse[i] - 1) * heights[i];

            largestArea = Math.max(area, largestArea);
        }
        return largestArea;
    }
}

/*
 * Time complexity : O(N) (where N is the size of the given array)
 * 
 * Space complexity : O(N) to store nse[] and pse[] arrays
 */