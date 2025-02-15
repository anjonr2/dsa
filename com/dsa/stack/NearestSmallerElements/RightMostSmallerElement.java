package com.dsa.stack.NearestSmallerElements;

import java.util.Stack;

public class RightMostSmallerElement {
    public static int[] rightMostSmallerElement(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i -= 1) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(ans[i]);
        }
        return ans;
    }
}
