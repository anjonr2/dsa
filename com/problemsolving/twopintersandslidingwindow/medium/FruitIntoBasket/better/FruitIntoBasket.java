package com.problemsolving.twopintersandslidingwindow.medium.FruitIntoBasket.better;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {
    public int totalFruits(int[] fruits) {
        int n = fruits.length;

        /* Pointers for the sliding window approach */
        int l = 0, r = 0;

        int maxLen = 0;

        /* Map to track the count of each fruit type in the current window */
        Map<Integer, Integer> map = new HashMap<>();

        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            /* If the number of different fruits exceeds 2 shrink the window from left */
            while (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l += 1;
            }

            if (map.size() <= 2) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r += 1;
        }
        return maxLen;
    }
}

/*
 * Time complexity : O(2N)
 */