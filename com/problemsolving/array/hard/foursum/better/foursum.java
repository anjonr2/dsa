package com.problemsolving.array.hard.foursum.better;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class foursum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        // set to store unique quadruplets
        Set<List<Integer>> uniqueQuadruplets = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i += 1) {
            for (int j = i + 1; j < n; j += 1) {
                // set to store elements seen so far for the in the loop
                Set<Long> seen = new HashSet<>();
                for (int k = j + 1; k < n; k += 1) {
                    /*
                     * calculate the fourth element needed to
                     * make the sum equal to target
                     */
                    long sum = nums[i] + nums[j] + nums[k];
                    long fourthElement = target - sum;
                    if (seen.contains(fourthElement)) {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) fourthElement);
                        Collections.sort(temp);
                        uniqueQuadruplets.add(temp);
                    }
                }

            }
        }
        result.addAll(uniqueQuadruplets);
        return result;
    }
}

/*
 * Time complexity : O(n^3 * log(m)) = for using 3 nested loops and inside the
 * loop there are some operations like adding elements to the set and looking
 * for elements in the set
 * 
 * Space complexity : O(2 * no of quadruplets) for using a set data structure to
 * store unique results and list to store final results. And Second term O(n) is
 * for using the stack to store array elements inside the foor loop
 */