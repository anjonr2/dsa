package com.dsa.strings;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i += 1) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (rotated.equals(goal))
                return true;
        }
        return false;
    }
}
