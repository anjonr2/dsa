package com.dsa.stack.NearestSmallerElements;

/*
 * intput: {4,10,5,8,20,15,3,12}
 * output: {3,3,3,3,15,3,-1,-1}
 * there is no smaller element right to 12 so we put -1
 * next there is no smaller element right to 3
 * next 3 is smaller than 15
 * next 15 is smaller than 20
 */
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
