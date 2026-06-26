package com.problemsolving.array.easy.SingleNumberI.optimal;

public class SingleNumberI {
    /*
     * Function to get the single number in the given array
     */
    public int singleNumber(int[] nums) {
        /*
         * Variable to store XOR of all elements of the array
         */
        int XOR = 0;

        // Since XOR of same number is 0. So elements which are presents twice cancels
        // out and odd one remains
        for (int i = 0; i < nums.length; i += 1) {
            XOR = XOR ^ nums[i];
        }

        // XOR stores the required number
        return XOR;
    }
}
