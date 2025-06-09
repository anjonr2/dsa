package com.dsa.strings.CountAndSay;

public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String previous = countAndSay(n - 1);
        int len = previous.length();
        String ans = ""; // result string
        int count = 1; // count of the current character
        for (int i = 1; i < len; i += 1) {
            if (previous.charAt(i) == previous.charAt(i - 1))
                count += 1;
            else {
                ans += (char) (count + '0'); // added frequency
                ans += previous.charAt(i - 1); // added character
                count = 1; // reset count to 1
            }
        }
        // for the last character
        // since the loop ends before the last character
        ans += (char) (count + '0');
        ans += previous.charAt(len - 1);
        return ans;
    }
}
