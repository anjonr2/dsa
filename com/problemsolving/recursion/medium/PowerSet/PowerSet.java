package com.problemsolving.recursion.medium.PowerSet;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    /* Helper function to generate all power subsets */
    private void backtrack(int index, int n, int[] nums, List<Integer> current, List<List<Integer>> ans) {
        /*
         * Base case : if the index reaches the length of the array
         * add the current subset to the answer list
         */
        if (index == n) {
            ans.add(current);
            return;
        }

        /* Exclusion : exclude nums[index] and move to next index */
        backtrack(index + 1, n, nums, current, ans);

        /*
         * Include current element nums[index] to current subset and move to next index
         */
        current.add(nums[index]);
        backtrack(index + 1, n, nums, current, ans);

        /*
         * It undoes the choice of including nums[index] so that when control returns
         * the parent frame, current is i n the exact same state as before the branch
         * current is shared mutable state
         */
        current.remove(nums.length - 1);
    }

    /* Main function to generate power set of the given array */
    public List<List<Integer>> powerSet(int[] nums) {
        /* List to store all subsets */
        List<List<Integer>> ans = new ArrayList<>();

        /* Temporary list to store current subsets */
        List<Integer> current = new ArrayList<>();
        backtrack(0, nums.length, nums, current, ans);
        return ans;
    }
}

/*
 * Time complexity : O(2^n) , Each element in the array has two choices : either
 * to be included in a subset or not , leading to 2^n possible subset
 * 
 * 
 */