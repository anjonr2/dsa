package com.dsa.strings.LargestOddNumber;

public class LargestOddNumber {
    public String largeOddNum(String s) {
        int index = -1;
        int i;
        for (i = s.length() - 1; i >= 0; i -= 1) {
            if ((s.charAt(i) - '0') % 2 == 1) {
                index = i;
                break;
            }
        }
        // If no odd number is found, return an empty string
        if (index == -1)
            return "";
        i = 0;
        while (i < s.length() && s.charAt(i) == '0')
            i += 1;
        return s.substring(i, index + 1);
    }
}
