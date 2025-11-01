package com.dsa.RecursionBasics.ReverseArray.recursive;

public class Reverse {
    public int[] reverse(int[] arr, int start, int end) {
        if (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
            reverse(arr, start, end);
        }
        return arr;
    }
}
