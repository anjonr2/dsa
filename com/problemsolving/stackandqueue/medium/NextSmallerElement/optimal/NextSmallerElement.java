package com.problemsolving.stackandqueue.medium.NextSmallerElement.optimal;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public int[] nextSmallerElement(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int ans[] = new int[n];
        Arrays.fill(ans, -1);

        for (int i = n - 1; i >= 0; i -= 1) {
            int current = arr[i];

            /*
             * since we need to find next smaller element so top of the stack needs to be
             * smaller than current element
             * If top of the stack is greater than current element then pop until stack is
             * empty
             * 
             */
            while (!stack.isEmpty() && stack.peek() >= current) {
                stack.pop();
            }

            if (stack.isEmpty())
                ans[i] = -1;
            else
                ans[i] = stack.peek();

            stack.push(arr[i]);
        }
        return ans;
    }
}
