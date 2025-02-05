package com.dsa.stack;

import java.util.Stack;

public class PrefixToInfix {
    public static boolean isOperand(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public static String prefixToInfix(String expression) {
        Stack<String> stack = new Stack<>();
        int i = expression.length() - 1;
        while (i >= 0) {
            char c = expression.charAt(i);
            if (isOperand(c)) {
                stack.push(c + "");
            } else {
                String top1 = stack.peek();
                stack.pop();
                String top2 = stack.peek();
                stack.pop();
                stack.push("(" + top1 + c + top2 + ")");
            }
            i--;
        }
        return stack.peek();
    }
}
