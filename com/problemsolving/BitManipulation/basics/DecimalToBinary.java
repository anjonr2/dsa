package com.problemsolving.BitManipulation.basics;

public class DecimalToBinary {
    /*
     * Converting 13 to its equivalent binary
     * Start with decimal number 13
     * Divide the number by 2 and record the remainder
     * 
     * Repeat the division with the quotient until the number becomes 0
     * 
     * 13/2 = 6 remainder 1
     * 6/2 = 3 remainder 0
     * 3/2 = 1 remainder 1
     * 1/2 = 0 remainder 1
     * 
     * to obtain the binary equivalent of 13, the remainders must be read from
     * bottom to top, i.e 1101
     */
    public static String decimalToBinary(int n) {
        String binary = "";
        while (n > 0) {
            if (n % 2 == 1)
                binary += '1';
            else
                binary += '0';
            n = n / 2;
        }
        binary = new StringBuilder(binary).reverse().toString();
        return binary;
    }
}

/*
 * Complexity analysis ---
 * 
 * Time complexity : O(logn) since the number is being divided by 2 continuously
 * Space complexity : O(logN) storing the bits
 */