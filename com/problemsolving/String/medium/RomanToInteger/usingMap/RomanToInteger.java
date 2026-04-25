package com.problemsolving.String.medium.RomanToInteger.usingMap;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;

        /* Create a map of Roman numerals to integers */
        Map<Character, Integer> romanToIntMap = new HashMap<>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);

        /*
         * Loop through the string except the last character that's why i<s.length()-1
         * and not s.length()
         */
        for (int i = 0; i < s.length() - 1; i += 1) {

            /* Subtract if current value is less than next value */
            if (romanToIntMap.get(s.charAt(i)) < romanToIntMap.get(s.charAt(i + 1))) {
                result -= romanToIntMap.get(s.charAt(i));
            } else {
                /* Otherwise add the value */
                result += romanToIntMap.get(s.charAt(i));
            }
        }
        /* Add the value of the last character */
        return result + romanToIntMap.get(s.charAt(s.length() - 1));
    }
}
