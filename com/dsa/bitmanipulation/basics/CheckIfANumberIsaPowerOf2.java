package com.dsa.bitmanipulation.basics;

public class CheckIfANumberIsaPowerOf2 {
    public static boolean isPowerOfTwo(int n) {
        // A number is a power of 2 if it is greater than 0 and
        // it has only one bit set in its binary representation.
        return (n & (n - 1)) == 0;
    }
}
