package com.problemsolving.BitManipulation.basics.CheckIfIthBitIsSet.optimal;

public class CheckIfIthBitIsSet {
    public boolean checkIthBit(int n, int i) {
        /* check if the ith bit is set using bitwise AND operation */
        return (n & (1 << i)) != 0; // If the i-th bit is 1, the result will be non zero
    }
}

/*
 * Time complexity : O(1), constant time bitwise operation
 * Space complexity : O(1), no additional space used
 */