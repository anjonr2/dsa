package com.problemsolving.array.medium.ReArrangePositiveNegativeElement.brute;

import java.util.ArrayList;
import java.util.List;

public class ReArrange {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (int i = 0; i < n; i += 1) {
            if (nums[i] >= 0) {
                positive.add(nums[i]);
            } else
                negative.add(nums[i]);
        }
        for (int i = 0; i < n / 2; i += 1) {
            nums[2 * i] = positive.get(i);
            nums[2 * i + 1] = negative.get(i);
        }
        return nums;
    }
}
