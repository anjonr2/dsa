package com.dsa.twopointerandslidingwindow.LongestSubstringWithKDistinctCharacter.Bruteforce;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCharacters {
    public int kDistinctChar(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            map.clear();
            for (int j = i; j < s.length(); j += 1) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                if (map.size() <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }
}
