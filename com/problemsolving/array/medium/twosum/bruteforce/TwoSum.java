package com.problemsolving.array.medium.twosum.bruteforce;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[] { -1, -1 };
        for (int i = 0; i < nums.length; i += 1) {
            for (int j = i + 1; j < nums.length; j += 1) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
        return ans;
    }
}
