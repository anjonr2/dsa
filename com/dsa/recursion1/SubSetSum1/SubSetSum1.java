package com.dsa.recursion1.SubSetSum1;

import java.util.ArrayList;
import java.util.List;

public class SubSetSum1 {
    public void getSubSetSums(int currIndex, int[] nums, int currentSum, List<Integer> result) {
        if (currIndex == nums.length) {
            result.add(currentSum);
            return;
        }
        // include the current element to the sum
        getSubSetSums(currIndex + 1, nums, currentSum + nums[currIndex], result);
        // exclude the current element from the sum
        getSubSetSums(currIndex + 1, nums, currentSum, result);
    }

    public List<Integer> subsetSums(int[] nums) {
        List<Integer> result = new ArrayList<>();
        getSubSetSums(0, nums, 0, result);
        return result;
    }
}
