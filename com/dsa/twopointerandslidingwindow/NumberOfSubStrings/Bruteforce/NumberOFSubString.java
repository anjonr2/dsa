package com.dsa.twopointerandslidingwindow.NumberOfSubStrings.Bruteforce;

public class NumberOFSubString {
    public int numberOfSubstrings(String s) {
        int cnt = 0;
        int n = s.length();
        int hash[] = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                hash[s.charAt(j) - 'a'] = 1;

                if (hash[0] + hash[1] + hash[2] == 3) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }
}
