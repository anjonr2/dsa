package com.problemsolving.array.medium.LongestConsecutiveSequence.brute;

import com.problemsolving.util.LinearSearch;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        LinearSearch linearSearch = new LinearSearch();
        if (nums.length == 0) {
            return 0;
        }
        int longest = 1;
        int n = nums.length;
        for (int i = 0; i < n; i += 1) {
            int x = nums[i];
            int cnt = 1;
            while (linearSearch.search(nums, x + 1) == true) {
                x += 1;
                cnt += 1;
            }
            longest = Math.max(cnt, longest);
        }
        return longest;
    }
}
