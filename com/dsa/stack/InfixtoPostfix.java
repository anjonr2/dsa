package com.dsa.stack;

import java.util.Stack;

public class InfixtoPostfix {
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

    public static String infixToPostFix(String infix) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        String postfix = "";
        int n = infix.length();
        while (i < n) {
            char c = infix.charAt(i);
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                postfix = postfix + c;
            } else if (c == '(') {
                // if it's an opening bracket, push it to the stack
                stack.push(c);
            } else if (c == ')') {
                // if it's a closing bracket, pop all the elements from the stack until we get
                // an
                // opening bracket
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix = postfix + stack.peek();
                    stack.pop();
                }
                // pop out the opening bracket
                stack.pop();
            } else {
                // if it's an operator
                while (!stack.isEmpty() && priority(c) <= priority(stack.peek())) {
                    postfix = postfix + stack.peek();
                    stack.pop();
                }
                stack.push(c);
            }
            i++;
        }
        // if the stack is not empty, pop out all the elements from the stack and keep
        // adding to the postfix expr
        while (!stack.isEmpty()) {
            postfix = postfix + stack.peek();
            stack.pop();
        }
        return postfix;
    }

}
