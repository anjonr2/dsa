package com.dsa.bitmanipulation.basics;

public class CheckIfIthBitIsSetOrNot {
    public boolean isIthBitSet(int num, int i) {
        // Check if the ith bit is set by using bitwise AND with a mask
        // The mask is created by left shifting 1 by i positions
        return (num & (1 << i)) != 0;
    }
}
