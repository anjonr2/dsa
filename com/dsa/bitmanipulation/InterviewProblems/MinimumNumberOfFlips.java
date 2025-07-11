package com.dsa.bitmanipulation.InterviewProblems;

public class MinimumNumberOfFlips {
    public int minBitsFlip(int start, int goal) {
        int num = start ^ goal; // XOR to find differing bits
        int count = 0; // Count of the bits to flip
        for (int i = 0; i < 32; i += 1) {
            // Check if the ith bit is set in num
            if ((num & (1 << i)) != 0) {
                count += 1; // Increment count for each differing bit
            }
        }
        return count;
    }
}
