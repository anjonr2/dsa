package com.problemsolving.array.hard.MaximumProductSubArray.brute;

public class MaximumProductSubArray {
    public int maxProduct(int[] nums) {

        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < n; i += 1) {
            int product = 1;
            for (int j = i; j < n; j += 1) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }
}

/*
 * Time Complexity : O(n^2)
 */