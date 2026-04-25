package com.problemsolving.String.medium.RomanToInteger.usingSwitchCase;

/*Switch case is faster than hashmap. Since rehashing happens in hashmap and that rehashing takes some time */
public class RomanToInteger {
    public int romanToIntMap(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public int romanToInt(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i += 1) {
            char ch = s.charAt(i);

            /*
             * i+1 <n checks if there's only one character in the string or it's the last
             * character in the string. For example String s = 'I'
             * n = 1; i=0; i+1 = 1 which is not less than n so it will be added to the
             * result
             */
            if ((i + 1) < n && romanToIntMap(ch) < romanToIntMap(s.charAt(i + 1))) {
                result -= romanToIntMap(ch);
            } else {
                /*
                 * Add to the result if it is the only character in the string or it is the last
                 * character of the string
                 */
                result += romanToIntMap(s.charAt(i));
            }
        }
        return result;
    }
}
