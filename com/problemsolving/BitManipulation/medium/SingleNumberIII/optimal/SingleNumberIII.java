package com.problemsolving.BitManipulation.medium.SingleNumberIII.optimal;

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

        /* Variable to get rightmost set bit in overall for a given number */
        int rightmost = (int) (XOR & (XOR - 1)) ^ (int) XOR;

        /* Variable to store XOR of elements in bucket 1 and 2 */
        int XOR1 = 0, XOR2 = 0;

        for (int i = 0; i < n; i += 1) {
            /*
             * Divide the numbers among bucket 1 and bucket 2 based on right most set bit
             */
            if ((nums[i] & rightmost) != 0) {
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

/*
 * Time complexity : O(2n) traversing the array twice
 * Space complexity : O(1)
 */