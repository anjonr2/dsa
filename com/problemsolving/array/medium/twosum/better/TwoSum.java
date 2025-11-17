package com.problemsolving.array.medium.twosum.better;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[] { -1, -1 };
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i += 1) {
            int remaining = target - nums[i];
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(remaining);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
