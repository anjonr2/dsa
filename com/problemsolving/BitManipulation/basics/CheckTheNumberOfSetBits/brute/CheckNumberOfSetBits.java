package com.problemsolving.BitManipulation.basics.CheckTheNumberOfSetBits.brute;

public class CheckNumberOfSetBits {
    public int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            /*
             * Step1 : check if the least significant bit is set
             * 1 in binary is ...0001
             * n & 1 compares the the lowest bit of n with 1
             * if the lowest bit of n is 1 result of n & 1 is 1 else 0
             * 
             * Example n = 29 -> binary 11101
             * n & 1 = 11101 & 00001 = 1 - that bit is set
             * 
             */
            count += (n & 1);

            /*
             * Right shift n by 1
             * shifts all bits one position to the right
             * 
             * Example binary of 29 = 11101
             * if we right shift it by 1 bit then it becomes 01110
             */
            n >>= 1;
        }
        return count;
    }
}
