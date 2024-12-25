package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPermutations {
    public static List<List<Integer>> recurPermutation(int index, int[] nums, List<List<Integer>> ans) {
        if (index == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(ds);
        }
        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recurPermutation(index + 1, nums, ans);
            swap(i, index, nums);
        }
        return ans;
    }

    public static void swap(int i, int idx, int[] nums) {
        int temp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = temp;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermutation(0, nums, ans);
        return ans;
    }
}
