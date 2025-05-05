package com.dsa.recursion1.SumOfArrayElements;

public class SumOfArrayElements {
    public static int sumOfArray(int[] arr, int n) {
        if (n <= 0) {
            return 0;
        }
        return arr[n - 1] + sumOfArray(arr, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int n = arr.length;
        int result = sumOfArray(arr, n);
        System.out.println("The sum of the array elements is: " + result);
    }
}
