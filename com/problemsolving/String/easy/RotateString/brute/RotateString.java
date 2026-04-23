package com.problemsolving.String.easy.RotateString.brute;

public class RotateString {
    public boolean rotateString(String s, String goal) {

        /* Strings must be of same length to be rotations of each other */
        if (s.length() != goal.length())
            return false;

        // Try all possible rotations of s
        for (int i = 0; i < s.length(); i += 1) {
            String rotated = s.substring(i) + s.substring(0, i - 1);

            if (rotated.equals(goal))
                return true;
        }

        return false;
    }
}
