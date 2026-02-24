package com.problemsolving.array.hard.subArraysWithxorK.optimal;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithXorK {
    public int countSubArraysWithXorK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        // map to store prefix xor and it's frequency
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixXor = 0;
        for (int i = 0; i < n; i += 1) {
            // prefix Xor till index i
            prefixXor = prefixXor ^ nums[i];

            int x = prefixXor ^ k;
            count += map.getOrDefault(x, 0);

            // insert the prefix xor till the index i in the map
            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }
        return count;
    }
}

/*
 * Time Complexity : O(n) we traverse the array once and each operation with the
 * hash map(insert and lookup) takes O(1)
 * Space Complexity : O(n) since we are using a hash map
 */