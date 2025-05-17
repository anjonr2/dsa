package com.dsa.recursion1.SubSetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an integer array nums, which can have duplicate entries, provide the power set. Duplicate subsets cannot exist in the solution set. Return the answer in any sequence.

Examples:
Input : nums = [1, 2, 2]

Output : [ [ ] , [1] , [1, 2] , [1, 2, 2] , [2] , [2, 2] ]

Input : nums = [1, 2]

Output : [ [ ], [1] , [2] , [1, 2] ] */
public class SubSetsII {
    public void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        generateSubsets(index + 1, nums, current, result);
        // Backtrack to exclude the last added element
        current.remove(current.size() - 1);

        // Skip duplicates
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                generateSubsets(i, nums, current, result);
                return;
            }
        }
        generateSubsets(nums.length, nums, current, result);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // Sort the array to group similar elements together
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<>(), result);
        return result;

    }
}
