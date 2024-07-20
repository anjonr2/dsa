package com.dsa.array.medium;

public class LongestConsecutiveSubSequence {
    public boolean linearSearch(int[] nums, int el) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == el) {
                return true;
            }
        }
        return false;
    }

    public int longestConsecutive(int[] nums) {
        int longest = 1;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int cnt = 1;
            while (linearSearch(nums, x + 1) == true) {
                x += 1;
                cnt += 1;
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
}
