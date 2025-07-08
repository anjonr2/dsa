package com.dsa.bitmanipulation.basics;

public class ToggleIthBit {
    public static int toggleIthBit(int num, int i) {
        // Toggle the ith bit of num by using bitwise XOR with a mask
        // The mask is created by left shifting 1 by i positions
        return num ^ (1 << i);
    }
}
