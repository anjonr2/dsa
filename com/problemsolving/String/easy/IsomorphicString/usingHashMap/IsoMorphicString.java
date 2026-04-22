package com.problemsolving.String.easy.IsomorphicString.usingHashMap;

import java.util.HashMap;

public class IsoMorphicString {
    public boolean isomorphicString(String s, String t) {
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();

        // converting string to string builder. As operation in string is slow so
        // coverted it to string builder
        StringBuilder sbS = new StringBuilder(s);
        StringBuilder sbT = new StringBuilder(t);

        int n = s.length();
        for (int i = 0; i < n; i += 1) {
            char s1 = sbS.charAt(i);
            char t1 = sbT.charAt(i);

            if (!sMap.containsKey(s1)) {
                sMap.put(s1, t1);
            }
            if (!tMap.containsKey(t1)) {
                tMap.put(t1, s1);
            }
            if (sMap.get(s1) != t1 || tMap.get(t1) != s1) {
                return false;
            }
        }

        return true;
    }
}
