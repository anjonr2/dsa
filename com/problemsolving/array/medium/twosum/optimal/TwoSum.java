package com.problemsolving.array.medium.twosum.optimal;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[] { -1, -1 };
        int n = nums.length;
        int left = 0, right = n - 1;
        Arrays.sort(nums);
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                ans[0] = left;
                ans[1] = right;
                break;
            }
            if (sum > target)
                right -= 1;
            else
                left += 1;
        }
        return ans;
    }
}
