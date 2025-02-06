package com.dsa.stack;

import java.util.Stack;

public class PostfixToPrefix {
    public static boolean isOperand(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static String postFixTopreFix(String exp) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        int n = exp.length();
        while (i < n) {
            char c = exp.charAt(i);
            if (isOperand(c)) {
                stack.push(c + "");
            } else {
                String op1 = stack.peek();
                stack.pop();
                String op2 = stack.peek();
                stack.pop();
                stack.push(c + op2 + op1);
            }
            i++;
        }
        return stack.peek();
    }
}
