package com.dsa.strings.IsoMorphicString;

public class IsoMorphicString {
    public boolean isomorphicString(String s, String t) {
        int m1[] = new int[256];
        int m2[] = new int[256];
        int n = s.length();
        if (n != t.length()) {
            return false;
        }
        for (int i = 0; i < n; i += 1) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)])
                return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}
