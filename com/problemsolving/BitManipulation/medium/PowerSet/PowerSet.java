package com.problemsolving.BitManipulation.medium.PowerSet;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    /* Function call to get the power set of given array */
    public List<List<Integer>> powerSet(int[] nums) {
        /* variable to store size of the array */
        int n = nums.length;

        /* to store the answer */
        List<List<Integer>> ans = new ArrayList<>();

        /*
         * variable to store count of total no of subsets
         * 1 << n == 2^n
         */
        int count = (1 << n);

        for (int val = 0; val < count; val += 1) {
            /* to store current subset */
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i += 1) {
                /*
                 * it checks if the current bit is set take it
                 * for n = 3
                 * total no of subsets is
                 * count = 1 << n == 1 * 2 ^ 3 = 8
                 * 
                 * if we traverse from val = 0 to val < count it will traverse from 0 to 7
                 * 
                 * if val = 3
                 * it's binary is 011
                 * 
                 * since n = 3 so inner for loop runs from 0 to 2
                 * val & 1 << 0 = 011 & 001 = 1
                 * val & 1 << 1 = 011 & 010 = 1
                 * val & 1 << 2 = 011 & 100 = 0
                 * 
                 * so for 3 it says take 0th and 1st index element
                 * os add nums[i] to list
                 * 
                 * if nums = [1,2,3]
                 * then one of the subset will be [1,2]
                 * 
                 */
                if ((val & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }

            /*
             * Add the current subset to final answer
             */
            ans.add(subset);
        }
        return ans;
    }
}
