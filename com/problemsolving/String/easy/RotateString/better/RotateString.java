package com.problemsolving.String.easy.RotateString.better;

public class RotateString {
    public boolean rotateString(String s, String goal) {
        /* Strings must be of the same length to be rotations of each other */
        if (s.length() != goal.length())
            return false;

        String doubleS = s + s;

        return doubleS.contains(goal); // Checks if goal is a substring of s + s
    }
}
