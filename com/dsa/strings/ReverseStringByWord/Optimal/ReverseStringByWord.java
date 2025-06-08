package com.dsa.strings.ReverseStringByWord.Optimal;

public class ReverseStringByWord {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        String[] words = s.split(" ");
        int n = words.length;
        for (int i = n - 1; i >= 0; i -= 1) {
            String word = words[i];
            if (word.length() == 0) {
                continue; // skip empty words or spaces
            }
            if (word.length() > 0 && result.length() == 0) {
                result.append(word); // append the first word without leading space
            } else {
                result.append(' ').append(word);
            }
        }
        return result.toString();
    }
}
