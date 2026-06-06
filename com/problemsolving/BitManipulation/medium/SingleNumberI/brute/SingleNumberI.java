package com.problemsolving.BitManipulation.medium.SingleNumberI.brute;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberI {
    public int singleNumber(int[] nums) {
        /*
         * Map to store the elements and their frequencies
         */
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            /* if frequency is 1 return the element */
            if (map.get(key) == 1) {
                return key;
            }
        }

        /*
         * Return -1 if there is no number having frequency 1
         */
        return -1;
    }
}
