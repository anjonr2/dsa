package com.problemsolving.array.hard.foursum.brute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class foursum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // set to store unique quadruplets
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i += 1) {
            for (int j = i + 1; j < n; j += 1) {
                for (int k = j + 1; k < n; k += 1) {
                    for (int l = k + 1; l < n; l += 1) {
                        long sum = nums[i];
                        sum += nums[j];
                        sum += nums[k];
                        sum += nums[l];
                        if (sum == target) {
                            List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(temp);
                            result.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}

/*
 * Time Complexity: O(n^4 * log(4)) = O(n^4) where n is the length of the input
 * array. The log(4) factor comes from sorting the quadruplets, but since it's a
 * constant, it can be ignored in the overall time complexity.
 * Space Complexity : O(2 * no of quadruplets) for using a set data structure
 * and list to store the unique quadruplets
 */