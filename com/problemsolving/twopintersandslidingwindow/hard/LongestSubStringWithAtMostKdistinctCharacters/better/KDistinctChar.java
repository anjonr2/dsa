package com.problemsolving.twopintersandslidingwindow.hard.LongestSubStringWithAtMostKdistinctCharacters.better;

import java.util.HashMap;
import java.util.Map;

public class KDistinctChar {
    /*
     * Function to find the length of the longest substring with at most k distinct
     * characters
     */
    public int kDistinctChar(String s, int k) {
        /*
         * Initialize left pointer , right pointer of the sliding window
         * and maximum length of the substring
         */
        int l = 0, r = 0, maxLen = 0;

        int n = s.length();

        /* Hashmap to store character frequencies */
        Map<Character, Integer> map = new HashMap<>();

        while (r < n) {

            /* Increment frequency of current character */
            char currentChar = s.charAt(r);

            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);

            /*
             * If the number of distinct characters exceeds k, shrink the window from the
             * left
             */
            while (map.size() > k) {

                /* Decrement frequency of character at left pointer */
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    /*
                     * Remove the character from the map if it's frequency becomes 0
                     */
                    map.remove(leftChar);
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
 * Time complexity : O(2N), where N is the size of the array. As the other while
 * loop runs for N time and inner while runs for N time in total through out the
 * program. Ignore the contribution of map data structure in the time complexity
 * as size of the map is extremely small
 * 
 * Space complexity : O(K), as at most the map data structure is holding k
 * elements
 */