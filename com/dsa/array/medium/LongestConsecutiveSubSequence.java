package com.dsa.array.medium;

import java.util.Arrays;

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

    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        Arrays.sort(arr);
        int longest = 1;
        int cnt = 0;
        int lastSmallest = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (arr[i] - 1 == lastSmallest) {
                cnt++;
                lastSmallest = arr[i];
            } else if (arr[i] != lastSmallest) {
                cnt = 1;
                lastSmallest = arr[i];
            }
            longest = Math.max(longest, cnt);
        }
        return longest;
    }
}
