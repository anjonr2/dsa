package com.dsa.stack;

import java.util.Stack;

public class InfixtoPrefix {
    public static int priority(char c) {
        if (c == '^') {
            return 3;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        }
        return -1;
    }

    public static boolean isOperand(char c) {
        if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    public static void reverse(String str) {
        String reverse = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
    }

    public static String infixToPrefixConversion(String expr) {
        String prefix = "";
        int n = expr.length();
        String reverse = "";
        for (int i = n; i > 0; i--) {
            char c = expr.charAt(i);
            reverse = reverse + c;
        }
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < reverse.length()) {
            char c = reverse.charAt(i);
            if (isOperand(c)) {
                prefix = prefix + c;
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() == '(') {
                    prefix = prefix + stack.peek();
                    stack.pop();
                }
                // pop out the opening bracket
                stack.pop();
            } else {
                if (c == '^') {
                    if (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                        prefix = prefix + stack.peek();
                        stack.pop();
                    }
                }
            }
            i += 1;
        }
        while (!stack.isEmpty()) {
            prefix = prefix + stack.peek();
            stack.pop();
        }
        reverse(prefix);
        return prefix;
    }
}
