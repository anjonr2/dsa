package com.problemsolving.BitManipulation.basics.SetTheRightMostUnsetBit;

public class SetRightMostUnsetBit {
    public static int setRightMostUnsetBit(int n) {
        /* Or with n+1 sets the rightmost 0 to 1 */
        return n | (n + 1);
    }
}
