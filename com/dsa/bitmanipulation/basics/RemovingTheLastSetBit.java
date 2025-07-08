package com.dsa.bitmanipulation.basics;

public class RemovingTheLastSetBit {
    public static int removeLastSetBit(int num) {
        // Remove the last set bit of num by using bitwise AND with (num - 1)
        // This operation clears the least significant set bit of num
        return num & (num - 1);
    }
}
