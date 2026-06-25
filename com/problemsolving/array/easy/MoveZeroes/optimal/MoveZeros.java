package com.problemsolving.array.easy.MoveZeroes.optimal;

public class MoveZeros {
    public void moveZeros(int[] nums) {
        // j keeps the track of where the next non-zero should be placed
        int j = 0;

        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                // Move j forward
                j++;
            }
        }
    }
}

/*
 * Time complexity : O(N) , where N is the size of the array, as we traversing
 * the array once
 */