package com.dsa.recursion1.CountSubSeqWithSum;

public class CountSubSeqWithSum {
    public int countSubSeqWithSum(int idx, int[] nums, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (sum < 0 || idx == nums.length) {
            return 0;
        }
        int include = countSubSeqWithSum(idx + 1, nums, sum - nums[idx]);
        int exclude = countSubSeqWithSum(idx + 1, nums, sum);

        return include + exclude;
    }

    public int countSubsequenceWithTargetSum(int[] nums, int k) {
        return countSubSeqWithSum(0, nums, k);
    }
}
