package com.problemsolving.BitManipulation.basics.CheckIfANumberIsOddOrEven.optimal;

public class CheckOddEven {
    /*
     * In binary odd numbers always have the least significant bit (LSB) set to 1
     * By performing a bitwise AND with 1 (n & 1), we can directly check this bit.
     * If it's 1, the number is odd; otherwise it is even
     * 
     * Perform bitwise AND n & 1
     * If the result is 1, return true ( no is odd)
     * If the result is 0, return false ( no is even )
     */
    public boolean isOdd(int n) {
        return (n & 1) == 1;
    }
}

/*
 * Time complexity :O(1), as checking whether a number is odd using bitwise AND
 * takes constant time
 * 
 * Space complexity : O(1)
 */