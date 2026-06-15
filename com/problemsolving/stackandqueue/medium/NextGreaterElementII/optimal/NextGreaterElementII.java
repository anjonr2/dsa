package com.problemsolving.stackandqueue.medium.NextGreaterElementII.optimal;

import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;

        int ans[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        /*
         * Start traversing from the back
         */
        for (int i = 2 * n - 1; i >= 0; i -= 1) {
            // get the actual index
            int index = i % n;

            int currentElement = arr[index];

            /*
             * Pop the elements in the stack until the stack is not empty and top element is
             * not greater than current element
             */
            while (!stack.isEmpty() && stack.peek() <= currentElement) {
                stack.pop();
            }

            // Store the answer for the actual array i.e second half of the array starting
            // from index n-1 to 0
            if (i < n) {
                if (stack.isEmpty())
                    ans[i] = -1;
                else
                    ans[i] = stack.peek();
            }

            stack.push(currentElement);

        }
        return ans;
    }
}

/*
 * Time complexity : O(2N) Traversing the hypothetical array will take O(2N)
 * time
 */