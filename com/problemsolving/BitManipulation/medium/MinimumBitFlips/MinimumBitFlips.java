package com.problemsolving.BitManipulation.medium.MinimumBitFlips;

public class MinimumBitFlips {
    public int minimumBitFlips(int start, int goal) {
        /*
         * Variable to store bits that are different in number
         * since xor operation gives 1 if two bits are different
         * start = 10 binary of 10 is 1010
         * goal = 7 binary of 7 is 0111
         * 
         * if we do xor of start ^ goal
         * 1010
         * ^0111
         * -----
         * 1101
         * 
         * since xor of same bits is 0 so 1 ^ 1 = 0 or 0^0 = 0
         */
        int num = start ^ goal;

        int count = 0;

        while (num > 0) {
            /*
             * 
             * binary of 1 is 0001
             * 
             * num & 1
             * num : 1101
             * 1 : 0001
             * & :-----
             * 0001
             * count += 1 count = 1
             * when we do right shift of num by 1
             * num gets updated to num = 0110
             * (0110 & 0001) = 0;
             * 
             * count = 1+0 = 0;
             * 
             * num >>1 = 0011
             * num & 1 = (0011&0001) = 1 count = 1+1 = 2;
             * 
             * num >> 1 = 0001
             * num & 1 = (0001 & 0001) = 1 count = 2 + 1 = 3;
             * 
             * 
             */
            count += (num & 1);
            num >>= 1;
        }

        return count;
    }
}
