package com.problemsolving.stackandqueue.medium.NextGreaterElement.optimal;

import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] arr) {
        int n = arr.length;

        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        // start travresing array from back or right
        for (int i = n - 1; i >= 0; i -= 1) {
            int currentElement = arr[i];

            /*
             * Pop the elements from the stack until the stack is not empty and top of the
             * stack is not greater than current element
             */
            while (!stack.isEmpty() && stack.peek() < currentElement) {
                stack.pop();
            }

            /*
             * If next greater element is not found for arr[i] stack will be empty
             */
            if (stack.isEmpty())
                ans[i] = -1;

            else
                ans[i] = stack.peek();

            /* Push the current element in the stack maintaining the decreasing order */
            stack.push(currentElement);
        }
        return ans;
    }
}

/*
 * Time complexity : O(N)
 * Traversing the array takes O(N) time, and traversing the stack will take
 * overall O(N) time
 * 
 * Space complexity : O(N)
 * Answer array takes o(N) space and Stack used will take O(N) space at worst
 * case
 */