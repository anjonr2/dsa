package com.dsa.bitmanipulation.InterviewProblems.NumberThatAppearsOnce.optimal;

public class NumberThatAppearsOnce {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i += 1) {
            xor ^= nums[i];
        }
        return xor;
    }
}
