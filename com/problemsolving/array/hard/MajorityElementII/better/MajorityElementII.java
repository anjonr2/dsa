package com.problemsolving.array.hard.MajorityElementII.better;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {
    public List majorityElement(int[] nums) {
        List<Integer> majorityElements = new ArrayList<>();
        int n = nums.length;
        Map<Integer, Integer> frequenecyMap = new HashMap<>();
        int majorityCount = n / 3 + 1;
        for (int i = 0; i < n; i += 1) {
            frequenecyMap.put(nums[i], frequenecyMap.getOrDefault(nums[i], 0) + 1);
            if (frequenecyMap.get(nums[i]) == majorityCount)
                majorityElements.add(nums[i]);
            if (majorityElements.size() == 2)
                break;
        }
        return majorityElements;
    }
}
