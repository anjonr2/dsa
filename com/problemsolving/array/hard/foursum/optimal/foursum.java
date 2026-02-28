package com.problemsolving.array.hard.foursum.optimal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class foursum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i += 1) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue; // this check ensures that we are not using the same element for the first
                          // position of the quadruplet
            for (int j = i + 1; j < n; j += 1) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
            }

        }
        return result;
    }
}
