package com.dsa.bitmanipulation.basics;

public class ClearIthBit {
    public static int clearIthBit(int num, int i) {
        // Clear the ith bit of num by using bitwise AND with a mask
        // The mask is created by left shifting 1 by i positions and then negating it
        return num & ~(1 << i);
    }
}
