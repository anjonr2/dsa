package com.problemsolving.BitManipulation.basics;

public class BinaryToDecimal {
    /*
     * Converting 1101 to its decimal equivalent
     * 
     * Start from the rightmost bit (least significant bit) and move to the left
     * 
     * Each bit is multiplied by 2 raised to the power of its position index
     * (starting from 0)
     * 
     * 1 * 2^0 = 1;
     * 0 * 2^1 = 0;
     * 1 * 2^2 = 4;
     * 1 * 2^3 = 8;
     * 
     * Summing these values will give the number 1 + 0 + 4 + 8 = 13
     */
    public static int binaryToDecimal(String str) {
        int decimal = 0;
        int len = str.length();
        int powerOf2 = 1;
        for (int i = len - 1; i >= 0; i -= 1) {
            if (str.charAt(i) == '1') {
                decimal += powerOf2;
            }
            powerOf2 *= 2;
        }
        return decimal;
    }
}

/*
 * Time complexity : O(n) traversing every bit in the string
 * Space complexity : O(1) couple of variable used
 */