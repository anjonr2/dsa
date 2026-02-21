package com.problemsolving.array.hard.MajorityElementII.optimal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int count1 = 0, count2 = 0;
        int el1 = Integer.MIN_VALUE, el2 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i += 1) {
            if (count1 == 0 && el2 != nums[i]) {
                count1 = 1;
                el1 = nums[i];
            } else if (count2 == 0 && el1 != nums[i]) {
                count2 = 1;
                el2 = nums[i];
            } else if (nums[i] == el1) {
                count1 += 1;
            } else if (nums[i] == el2) {
                count2 += 1;
            } else {
                count1 -= 1;
                count2 -= 1;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i += 1) {
            if (nums[i] == el1) {
                count1 += 1;
            } else if (nums[i] == el2) {
                count2 += 1;
            }
        }

        int majorityCount = n / 3 + 1;
        List<Integer> majorityElements = new ArrayList<>();
        if (count1 >= majorityCount)
            majorityElements.add(el1);
        if (count2 >= majorityCount && el2 != el1)
            majorityElements.add(el2);

        Collections.sort(majorityElements);
        return majorityElements;
    }
}
