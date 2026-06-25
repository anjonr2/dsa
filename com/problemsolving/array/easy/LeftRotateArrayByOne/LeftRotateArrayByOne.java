package com.problemsolving.array.easy.LeftRotateArrayByOne;

public class LeftRotateArrayByOne {
    public void rotateArrayByOne(int[] nums) {
        // Store the first element in a temporary variable
        int temp = nums[0];

        // Shift array elements starting from idx 1 towards left by one position
        for (int i = 1; i < nums.length; i += 1) {
            nums[i - 1] = nums[i];
        }

        nums[nums.length - 1] = temp;
    }
}
