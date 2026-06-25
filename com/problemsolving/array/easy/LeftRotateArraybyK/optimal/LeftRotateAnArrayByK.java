package com.problemsolving.array.easy.LeftRotateArraybyK.optimal;

public class LeftRotateAnArrayByK {
    private void reverseArray(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left += 1;
            right -= 1;
        }
    }

    public void rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        // Reverse the first k elements
        reverseArray(nums, 0, k - 1);

        // Reverse the last n-k elements
        reverseArray(nums, k, n - 1);

        // Reverse the entire array
        reverseArray(nums, 0, n - 1);
    }
}

/*
 * Time complexity :
 * O(N) where N is the size of the array
 * As three reversals are performed taking O(K), O(N-K) and O(N) time
 * respectively
 * 
 * Space complexity : O(1)
 */