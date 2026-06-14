package com.problemsolving.stackandqueue.basic.InfixToPrefix;

public class InfixToPrefix {
    private static int getPriority(char c) {
        if (c == '^')
            return 3;
        else if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }

    public static String infixToPrefix(String infix) {
        StringBuilder prefix = new StringBuilder();
        int n = infix.length();
        return prefix.toString();
    }
}
