package com.problemsolving.stackandqueue.basic.PostfixToPrefix;

import java.util.Stack;

public class PostfixToPrefix {
    /* Function to convert postfix to prefix */
    public String postfixToPrefix(String postfix) {
        Stack<String> stack = new Stack<>();
        int n = postfix.length();

        // Traverse postfix expression from left to right
        for (int i = 0; i < n; i += 1) {
            char c = postfix.charAt(i);

            // if character is an operand, push it to the stack
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();

                // Form the new prefix expression and push it back to stack
                stack.push(c + operand1 + operand2);
            }
        }
        return stack.pop();
    }
}
