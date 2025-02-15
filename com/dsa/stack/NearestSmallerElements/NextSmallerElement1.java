package com.dsa.stack.NearestSmallerElements;

import java.util.Stack;

public class NextSmallerElement1 {
    public static int[] leftMostSmallerElement(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.pop();
            stack.push(arr[i]);
        }
        return ans;
    }
}
