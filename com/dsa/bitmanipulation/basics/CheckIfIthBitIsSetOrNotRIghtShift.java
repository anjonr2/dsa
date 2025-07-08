package com.dsa.bitmanipulation.basics;

public class CheckIfIthBitIsSetOrNotRIghtShift {
    public boolean isIthBitSet(int num, int i) {
        return ((num >> i) & 1) != 0;
    }
}
