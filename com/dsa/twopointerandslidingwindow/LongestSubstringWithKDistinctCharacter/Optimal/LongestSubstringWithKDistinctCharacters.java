package com.dsa.twopointerandslidingwindow.LongestSubstringWithKDistinctCharacter.Optimal;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {
    public int kDistinctChar(String s, int k) {
        int maxLength = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while (right < n) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left += 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right += 1;
        }
        return maxLength;
    }
}
