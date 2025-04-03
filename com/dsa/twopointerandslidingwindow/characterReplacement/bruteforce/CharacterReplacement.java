package com.dsa.twopointerandslidingwindow.characterReplacement.bruteforce;

public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxLength = 0;
        int maxFreq = 0;
        int[] freq = new int[26];
        for (int right = 0; right < s.length(); right += 1) {
            char rightChar = s.charAt(right);
            freq[rightChar - 'A'] += 1;
            maxFreq = Math.max(maxFreq, freq[rightChar - 'A']);
            while (right - left + 1 - maxFreq > k) {
                char leftChar = s.charAt(left);
                freq[leftChar - 'A'] -= 1;
                left += 1;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
