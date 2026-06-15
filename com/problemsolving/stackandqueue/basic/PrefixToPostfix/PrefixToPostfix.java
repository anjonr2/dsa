package com.problemsolving.stackandqueue.basic.PrefixToPostfix;

import java.util.Stack;

public class PrefixToPostfix {
    public String prefixToPostfix(String prefix) {
        Stack<String> stack = new Stack<>();
        int n = prefix.length();

        // Traverse the prefix expression from right to left
        for (int i = n - 1; i >= 0; i -= 1) {
            char c = prefix.charAt(i);

            // If the character is an operand, push it to the stack
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();

                // Form the new postfix expression and push back to stack
                stack.push(operand1 + operand2 + c);
            }
        }

        return stack.pop();
    }
}
