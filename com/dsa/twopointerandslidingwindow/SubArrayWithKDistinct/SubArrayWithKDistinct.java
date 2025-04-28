package com.dsa.twopointerandslidingwindow.SubArrayWithKDistinct;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKDistinct {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int cnt = 0, left = 0, right = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left += 1;
            }
            cnt += right - left + 1;
        }
        return cnt;
    }
}
