package com.problemsolving.BitManipulation.basics.CheckIfPowerOftwo;

public class CheckIfANumberIsAPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
