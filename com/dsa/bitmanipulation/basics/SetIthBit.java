package com.dsa.bitmanipulation.basics;

public class SetIthBit {
    public static int setIthBit(int num, int i) {
        // Set the ith bit of num to 1 by using bitwise OR with a mask
        // The mask is created by left shifting 1 by i positions
        return num | (1 << i);
    }
}
