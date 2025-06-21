package com.dsa.bitmanipulation.basics;

public class BinaryToDecimal {
    public int binaryToDecimal(String binary) {

        int decimal = 0, powerOfTwo = 1;
        int n = binary.length();
        for (int i = n - 1; i >= 0; i -= 1) {
            // check if the character is not '0'.
            // Because if we multiply 0 with any number, it will always be 0.
            if (binary.charAt(i) == '1') {
                decimal += powerOfTwo;
            }
            powerOfTwo *= 2;
        }
        return decimal;
    }
}
