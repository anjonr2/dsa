package com.dsa.stack.SubArrMin;

/* problem description:https://leetcode.com/problems/sum-of-subarray-minimums/description/  */
public class SubArrayMins {
    public int sumSubarrayMins(int[] arr) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                sum += min;
            }
        }
        return sum;
    }
}
