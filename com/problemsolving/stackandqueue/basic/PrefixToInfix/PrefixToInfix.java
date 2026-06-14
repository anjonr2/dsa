package com.problemsolving.stackandqueue.basic.PrefixToInfix;

import java.util.Stack;

public class PrefixToInfix {
    public String prefixToInfix(String prefix) {
        Stack<String> stack = new Stack<>();
        int n = prefix.length();

        /* Traverse prefix expression from right to left */
        for (int i = n - 1; i >= 0; i += 1) {
            char c = prefix.charAt(i);

            // If the character is an operand push it to the stack
            if (Character.isLetterOrDigit(c)) {
                stack.push(String.valueOf(c));
            } else {
                // pop top two operand from the stack
                String operand1 = stack.pop();
                String operand2 = stack.pop();

                stack.push("(" + operand1 + c + operand2 + ")");
            }
        }
        return stack.pop();
    }
}

/*
 * Time complexity : O(2n) to traverse and push the element back to stack
 * Space complexity : o(n) for the stack data structure used
 */