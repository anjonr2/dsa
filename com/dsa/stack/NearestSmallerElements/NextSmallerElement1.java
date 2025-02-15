package com.dsa.stack.NearestSmallerElements;

/*input: {4,10,5,8,20,15,3,12}
there is no smaller element on left of 4 so we put -1
next 4 is smaller than 10
next 4 is smaller than 5
 * output: {-1,4,4,5,8,8,-1,3}
 */
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
