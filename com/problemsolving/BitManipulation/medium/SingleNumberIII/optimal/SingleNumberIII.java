package com.problemsolving.BitManipulation.medium.SingleNumberIII.brute;

public class SingleNumberIII {
    /*
     * Function to get the single number in a given array
     */
    public int[] singleNumber(int[] nums) {
        int n = nums.length;

        /* Variable to store XOR of all elements */
        long XOR = 0;

        for (int i = 0; i < n; i += 1) {
            XOR ^= nums[i];
        }

        /* Variable to get rightmost set bit in overall XOR */
        int rightmost = (int) (XOR & (XOR - 1)) ^ (int) XOR;

        int XOR1 = 0, XOR2 = 0;

        for (int i = 0; i < n; i += 1) {
            if ((nums[i] & XOR) != 0) {
                XOR1 = XOR1 ^ nums[i];
            } else {
                XOR2 = XOR2 ^ nums[i];
            }
        }

        // return the result in sorted order
        if (XOR1 < XOR2)
            return new int[] { XOR1, XOR2 };

        return new int[] { XOR1, XOR2 };
    }
}
