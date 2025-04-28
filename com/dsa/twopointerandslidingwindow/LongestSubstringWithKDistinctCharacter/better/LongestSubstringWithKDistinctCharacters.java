package com.dsa.twopointerandslidingwindow.LongestSubstringWithKDistinctCharacter.better;

import java.util.HashMap;

public class LongestSubstringWithKDistinctCharacters {
    public int kDistinctChar(String s, int k) {
        int maxLength = 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < n) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left += 1;
            }
            if (map.size() <= k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }
}
