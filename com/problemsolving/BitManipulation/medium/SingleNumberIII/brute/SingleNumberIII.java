package com.problemsolving.BitManipulation.medium.SingleNumberIII.brute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleNumberIII {
    /* Function to get the singleNumbers in the given array */
    public List<Integer> singleNumber(int[] nums) {
        /* Array to store the answer */
        List<Integer> ans = new ArrayList<>();

        /* Map to store the elements and their frequencies */
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            /* If frequency is 1 */
            if (entry.getValue() == 1) {
                /* Add the element to the result array */
                ans.add(entry.getKey());
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
