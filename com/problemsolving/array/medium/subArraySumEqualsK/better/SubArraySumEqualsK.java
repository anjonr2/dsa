package com.problemsolving.array.medium.subArraySumEqualsK.better;

public class SubArraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int startIndex = 0; startIndex < n; startIndex += 1) {
            int currentSum = 0;
            for (int endIndex = startIndex; endIndex < n; endIndex += 1) {
                currentSum += nums[endIndex];
            }
            if (currentSum == k) {
                count += 1;
            }
        }
        return count;
    }
}
