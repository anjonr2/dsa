package com.dsa.array;

public class SingleNondDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    return nums[0];
                }
            } else if (i == n - 1) {
                if (nums[i - 1] != nums[i - 2]) {
                    return nums[i - 1];
                }
            } else {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        SingleNondDuplicate obj = new SingleNondDuplicate();
        System.out.println("Single non duplicate element is " + obj.singleNonDuplicate(nums));
    }
}
