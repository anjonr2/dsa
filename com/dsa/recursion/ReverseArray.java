package com.dsa.recursion;

public class ReverseArray {
    //
    public static void reverse(int i, int n, int[] arr) {
        if (i >= n / 2) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[n - i - 1];
        arr[n - i - 1] = temp;

        reverse(i + 1, n, arr);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        reverse(0, 6, arr);
        for (int el : arr) {
            System.out.println(el);
        }
    }
}
