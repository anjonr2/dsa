package com.problemsolving.twopintersandslidingwindow.hard.LongestSubStringWithAtMostKdistinctCharacters.optimal;

import java.util.HashMap;
import java.util.Map;

public class KDistinctChar {
    /*
     * Function to find the maximum length of substring with at most k distinct
     * characters
     */
    public int kDistinctChar(String s, int k) {

        int n = s.length();

        int maxLen = 0;

        Map<Character, Integer> map = new HashMap<>();

        /* Pointers for sliding window */
        int l = 0, r = 0;

        while (r < n) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.size() > k) {
                char leftChar = s.charAt(l);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0)
                    map.remove(leftChar);

                l += 1;
            }

            if (map.size() <= k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r += 1;
        }
        return maxLen;
    }
}

/*
 * Time complexity : O(N) as outer while loop runs for N time only
 * 
 * Space complexity : O(K) at most the map data structure is holding k elements
 */