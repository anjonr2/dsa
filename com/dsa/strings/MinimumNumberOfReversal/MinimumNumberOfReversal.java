package com.dsa.strings.MinimumNumberOfReversal;

public class MinimumNumberOfReversal {
    /*
     * Function to find minimum number of reversals required to convert the string
     * into a balanced expression.
     */
    public int countRev(String s) {
        int n = s.length();

        // If the length of the string is odd, it cannot be balanced
        if (n % 2 != 0) {
            return -1;
        }
        int openCount = 0; // Count of open brackets
        int closeCount = 0; // Count of close brackets

        // Traverse the string to count open and close brackets
        for (int i = 0; i < n; i += 1) {
            char ch = s.charAt(i);
            if (ch == '(')
                openCount += 1;
            else {
                if (openCount > 0) {
                    openCount -= 1;
                } else {
                    closeCount += 1;
                }
            }
        }
        return openCount / 2 + closeCount / 2 + openCount % 2 + closeCount % 2;
    }
}
