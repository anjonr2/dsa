package com.dsa.twopointerandslidingwindow.BinarySubArraysWithSum.Optimal;

public class BinarySubArraysWithSum {
    public int numberOfSubArraysWithSumLessThanOrEqualToGoal(int[] nums, int goal) {
        if (goal < 0)
            return 0;
        int cnt = 0;
        int sum = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left += 1;
            }
            cnt += cnt + (right - left + 1);
            right += 1;
        }
        return cnt;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        return numberOfSubArraysWithSumLessThanOrEqualToGoal(nums, goal)
                - numberOfSubArraysWithSumLessThanOrEqualToGoal(nums, goal - 1);
    }
}
