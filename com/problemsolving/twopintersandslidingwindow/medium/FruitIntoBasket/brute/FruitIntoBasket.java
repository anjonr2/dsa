package com.problemsolving.twopintersandslidingwindow.medium.FruitIntoBasket.brute;

import java.util.HashSet;
import java.util.Set;

public class FruitIntoBasket {

    /*
     * Function to find the maximum fruits the basket can have
     */
    public int totalFruits(int[] fruits) {
        int n = fruits.length;

        /* Variable to store the maximum length of substring */
        int maxLen = 0;

        /*
         * Iterate through all possible starting points of the substring
         */
        for (int i = 0; i < n; i += 1) {

            /* Use a hashset to track different types of fruits */
            Set<Integer> set = new HashSet<>();

            for (int j = i; j < n; j += 1) {
                set.add(fruits[i]);

                /* Check if the number of different fruits is within the allowed limits */
                if (set.size() <= 2) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else
                    break;
            }
        }
        return maxLen;
    }
}

/*
 * Time complexity : O(N^2)
 * Space complexity : O(3), as at most data structure is holding 3 elements
 */