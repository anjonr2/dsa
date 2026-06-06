package com.problemsolving.BitManipulation.medium.SingleNumberI.optimal;

public class SingleNumberI {
    /* Function to the single number in the given array */
    public int singleNumber(int[] nums) {
        /* variable to store XOR of all numbers */
        int XOR = 0;

        /*
         * since XOR of same bit is 0 XOR of all the elements that are present twice
         * will return 0
         */
        for (int num : nums) {
            XOR ^= num;
        }

        return XOR;
    }
}

/*
 * Time complexity : O(N) for traversing through the array
 * Space complexity : O(1)
 */