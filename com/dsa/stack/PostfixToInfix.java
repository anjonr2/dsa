package com.dsa.stack;

import java.util.Stack;

public class PostfixToInfix {
    public static boolean isOperand(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }

    public static String postFixToInfix(String exp) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < exp.length()) {
            char c = exp.charAt(i);
            if (isOperand(c)) {
                stack.push(c + "");
            } else {
                String op1 = stack.peek();
                stack.pop();
                String op2 = stack.peek();
                stack.pop();
                stack.push("(" + op1 + c + op2 + ")");
            }
            i++;
        }
        return stack.peek();
    }
}
