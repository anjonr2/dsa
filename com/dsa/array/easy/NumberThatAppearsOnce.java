package com.dsa.array.easy;

public class NumberThatAppearsOnce {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == num) {
                    cnt++;
                }
            }
            if (cnt == 1)
                return num;
        }
        return -1;
    }

    public int singleNumber1(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }
}
