package com.problemsolving.array.medium.majorityelement.optimal;

public class MajorityElement {
    public int majorityElement(int[] nums) {

        int cnt = 0;
        int majorityElement = -1;
        int n = nums.length;
        for (int i = 0; i < n; i += 1) {
            if (cnt == 0) {
                cnt = 1;
                majorityElement = nums[i];
            } else if (nums[i] == majorityElement) {
                cnt += 1;
            } else {
                cnt -= 1;
            }
        }

        int cnt1 = 0;
        for (int i = 0; i < nums.length; i += 1) {
            if (nums[i] == majorityElement)
                cnt1 += 1;
        }
        if (cnt1 > n / 2)
            return majorityElement;
        return -1;
    }
}
