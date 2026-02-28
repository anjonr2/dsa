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
                if (j > i + 1 && nums[j] == nums[j - 1]) // check to skip duplicates for the secondposition of the
                                                         // quadruplet
                    continue;

                // two pointer approach
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        // found the quadruplet
                        List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        result.add(quadruplet);

                        left += 1;
                        right -= 1;

                        while (left < right && nums[left] == nums[left - 1])
                            left += 1;
                        while (left < right && nums[right] == nums[right + 1])
                            right -= 1;
                    } else if (sum < target) {
                        left += 1;
                    } else {
                        right -= 1;
                    }

                }

            }

        }
        return result;
    }
}
