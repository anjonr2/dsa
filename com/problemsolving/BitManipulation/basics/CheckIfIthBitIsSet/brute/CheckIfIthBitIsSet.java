package com.problemsolving.BitManipulation.basics.CheckIfIthBitIsSet.brute;

public class CheckIfIthBitIsSet {
    /* Function to check if the i-th bit of number n is set (1) */
    public boolean checkIthBit(int n, int i) {
        /*
         * in this brute force approach
         * We first convert n to it's binary representation
         * Reverse the binary string to make it 0-indexed from the least significant bit
         * If the string has fewer than i + 1 bits, return false
         * Otherwise return true if the ith bit is '1'
         */

        String binary = Integer.toBinaryString(n); // convert the number into binary string

        // if the bit index is greater than the length of the binary string return false
        if (i >= binary.length())
            return false;

        /*
         * Return true if the ith bit is 1
         * We are checking from last index that's why binary.length() - 1 - i
         */
        return binary.charAt(binary.length() - 1 - i) == '1';
    }
}
