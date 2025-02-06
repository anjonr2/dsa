package com.dsa.stack;

import java.util.Stack;

public class PrefixToPostfix {
    public static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static String prefixToPostfix(String exp) {
        Stack<String> stack = new Stack<>();
        int i = exp.length() - 1;
        while (i >= 0) {
            char c = exp.charAt(i);
            if (isOperand(c)) {
                stack.push(c + "");
            } else {
                String op1 = stack.peek();
                stack.pop();
                String op2 = stack.peek();
                stack.pop();
                stack.push(op1 + op2 + c);
            }
            i -= 1;
        }
        return stack.peek();
    }
}
