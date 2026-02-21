package com.problemsolving.array.hard.MajorityElementII.bruteforce;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> majorityElements = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i += 1) {
            if (majorityElements.size() == 0 || majorityElements.get(0) != nums[i]) {
                int count = 0;
                for (int j = 0; j < n; j += 1) {
                    if (nums[i] == nums[j])
                        count += 1;
                }
                if (count > n / 3)
                    majorityElements.add(nums[i]);
                if (majorityElements.size() == 2)
                    break;
            }
        }
        return majorityElements;
    }
}
