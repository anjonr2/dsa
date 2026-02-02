package com.problemsolving.array.medium.LongestConsecutiveSequence.better;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        Arrays.sort(nums);
        int longest = 1;
        int lastSmaller = Integer.MIN_VALUE;
        for (int i = 0; i < n; i += 1) {
            int cnt = 0;
            if (nums[i] - 1 == lastSmaller) {
                cnt += 1;
                lastSmaller = nums[i];
            } else if (nums[i] != lastSmaller) {
                cnt = 1;
                lastSmaller = nums[i];
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
}
