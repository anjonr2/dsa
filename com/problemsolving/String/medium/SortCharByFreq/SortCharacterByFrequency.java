package com.problemsolving.String.medium.SortCharByFreq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortCharacterByFrequency {
    public List<Character> frequencySort(String s) {
        /* Frequency array for characters 'a' to 'z' */
        Pair[] freq = new Pair[26];

        for (int i = 0; i < 26; i += 1) {
            freq[i] = new Pair(0, (char) (i + 'a'));
        }

        for (char ch : s.toCharArray()) {
            freq[ch - 'a'].freq += 1;
        }

        Arrays.sort(freq, (p1, p2) -> {
            if (p1.freq != p2.freq)
                return p2.freq - p1.freq;
            return p1.ch - p2.ch;
        });

        List<Character> result = new ArrayList<>();
        for (Pair p : freq) {
            if (p.freq > 0)
                result.add(p.ch);
        }

        return result;
    }

    class Pair {
        int freq;
        char ch;

        Pair(int freq, char ch) {
            this.freq = freq;
            this.ch = ch;
        }
    }
}
