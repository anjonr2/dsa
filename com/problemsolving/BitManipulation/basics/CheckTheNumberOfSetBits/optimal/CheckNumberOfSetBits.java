package com.problemsolving.BitManipulation.basics.CheckTheNumberOfSetBits.optimal;

public class CheckNumberOfSetBits {
    public int countSetBit(int n) {
        int count = 0;

        while (n > 0) {
            /*
             * What does n & (n-1) do?
             * 
             * n-1 flips the lowest 1 bit to 0 and all lower bits (to the right) to 1
             * n & (n-1) - bitwise AND between n and n-1 clears only that lowest 1 bit,
             * leaving all higher bits unchanged
             * 
             * Let n = 12 1100
             * n - 1 = 11 binary 1011
             * 
             * lowest 1 bit of 12 is in the 2nd index
             * so it will get cleared if we do n & (n-1) = 1000
             * 
             * n = 1000
             * n-1 = 9 binary of 9 0111 ( it flips lowest significant bit and then sets the
             * rightmost bit to it to 1)
             * 
             * so if we do a and of n & n-1 it will give
             * 1000
             * 0111
             * ----
             * 0000
             */
            n &= (n - 1);
            count += 1;
        }
        return count;
    }

}
