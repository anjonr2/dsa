package com.problemsolving.array.easy.MoveZeroes.brute;

public class MoveZeros {
    public void moveZeros(int[] nums) {
        int n = nums.length;

        // Create a temporary element to store non-zero elements
        int[] temp = new int[n];
        int count = 0;

        // Copy non-zero elements to temporary
        for (int i = 0; i < n; i += 1) {
            if (nums[i] != 0) {
                temp[count++] = nums[i];
            }
        }

        // Copy non-zero elements back to nums
        for (int i = 0; i < count; i++) {
            nums[i] = temp[i];
        }

        for (int i = count; i < nums.length; i += 1) {
            nums[i] = 0;
        }
    }
}
