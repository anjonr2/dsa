package com.problemsolving.array.medium.majorityelement.better;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < n; j += 1) {
                if (nums[i] == nums[j]) {
                    cnt += 1;
                }
            }
            if (cnt > n / 2)
                return nums[i];
        }
        return -1;
    }
}
