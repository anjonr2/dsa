package com.problemsolving.array.easy.LeftRotateArraybyK.brute;

public class LeftRotateAnArrayByK {
    public void rotateArray(int[] nums, int k) {
        int n = nums.length; // Size of array
        k = k % n; // to avoid unecessary rotations

        int[] temp = new int[k];

        // store first k element in the temporary array
        for (int i = 0; i < k; i += 1) {
            temp[i] = nums[i];
        }

        // shift n-k elements to the left
        for (int i = k; i < n; i += 1) {
            nums[i - k] = nums[i];
        }

        // copy back the k elements at the end
        for (int i = 0; i < k; i += 1) {
            nums[n - k + i] = temp[i];
        }
    }
}

/*
 * Time complexity : O(N), where N is the length of the array
 * Three loops are used taking K, N-K and K iterations respectively contributing
 * to O(N+K).
 * 
 * Space complexity : O(K), due to temporary list created to copy the K elements
 */