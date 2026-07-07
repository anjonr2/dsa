package com.problemsolving.twopintersandslidingwindow.medium.FruitIntoBasket.optimal;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {
    /*
     * Function to find the maximum fruits the basket can have
     */
    public int totalFruits(int[] fruits) {
        int n = fruits.length;

        int maxLen = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int l = 0, r = 0;

        while (r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            if (map.size() > 2) {
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
