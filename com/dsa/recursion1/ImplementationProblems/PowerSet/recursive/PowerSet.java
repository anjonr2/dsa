package com.dsa.recursion1.ImplementationProblems.PowerSet.recursive;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public void generatePowerSet(int[] nums, int length, int currentIdx, List<Integer> current,
            List<List<Integer>> result) {
        if (currentIdx == length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[currentIdx]);
        generatePowerSet(nums, length, currentIdx + 1, current, result);
        current.remove(current.size() - 1);

        generatePowerSet(nums, length, currentIdx + 1, current, result);
    }

    public List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int n = nums.length;
        int idx = 0;
        generatePowerSet(nums, n, idx, current, result);
        return result;
    }
}
