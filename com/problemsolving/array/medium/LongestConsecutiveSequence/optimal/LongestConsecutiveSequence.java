package com.problemsolving.array.medium.LongestConsecutiveSequence.optimal;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int longest = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i += 1) {
            set.add(nums[i]);
        }
        for (int el : set) {
            if (!set.contains(el - 1)) {
                // el is the start of a sequence
                int cnt = 1;
                int startingEl = el;
                while (set.contains(startingEl + 1)) {
                    startingEl += 1;
                    cnt += 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
}
