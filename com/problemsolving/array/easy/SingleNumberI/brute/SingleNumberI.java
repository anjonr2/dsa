package com.problemsolving.array.easy.SingleNumberI.brute;

import java.util.HashMap;

public class SingleNumberI {
    /*
     * Function to get the single number in the given array
     */
    public int singleNumber(int[] nums) {

        /*
         * Map to store elements and their frequencies
         */
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1)
                return key;
        }

        return -1;
    }
}
