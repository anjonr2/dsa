package com.problemsolving.BitManipulation.basics.SwapTwonumbers;

public class SwapTwoNumbers {
    /* Function to swap two numbers using XOR */
    public void swap(int[] arr) {
        arr[0] = arr[0] ^ arr[1];
        /*
         * arr[0] ^ arr[1] ^ arr[1]
         * arr[1] ^ arr[1] becomes 0
         * so arr[0] = arr[1]
         */
        arr[1] = arr[0] ^ arr[1];

        /*
         * arr[1] = arr[0] ^ arr [1]
         * arr[0] ^ arr[1] = arr[0] ^ arr[0] ^ arr[1]
         * arr[0] ^ arr[0] = 0
         * so arr[1] = arr[0]
         */
        arr[0] = arr[0] ^ arr[1];
    }
}
