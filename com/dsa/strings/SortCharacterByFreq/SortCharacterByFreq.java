package com.dsa.strings.SortCharacterByFreq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dsa.util.Pair;

public class SortCharacterByFreq {
    public List<Character> frequencySort(String s) {
        // Frequency array for characters 'a' to 'z'
        Pair[] count = new Pair[26];
        for (int i = 0; i < 26; i += 1) {
            count[i] = new Pair(0, (char) (i + 'a'));
        }

        // count frequency of each character from given string s
        for (char ch : s.toCharArray()) {
            count[ch - 'a'].freq += 1;
        }

        Arrays.sort(count, (a, b) -> {
            if (a.freq != b.freq)
                return b.freq - a.freq;
            return a.ch - b.ch;
        });

        List<Character> result = new ArrayList<>();
        for (Pair p : count) {
            if (p.freq > 0)
                result.add(p.ch);
        }
        return result;
    }

}
