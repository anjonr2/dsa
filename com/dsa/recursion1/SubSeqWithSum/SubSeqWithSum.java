/* Problem Statement:
Given an array nums and an integer k. R﻿eturn true if there exist subsequences such that the sum of all elements in subsequences is equal to k else false.
Examples:
Input : nums = [1, 2, 3, 4, 5] , k = 8
Output : Yes
Explanation : The subsequences like [1, 2, 5] , [1, 3, 4] , [3, 5] sum up to 8.
Input : nums = [4, 3, 9, 2] , k = 10
Output : No
Explanation : No subsequence can sum up to 10. */
public class SubSeqWithSum {
    public boolean checkSubSequenceSum(int[] nums, int idx, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || idx == nums.length) {
            return false;
        }
        boolean include = checkSubSequenceSum(nums, idx + 1, sum - nums[idx]);
        boolean exclude = checkSubSequenceSum(nums, idx + 1, sum);

        return include || exclude;
    }

    public boolean checkSubsequenceSum(int[] nums, int k) {
        return checkSubSequenceSum(nums, 0, k);
    }
}
