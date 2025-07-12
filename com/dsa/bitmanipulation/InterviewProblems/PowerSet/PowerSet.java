package com.dsa.bitmanipulation.InterviewProblems.PowerSet;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public List<List<Integer>> powerSet(int[] nums) {
        int n = nums.length;
        int totalSubsets = 1 << n; // 2^n subsets
        List<List<Integer>> result = new ArrayList<>();
        for (int val = 0; val < totalSubsets; val += 1) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i += 1) {
                // check if the idx-th bit is set
                if ((val & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }
        return result;
    }
}
